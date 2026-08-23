import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;

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
        registrationFormPage
                .openPage()
                .preparePage()
                .openRegisterForm()
                .typePhoneNumber("9172403384")
                .sendAuthCode()
                .checkEntryCodeText()
                .typeEntryCodeText("1234")
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
        registrationFormPage
                .openPage()
                .preparePage()
                .openRegisterForm()
                .openAuthOldModal()
                .checkCorrectMessageInOldModal()
                .typeWrongLogin("test_wrong_email")
                .typeAuthPassword("123456")
                .clickSubmitBtn().checkErrorMessageInOldModalInvalidLogin();
    }

    @Test
    @DisplayName("Отправка невалидного телефона или email через клавишу Enter")
    public void sendInvalidPhoneOrEmailWithEnterTest() {
        registrationFormPage
                .openPage()
                .preparePage()
                .openRegisterForm()
                .openAuthOldModal()
                .checkCorrectMessageInOldModal()
                .typeWrongLogin("test_wrong_email")
                .typeAuthPasswordWithEnter("123456")
                .clickSubmitBtn().checkErrorMessageInOldModalInvalidLogin();
    }

    @Test
    @DisplayName("Проверка наличия ссылки на правила сайта")
    public void checkUrlStolichkiPageRulesTest() {
        registrationFormPage
                .openPage()
                .preparePage()
                .openRegisterForm()
                .checkPageRulesUrl();

    }


    @Test
    @DisplayName("Открыть правила сайта")
    public void openStolichkiPageRulesTest() {
        registrationFormPage
                .openPage()
                .preparePage()
                .openRegisterForm()
                .checkPageRulesUrl()
                .openPageRulesUrl()
                .checkPageRulesOpen()
                .checkPageRulesContent();

    }
}
