package business2;

import io.restassured.http.Header;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class yys2507 {
    private String url = "https://zd-iot.here.link";

    @Test
    public void testSelect(){
        Map<String,Object> map = new HashMap<>();
        map.put("foo","实例");
        given().cookie("ticket=TKWCJAAVXTMCDKGC28897T48FWHRDBSL")
                .header("intebox-sso-tkt", "TK1G5IX0KWU3ME1ZCGFV48QINS6Z58I1")
//                .header(new Header("foo","msg"))
                .body(map)
                .log().all()

                .when().post(url+"/herelink-manage-business2/api/v2/web/yys/select")

                .then().log().all()
                .assertThat().statusCode(200);
    }
    @Test
    public void testAddUser(){
        Map<String,Object> map = new HashMap<>();
        map.put("mobile","15619293847");
        map.put("userName","运营商测试");
        map.put("regionName","朝阳区");
        map.put("yysName","移动");

        given().cookie("ticket=TKWCJAAVXTMCDKGC28897T48FWHRDBSL")
                .contentType("application/json")
                .body(map)
                .header("intebox-sso-tkt", "TK1G5IX0KWU3ME1ZCGFV48QINS6Z58I1")
                .log().all()
                .when().post(url+"/herelink-manage-business2/api/v2/web/yys/add/user")
                .then().log().all()
                .body("errorCode",equalTo(0))
        ;
    }
    @Test
    public void testEditUser(){
        Map<String,Object> map = new HashMap<>();
        map.put("id",28);
        map.put("mobile","15619293847");
        map.put("userName","<script>alert(1)</script>");
        map.put("regionName","朝阳区");
        map.put("yysName","联通");

        given().cookie("ticket=TKWCJAAVXTMCDKGC28897T48FWHRDBSL")
                .contentType("application/json")
                .body(map)
                .header("intebox-sso-tkt", "TK1G5IX0KWU3ME1ZCGFV48QINS6Z58I1")
                .log().all()
                .when().post(url+"/herelink-manage-business2/api/v2/web/yys/edit/user")
                .then().log().all()
                .body("errorCode",equalTo(0))
        ;
    }
    @Test
    public void testDelUser(){
        Map<String,Object> map = new HashMap<>();
        map.put("id",28);
        map.put("mobile","15619293847");
        map.put("userName","运营商测试2");
        map.put("regionName","朝阳区");
        map.put("yysName","联通");

        given()
//                .cookie("ticket=TKWCJAAVXTMCDKGC28897T48FWHRDBSL")
                .contentType("application/json")
                .body(map)
                .header("intebox-sso-tkt", "TK1G5IX0KWU3ME1ZCGFV48QINS6Z58I1")
                .log().all()
                .when()
                    .post(url+"/herelink-manage-business2/api/v2/web/yys/del/user")
                .then()
                .log().all()
                .body("errorCode",equalTo(0))
        ;
    }
    @Test
    public void testPageUser(){
        Map<String,Object> map = new HashMap<>();
        map.put("keyword","关键字");
        map.put("pageNum","1");
        map.put("pageSize","10");

        given().cookie("ticket=TKWCJAAVXTMCDKGC28897T48FWHRDBSL")
                .contentType("application/json")
                .body(map)
                .header("intebox-sso-tkt", "TK1G5IX0KWU3ME1ZCGFV48QINS6Z58I1")
                .log().all()
                .when().post(url+"/herelink-manage-business2/api/v2/web/yys/page/user")
                .then().log().all()
                .body("errorCode",equalTo(0))
        ;
    }
    @Test
    public void testPageRoomList(){
        Map<String,Object> map = new HashMap<>();
        given().cookie("ticket=TKWCJAAVXTMCDKGC28897T48FWHRDBSL")
                .contentType("application/json")
                .body(map)
                .header("intebox-sso-tkt", "TK1G5IX0KWU3ME1ZCGFV48QINS6Z58I1")
                .log().all()
                .when().post(url+"/herelink-manage-business2/api/v2/web/yys/page/room/list")
                .then().log().all()
                .body("errorCode",equalTo(0))
        ;
    }
    @Test
    public void testSelectManage(){
        Map<String,Object> map = new HashMap<>();
        given().cookie("ticket=TKWCJAAVXTMCDKGC28897T48FWHRDBSL")
                .contentType("application/json")
                .body(map)
                .header("intebox-sso-tkt", "TK1G5IX0KWU3ME1ZCGFV48QINS6Z58I1")
                .log().all()
                .when().post(url+"/herelink-manage-business2/api/v2/web/yys/select/manage")
                .then().log().all()
                .assertThat().statusCode(200)
        ;
    }
    @Test
    public void test1()  {
        Properties properties = new  Properties();
        try {
            InputStream input = getClass().getClassLoader().getResourceAsStream("case.properties");
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
      Map<String,Object> map = new HashMap<>();
        String[] foos = properties.getProperty("foo").split(",");
        for (int i = 0; i < foos.length; i++) {
            map.put("foo",foos[i]);
            System.out.println(map);
        }

    }







}
