package com.crud.test.rest;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;




public class JWTGenerateValidateHMAC extends User{
        
        String jwt = createJwtSignedHMAC(null);

        Jws<Claims> token = parseJwt(jwt);



       
    
        public static void sendGET(String email) throws IOException {
            
            
             final String GET_URL = " http://localhost:8080/Users";
            URL obj = new URL(GET_URL);
            
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
           
            int responseCode = con.getResponseCode();
            System.out.println("GET Response Code :: " + responseCode);
            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
    
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                
                String map = response.toString();
                JSONParser parse = new JSONParser();
                JSONArray dataObject;
                try {
                    dataObject = (JSONArray) parse.parse(String.valueOf(map));
                    System.out.println(dataObject.get(1));
                    for (int i = 0; i < dataObject.size(); i++) {
                    JSONObject data = (JSONObject) dataObject.get(i);
                    System.out.println(dataObject.get(i)); 
                    System.out.println(data.get("email"));
                    }
                } catch (ParseException e) {
                    
                    e.printStackTrace();
                }
    
        }
        }










    public static Jws<Claims> parseJwt(String jwtString) {

        String secret = "asdfSFS34wfsdfsdfSDSD32dfsddDDerQSNCK34SOWEK5354fdgdf4";

        Key hmacKey = new SecretKeySpec(Base64.getDecoder().decode(secret), SignatureAlgorithm.HS256.getJcaName());
    
    



        //XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXxx
        Jws<Claims> jwt = Jwts.parserBuilder()
                .setSigningKey(hmacKey)
                .build()
                .parseClaimsJws(jwtString);

                
        return jwt;
    }


    public static String createJwtSignedHMAC(String email) {

        String secret = "asdfSFS34wfsdfsdfSDSD32dfsddDDerQSNCK34SOWEK5354fdgdf4";

        Key hmacKey = new SecretKeySpec(Base64.getDecoder().decode(secret), SignatureAlgorithm.HS256.getJcaName());

        Instant now = Instant.now();

        String jwtToken = Jwts.builder()
              
                .claim("email", email)
               
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(now.plus(5l, ChronoUnit.MINUTES)))
                .signWith(hmacKey)
                .compact();

        return jwtToken;
    }










    public static boolean isTokenExpired(Date expiration) {
        return expiration.before(new Date());
    }


    public static boolean isTokenValid(String jwt, Claims claims) {
        Claims parsedClaims = parseJwt(jwt).getBody();
        return parsedClaims.equals(claims);
    }
   
}