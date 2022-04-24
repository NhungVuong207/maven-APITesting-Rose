package StepDefinations;

import Request.Request;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

public class UpdateBookingStep {
    @Then("I update booking which I want")
    public void updateBookingStep() {
        Response response = Request.updateBookingStep();
    }
}
