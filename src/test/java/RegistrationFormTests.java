import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationFormTests extends TestBase {

    @Test
    @DisplayName("Отправка пустой формы с телефоном")
    public void sendEmptyRegistrationFormWithPhoneTest() {
        open("");

        executeJavaScript("window.stop();");
        executeJavaScript("""
                document.getElementById('fixedban')?.remove();
                document.querySelector('footer')?.remove();
                document.querySelectorAll('[class*="ad"], [class*="banner"], iframe').forEach(el => el.remove());
                """);

        $("[data-click='openAuthModal']").click();
        $("#auth__send-code-btn").click();
        $(".pop.pop-auth.fancybox-content").shouldHave(text("Введите номер телефона"));
    }

    @Test
    @DisplayName("Ввод неверного кода подтверждения")
    public void sendWrongVerifyCode() {
        open("");

        executeJavaScript("window.stop();");
        executeJavaScript("""
                document.getElementById('fixedban')?.remove();
                document.querySelector('footer')?.remove();
                document.querySelectorAll('[class*="ad"], [class*="banner"], iframe').forEach(el => el.remove());
                """);

        $("[data-click='openAuthModal']").click();
        $("#auth__phone").setValue("9172403384");
        $("#auth__send-code-btn").click();
        $("#entry__code-text")
                .shouldHave(text("На Ваш номер телефона выслан sms-код для подтверждения входа."));

        $(".pop-auth__code-inputs").setValue("1234");
        $("#auth__login-code-error").shouldHave(text("Указан неверный код"));
    }

    @Test
    @DisplayName("Отправка пустой формы с email")
    public void sendEmptyRegistrationFormWithEmailTest() {
        open("");

        executeJavaScript("window.stop();");
        executeJavaScript("""
                document.getElementById('fixedban')?.remove();
                document.querySelector('footer')?.remove();
                document.querySelectorAll('[class*="ad"], [class*="banner"], iframe').forEach(el => el.remove());
                """);

        $("[data-click='openAuthModal']").click();
        $("#auth__old-auth-btn").click();
        $(".pop-login-form").shouldHave(text("Мобильный телефон или Email"));
        $("[data-click='doAuth']").click();
        $(".pop-login-form").shouldHave(text("Введите мобильный телефон или email"));
    }

    @Test
    @DisplayName("Отправка невалидного телефона или email")
    public void sendInvalidPhoneOrEmailWithSubmitButtonTest() {
        open("");

        executeJavaScript("window.stop();");
        executeJavaScript("""
                document.getElementById('fixedban')?.remove();
                document.querySelector('footer')?.remove();
                document.querySelectorAll('[class*="ad"], [class*="banner"], iframe').forEach(el => el.remove());
                """);

        $("[data-click='openAuthModal']").click();
        $("#auth__old-auth-btn").click();
        $(".pop-login-form").shouldHave(text("Мобильный телефон или Email"));
        $("#auth__login").setValue("test_wrong_email");
        $("#auth__password").setValue("123456");
        $("[data-click='doAuth']").click();
        $(".pop-login-form").shouldHave(text("Неверный мобильный телефон или email"));
    }

    @Test
    @DisplayName("Отправка невалидного телефона или email")
    public void sendInvalidPhoneOrEmailWithEnterTest() {
        open("");

        executeJavaScript("window.stop();");
        executeJavaScript("""
                document.getElementById('fixedban')?.remove();
                document.querySelector('footer')?.remove();
                document.querySelectorAll('[class*="ad"], [class*="banner"], iframe').forEach(el => el.remove());
                """);

        $("[data-click='openAuthModal']").click();
        $("#auth__old-auth-btn").click();
        $(".pop-login-form").shouldHave(text("Мобильный телефон или Email"));
        $("#auth__login").setValue("test_wrong_email");
        $("#auth__password").setValue("123456").pressEnter();
        $(".pop-login-form").shouldHave(text("Неверный мобильный телефон или email"));
    }

    @Test
    @DisplayName("Проверка наличия ссылки на правила сайта")
    public void checkUrlStolichkiPageRulesTest() {
        open("");

        executeJavaScript("window.stop();");
        executeJavaScript("""
                document.getElementById('fixedban')?.remove();
                document.querySelector('footer')?.remove();
                document.querySelectorAll('[class*="ad"], [class*="banner"], iframe').forEach(el => el.remove());
                """);

        $("[data-click='openAuthModal']").click();
        $(byText("правилами сайта")).shouldHave(attribute("href", "/site_rules"));

    }


    @Test
    @DisplayName("Открыть правила сайта")
    public void openStolichkiPageRulesTest() {
        open("");

        executeJavaScript("window.stop();");
        executeJavaScript("""
                document.getElementById('fixedban')?.remove();
                document.querySelector('footer')?.remove();
                document.querySelectorAll('[class*="ad"], [class*="banner"], iframe').forEach(el => el.remove());
                """);

        $("[data-click='openAuthModal']").click();
        $(byText("правилами сайта")).click();

        switchTo().window(1);
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals("https://stolichki.ru/site_rules", currentUrl);


        $(".t-h1").shouldHave(text("Правила сайта и приложений Столички"));


    }
}
