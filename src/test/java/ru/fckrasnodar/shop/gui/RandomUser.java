package ru.fckrasnodar.shop.gui;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomUser {

    private static String DOMAINS[] = {"gmail.com", "yandex.ru", "mail.ru"};
    private static String LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private static Random random = new Random();

    public static String getRandomNumberPhone() {
        int numberPhone = Math.abs(random.nextInt(Integer.MAX_VALUE)) % 10000000 + 1230000000;
        return java.lang.String.valueOf(numberPhone);
    }

    public static String getRandomFirstName() {
        List<String> randomFirstName = Arrays.asList("John", "@#Gg123", "Сергей", "Бобер32?", "Al;ex_36", "17Ghost", "Петр I");
        return randomFirstName.get(random.nextInt(randomFirstName.size()));
    }

    public static String getRandomMiddleName() {
        List<String> randomMiddleName = Arrays.asList("Black", "352 %", "Ghost*&$", "Бобер32?", "Al;ex_36", "Добрыня%");
        return randomMiddleName.get(random.nextInt(randomMiddleName.size()));
    }

    public static String getRandomLastName() {
        List<String> randomLastName = Arrays.asList("Федорович", "352*^ +", "Ghost*&$", "Бобер32?", "Al;ex_36", "Nikitich12");
        return randomLastName.get(random.nextInt(randomLastName.size()));
    }

    public static String getRandomPassword() {
        int leftLimit = 33;
        int rightLimit = 122;
        int targetStringLength = 12;
        String generatePassword = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return generatePassword;
    }

    public static String getRandomEmail() {
        int lengthUserName = 7;
        StringBuilder userName = new StringBuilder();
        for (int i = 0; i < lengthUserName; i++) {
            userName.append(LETTERS.charAt(random.nextInt(LETTERS.length())));
        }

        int number = random.nextInt(10);
        String domain = DOMAINS[random.nextInt(DOMAINS.length)];

        return userName.toString() + number + "@" + domain;
    }
}
