package calls;

import common.GsonFunctions;
import common.RestAssuredFunctions;
import constants.ApiEndPoints;
import data.models.models.*;
import io.restassured.response.Response;

public class CrocodilesAPI {

    public static LoginResponse login(LoginRequest loginRequest) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.post(ApiEndPoints.LOGIN, loginRequest), LoginResponse.class);
    }

    public static String  crocodileID ( String accessToken){
        Response responseAllCrocodiles = RestAssuredFunctions.get(ApiEndPoints.MY_CROCODILES , accessToken);
        return responseAllCrocodiles.then().extract().response().path("[0].id").toString();

    }
    public static SingleCrocodileResponse createNewCrocodile(String accessToken, CreateCrocodileRequest createCrocodileRequest) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.post(ApiEndPoints.MY_CROCODILES, accessToken, createCrocodileRequest), SingleCrocodileResponse.class);
    }

    public static CrocodileResponse[] getPublicCrocodileResponse() {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get(ApiEndPoints.PUBLIC_CROCODILES), CrocodileResponse[].class);
    }

    public static CrocodileResponse[] getMyCrocodileResponses(String accessToken) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get(ApiEndPoints.MY_CROCODILES, accessToken), CrocodileResponse[].class);
    }
    public static SingleCrocodileResponse getCrocodileByIdResponse(String accessToken){
        return  GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get(ApiEndPoints.SINGLE_CROCODILE(crocodileID(accessToken)),accessToken),  SingleCrocodileResponse.class);
    }

    public static SingleCrocodileResponse deleteMyCrocodile(String accessToken) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.delete(ApiEndPoints.SINGLE_CROCODILE(crocodileID(accessToken)) + "/", accessToken),SingleCrocodileResponse.class);
    }

    public static SingleCrocodileResponse updateCrocodile(String accessToken, Object requestBody) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.put(ApiEndPoints.SINGLE_CROCODILE(crocodileID(accessToken)) + "/", accessToken, requestBody), SingleCrocodileResponse.class);
    }

    public static SingleCrocodileResponse patchCrocodile(String accessToken, Object requestBody) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.patch(ApiEndPoints.SINGLE_CROCODILE(accessToken) + "/", accessToken, requestBody), SingleCrocodileResponse.class);
    }
}