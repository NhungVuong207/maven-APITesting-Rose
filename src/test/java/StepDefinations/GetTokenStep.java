package StepDefinations;



import Request.Request;
import io.cucumber.java.en.Given;
import io.restassured.response.Response;


public class GetTokenStep {
    @Given("I create new token with username {word} and password {word}")
    public void getTokenWithAccount(String username, String pass) {
        Response response = Request.getTokenWithAccount(username,pass);

    }
}
