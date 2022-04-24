package StepDefinations;

import Request.Request;
import io.cucumber.java.en.Given;
import io.restassured.response.Response;

public class CreateBookingStep {
    @Given("I create a new booking")
    public void createBookingStep() {
        Response response = Request.createBookingStep();
    }
}
