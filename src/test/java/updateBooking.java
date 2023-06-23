import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class updateBooking {

    /*
        curl -X PUT \
        https://restful-booker.herokuapp.com/booking/1 \
        -H 'Content-Type: application/json' \
        -H 'Accept: application/json' \
        -H 'Cookie: token=abc123' \
        -d '{
                "firstname" : "James",
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
    public void updateBookingTest(){

        JSONObject body = new JSONObject();
        body.put("firstname", "Ali");
        body.put("lastname", "Veli");
        body.put("totalprice", 300);
        body.put("depositpaid", false);

        JSONObject bookingDate = new JSONObject();
        bookingDate.put("checkin", "2023-06-25");
        bookingDate.put("checkout", "2023-06-26");

        body.put("bookingdates", bookingDate);
        body.put("additionalneeds", "Kahvaltı");

        Response response = given()
                .contentType(ContentType.JSON)
                .header("Cookie","token:9d26a60d9241160")
                .body(body.toString()).log().all()
                .put("https://restful-booker.herokuapp.com/booking/4902");

        response.prettyPrint();

    }
}
