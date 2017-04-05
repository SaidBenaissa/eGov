package tests.eGovEIS.searchEISMaster;

import builders.eGovEIS.searchEISMaster.RequestInfoBuilder;
import builders.eGovEIS.searchEISMaster.SearchEmployeeMasterRequestBuilder;
import com.jayway.restassured.response.Response;
import entities.requests.eGovEIS.searchEISMaster.RequestInfo;
import entities.requests.eGovEIS.searchEISMaster.SearchEmployeeMasterRequest;
import entities.responses.eGovEIS.searchEISMasters.position.SearchPositionResponse;
import entities.responses.login.LoginResponse;
import org.junit.Assert;
import org.testng.annotations.Test;
import resources.searchEISMaster.EISMasterResource;
import utils.APILogger;
import utils.LoginAndLogoutHelper;
import utils.RequestHelper;
import utils.ResponseHelper;

import java.io.IOException;

public class EISPositionTest {

    @Test
    public void searchPositionTest() throws IOException {

        // Login Test
        LoginResponse loginResponse = LoginAndLogoutHelper.login("narasappa");

        // Search Designation Test
        searchPositionTestMethod(loginResponse);
    }

    private void searchPositionTestMethod(LoginResponse loginResponse)throws IOException {

        RequestInfo requestInfo = new RequestInfoBuilder()
                .withAuthToken(loginResponse.getAccess_token())
                .build();

        SearchEmployeeMasterRequest searchEmployeeMasterRequest = new SearchEmployeeMasterRequestBuilder()
                .withRequestInfo(requestInfo)
                .build();

        Response response = new EISMasterResource().
                searchPosition(RequestHelper.getJsonString(searchEmployeeMasterRequest));

        SearchPositionResponse searchPositionResponse = (SearchPositionResponse)
                ResponseHelper.getResponseAsObject(response.asString() ,SearchPositionResponse.class );

        Assert.assertEquals(response.getStatusCode() , 200);
        Assert.assertEquals(searchPositionResponse.getPosition().length , 10);

        new APILogger().log("Search Position Test is Completed--");
    }

}
