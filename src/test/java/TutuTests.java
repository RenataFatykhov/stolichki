import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.TutuMainPage;

import static com.codeborne.selenide.logevents.SelenideLogger.step;
import static testdata.TestData.*;

public class TutuTests extends TestBase {

    TutuMainPage mainPage = new TutuMainPage();

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
    @DisplayName("На главной странице виден логотип")
    public void headerLogoTest() {

        step("Открыть главную страницу", () -> {
            mainPage
                    .openPage()
                    .preparePage();
        });

        step("Проверить логотип", () -> {
            mainPage
                    .checkHeaderLogo();
        });
    }

    @Test
    @DisplayName("На главной странице видна форма поиска")
    public void searchFormVisibleTest() {

        step("Открыть главную страницу", () -> {
            mainPage
                    .openPage()
                    .preparePage();
        });

        step("Проверить форму поиска", () -> {
            mainPage
                    .checkSearchFormVisible();
        });
    }

    @Test
    @DisplayName("На главной странице есть вкладки Поезда, Авиа и Отели")
    public void searchTabsVisibleTest() {

        step("Открыть главную страницу", () -> {
            mainPage
                    .openPage()
                    .preparePage();
        });

        step("Проверить вкладки формы поиска", () -> {
            mainPage
                    .checkSearchTabsVisible();
        });
    }

    @Test
    @DisplayName("На главной странице есть кнопка Войти")
    public void loginButtonVisibleTest() {

        step("Открыть главную страницу", () -> {
            mainPage
                    .openPage()
                    .preparePage();
        });

        step("Проверить кнопку входа", () -> {
            mainPage
                    .checkLoginButton();
        });
    }

    @Test
    @DisplayName("В шапке есть ссылки на основные разделы")
    public void headerLinksTest() {

        step("Открыть главную страницу", () -> {
            mainPage
                    .openPage()
                    .preparePage();
        });

        step("Проверить ссылки шапки", () -> {
            mainPage
                    .checkHeaderLinks();
        });
    }

    @Test
    @DisplayName("На главной странице виден футер")
    public void footerVisibleTest() {

        step("Открыть главную страницу", () -> {
            mainPage
                    .openPage()
                    .preparePage();
        });

        step("Проверить футер", () -> {
            mainPage
                    .checkFooterVisible();
        });
    }

    @Test
    @DisplayName("Открывается страница справочной")
    public void openHelpPageTest() {

        step("Открыть страницу справочной", () -> {
            mainPage
                    .openHelpPage()
                    .preparePage();
        });

        step("Проверить URL и заголовок страницы", () -> {
            mainPage
                    .checkPageOpen(HELP_PAGE_FULL_URL)
                    .checkTitle(HELP_PAGE_TITLE);
        });
    }

    @Test
    @DisplayName("Открывается страница путеводителя")
    public void openGuidePageTest() {

        step("Открыть страницу путеводителя", () -> {
            mainPage
                    .openGuidePage()
                    .preparePage();
        });

        step("Проверить URL и текст на странице", () -> {
            mainPage
                    .checkPageOpen(GUIDE_PAGE_FULL_URL)
                    .checkTitle(GUIDE_PAGE_TITLE);
        });
    }

    @Test
    @DisplayName("Открывается страница ЖД билетов")
    public void openTrainsPageTest() {

        step("Открыть страницу ЖД билетов", () -> {
            mainPage
                    .openTrainsPage()
                    .preparePage();
        });

        step("Проверить URL и заголовок страницы", () -> {
            mainPage
                    .checkPageOpen(TRAINS_PAGE_FULL_URL)
                    .checkTitle(TRAINS_PAGE_TITLE);
        });
    }
}
