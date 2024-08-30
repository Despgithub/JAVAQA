package Lesson6;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @AfterAll
    static void afterAll() {
        closeWebDriver();
    }

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
