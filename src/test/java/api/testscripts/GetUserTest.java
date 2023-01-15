package api.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.GetUsersEnpoint;

public class GetUserTest {

	GetUsersEnpoint getUsers;
	
	@BeforeMethod
	public void init() {
		getUsers = new GetUsersEnpoint();
	}
	
	@Test
	public void getUsersTest() {
		getUsers.getUsers();
		getUsers.statusCodeValidation();
		getUsers.responseBodyValidation("data.id", 2);
		getUsers.responseBodyValidation("data.first_name", "Janet");
		getUsers.responseBodyValidation("data.last_name", "Weaver");
		getUsers.responseBodyValidation("data.email", "janet.weaver@reqres.in");
	}
}
