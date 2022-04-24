package StepDefinations;

import Request.Request;
import io.cucumber.java.en.Given;
import io.restassured.response.Response;

public class GetBookingIDStep {
     @Given("I get booking by ID")
          public void getBookingIDStep() {
         Response response = Request.getBookingIDStep();
        }
    }

