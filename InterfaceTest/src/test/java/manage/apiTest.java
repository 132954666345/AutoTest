package manage;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class apiTest {

    public String token ;
    @Test
    public void ScheduledExecutorTest(){
        //创建单线程定时任务调度器
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

        //定义测试任务
        Runnable task = this::testGetInfo;

        //安排定时任务
        //延迟0秒，每隔3秒执行一次
        executor.scheduleAtFixedRate(task, 0, 3, java.util.concurrent.TimeUnit.SECONDS);

        //主线程等待10秒后关闭
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.shutdown();
    }

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
