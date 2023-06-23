import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class createBooking {

    /*
    curl -X POST \
    https://restful-booker.herokuapp.com/booking \
    -H 'Content-Type: application/json' \
    -d '{
            "firstname" : "Jim",
            "lastname" : "Brown",
            "totalprice" : 111,
            "depositpaid" : true,
            "bookingdates" : {
            "checkin" : "2018-01-01",
            "checkout" : "2019-01-01"
        },
        "additionalneeds" : "Breakfast"
       }'
     */

    @Test
    public void createBookingTest(){

        JSONObject body = new JSONObject();
        body.put("firstname", "Baris");
        body.put("lastname", "Temiz");
        body.put("totalprice", 200);
        body.put("depositpaid", true);

        JSONObject bookingDate = new JSONObject();
        bookingDate.put("checkin", "2023-06-22");
        bookingDate.put("checkout", "2023-06-23");

        body.put("bookingdates", bookingDate);
        body.put("additionalneeds", "Klima");


        Response response = given()
                .when()
                .contentType(ContentType.JSON)
                .body(body.toString())
                .post("https://restful-booker.herokuapp.com/booking");

        response
                .then()
                .statusCode(200);

        response.prettyPrint();

    }
}
