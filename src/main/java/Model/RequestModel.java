package Model;

import lombok.Data;

public class RequestModel {


    @Data
    public static class GetTokenModel {
        String username;
        String password;
    }

    @Data
    public static class BookingModel {
        String firstname;
        String lastname;
        int totalprice;
        boolean depositpaid;
        Bookingdates bookingdates;
        String additionalneeds;
    }

    @Data
    public static class Bookingdates{
        String checkin;
        String checkout;
    }

    @Data
    public static class NameModel{
        String firstname;
        String lastname;
    }



}
