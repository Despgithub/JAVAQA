package Lesson6.Pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultTable {

    public ResultTable checkHeader() {
        resultWindowHeader
                .shouldBe(visible)
                .shouldHave(text("Thanks for submitting the form"));
        return this;
    }

    private final SelenideElement resultWindow = $(".modal-dialog"),
            resultWindowHeader = resultWindow.$("#example-modal-sizes-title-lg"),
            resultTable = resultWindow.$(".table-responsive");

    public ResultTable checkTableValue(String key, String value) {
        resultTable
                .$(byText(key))
                .parent()
                .shouldHave(text(value));
        return this;
    }

    public ResultTable notAppear() {
        resultWindow.shouldNot(appear);
        return this;
    }

    public ResultTable appear() {
        resultWindow.should(appear);
        return this;
    }


}
