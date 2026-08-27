import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.MainPage;

import static com.codeborne.selenide.logevents.SelenideLogger.step;
import static testdata.TestData.*;

public class StolichkiTests extends TestBase {

    MainPage mainPage = new MainPage();

    @Test
    @DisplayName("Открывается главная страница")
    public void openHomePageTest() {

        step("Открыть главную страницу", () -> {
            mainPage
                    .openPage()
                    .preparePage();
        });

        step("Проверить title страницы", () -> {
            mainPage
                    .checkTitle(HOME_TITLE);
        });
    }

    @Test
    @DisplayName("На главной странице видна шапка сайта")
    public void headerVisibleTest() {

        step("Открыть главную страницу", () -> {
            mainPage
                    .openPage()
                    .preparePage();
        });

        step("Проверить шапку сайта", () -> {
            mainPage
                    .checkHeaderVisible();
        });
    }

    @Test
    @DisplayName("На главной странице есть meta description")
    public void metaDescriptionTest() {

        step("Открыть главную страницу", () -> {
            mainPage
                    .openPage()
                    .preparePage();
        });

        step("Проверить description страницы", () -> {
            mainPage
                    .checkMetaDescription(META_DESCRIPTION);
        });
    }

    @Test
    @DisplayName("Поле поиска содержит плейсхолдер")
    public void searchPlaceholderTest() {

        step("Открыть главную страницу", () -> {
            mainPage
                    .openPage()
                    .preparePage();
        });

        step("Проверить поле поиска", () -> {
            mainPage
                    .checkSearchPlaceholder(SEARCH_PLACEHOLDER);
        });
    }

    @Test
    @DisplayName("В шапке есть разделы Каталог и Аптеки")
    public void headerContainsCatalogAndPharmaciesTest() {

        step("Открыть главную страницу", () -> {
            mainPage
                    .openPage()
                    .preparePage();
        });

        step("Проверить тексты в шапке", () -> {
            mainPage
                    .checkHeaderContainsText(CATALOG_TEXT)
                    .checkHeaderContainsText(PHARMACIES_TEXT);
        });
    }

    @Test
    @DisplayName("В шапке есть ссылка на программу лояльности")
    public void loyaltyLinkTest() {

        step("Открыть главную страницу", () -> {
            mainPage
                    .openPage()
                    .preparePage();
        });

        step("Проверить ссылку программы лояльности", () -> {
            mainPage
                    .checkLoyaltyLink();
        });
    }

    @Test
    @DisplayName("На странице есть телефон горячей линии")
    public void hotlinePhoneTest() {

        step("Открыть главную страницу", () -> {
            mainPage
                    .openPage()
                    .preparePage();
        });

        step("Проверить телефон горячей линии", () -> {
            mainPage
                    .checkHotlinePhone();
        });
    }

    @Test
    @DisplayName("На странице есть ссылка обратной связи по сайту")
    public void feedbackSiteLinkTest() {

        step("Открыть главную страницу", () -> {
            mainPage
                    .openPage()
                    .preparePage();
        });

        step("Проверить ссылку обратной связи", () -> {
            mainPage
                    .checkFeedbackSiteLink();
        });
    }

    @Test
    @DisplayName("Проверка наличия ссылки на правила сайта")
    public void checkUrlStolichkiPageRulesTest() {

        step("Открыть страницу регистрации", () -> {
            mainPage
                    .openPage()
                    .preparePage();
        });

        step("Проверка наличия ссылки на правила сайта", () -> {
            mainPage
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
            mainPage
                    .openSiteRulesPage()
                    .preparePage();
        });

        step("Проверка перехода на страницу с правилами и наличия текста заголовка", () -> {
            mainPage
                    .checkPageRulesOpen(PAGE_RULES_FULL_URL)
                    .checkPageRulesContent(PAGE_RULES_TITLE);
        });

    }
}
