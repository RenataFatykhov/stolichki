import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;
import testdata.TestData;

import static com.codeborne.selenide.logevents.SelenideLogger.step;
import static testdata.TestData.*;

public class RegistrationFormTests extends TestBase {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @Test
    @DisplayName("Отправка пустой формы с телефоном")
    public void sendEmptyRegistrationFormWithPhoneTest() {

        step("Открыть страницу регистрации", () -> {
            registrationFormPage
                    .openPage()
                    .preparePage();
        });

        step("Работа с формой регистрации", () -> {
            registrationFormPage
                    .openRegistrationForm()
                    .sendAuthCode();
        });

        step("Проверка наличия текста-подсказки", () -> {
            registrationFormPage
                    .checkEmptyErrorMessage(ERROR_EMPTY_PHONE);
        });
    }

    @Test
    @DisplayName("Ввод неверного кода подтверждения")
    public void sendWrongVerifyCode() {
        TestData data = new TestData();

        step("Открыть страницу регистрации", () -> {
            registrationFormPage
                    .openPage()
                    .preparePage();
        });

        step("Ввод номера телефона", () -> {
            registrationFormPage
                    .openRegistrationForm()
                    .typePhoneNumber(data.phoneNumber)
                    .sendAuthCode();
        });

        step("Ввод неверного кода подтверждения", () -> {
            registrationFormPage
                    .checkEntryCodeText(SMS_SENT)
                    .typeEntryCodeText(data.verifyCode);
        });

        step("Проверка наличия текста об ошибке", () -> {
            registrationFormPage
                    .checkInvalidEntryCodeMessage(ERROR_INVALID_CODE);
        });

    }

    @Test
    @DisplayName("Отправка пустой формы с email")
    public void sendEmptyRegistrationFormWithEmailTest() {

        step("Открыть страницу регистрации", () -> {
            registrationFormPage
                    .openPage()
                    .preparePage();
        });

        step("Открытие старого способа авторизации", () -> {
            registrationFormPage
                    .openRegistrationForm()
                    .openAuthOldModal()
                    .checkCorrectMessageInOldModal(OLD_MODAL_TITLE)
                    .clickSubmitBtn();
        });

        step("Проверка наличия текста об ошибке", () -> {
            registrationFormPage
                    .checkErrorMessageInOldModal(ERROR_EMPTY_LOGIN);
        });

    }

    @Test
    @DisplayName("Отправка невалидного телефона или email через кнопку")
    public void sendInvalidLoginlWithSubmitButtonTest() {
        TestData data = new TestData();

        step("Открыть страницу регистрации", () -> {
            registrationFormPage
                    .openPage()
                    .preparePage();
        });

        step("Открытие старого способа авторизации", () -> {
            registrationFormPage
                    .openRegistrationForm()
                    .openAuthOldModal()
                    .checkCorrectMessageInOldModal(OLD_MODAL_TITLE)
                    .typeWrongLogin(data.wrongLogin)
                    .typeAuthPassword(data.wrongPassword)
                    .clickSubmitBtn();
        });

        step("Проверка наличия текста об ошибке", () -> {
            registrationFormPage
                    .checkErrorMessageInOldModalInvalidLogin(ERROR_INVALID_LOGIN);
        });
    }

    @Test
    @DisplayName("Отправка невалидного телефона или email через клавишу Enter")
    public void sendInvalidPhoneOrEmailWithEnterTest() {
        TestData data = new TestData();

        step("Открыть страницу регистрации", () -> {
            registrationFormPage
                    .openPage()
                    .preparePage();
        });

        step("Открытие старого способа авторизации", () -> {
            registrationFormPage
                    .openRegistrationForm()
                    .openAuthOldModal()
                    .checkCorrectMessageInOldModal(OLD_MODAL_TITLE)
                    .typeWrongLogin(data.wrongLogin)
                    .typeAuthPasswordWithEnter(data.wrongPassword);
        });

        step("Проверка наличия текста об ошибке", () -> {
            registrationFormPage
                    .checkErrorMessageInOldModalInvalidLogin(ERROR_INVALID_LOGIN);
        });
    }

    @Test
    @DisplayName("Проверка наличия ссылки на правила сайта")
    public void checkUrlStolichkiPageRulesTest() {

        step("Открыть страницу регистрации", () -> {
            registrationFormPage
                    .openPage()
                    .preparePage();
        });

        step("Работа с формой регистрации", () -> {
            registrationFormPage
                    .openRegistrationForm();
        });

        step("Проверка наличия ссылки на правила сайта", () -> {
            registrationFormPage
                    .checkPageRulesUrl(
                            "href",
                            PAGE_RULES_URL
                    );
        });

    }

    @Test
    @DisplayName("Открыть правила сайта")
    public void openStolichkiPageRulesTest() {

        step("Открыть страницу регистрации", () -> {
            registrationFormPage
                    .openPage()
                    .preparePage();
        });

        step("Работа с формой регистрации", () -> {
            registrationFormPage
                    .openRegistrationForm();
        });

        step("Проверка наличия ссылки на правила сайта", () -> {
            registrationFormPage
                    .checkPageRulesUrl(
                            "href",
                            PAGE_RULES_URL
                    )
                    .openPageRulesUrl();
        });

        step("Проверка перехода на страницу с правилами и наличия текста заголовка", () -> {
            registrationFormPage
                    .checkPageRulesOpen(PAGE_RULES_FULL_URL)
                    .checkPageRulesContent(PAGE_RULES_TITLE);
        });

    }
}
