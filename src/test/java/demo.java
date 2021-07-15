import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class demo {
//    ...
    private ValidatableResponse getStudentById(Integer studentId) {
        return
                given()
                        // Uri - universal resource identifier
                        .baseUri("https://it-foundations.app.ap.assurity.cloud/")
                        .contentType(ContentType.JSON)
                        .when()
                        .get("people/" + String.valueOf(studentId)) // people/ added to the base uri
                        .then()
                        .statusCode(200); // expected result : 200 OK
    }

    @Test
    public void myTest() {
        getStudentById(2);
    }


//...
}
