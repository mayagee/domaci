package test.common;

import calls.CrocodilesAPI;
import data.models.LoginRequest;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class TestBase {
    public static String accessToken;

    @BeforeClass
    public void beforeClass() {
        RestAssured.baseURI = "https://test-api.k6.io";
            accessToken = CrocodilesAPI.login(new LoginRequest("Maja22", "QA2022")).getAccess();

    }

}
