package StepDefinations;

import Request.Request;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class PartialUpdateBookingStep {
    @When("I update a current booking with a partial payload with firstname {word} and lastname {word}")
    public void updatePartialPayloadWithInformation(String firstname, String lastname) {
        Response response = Request.updatePartialPayload(firstname,lastname);

    }
}
