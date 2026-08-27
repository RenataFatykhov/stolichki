import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;

import static com.codeborne.selenide.logevents.SelenideLogger.step;
import static testdata.TestData.*;

public class RegistrationFormTests extends TestBase {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @Test
    @DisplayName("Открывается главная страница")
    public void openHomePageTest() {

        step("Открыть главную страницу", () -> {
            registrationFormPage
                    .openPage()
                    .preparePage();
        });

        step("Проверить title страницы", () -> {
            registrationFormPage
                    .checkTitle(HOME_TITLE);
        });
    }

    @Test
    @DisplayName("На главной странице видна шапка сайта")
    public void headerVisibleTest() {

        step("Открыть главную страницу", () -> {
            registrationFormPage
                    .openPage()
                    .preparePage();
        });

        step("Проверить шапку сайта", () -> {
            registrationFormPage
                    .checkHeaderVisible();
        });
    }

    @Test
    @DisplayName("На главной странице есть meta description")
    public void metaDescriptionTest() {

        step("Открыть главную страницу", () -> {
            registrationFormPage
                    .openPage()
                    .preparePage();
        });

        step("Проверить description страницы", () -> {
            registrationFormPage
                    .checkMetaDescription(META_DESCRIPTION);
        });
    }

    @Test
    @DisplayName("Поле поиска содержит плейсхолдер")
    public void searchPlaceholderTest() {

        step("Открыть главную страницу", () -> {
            registrationFormPage
                    .openPage()
                    .preparePage();
        });

        step("Проверить поле поиска", () -> {
            registrationFormPage
                    .checkSearchPlaceholder(SEARCH_PLACEHOLDER);
        });
    }

    @Test
    @DisplayName("В шапке есть разделы Каталог и Аптеки")
    public void headerContainsCatalogAndPharmaciesTest() {

        step("Открыть главную страницу", () -> {
            registrationFormPage
                    .openPage()
                    .preparePage();
        });

        step("Проверить тексты в шапке", () -> {
            registrationFormPage
                    .checkHeaderContainsText(CATALOG_TEXT)
                    .checkHeaderContainsText(PHARMACIES_TEXT);
        });
    }

    @Test
    @DisplayName("В шапке есть ссылка на программу лояльности")
    public void loyaltyLinkTest() {

        step("Открыть главную страницу", () -> {
            registrationFormPage
                    .openPage()
                    .preparePage();
        });

        step("Проверить ссылку программы лояльности", () -> {
            registrationFormPage
                    .checkLoyaltyLink();
        });
    }

    @Test
    @DisplayName("На странице есть телефон горячей линии")
    public void hotlinePhoneTest() {

        step("Открыть главную страницу", () -> {
            registrationFormPage
                    .openPage()
                    .preparePage();
        });

        step("Проверить телефон горячей линии", () -> {
            registrationFormPage
                    .checkHotlinePhone();
        });
    }

    @Test
    @DisplayName("На странице есть ссылка обратной связи по сайту")
    public void feedbackSiteLinkTest() {

        step("Открыть главную страницу", () -> {
            registrationFormPage
                    .openPage()
                    .preparePage();
        });

        step("Проверить ссылку обратной связи", () -> {
            registrationFormPage
                    .checkFeedbackSiteLink();
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

        step("Открыть страницу правил сайта", () -> {
            registrationFormPage
                    .openSiteRulesPage()
                    .preparePage();
        });

        step("Проверка перехода на страницу с правилами и наличия текста заголовка", () -> {
            registrationFormPage
                    .checkPageRulesOpen(PAGE_RULES_FULL_URL)
                    .checkPageRulesContent(PAGE_RULES_TITLE);
        });

    }
}
