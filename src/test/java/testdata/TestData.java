package testdata;

import com.codeborne.selenide.Configuration;

public class TestData {
    public static final String HOME_TITLE = "Tutu.ru";
    public static final String META_DESCRIPTION = "Билеты на жд поезда и автобусы";
    public static final String LOGIN_BUTTON_TEXT = "Войти";
    public static final String AVIABILETY_TEXT = "Авиабилеты";
    public static final String TRAIN_TICKETS_TEXT = "Ж/д билеты";
    public static final String HOTELS_TEXT = "Отели";
    public static final String AVIA_LINK_URL = "https://avia.tutu.ru/";
    public static final String TRAINS_LINK_URL = "https://www.tutu.ru/poezda/";
    public static final String HOTELS_LINK_URL = "https://hotel.tutu.ru/";
    public static final String HELP_PAGE_TITLE = "Справочная Tutu.ru";
    public static final String HELP_PAGE_URL = "/2read/";
    public static final String HELP_PAGE_FULL_URL = Configuration.baseUrl + HELP_PAGE_URL;
    public static final String GUIDE_PAGE_TITLE = "Путеводитель по странам мира";
    public static final String GUIDE_PAGE_URL = "/geo/";
    public static final String GUIDE_PAGE_FULL_URL = Configuration.baseUrl + GUIDE_PAGE_URL;
    public static final String TRAINS_PAGE_TITLE = "Расписание поездов";
    public static final String TRAINS_PAGE_URL = "/poezda/";
    public static final String TRAINS_PAGE_FULL_URL = Configuration.baseUrl + TRAINS_PAGE_URL;
}
