package tests;
import com.github.javafaker.Faker;

import java.util.Locale;

public class TestVar {
    static Faker faker = new Faker(new Locale("en"));

    public String getFirstName() {
        return faker.name().firstName();
    }

    public String getLastName() {
        return faker.name().lastName();
    }

    public String getEmail() {
        return faker.internet().emailAddress();
    }

    public String getGender() {
        return faker.options().option("Male", "Female", "Other");
    }

    public String getSubject() {
        return faker.options().option("Physics", "Commerce", "Chemistry", "Maths", "Arts", "Biology");
    }

    public String getNumber() {
        return faker.phoneNumber().subscriberNumber(10);
    }

    public String getHobby() {
        return faker.options().option("Sports", "Reading", "Music");
    }

    public String getDay() {
        return String.valueOf(faker.number().numberBetween(1, 28));
    }

    public String getMonth() {
        return faker.options().option("January", "February", "March",
                "April", "May", "June",
                "July", "August", "September",
                "October", "November", "December");
    }

    public String getYear() {
        return String.valueOf(faker.number().numberBetween(1950, 2025));
    }

    public String getState() {
        return faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    }

    public String getCity(String state) {
        return getRandomCity(state);
    }

    public String getAddress() {
        return faker.address().secondaryAddress();
    }

    public static String getRandomCity(String stateName) {
        return switch (stateName) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> throw new IllegalArgumentException("Некорректный штат");
        };

    }
}
