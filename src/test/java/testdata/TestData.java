package testdata;

import com.github.javafaker.Faker;

import static utils.RandomUtils.generatePhoneNumber;
import static utils.RandomUtils.generateVerifyCode;

public class TestData {
    private final Faker faker = new Faker();

    public String phoneNumber = generatePhoneNumber(10);
    public String verifyCode = generateVerifyCode(4);

    public String wrongLogin = faker.lorem().characters(5);
    public String wrongPassword = faker.lorem().characters(5);




}
