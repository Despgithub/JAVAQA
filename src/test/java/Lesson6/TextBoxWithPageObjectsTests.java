package Lesson6;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxWithPageObjectsTests extends TestBase {

    @Test
    void fillFormTest() {
        open("/text-box");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#userName").setValue("Ostap");
        $("#userEmail").setValue("Osya@test.com");
        $("#currentAddress").setValue("Moskva, Voznesenskij pereulok, 7");
        $("#permanentAddress").setValue("Better world 13");
        $("#submit").click();

        $("#output #name").shouldHave(text("Ostap"));
        $("#output #email").shouldHave(text("Osya@test.com"));
        $("#output #currentAddress").shouldHave(text("Moskva, Voznesenskij pereulok, 7"));
        $("#output #permanentAddress").shouldHave(text("Better world 13"));
    }
}
