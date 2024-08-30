package Lesson6;

import Lesson6.Pages.RegistrationPage;
import Lesson6.Pages.components.ResultTable;
import Lesson6.Utils.RandomUtils;
import org.junit.jupiter.api.Test;

public class RegistrationWithPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    ResultTable resultTable = new ResultTable();
    RandomUtils randomUtils = new RandomUtils();


    @Test
    void successfulRegistrationAllFieldsTest() {
        registrationPage.openPage()
                .setFirstName(randomUtils.firstName)
                .setLastName(randomUtils.lastName)
                .setEmail(randomUtils.email)
                .setGender(randomUtils.gender)
                .setUserNumber(randomUtils.userNumber)
                .setDateOfBirth(randomUtils.day, randomUtils.month, randomUtils.year)
                .setSubjects(randomUtils.subject)
                .selectHobbies(randomUtils.hobbies)
                .uploadPicture(randomUtils.picture)
                .setAddress(randomUtils.address)
                .selectState(randomUtils.state)
                .selectCity(randomUtils.city)
                .clickSubmitButton();

        resultTable.appear().checkHeader()
                .checkTableValue("Student Name", randomUtils.firstName + " " + randomUtils.lastName)
                .checkTableValue("Student Email", randomUtils.email)
                .checkTableValue("Gender", randomUtils.gender)
                .checkTableValue("Mobile", randomUtils.userNumber)
                .checkTableValue("Date of Birth", randomUtils.day + " " + randomUtils.month + "," + randomUtils.year)
                .checkTableValue("Subjects", randomUtils.subject)
                .checkTableValue("Hobbies", randomUtils.hobbies)
                .checkTableValue("Picture", randomUtils.picture)
                .checkTableValue("Address", randomUtils.address)
                .checkTableValue("State and City", randomUtils.state + " " + randomUtils.city);
    }

    @Test
    void successfulRegistrationRequiredFieldsTest() {
        registrationPage.openPage()
                .setFirstName(randomUtils.firstName)
                .setLastName(randomUtils.lastName)
                .setGender(randomUtils.gender)
                .setUserNumber(randomUtils.userNumber)
                .clickSubmitButton();

        resultTable.appear().checkHeader()
                .checkTableValue("Student Name", randomUtils.firstName + " " + randomUtils.lastName)
                .checkTableValue("Gender", randomUtils.gender)
                .checkTableValue("Mobile", randomUtils.userNumber);
    }

    @Test
    void unSuccessfulRegistrationTest() {
        registrationPage.openPage().clickSubmitButton();

        resultTable.notAppear();
    }


}
