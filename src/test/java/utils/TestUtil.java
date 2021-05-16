package utils;

import com.github.javafaker.Faker;

public final class TestUtil {

    public static String randomEmail(int length) {
        Faker faker = new Faker();
        return faker.internet().emailAddress();
    }

}
