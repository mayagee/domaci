package test;

import calls.CrocodilesAPI;
import data.models.*;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.asserts.CrocodileAsserts;
import test.common.TestBase;


public class CrocodileTest extends TestBase {


    public CrocodileAsserts crocodileAsserts = new CrocodileAsserts();

    @Test
    public void loginTest() {
        Assert.assertFalse(accessToken.isEmpty(), "Access token is empty");
    }

    @Test
    @Description("verify crocodile is created")
    public void createCrocodileTest() {
        CreateCrocodileRequest createCrocodileRequest = new CreateCrocodileRequest("Mila", "M", "2020-12-12");
        SingleCrocodileResponse createCrocodileResponse = CrocodilesAPI.createNewCrocodile(accessToken, createCrocodileRequest);
        crocodileAsserts.assertCreateNewCrocodile(createCrocodileResponse, createCrocodileRequest);
    }

    @Test
    @Description( "List of public crocodiles")
    public void getListOfPublicCrocodiles() {
        CrocodileResponse[] crocodileResponse = CrocodilesAPI.getPublicCrocodileResponse();
        crocodileAsserts.assertListOfPublicCrocodiles(crocodileResponse);
    }

    @Test
    @Description("List of my crocodiles")
    public void getListOfMyCrocodiles() {
        CrocodileResponse[] crocodileResponse = CrocodilesAPI.getMyCrocodileResponses(accessToken);
        crocodileAsserts.assertListOfMyCrocodiles(crocodileResponse);
    }

    @Test
    @Description("My crocodile by ID")
    public void getCrocodileById() {
        SingleCrocodileResponse singleCrocodileResponse = CrocodilesAPI.getCrocodileByIdResponse(accessToken);
        crocodileAsserts.assertNewCrocodile(singleCrocodileResponse);
    }

    @Test
    @Description("Delete crocodile")
    public void  deleteMyCrocodile(){
        SingleCrocodileResponse singleCrocodileResponse = CrocodilesAPI.deleteMyCrocodile(accessToken);
        crocodileAsserts.assertDeleteSingleCrocodile(singleCrocodileResponse);
    }

    @Test
    @Description("Patch crocodile")
    public void patchCrocodile() {
        SingleCrocodileResponse singleCrocodileResponse = CrocodilesAPI.getCrocodileByIdResponse(accessToken);
        singleCrocodileResponse.setName("Darija");
        SingleCrocodileResponse patchCrocodileResponse = CrocodilesAPI.patchCrocodile(accessToken,singleCrocodileResponse);
        crocodileAsserts.assertPatchMyCrocodile(patchCrocodileResponse, singleCrocodileResponse);
    }


    @Test
    @Description("Update crocodile")
    public void updateCrocodile() {
        SingleCrocodileResponse singleCrocodileResponse = CrocodilesAPI.getCrocodileByIdResponse(accessToken);
        singleCrocodileResponse.setName("Jasmina");
        singleCrocodileResponse.setAge(2);
        singleCrocodileResponse.setSex("F");
        singleCrocodileResponse.setDateOfBirth("2020-05-10");
        SingleCrocodileResponse updateCrocodileResponse = CrocodilesAPI.updateCrocodile(accessToken,singleCrocodileResponse);
        crocodileAsserts.assertUpdateMyCrocodile(updateCrocodileResponse, singleCrocodileResponse);


    }



}
