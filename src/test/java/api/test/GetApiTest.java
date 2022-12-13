package api.test;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import io.restassured.RestAssured;

public class GetApiTest {
@Test(enabled = false)
public void getCallStatusCodeValidation() {
	RestAssured
	.given().log().all()
	.get("https://api.instantwebtools.net/v1/airlines/1")
	.then()
	.log().all()
	.statusCode(200);
}
@Test(enabled = false)
public void getCallStatusCodeValidationFail() {
	RestAssured
	.given().log().all()
	.get("https://api.instantwebtools.net/v1/airlines/1")
	.then()
	.log().all()
	.statusCode(201);

}
@Test(enabled = true)
public void getCallBodyValidation() {
	RestAssured
	.given().log().all()
	.get("https://api.instantwebtools.net/v1/airlines/1")
	.then()
	.log().all()
	.statusCode(200)
    .body("name",Matchers.equalTo("Quatar Airways"))
	.body("country",Matchers.equalTo("Quatar"))
	.body("slogan", Matchers.equalTo("Going Places Together"));
}

}
