package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static testdata.TestData.*;

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

    @Step("Открыть страницу")
    public RegistrationFormPage openPage() {
        open("");
        return this;
    }

    @Step("Подготовить страницу")
    public RegistrationFormPage preparePage() {
        executeJavaScript("window.stop();");
        executeJavaScript("""
                document.getElementById('fixedban')?.remove();
                document.querySelector('footer')?.remove();
                document.querySelectorAll('[class*="ad"], [class*="banner"], iframe').forEach(el => el.remove());
                """);
        return this;
    }

    @Step("Открыть модальное окно авторизации")
    public RegistrationFormPage openRegistrationForm() {
        authModal.click();
        return this;
    }

    @Step("Отправить код подтверждения")
    public RegistrationFormPage sendAuthCode() {
        sendCodeBtn.click();
        return this;
    }

    @Step("Проверка наличия подсказки \"{expectedText}\"")
    public RegistrationFormPage checkEmptyErrorMessage(String expectedText) {
        popUpModal.shouldHave(text(expectedText));
        return this;
    }

    @Step("Ввод номера телефона")
    public RegistrationFormPage typePhoneNumber(String value) {
        phoneInput.setValue(value);
        return this;
    }

    @Step("Проверка SMS сообщения: \"{expectedText}\"")
    public RegistrationFormPage checkEntryCodeText(String expectedText) {
        entryCodeText.shouldHave(text(expectedText));
        return this;
    }

    @Step("Ввод кода подтверждения")
    public RegistrationFormPage typeEntryCodeText(String value) {
        authCodeInput.setValue(value);
        return this;
    }


    @Step("Проверка сообщения об ошибке: \"{expectedText}\"")
    public RegistrationFormPage checkInvalidEntryCodeMessage(String expectedText) {
        authCodeInvalid.shouldHave(text(expectedText));
        return this;
    }

    @Step("Открыть модальное окно регистрации через логин")
    public RegistrationFormPage openAuthOldModal() {
        authOldModal.click();
        return this;
    }

    @Step("Проверка сообщения в модалке: \"{expectedText}\"")
    public RegistrationFormPage checkCorrectMessageInOldModal(String expectedText) {
        popLoginForm.shouldHave(text(expectedText));
        return this;
    }

    @Step("Клик по кнопке подтверждения")
    public RegistrationFormPage clickSubmitBtn() {
        submitBtn.click();
        return this;
    }

    @Step("Проверка пустого поля логина: \"{expectedText}\"")
    public RegistrationFormPage checkErrorMessageInOldModal(String expectedText) {
        popLoginForm.shouldHave(text(expectedText));
        return this;
    }

    @Step("Проверка неверного логина: \"{expectedText}\"")
    public RegistrationFormPage checkErrorMessageInOldModalInvalidLogin(String expectedText) {
        popLoginForm.shouldHave(text(expectedText));
        return this;
    }

    @Step("Ввод неверного логина")
    public RegistrationFormPage typeWrongLogin(String value) {
        loginInput.setValue(value);
        return this;
    }

    @Step("Ввод пароля")
    public RegistrationFormPage typeAuthPassword(String value) {
        passwordInput.setValue(value);
        return this;
    }

    @Step("Ввод пароля и подтверждение введенных данных")
    public RegistrationFormPage typeAuthPasswordWithEnter(String value) {
        passwordInput.setValue(value).pressEnter();
        return this;
    }

    @Step("Наличие ссылки на правила сайта")
    public RegistrationFormPage checkPageRulesUrl(String name, String value) {
        pageRules.shouldHave(attribute(name, value));
        return this;
    }

    @Step("Открытие ссылки на правила сайта")
    public RegistrationFormPage openPageRulesUrl() {
        pageRules.click();
        return this;
    }

    @Step("Открытие ссылки на соседней странице с \"{expectedText}\"")
    public RegistrationFormPage checkPageRulesOpen(String expectedText) {
        switchTo().window(1);
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals(expectedText, currentUrl);
        return this;
    }

    @Step("Наличие заголовка у правил \"{expectedText}\"")
    public RegistrationFormPage checkPageRulesContent(String expectedText) {
        listPageRules.shouldHave(text(expectedText));
        return this;
    }
}
