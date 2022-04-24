package StepDefinations;

import Request.Request;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

public class DeleteBookingStep {
    @Then("I delete booking which I created")
    public void deleteBooking() {
        Response response = Request.deleteBooking();
    }
}
