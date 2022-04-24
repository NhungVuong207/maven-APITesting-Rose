package StepDefinations;

import Request.Request;
import io.cucumber.java.en.Given;
import io.restassured.response.Response;

public class GetBooking {
    @Given("I get booking which I want")
    public void getBookingStep() {
        Response response = Request.getBookingStep();
    }
}
