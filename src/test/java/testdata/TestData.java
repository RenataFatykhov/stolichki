package testdata;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;

import static utils.RandomUtils.generatePhoneNumber;
import static utils.RandomUtils.generateVerifyCode;

public class TestData {
    private final Faker faker = new Faker();

    // Тестовые данные
    public String phoneNumber = generatePhoneNumber(10);
    public String verifyCode = generateVerifyCode(4);
    public String wrongLogin = faker.lorem().characters(5);
    public String wrongPassword = faker.lorem().characters(5);


    // Тексты ошибок и сообщений
    public static final String ERROR_EMPTY_PHONE = "Введите номер телефона";
    public static final String SMS_SENT = "На Ваш номер телефона выслан sms-код для подтверждения входа.";
    public static final String ERROR_INVALID_CODE = "Указан неверный код";
    public static final String OLD_MODAL_TITLE = "Мобильный телефон или Email";
    public static final String ERROR_EMPTY_LOGIN = "Введите мобильный телефон или email";
    public static final String ERROR_INVALID_LOGIN = "Неверный мобильный телефон или email";
    public static final String PAGE_RULES_TITLE = "Правила сайта и приложений Столички";
    public static final String PAGE_RULES_URL = "/site_rules";
    public static final String PAGE_RULES_FULL_URL = Configuration.baseUrl + PAGE_RULES_URL;
}
