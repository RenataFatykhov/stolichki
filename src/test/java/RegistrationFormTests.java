import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;
import testdata.TestData;

import static testdata.TestData.PAGE_RULES_URL;

public class RegistrationFormTests extends TestBase {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @Test
    @DisplayName("Отправка пустой формы с телефоном")
    public void sendEmptyRegistrationFormWithPhoneTest() {
        registrationFormPage
                .openPage()
                .preparePage()
                .openRegisterForm()
                .sendAuthCode()
                .checkEmptyErrorMessage();
    }

    @Test
    @DisplayName("Ввод неверного кода подтверждения")
    public void sendWrongVerifyCode() {
        TestData data = new TestData();
        registrationFormPage
                .openPage()
                .preparePage()
                .openRegisterForm()
                .typePhoneNumber(data.phoneNumber)
                .sendAuthCode()
                .checkEntryCodeText()
                .typeEntryCodeText(data.verifyCode)
                .checkInvalidEntryCodeMessage();
    }

    @Test
    @DisplayName("Отправка пустой формы с email")
    public void sendEmptyRegistrationFormWithEmailTest() {
        registrationFormPage
                .openPage()
                .preparePage()
                .openRegisterForm()
                .openAuthOldModal()
                .checkCorrectMessageInOldModal()
                .clickSubmitBtn()
                .checkErrorMessageInOldModal();
    }

    @Test
    @DisplayName("Отправка невалидного телефона или email через кнопку")
    public void sendInvalidLoginlWithSubmitButtonTest() {
        TestData data = new TestData();
        registrationFormPage
                .openPage()
                .preparePage()
                .openRegisterForm()
                .openAuthOldModal()
                .checkCorrectMessageInOldModal()
                .typeWrongLogin(data.wrongLogin)
                .typeAuthPassword(data.wrongPassword)
                .clickSubmitBtn()
                .checkErrorMessageInOldModalInvalidLogin();
    }

    @Test
    @DisplayName("Отправка невалидного телефона или email через клавишу Enter")
    public void sendInvalidPhoneOrEmailWithEnterTest() {
        TestData data = new TestData();
        registrationFormPage
                .openPage()
                .preparePage()
                .openRegisterForm()
                .openAuthOldModal()
                .checkCorrectMessageInOldModal()
                .typeWrongLogin(data.wrongLogin)
                .typeAuthPasswordWithEnter(data.wrongPassword);
    }

    @Test
    @DisplayName("Проверка наличия ссылки на правила сайта")
    public void checkUrlStolichkiPageRulesTest() {
        registrationFormPage
                .openPage()
                .preparePage()
                .openRegisterForm()
                .checkPageRulesUrl(
                        "href",
                        PAGE_RULES_URL
                );

    }

    @Test
    @DisplayName("Открыть правила сайта")
    public void openStolichkiPageRulesTest() {
        registrationFormPage
                .openPage()
                .preparePage()
                .openRegisterForm()
                .checkPageRulesUrl(
                        "href",
                        PAGE_RULES_URL
                )
                .openPageRulesUrl()
                .checkPageRulesOpen()
                .checkPageRulesContent();

    }
}
