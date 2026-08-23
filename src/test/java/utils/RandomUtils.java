package utils;

import com.github.javafaker.Faker;

public final class RandomUtils {
    private static final Faker faker = new Faker();

    private RandomUtils() {
    }

    public static String generatePhoneNumber(int length) {
        return faker.number().digits(length);
    }

    public static String generateVerifyCode(int length) {
        return faker.number().digits(length);
    }


}
