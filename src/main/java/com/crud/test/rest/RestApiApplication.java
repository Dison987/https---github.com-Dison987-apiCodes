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











// package com.crud.test.rest;

// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.CommandLineRunner;
// import org.springframework.jdbc.core.JdbcTemplate;

// @SpringBootApplication  
// public class RestApiApplication implements CommandLineRunner {

// 	@Autowired
// 	private JdbcTemplate jdbcTemplate;

// 	public static void main(String[] args) {
// 	SpringApplication.run(RestApiApplication.class, args);
// 	System.out.println("this is running");
// 	}

// 	@Override
// 	public void run(String... args) throws Exception {
	
// 		jdbcTemplate.execute("DROP TABLE IF EXISTS students");
// 		jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS students" +
//               "  (name varchar, email varchar)");	

// 	String sql = "INSERT INTO students (name, email) VALUES ("
// 	+ "'Alex Tan', 'nam@codejava.net')";

// 	int rows = jdbcTemplate.update(sql);
// 	if (rows > 0) {
// 	System.out.println("A new row has been inserted.");
// 	}
// }
// }
