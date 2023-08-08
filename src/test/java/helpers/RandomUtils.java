package helpers;

import com.github.javafaker.Faker;

import java.util.Locale;


public class RandomUtils {
    static Faker faker = new Faker(new Locale("en-GB"));
    public static String createRandomFirstName() {

        return faker.name().firstName();
    }

    public static String createRandomLastName() {

        return faker.name().lastName();
    }

}
