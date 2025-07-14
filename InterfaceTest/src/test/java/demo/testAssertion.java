package demo;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class testAssertion {

    @Test
    public void testResponseBody(){
        given()
                .when().get("https://httpbin.ceshiren.com/get")
                .then().log().all()
                .body("origin",equalTo("183.192.0.66, 182.92.156.22"))
        ;
    }



}
