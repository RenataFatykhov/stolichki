package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static testdata.TestData.*;

public class RegistrationFormPage {

    private final SelenideElement header = $("header.hdr");
    private final SelenideElement searchInput = $("input.products-search__input");
    private final SelenideElement loyaltyLink = $("a[href='/loyalty']");
    private final SelenideElement pageRules = $("a[href='/site_rules']");
    private final SelenideElement siteRulesTitle = $(".t-h1");
    private final SelenideElement hotlinePhone = $("a[href='tel:+74952155215']");
    private final SelenideElement feedbackSiteLink = $("a[href='/feedback/site']");

    @Step("Открыть страницу")
    public RegistrationFormPage openPage() {
        open("");
        return this;
    }

    @Step("Открыть страницу правил сайта")
    public RegistrationFormPage openSiteRulesPage() {
        open(PAGE_RULES_URL);
        return this;
    }

    @Step("Подготовить страницу")
    public RegistrationFormPage preparePage() {
        SelenideElement cityConfirmButton = $$("[data-tip-pop-close]").findBy(text("Да, верно"));
        if (cityConfirmButton.exists()) {
            cityConfirmButton.click();
        }
        SelenideElement appHintCloseButton = $("button[data-close-btn]");
        if (appHintCloseButton.exists()) {
            appHintCloseButton.click();
        }
        return this;
    }

    @Step("Проверка видимости шапки сайта")
    public RegistrationFormPage checkHeaderVisible() {
        header.shouldBe(visible);
        return this;
    }

    @Step("Проверка заголовка страницы")
    public RegistrationFormPage checkTitle(String expectedText) {
        assertTrue(title().contains(expectedText));
        return this;
    }

    @Step("Проверка meta description")
    public RegistrationFormPage checkMetaDescription(String expectedText) {
        $("meta[name='description']").shouldHave(attribute("content", expectedText));
        return this;
    }

    @Step("Проверка поля поиска")
    public RegistrationFormPage checkSearchPlaceholder(String expectedText) {
        searchInput.shouldBe(visible).shouldHave(attribute("placeholder", expectedText));
        return this;
    }

    @Step("Проверка текста в шапке")
    public RegistrationFormPage checkHeaderContainsText(String expectedText) {
        header.shouldHave(text(expectedText));
        return this;
    }

    @Step("Проверка ссылки программы лояльности")
    public RegistrationFormPage checkLoyaltyLink() {
        loyaltyLink.shouldBe(visible).shouldHave(text(LOYALTY_LINK_TEXT));
        return this;
    }

    @Step("Проверка ссылки на правила сайта")
    public RegistrationFormPage checkPageRulesUrl(String name, String value) {
        pageRules.should(exist).shouldHave(attribute(name, value));
        return this;
    }

    @Step("Проверка телефона горячей линии")
    public RegistrationFormPage checkHotlinePhone() {
        hotlinePhone.shouldBe(visible).shouldHave(text(HOTLINE_PHONE));
        return this;
    }

    @Step("Проверка ссылки обратной связи по сайту")
    public RegistrationFormPage checkFeedbackSiteLink() {
        feedbackSiteLink.should(exist).shouldHave(attribute("href", FEEDBACK_SITE_URL));
        return this;
    }

    @Step("Проверка открытия страницы правил сайта")
    public RegistrationFormPage checkPageRulesOpen(String expectedText) {
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals(expectedText, currentUrl);
        return this;
    }

    @Step("Проверка заголовка правил сайта")
    public RegistrationFormPage checkPageRulesContent(String expectedText) {
        siteRulesTitle.shouldHave(text(expectedText));
        return this;
    }
}
