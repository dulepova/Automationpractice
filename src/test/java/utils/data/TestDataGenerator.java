package utils.data;

import models.User;

import java.util.Random;

public class TestDataGenerator {
    public static User getNewValidUser() {
        return User.builder()
                .firstName("Nastia")
                .lastName("Dulepova")
                .email(generateNewEmail())
                .password("Qwerty123")
                .address("Dzerzhinskogo 3")
                .city("Minsk")
                .state("California")
                .postalCode("12345")
                .country("21")
                .phone("3752977777777")
                .build();
    }

    public static User getRegisteredUser() {
        return User.builder()
                .firstName("Nastia")
                .lastName("Dulepova")
                .email("qwerty777@gmail.com")
                .password("Qwerty123")
                .address("Dzerzhinskogo 3")
                .city("Minsk")
                .state("California")
                .postalCode("12345")
                .country("21")
                .phone("3752977777777")
                .build();
    }

    public static Object[][] getSearchTextsWithResultsNumber() {
        return new Object[][]{
                {"Dress", 7},
                {"1231231321", 0},
                {"Print", 5},
                {"ewqeqweqwewq", 0},
        };
    }

    private static String generateNewEmail() {
        int leftLimit = 97;
        int rightLimit = 122;
        int targetStringLength = 7;
        Random random = new Random();

        return random
                .ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString() +"12345"+ "@gmail.com";
    }
}
