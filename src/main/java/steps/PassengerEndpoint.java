package steps;

import utils.ReadConfig;
import utils.RestSteps;

public class PassengerEndpoint extends RestSteps{
	final String ENDPOINT = "/api/unknown/2";
	
	ReadConfig readConfig = new ReadConfig();
	
	public PassengerEndpoint() {
		setBaseUrl(readConfig.get("baseUrl"));
	}
	
	public void getPassenger() {
		sentAsGet(ENDPOINT);
	}
	
	public void statusCodeValidation() {
		getResponse().then().statusCode(200);
	}
	
}
