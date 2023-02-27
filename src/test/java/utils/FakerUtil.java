package utils;

import com.github.javafaker.Faker;

public class FakerUtil {

    private final static Faker FAKER = new Faker();

    public static String name() {
        return FAKER.name().fullName();
    }

    public static String email() {
        return FAKER.internet().emailAddress();
    }

    public static String password() {
        return FAKER.internet().password();
    }

    public static String lastName() {
        return FAKER.name().lastName();
    }

    public static String address() {
        return FAKER.address().streetAddress();
    }

    public static String state() {
        return FAKER.address().state();
    }

    public static String city() {
        return FAKER.address().city();
    }

    public static String zipcode() {
        return FAKER.address().zipCode();
    }

    public static String number() {
        return FAKER.phoneNumber().phoneNumber();
    }
}
