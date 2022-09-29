package rest.methods;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import rest.helpers.Util;

import java.io.File;

import static io.restassured.RestAssured.given;

public class RestMethod {

    Util util = new Util();
    String petId;
    String base = util.getProperty("BASE-URL");

    public void postANewPet(JSONObject testData, int expectedStatusCode) {

        RestAssured.baseURI = base;

        Response postResponse = given()
                .contentType("application/json; charset=UTF-8")
                .body(testData.toString())
                .when()
                .post("/pet")
                .then()
                .log().body()
                .statusCode(expectedStatusCode)
                .extract().response();
    }

    public void postUploadIMage(JSONObject testData, int expectedStatusCode) {

        RestAssured.baseURI = base;
        petId = Integer.toString(testData.getInt("id"));
        File file = new File(System.getProperty("user.dir") + util.getProperty("IMAGE-PATH"));

        Response postResponse = given()
                .multiPart("file", file, "multipart/form-data")
                .body(testData.toString())
                .when()
                .post("/pet/" + petId + "/uploadImage")
                .then()
                .log().body()
                .statusCode(expectedStatusCode)
                .extract().response();
    }

    public void postNotUploadIMage(JSONObject testData, int expectedStatusCode) {

        RestAssured.baseURI = base;
        petId = Integer.toString(testData.getInt("id"));
        File file = new File(System.getProperty("user.dir") + util.getProperty("IMAGE-PATH"));

        Response postResponse = given()
                .multiPart("file", file, "multipart/form-data")
                .when()
                .post("/" + petId + "/uploadImage")
                .then()
                .log().body()
                .statusCode(expectedStatusCode)
                .extract().response();
    }

    public void getById(JSONObject testData, int expectedStatusCode) {

        RestAssured.baseURI = base;
        petId = Integer.toString(testData.getInt("id"));

        Response getResponse = given()
                .contentType("application/json; charset=UTF-8")
                .when()
                .get("/pet/" + petId)
                .then()
                .log().body()
                .statusCode(expectedStatusCode)
                .extract().response();
    }

    public void getByStatus(String status, int expectedStatusCode) {

        RestAssured.baseURI = base;

        Response getResponse = given()
                .queryParam("status", status)
                .contentType("application/json; charset=UTF-8")
                .when()
                .get("/pet/findByStatus")
                .then()
                .log().body()
                .statusCode(expectedStatusCode)
                .extract().response();
    }

    public void updateAPet(JSONObject testData, int expectedStatusCode) {

        RestAssured.baseURI = base;

        Response putResponse = given()
                .contentType("application/json; charset=UTF-8")
                .body(testData.toString())
                .when()
                .put("/pet")
                .then()
                .log().body()
                .statusCode(expectedStatusCode)
                .extract().response();
    }

    public void updateAPetWithFormData(JSONObject testData, int expectedStatusCode) {

        RestAssured.baseURI = base;
        petId = Integer.toString(testData.getInt("id"));
        String petIdNew = Integer.toString(testData.getInt("id") + 1);

        Response postResponse = given()
                .contentType("application/x-www-form-urlencoded")
                .formParam("name", "dog111")
                .formParam("status", "pending")
                .when()
                .post("/pet/" + petId)
                .then()
                .log().body()
                .statusCode(expectedStatusCode)
                .extract().response();
    }

    public void updateNotAPetWithFormData(JSONObject testData, int expectedStatusCode) {

        RestAssured.baseURI = base;
        petId = Integer.toString(testData.getInt("id"));
        String petIdNew = Integer.toString(testData.getInt("id") + 1);

        Response postResponse = given()
                .contentType("application/json")
                .formParam("name", "dog111")
                .formParam("status", "pending")
                .when()
                .post("/pet/" + petId)
                .then()
                .log().body()
                .statusCode(expectedStatusCode)
                .extract().response();
    }

    public void deleteAPet(JSONObject testData, int expectedStatusCode) {

        RestAssured.baseURI = base;
        petId = Integer.toString(testData.getInt("id"));

        Response postResponse = given()
                .contentType("application/json; charset=UTF-8")
                .when()
                .delete("/pet/" + petId)
                .then()
                .log().body()
                .statusCode(expectedStatusCode)
                .extract().response();
    }
}
