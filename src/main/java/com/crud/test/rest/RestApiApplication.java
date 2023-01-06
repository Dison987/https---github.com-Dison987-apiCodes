package com.crud.test.rest;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class RestApiApplication extends JWTGenerateValidateHMAC{

	public static void main(String[] args)throws IOException {
		SpringApplication.run(RestApiApplication.class, args);
		// JWTGenerateValidateHMAC.sendGET();
		// System.out.println(JWTGenerateValidateHMAC.createJwtSignedHMAC(null));
		System.out.println("DONE");
	}

}




