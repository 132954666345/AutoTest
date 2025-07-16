package manage;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class apiTest {

    public String token ;

    //执行登录，获取token
    @BeforeClass
    public void  setup(){
        RestAssured.baseURI = "http://47.99.33.104/api";
        Map<String,Object> map = new HashMap<>();
        map.put("username","manager");
        map.put("password","Qq@123");
        token = given()
                .contentType("application/json")
                .body(map)
                .log().all()
                .when().post("/login")
                .then().log().all()
                .extract().path("token");
    }
    @Test
    public void testGetInfo() {
        given()
                .header("Authorization",token)
                .when()
                .get("/getInfo")
                .then().log().all()
                .assertThat().statusCode(200);


    }

}
