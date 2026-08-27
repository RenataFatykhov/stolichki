package testdata;

import com.codeborne.selenide.Configuration;

public class TestData {
    // Тексты и ссылки для smoke-проверок без авторизации
    public static final String HOME_TITLE = "Столички";
    public static final String META_DESCRIPTION = "Большой выбор лекарственных средств";
    public static final String SEARCH_PLACEHOLDER = "Поиск лекарств";
    public static final String LOYALTY_LINK_TEXT = "Программа лояльности";
    public static final String PHARMACIES_TEXT = "Аптеки";
    public static final String CATALOG_TEXT = "Каталог";
    public static final String HOTLINE_PHONE = "+7 (495) 215-52-15";
    public static final String FEEDBACK_SITE_URL = "/feedback/site";
    public static final String PAGE_RULES_TITLE = "Правила сайта и приложений Столички";
    public static final String PAGE_RULES_URL = "/site_rules";
    public static final String PAGE_RULES_FULL_URL = Configuration.baseUrl + PAGE_RULES_URL;
}
