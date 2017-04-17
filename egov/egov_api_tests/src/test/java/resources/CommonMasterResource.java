package resources;

import com.jayway.restassured.response.Response;
import org.codehaus.jackson.map.MapperConfig;
import tests.BaseAPITest;
import utils.APILogger;
import utils.Properties;

import static com.jayway.restassured.RestAssured.given;

public class CommonMasterResource extends BaseAPITest{

    public Response searchLanguageTest(String json) {
        new APILogger().log("Search Language Request Test is Started with --" + json);
        Response response = given().request().with()
                .header("Content-Type", "application/json")
                .body(json)
                .when()
                .post(Properties.cmLanguageUrl);

        new APILogger().log("Search Language Response Test is Generated as --" + response.asString());
        return response;
    }

    public Response searchDepartmentTest(String jsonString) {
        new APILogger().log("Search Department Request Test is started with --" + jsonString);
        Response response = given().request().with()
                .header("Content-Type", "application/json")
                .body(jsonString)
                .when()
                .post(Properties.cmDepartmentUrl);

        new APILogger().log("Search Department Response Test is Generated as --" + response.asString());
        return response;
    }

    public Response searchCommunityTest(String jsonString) {

        new APILogger().log("Search Community Request Test is started with --" + jsonString);
        Response response = given().request().with()
                .header("Content-Type", "application/json")
                .body(jsonString)
                .when()
                .post(Properties.cmCommunityUrl);

        new APILogger().log("Search Community Response Test is Generated as --" + response.asString());
        return response;
    }

    public Response searchReligionTest(String jsonString) {

        new APILogger().log("Search Religion Request Test is started with --" + jsonString);
        Response response = given().request().with()
                .header("Content-Type", "application/json")
                .body(jsonString)
                .when()
                .post(Properties.cmReligionUrl);

        new APILogger().log("Search Religion Response Test is Generated as --" + jsonString);
        return response;
    }

    public Response searchHolidayTest(String jsonString) {

        new APILogger().log("Search Holiday Request Test is started with --" + jsonString);
        Response response = given().request().with()
                .header("Content-Type", "application/json")
                .body(jsonString)
                .when()
                .post(Properties.cmHolidayUrl);

        new APILogger().log("Search Holiday Response Test is Generated as --" + response.asString());
        return response;
    }

    public Response searchCategoryTest(String jsonString) {

        new APILogger().log("Search Category Request Test is started with --" + jsonString);
        Response response = given().request().with()
                .header("Content-Type", "application/json")
                .body(jsonString)
                .when()
                .post(Properties.cmCategoryUrl);

        new APILogger().log("Search Category Response Test is Generated as --" + response.asString());
        return response;
    }

    public Response createHoliday(String jsonString) {
        new APILogger().log("Create Holiday Request Test is started with --" + jsonString);
        Response response = given().request().with()
                .header("Content-Type", "application/json")
                .body(jsonString)
                .when()
                .post(Properties.cmCreateHolidayUrl);

        new APILogger().log("Create Holiday Response Test is Generated as --" + response.asString());
        return response;
    }
}
