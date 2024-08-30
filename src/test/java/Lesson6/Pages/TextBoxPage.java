package Lesson6.Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxPage {

    private SelenideElement fullNameInput = $("#userName"),
            emailInput = $("#userEmail"),
            currentAddressTextarea = $("#currentAddress"),
            permanentAddressTextarea = $("#permanentAddress"),
            submitButton = $("#submit"),
            outputName = $("#output #name"),
            outputEmail = $("#output #email"),
            outputCurrentAddress = $("#output #currentAddress"),
            outputPermanentAddress = $("#output #permanentAddress");


    public TextBoxPage openPage() {
        open("/text-box");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public TextBoxPage setFullName(String value) {
        fullNameInput.setValue(value);
        return this;
    }

    public TextBoxPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public TextBoxPage setCurrentAddress(String value) {
        currentAddressTextarea.setValue(value);
        return this;
    }

    public TextBoxPage setPermanentAddress(String value) {
        permanentAddressTextarea.setValue(value);
        return this;
    }

    public TextBoxPage clickSubmitButton() {
        submitButton.click();
        return this;
    }

    public TextBoxPage checkName(String value) {
        outputName.shouldHave(text(value));
        return this;
    }

    public TextBoxPage checkEmail(String value) {
        outputEmail.shouldHave(text(value));
        return this;
    }

    public TextBoxPage checkCurrentAddress(String value) {
        outputCurrentAddress.shouldHave(text(value));
        return this;
    }

    public TextBoxPage checkPermanentAddress(String value) {
        outputPermanentAddress.shouldHave(text(value));
        return this;
    }

}
