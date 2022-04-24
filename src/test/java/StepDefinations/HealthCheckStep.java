package StepDefinations;

import Request.Request;
import io.cucumber.java.en.Given;
import io.restassured.response.Response;

public class HealthCheckStep {
    @Given("I check Health Check API")
    public void checkHealthCheckAPI() {
        Response response = Request.verifyAPIRunning();
    }
}
