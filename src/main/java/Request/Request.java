package Request;

import Common.API;
import Common.GVs;
import Model.RequestModel;
import io.restassured.response.Response;
import io.restassured.path.json.JsonPath;

public class Request {
    public static Response getTokenWithAccount(String username,String password){
        API api = new API();

        //Set body cho request
        RequestModel.GetTokenModel getTokenModel = api.setGetTokenObject(username,password);

        //Send Request
        Response response = api.commonRequestPost(getTokenModel, GVs.GET_TOKEN);

        //Xu ly Respone
        JsonPath jsonPath = response.jsonPath();
        String token = jsonPath.get("token");
        System.out.println("TOKENNNNNNNNNNNNNNNN " + token );
        GVs.TOKEN = token;
        return response;
    }

    public static Response getBookingIDStep(){
        API api = new API();
        //Send Request
        Response response = api.commonRequestGet(GVs.GET_BOOKING_ID);
        System.out.println("RESPONSE GET BOOKING ID" + response.prettyPrint());
        return response;
    }

    public static Response getBookingStep(){
        API api = new API();
        Response response = api.commonRequestGet(GVs.GET_BOOKING_ID+GVs.ID_BOOKING);
        System.out.println("RESPONE GET BOOKING ID 1 " + response.prettyPrint());
        return response;
    }

    public static Response createBookingStep(){
        API api = new API();
        RequestModel.BookingModel bookingModel = api.setCreateBookingObject();
        Response response = api.commonRequestPost(bookingModel,GVs.RESTFUL_URL);
        System.out.println("RESPONSE CREATE BOOKING" + response.prettyPrint());
        JsonPath jsonPath = response.jsonPath();
        int bookingId = jsonPath.get("bookingid");
        System.out.println(bookingId);
        GVs.BOOKING_ID = bookingId;
        return response;
    }

    public static Response updateBookingStep(){
        API api = new API();
        RequestModel.BookingModel bookingModel = api.setUpdateBooking();
        Response response = api.commonRequestPut(bookingModel,GVs.RESTFUL_URL+ GVs.ID_BOOKING);
        System.out.println("RESPONSE UPDATE BOOKING " +response.prettyPrint());
        return response;
    }

    public static Response updatePartialPayload(String firstname, String lastname){
        API api = new API();
        RequestModel.NameModel nameModel = api.setPartialUpdateBookingObject(firstname,lastname);
        Response response = api.commonRequestPatch(nameModel,GVs.RESTFUL_URL+GVs.ID_BOOKING);
        System.out.println("RESPONSE UPDATE PARTIAL PAYLOAD" + response.prettyPrint());
        return response;
    }
    public static Response deleteBooking(){
        API api = new API();
        Response response = api.commonRequestDelete(GVs.RESTFUL_URL+GVs.BOOKING_ID);
        System.out.println("DELETED BOOKING ID" + GVs.BOOKING_ID + response.prettyPrint());
        return response;
    }

    public static Response verifyAPIRunning(){
        API api = new API();
        Response response = api.commonRequestGetCheck(GVs.RESTFUL_PING,201);
        System.out.println("API is running" + response.prettyPrint());
        return response;
    }
}
