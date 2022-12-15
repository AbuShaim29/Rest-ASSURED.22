 package api.test;

import static org.hamcrest.Matchers.*;
import java.util.List;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

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
@Test(enabled = false)
public void getCallBodyValidation() {
	RestAssured
	.given().log().all()
	.get("https://api.instantwebtools.net/v1/airlines/1")
	.then()
	.log().all()
	.statusCode(200)
    .body("name", equalTo("Quatar Airways"))
	.body("country", equalTo("Quatar"))
	.body("slogan", equalTo("Going Places Together"))
	.body("established",equalTo("1994"));
}

@Test(enabled = false)
public void getCallListValidation() {
	
			String Response =
	RestAssured
	.given()
	.get("https://api.instantwebtools.net/v1/airlines/")
	.then()
	.extract().response().asString();
			
			System.out.println(Response);
			JsonPath path =	JsonPath.from(Response);	
			
			List<String> airlineNameList = path.getList("name");
			for(String name : airlineNameList) {
				System.out.println(name);
			}
}
@Test(enabled = true)
public void getCallComplexListValidationJsonPath() {
	String Response =
	RestAssured
	.given()
	//.auth().basic("user","pass")
	.param("page","2")
	.log().all()
	.get("https://reqres.in/api/users")
	.then()
	.extract().response().asString();
			
			System.out.println(Response);
			JsonPath path =	JsonPath.from(Response);	
			 
			List<Integer> list = path.getList("data.id");
			for(int name : list) {
				System.out.println(name);
				
}
System.out.println("Size of the list"+list.size());
System.out.println(path.getInt("data.id[2]"));
}

}
