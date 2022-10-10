package test.asserts;

import data.models.*;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class CrocodileAsserts {

    public SoftAssert softAssert = new SoftAssert();;

    public void assertCreateNewCrocodile(SingleCrocodileResponse createCrocodileResponse, CreateCrocodileRequest createCrocodileRequest) {
        softAssert.assertEquals(createCrocodileResponse.getName(), createCrocodileRequest.getName(), "Name didn't match");
        softAssert.assertEquals(createCrocodileResponse.getDateOfBirth(), createCrocodileRequest.getDateOfBirth(), "date of birth didn't match");
        softAssert.assertEquals(createCrocodileResponse.getSex(), createCrocodileRequest.getSex(), "Sex didn't match");
        softAssert.assertAll();
    }

    public void assertListOfPublicCrocodiles(CrocodileResponse[] crocodileResponse) {
        for(int i = 0; i < crocodileResponse.length; i++) {
            softAssert.assertFalse(crocodileResponse[i].getName().isEmpty(), "Name is not empty");
        }
        softAssert.assertAll();
    }

    public void assertListOfMyCrocodiles(CrocodileResponse[] crocodileResponse) {
        for(int i = 0; i < crocodileResponse.length; i++) {
            softAssert.assertFalse(crocodileResponse[i].getName().isEmpty(), "Name is not empty");
        }
        softAssert.assertAll();
    }

    public void assertNewCrocodile(SingleCrocodileResponse getMyCrocodileResponses ){
        softAssert.assertNotNull(getMyCrocodileResponses, "response is not empty");
        //softAssert.assertSame();
        softAssert.assertAll();
    }

    public void assertDeleteSingleCrocodile(SingleCrocodileResponse singleCrocodileResponse){
        Assert.assertNull(singleCrocodileResponse, "Delete crocodile contains data");
    }

    public void assertUpdateMyCrocodile(SingleCrocodileResponse updateCrocodileResponse, SingleCrocodileResponse singleCrocodileResponse) {
        softAssert.assertEquals(updateCrocodileResponse.getName(), singleCrocodileResponse.getName(), "Name didn't match");
        softAssert.assertEquals(updateCrocodileResponse.getAge(), singleCrocodileResponse.getAge(), "Age didn't match");
        softAssert.assertEquals(updateCrocodileResponse.getDateOfBirth(), singleCrocodileResponse.getDateOfBirth(), "Date of birth didn't match");
        softAssert.assertEquals(updateCrocodileResponse.getSex(), singleCrocodileResponse.getSex(), "Sex didn't match");
        softAssert.assertAll();
    }

    public void assertPatchMyCrocodile(SingleCrocodileResponse patchCrocodileResponse, SingleCrocodileResponse singleCrocodileResponse) {
        softAssert.assertEquals(patchCrocodileResponse.getName(), singleCrocodileResponse.getName(), "Name didn't match");
        softAssert.assertAll();
    }
}
