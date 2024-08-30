package Lesson6.Utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class RandomUtils {

    static Faker faker = new Faker(new Locale("en-GB"));

    public String firstName = getFirstName(),
            lastName = getLastName(),
            email = getEmail(),
            gender = getGender(),
            userNumber = getUserNumber(),
            month = getMonth(),
            year = getYear(),
            day = getDay(),
            subject = getSubjects(),
            hobbies = getHobbies(),
            picture = getPicture(),
            address = getAddress(),
            state = getState(),
            city = getCity(state);

    public static String getUserNumber() {
        return faker.number().digits(10);
    }

    public static String getDay() {
        return String.valueOf(faker.number().numberBetween(1, 28));
    }

    public static String getMonth() {
        String[] month = {"December", "January", "February", "March",
                "April", "May", "June", "July",
                "August", "September", "October", "November"};
        return faker.options().option(month);
    }

    public static String getYear() {
        return String.valueOf(faker.number().numberBetween(1970, 2005));
    }

    public static String getSubjects() {
        return faker.options().option("Java", "Python", "JS");
    }

    public static String getHobbies() {
        return faker.options().option("Sports", "Reading", "Music");
    }

    public static String getPicture() {
        return faker.options().option("Ostap.png", "Kisa.png");
    }

    public static String getAddress() {
        return faker.address().fullAddress();
    }

    public static String getState() {
        return faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    }

    public static String getCity(String state) {
        String city = "";
        switch (state) {
            case "NCR":
                city = faker.options().option("Delhi", "Gurgaon", "Noida");
                break;
            case "Uttar Pradesh":
                city = faker.options().option("Agra", "Lucknow", "Merrut");
                break;
            case "Haryana":
                city = faker.options().option("Karnal", "Panipat");
                break;
            case "Rajasthan":
                city = faker.options().option("Jaipur", "Jaiselmer");
                break;
            default:
                break;
        }
        return city;
    }

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
        String[] genders = {"Male", "Female", "Other"};
        return faker.options().option(genders);
    }

}
