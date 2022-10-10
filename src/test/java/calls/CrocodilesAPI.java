package calls;

import common.GsonFunctions;
import common.RestAssuredFunctions;
import data.models.*;
import io.restassured.response.Response;

public class CrocodilesAPI {

    public static LoginResponse login(LoginRequest loginRequest) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.post("auth/token/login/", loginRequest), LoginResponse.class);
    }

    public static String  crocodileID ( String accessToken){
        Response responseAllCrocodiles = RestAssuredFunctions.get("my/crocodiles/" , accessToken);
        return responseAllCrocodiles.then().extract().response().path("[0].id").toString();

    }
    public static SingleCrocodileResponse createNewCrocodile(String accessToken, CreateCrocodileRequest createCrocodileRequest) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.post("my/crocodiles/", accessToken, createCrocodileRequest), SingleCrocodileResponse.class);
    }

    public static CrocodileResponse[] getPublicCrocodileResponse() {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get("public/crocodiles/"), CrocodileResponse[].class);
    }

    public static CrocodileResponse[] getMyCrocodileResponses(String accessToken) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get("my/crocodiles/", accessToken), CrocodileResponse[].class);
    }
    public static SingleCrocodileResponse getCrocodileByIdResponse(String accessToken){
        return  GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get("/my/crocodiles/" +  crocodileID(accessToken),accessToken),  SingleCrocodileResponse.class);
    }

    public static SingleCrocodileResponse deleteMyCrocodile(String accessToken) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.delete("my/crocodiles/" + crocodileID(accessToken) + "/", accessToken),SingleCrocodileResponse.class);
    }

    public static SingleCrocodileResponse updateCrocodile(String accessToken, Object requestBody) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.put("my/crocodiles/" + crocodileID(accessToken) + "/", accessToken, requestBody), SingleCrocodileResponse.class);
    }

    public static SingleCrocodileResponse patchCrocodile(String accessToken, Object requestBody) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.patch("my/crocodiles/"+  crocodileID(accessToken)  + "/", accessToken, requestBody), SingleCrocodileResponse.class);
    }
}