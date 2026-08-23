package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationFormPage {

    private final SelenideElement authModal = $("[data-click='openAuthModal']");
    private final SelenideElement sendCodeBtn = $("#auth__send-code-btn");
    private final SelenideElement popUpModal = $(".pop.pop-auth.fancybox-content");
    private final SelenideElement phoneInput = $("#auth__phone");
    private final SelenideElement entryCodeText = $("#entry__code-text");
    private final SelenideElement authCodeInput = $(".pop-auth__code-inputs");
    private final SelenideElement authCodeInvalid = $("#auth__login-code-error");
    private final SelenideElement authOldModal = $("#auth__old-auth-btn");
    private final SelenideElement popLoginForm = $(".pop-login-form");
    private final SelenideElement submitBtn = $("[data-click='doAuth']");
    private final SelenideElement loginInput = $("#auth__login");
    private final SelenideElement passwordInput = $("#auth__password");
    private final SelenideElement pageRules = $(byText("правилами сайта"));
    private final SelenideElement listPageRules = $(".t-h1");


    public RegistrationFormPage openPage() {
        open("");
        return this;
    }

    public RegistrationFormPage preparePage() {
        executeJavaScript("window.stop();");
        executeJavaScript("""
                document.getElementById('fixedban')?.remove();
                document.querySelector('footer')?.remove();
                document.querySelectorAll('[class*="ad"], [class*="banner"], iframe').forEach(el => el.remove());
                """);
        return this;
    }

    public RegistrationFormPage openRegisterForm() {
        authModal.click();
        return this;
    }

    public RegistrationFormPage sendAuthCode() {
        sendCodeBtn.click();
        return this;
    }

    public RegistrationFormPage checkEmptyErrorMessage() {
        popUpModal.shouldHave(text("Введите номер телефона"));
        return this;
    }

    public RegistrationFormPage typePhoneNumber(String value) {
        phoneInput.setValue(value);
        return this;
    }

    public RegistrationFormPage checkEntryCodeText() {
        entryCodeText.shouldHave(text("На Ваш номер телефона выслан sms-код для подтверждения входа."));
        return this;
    }

    public RegistrationFormPage typeEntryCodeText(String value) {
        authCodeInput.setValue(value);
        return this;
    }

    public RegistrationFormPage checkInvalidEntryCodeMessage() {
        authCodeInvalid.shouldHave(text("Указан неверный код"));
        return this;
    }

    public RegistrationFormPage openAuthOldModal() {
        authOldModal.click();
        return this;
    }

    public RegistrationFormPage checkCorrectMessageInOldModal() {
        popLoginForm.shouldHave(text("Мобильный телефон или Email"));
        return this;
    }

    public RegistrationFormPage clickSubmitBtn() {
        submitBtn.click();
        return this;
    }

    public RegistrationFormPage checkErrorMessageInOldModal() {
        popLoginForm.shouldHave(text("Введите мобильный телефон или email"));
        return this;
    }

    public RegistrationFormPage checkErrorMessageInOldModalInvalidLogin() {
        popLoginForm.shouldHave(text("Неверный мобильный телефон или email"));
        return this;
    }

    public RegistrationFormPage typeWrongLogin(String value) {
        loginInput.setValue(value);
        return this;
    }

    public RegistrationFormPage typeAuthPassword(String value) {
        passwordInput.setValue(value);
        return this;
    }

    public RegistrationFormPage typeAuthPasswordWithEnter(String value) {
        passwordInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationFormPage checkPageRulesUrl() {
        pageRules.shouldHave(attribute("href", "/site_rules"));
        return this;
    }

    public RegistrationFormPage openPageRulesUrl() {
        pageRules.click();
        return this;
    }

    public RegistrationFormPage checkPageRulesOpen() {
        switchTo().window(1);
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals("https://stolichki.ru/site_rules", currentUrl);
        return this;
    }

    public RegistrationFormPage checkPageRulesContent() {
        listPageRules.shouldHave(text("Правила сайта и приложений Столички"));
        return this;
    }
}
