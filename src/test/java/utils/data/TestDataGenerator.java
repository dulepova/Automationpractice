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
                .address("Clark Street")
                .city("Chiсago")
                .state("Illinois")
                .postalCode("12345")
                .phone("+3752977777777")
                .build();
    }

    public static User getRegisteredUser() {
        return User.builder()
                .firstName("Nastia")
                .lastName("Dulepova")
                .email("qwerty777@gmail.com")
                .password("Qwerty123")
                .address("Clark Street")
                .city("Chiсago")
                .state("Illinois")
                .postalCode("12345")
                .phone("+3752977777777")
                .build();
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
