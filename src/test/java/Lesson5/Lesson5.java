package Lesson5;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Lesson5 {

    @Test
    void EnterprizeTest() {
        Configuration.browserSize = "1920x1080";
        open("https://github.com/");
        $(byText("Solutions")).hover();
        $(byText("Enterprise")).click();
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered developer platform."));
    }

    @Test
    void DragAndDropTest() {
        Configuration.browserSize = "1920x1080";
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").dragAndDrop(to("#column-b"));
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }

    @Test
    void ActionsTest() {
        Configuration.browserSize = "1920x1080";
        open("https://the-internet.herokuapp.com/drag_and_drop");
        actions().moveToElement($("#column-a")).clickAndHold().moveToElement($("#column-b")).release().perform();
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }

}
