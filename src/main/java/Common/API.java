package Common;

import Model.RequestModel;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;

import static Model.RequestModel.*;
import static io.restassured.RestAssured.given;

public class API {

    public RequestModel.GetTokenModel setGetTokenObject(String username, String pass){
        RequestModel.GetTokenModel getTokenModel = new RequestModel.GetTokenModel();
        getTokenModel.setUsername(username);
        getTokenModel.setPassword(pass);
        return getTokenModel;
    }

    public Response commonRequestPost(Object obj, String url){
        RestAssured.baseURI = url;
        RestAssured.defaultParser = Parser.JSON;
        return given().log().ifValidationFails().
                headers("Content-Type", ContentType.JSON).
//                header("Authorization", "bearer " + sessionId).
        when().
                body(obj).
                post().
                then().log().ifValidationFails().
                statusCode(200).
                extract().
                response();
    }

    public Response commonRequestGet(String url){
        RestAssured.baseURI = url;
        RestAssured.defaultParser = Parser.JSON;
        return given().log().ifValidationFails().
                headers("Content-Type", ContentType.JSON).
//                header("Authorization", "bearer " + sessionId).
        when().
                get().
                then().log().ifValidationFails().
                statusCode(200).
                extract().
                response();
    }

    public Response commonRequestGetCheck(String url, int stsCode){
        RestAssured.baseURI = url;
        RestAssured.defaultParser = Parser.JSON;
        return given().log().ifValidationFails().
                headers("Content-Type", ContentType.JSON).
//                header("Authorization", "bearer " + sessionId).
        when().
                get().
                then().log().ifValidationFails().
                statusCode(stsCode).
                extract().
                response();
    }

    public Response commonRequestPut(Object obj, String url){
      RestAssured.baseURI = url;
      RestAssured.defaultParser = Parser.JSON;
      return given().log().ifValidationFails().
              headers("Content-Type", ContentType.JSON).
              headers("Cookie", "token="+ GVs.TOKEN).
//                header("Authorization", "bearer " + sessionId).
        when().
              body(obj).
              put().
              then().log().ifValidationFails().
              statusCode(200).
              extract().
              response();
    }

    public Response commonRequestPatch(Object obj, String url){
        RestAssured.baseURI = url;
        RestAssured.defaultParser = Parser.JSON;
        return given().log().ifValidationFails().
                headers("Content-Type", ContentType.JSON).
                headers("Cookie", "token="+ GVs.TOKEN).
//                header("Authorization", "bearer " + sessionId).
        when().
                body(obj).
                patch().
                then().log().ifValidationFails().
                statusCode(200).
                extract().
                response();
    }

    public Response commonRequestDelete(String url){
        RestAssured.baseURI = url;
        RestAssured.defaultParser = Parser.JSON;
        return given().log().ifValidationFails().
                headers("Content-Type", ContentType.JSON).
                headers("Cookie", "token="+ GVs.TOKEN).
//                header("Authorization", "bearer " + sessionId).
        when().
                delete().
                then().log().ifValidationFails().
                statusCode(201).
                extract().
                response();
    }

    public RequestModel.BookingModel setCreateBookingObject(){
        RequestModel.BookingModel bookingModel = new RequestModel.BookingModel();

        RequestModel.Bookingdates bookingdates = new RequestModel.Bookingdates();
        bookingdates.setCheckin("2018-01-01");
        bookingdates.setCheckout("2019-01-01");

        bookingModel.setFirstname("Jim");
        bookingModel.setLastname("Brown");
        bookingModel.setTotalprice(111);
        bookingModel.setDepositpaid(true);
        bookingModel.setBookingdates(bookingdates);
        bookingModel.setAdditionalneeds("Breakfast");

        return bookingModel;
    }

    public RequestModel.BookingModel setUpdateBooking(){
        RequestModel.BookingModel bookingModel = new RequestModel.BookingModel();

        RequestModel.Bookingdates bookingdates = new RequestModel.Bookingdates();
        bookingdates.setCheckin("2018-01-01");
        bookingdates.setCheckout("2019-01-01");

        bookingModel.setFirstname("James");
        bookingModel.setLastname("Brown");
        bookingModel.setTotalprice(111);
        bookingModel.setDepositpaid(true);
        bookingModel.setBookingdates(bookingdates);
        bookingModel.setAdditionalneeds("Breakfast");
        return bookingModel;
    }

    public RequestModel.NameModel setPartialUpdateBookingObject(String firstname, String lastname){
        RequestModel.NameModel nameModel = new RequestModel.NameModel();
        nameModel.setFirstname(firstname);
        nameModel.setLastname(lastname);
        return nameModel;
    }
}
