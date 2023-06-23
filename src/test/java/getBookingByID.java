import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;


public class getBookingByID {

    @Test
    public void getBookingByIDTest(){

        // curl -i https://restful-booker.herokuapp.com/booking/1
        /*
            HTTP/1.1 200 OK

        {
            "firstname": "Sally",
            "lastname": "Brown",
            "totalprice": 111,
            "depositpaid": true,
            "bookingdates": {
            "checkin": "2013-02-23",
            "checkout": "2014-10-23"
            },
            "additionalneeds": "Breakfast"
          }
         */

        Response response = given()
                .when()
                .get("https://restful-booker.herokuapp.com/booking/3572");

        response
                .then()
                .statusCode(200);

        response.prettyPrint();

        String firstName = response.jsonPath().getJsonObject("firstname");
        String lastname = response.jsonPath().getJsonObject("lastname");
        int totalPrice = response.jsonPath().getJsonObject("totalprice");

        Assertions.assertEquals("John", firstName);
        Assertions.assertEquals("Smith", lastname);
        Assertions.assertEquals(111, totalPrice);

    }
}
