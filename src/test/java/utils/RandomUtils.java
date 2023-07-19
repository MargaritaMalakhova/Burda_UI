package utils;

import com.github.javafaker.Faker;

import java.util.Locale;


public class RandomUtils {
    Faker faker = new Faker(new Locale("en-GB"));
    public String createRandomFirstName() {

        return faker.name().firstName();
    }

    public String createRandomLastName() {

        return faker.name().lastName();
    }

}
