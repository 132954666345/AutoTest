package api;


import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestApi {
    private Response response;

    //测试项目环境
    @Test
    public void test() {
        System.out.println("test");
    }

    /**
     * 通过rest-assured 实现接口自动化测试
     */
    @Test
    public void test1() {
        // 使用RestAssured进行接口测试的示例代码
        //请求四要素：请求方式 请求路径 请求参数 请求头
        given()//在什么场景下使用（请求头，请求参数，cookies等等）
                .queryParam("phone", "13800138000")
                .queryParam("password", "123456")
                .when()//请求方式（get，post，put，delete等等）
                .get("https://httpbin.org/get")
                .then()//
                .log().body()//打印日志
        ;
    }
    //get请求
    @Test
    public void test2() {
       Response  response = given()
                .when()
                .get("http://localhost:8080/user/findAllUser")
                .then()//
                .log().body()//打印日志
                .extract().response();
        System.out.println(response.getHeaders());
        System.out.println(response.jsonPath().get("name").toString());
    }
    //post请求
        @Test
        public void test4() {
            given()
                    .contentType("application/json")
                    .body("{\"name\": \"张三\", \"age\": 25}")
            .when()
                    .post("http://localhost:8080/user/addUser")
            .then()//
                    .log().body()//打印日志
            ;

        }

    @Test
    public void testEncrypt(){
         response = given()
                .when()
                .post("https://iot.easyctid.cn/herelink-manage-business2/api/1.0.0/business/system/free/login/encrypt")
                .then().log().body()
                .extract().response();
        String encryptId = response.jsonPath().get("data.encryptId").toString();
        System.out.println(encryptId);
    }

        @Test(dependsOnMethods = {"testEncrypt"})
    public void testLogin(){
          /*  Response response = given()
                    .when()
                    .post("https://iot.easyctid.cn/herelink-manage-business2/api/1.0.0/business/system/free/login/encrypt")
                    .then().log().body()
                    .extract().response();
            String encryptId = response.jsonPath().get("data.encryptId").toString();
            System.out.println(encryptId);*/
            System.out.println(response);
            given()
//                    .contentType("application/json;charset=UTF-8")
                    .formParam("mobile" ,"13295466345")
                    .formParam( "password" ,"c41a15db1773221f403ed21f4a53f45b")
                    .formParam( "encryptMode" ,"3DES")
                    .formParam( "encryptId" ,response.jsonPath().get("data.encryptId").toString())
//                .body("{\"mobile\": \"13295466345\", \"password\": \"Zzx@20251\",\"encryptMode\": \"3DES\",\"encryptId\": \""+response.jsonPath().get("data.encryptId")+"\"}")
                    .cookie ("HWWAFSESID=11b667393dba52c352; HWWAFSESTIME=1751941309772; ticket=TK4E0C5X1LSY2LJL5CV5WNN97UMCRUNF"  )
                    .log().all()
        .when()
                .post("https://iot.easyctid.cn/herelink-manage-business2/api/1.0.0/business/system/signin")
        .then().log().body();

        }

    }

