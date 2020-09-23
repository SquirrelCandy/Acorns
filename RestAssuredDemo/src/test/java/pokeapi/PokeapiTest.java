package pokeapi;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import io.restassured.http.ContentType;

public class PokeapiTest {
	
	private String url = "https://pokeapi.co/api/v2/pokemon/ditto";

	@Test
	public void testDittoBaseExperienceIs101() {
		given().  //log().all().  // for logging
	    when().
	        get(url).
	    then().
	        assertThat().
	        body("base_experience",equalTo(101));
	}
	
	@Test
	public void testResponseStatusIs200() {
		given().
	    when().
	        get(url).
	    then().assertThat().statusCode(200);
	}
	
	@Test
	public void logResponseTime() {
		get(url).timeIn(TimeUnit.MILLISECONDS);
	}
	
	@Test
	public void testContentTypeIsApplicationJSON() {
		get(url).then().assertThat().contentType(ContentType.JSON);
	}
}
