package Lesson6;

import Lesson6.Pages.TextBoxPage;
import org.junit.jupiter.api.Test;

public class TextBoxWithPageObjectsTests extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void fillFormTest() {
        textBoxPage.openPage()
                .setFullName("Ostap Suleyman Berta Maria Bender Bey")
                .setEmail("Osya@test.com")
                .setCurrentAddress("Moskva, Voznesenskij pereulok, 7")
                .setPermanentAddress("Better world 13")
                .clickSubmitButton()
                .checkName("Ostap Suleyman Berta Maria Bender Bey")
                .checkEmail("Osya@test.com")
                .checkCurrentAddress("Moskva, Voznesenskij pereulok, 7")
                .checkPermanentAddress("Better world 13");
    }
}
