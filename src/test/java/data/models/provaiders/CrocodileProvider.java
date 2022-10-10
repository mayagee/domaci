package data.models.provaiders;

import com.github.javafaker.Faker;
import common.ValueChoosers;
import data.models.models.CreateCrocodileRequest;


public class CrocodileProvider {

    public static CreateCrocodileRequest prepareCrocodileRequest() {
        CreateCrocodileRequest createCrocodileRequest = new CreateCrocodileRequest();
        createCrocodileRequest.setName(Faker.instance().gameOfThrones().character());
        createCrocodileRequest.setSex(ValueChoosers.getRandomSex());
        createCrocodileRequest.setDateOfBirth(ValueChoosers.getRandomDate());

        return createCrocodileRequest;
    }
}
