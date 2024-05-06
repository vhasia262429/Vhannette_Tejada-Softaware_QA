package utility;

import org.apache.commons.lang3.RandomStringUtils;

public class TestUtils {

    // Method to generate a random username
    public static String generateRandomUsername(int length) {
        String allowedChars = "abcdefghijklmnopqrstuvwxyz0123456789";
        return "user_" + RandomStringUtils.random(length - 5, allowedChars);
    }
}
