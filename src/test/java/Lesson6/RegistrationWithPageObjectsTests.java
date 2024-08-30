package Lesson6;

import Lesson6.Pages.RegistrationPage;
import Lesson6.Pages.components.ResultTable;
import org.junit.jupiter.api.Test;

public class RegistrationWithPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    ResultTable resultTable = new ResultTable();

    @Test
    void successfulRegistrationAllFieldsTest() {
        registrationPage.openPage()
                .setFirstName("Ostap")
                .setLastName("Suleyman Berta Maria Bender Bey")
                .setEmail("Osya@test.com")
                .setGender("Male")
                .setUserNumber("9876543210")
                .setDateOfBirth("25", "August", "2024")
                .setSubjects("Commerce")
                .selectHobbies("Sports")
                .uploadPicture("Ostap.png")
                .setAddress("Moskva, Voznesenskij pereulok, 7")
                .selectState("NCR")
                .selectCity("Delhi")
                .clickSubmitButton();

        resultTable.appear().checkHeader()
                .checkTableValue("Student Name", "Ostap Suleyman Berta Maria Bender Bey")
                .checkTableValue("Student Email", "Osya@test.com")
                .checkTableValue("Gender", "Male")
                .checkTableValue("Mobile", "9876543210")
                .checkTableValue("Date of Birth", "25 August,2024")
                .checkTableValue("Subjects", "Commerce")
                .checkTableValue("Hobbies", "Sports")
                .checkTableValue("Picture", "Ostap.png")
                .checkTableValue("Address", "Moskva, Voznesenskij pereulok, 7")
                .checkTableValue("State and City", "NCR Delhi");
    }

    @Test
    void successfulRegistrationRequiredFieldsTest() {
        registrationPage.openPage()
                .setFirstName("Ostap")
                .setLastName("Suleyman Berta Maria Bender Bey")
                .setGender("Male")
                .setUserNumber("9876543210")
                .clickSubmitButton();

        resultTable.appear().checkHeader()
                .checkTableValue("Student Name", "Ostap Suleyman Berta Maria Bender Bey")
                .checkTableValue("Gender", "Male")
                .checkTableValue("Mobile", "9876543210");
    }

    @Test
    void unSuccessfulRegistrationTest() {
        registrationPage.openPage().clickSubmitButton();

        resultTable.notAppear();
    }


}
