package Lesson4;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class XPath {

    @Test
    void softAssertionsSearchTest() {
        Configuration.browserSize = "1920x1080";
        open("https://github.com/selenide/selenide");
        $x("//a[@id='wiki-tab']").click();
        $x("//div[@class='wiki-rightbar']//button[contains(text(),'Show 3 more pages…')]").click();
        $x("//a[@href='/selenide/selenide/wiki/SoftAssertions']").shouldHave(text("Soft assertions")).click();
        $x("//div[@id='wiki-content']").shouldHave(text("Using JUnit5 extend test class"));
    }
}
