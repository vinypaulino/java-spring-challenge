package com.vinypaulino.challenge.ubs;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UnidadeBasicaDeSaudeApiTest {
	
	@LocalServerPort
	private int port;
	
	@Test
	public void shouldReturnStatus200_When_find_UBSs() {
		RestAssured.given()
			.queryParam("query", "25.25654,-86.4000")
			.queryParam("page", 1)
			.basePath("api/v1/find_ubs")
			.port(port)
			.accept(ContentType.JSON)
		.when()
			.get()
		.then()
			.statusCode(HttpStatus.OK.value());
		
	}
	
	public void shouldReturnStatus400_When_the_parameters_are_missing() {
		RestAssured.given()
			.queryParam("query", "25.25654,-86.4000")
			.queryParam("page", 1)
			.basePath("api/v1/find_ubs")
			.port(port)
			.accept(ContentType.JSON)
		.when()
			.get()
		.then()
			.statusCode(HttpStatus.BAD_REQUEST.value());
		
	}

}
