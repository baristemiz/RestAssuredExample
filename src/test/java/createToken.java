import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class createToken {

    @Test
    public void createTokenTest(){
        /*
            curl -X POST \
        https://restful-booker.herokuapp.com/auth \
        -H 'Content-Type: application/json' \
        -d '{
        "username" : "admin",
        "password" : "password123"
        }'
         */

        JSONObject body = new JSONObject();
        body.put("username","admin");
        body.put("password","password123");

        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .body(body.toString()).log().all()
                .post("https://restful-booker.herokuapp.com/auth");

        response.prettyPrint();



    }
}
