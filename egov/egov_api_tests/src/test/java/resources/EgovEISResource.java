package resources;

import com.jayway.restassured.response.Response;
import utils.APILogger;
import utils.Properties;

import java.util.Map;

import static com.jayway.restassured.RestAssured.given;

public class EgovEISResource {

    public Response searchAttendance(Map jsonData, String auth_token) {
        new APILogger().log("Search Attendance is started -- ");
        Response response = given().request().with()
                .urlEncodingEnabled(false)
                .header("Content-Type", "application/json")
                .header("auth-token", auth_token)
                .body(jsonData)
                .when()
                .post(Properties.devServerUrl + Properties.searchAttendanceUrl);
        return response;
    }

    public Response createAttendance(String jsonData, String access_token) {

        new APILogger().log("Create Attendance is started -- ");
        Response response = given().request().with()
                .urlEncodingEnabled(false)
                .header("Content-Type", "application/json")
                .header("auth-token", access_token)
                .body(jsonData)
                .when()
                .post(Properties.devServerUrl + Properties.createAttendanceURL);
        return response;

    }

    public Response searchEmployee(Map jsonData, String access_token) {
        new APILogger().log("Search Employee is started -- ");
        Response response = given().request().with()
                .urlEncodingEnabled(false)
                .header("Content-Type", "application/json")
                .header("auth-token", access_token)
                .body(jsonData)
                .when()
                .post(Properties.devServerUrl + Properties.searchEmployeeURL);
        return response;
    }
}