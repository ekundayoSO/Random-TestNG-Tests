package utility;

import org.apache.maven.surefire.shared.lang3.RandomStringUtils;

public class RandomEmailGenerator {
    private static String randomEmail;
    public static String generateRandomEmail() {
        if (randomEmail == null) {
            randomEmail = RandomStringUtils.randomAlphanumeric(3) + "@gmail.com";
        }
        return randomEmail;

    }

}
