package correcter;

import java.util.Random;

public class ErrorGenerator {
    private final Random random = new Random();

    /**
     * Generates a random character.
     */
    private char randomCharacterGenerator() {
        String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        int index = random.nextInt(ALPHABET.length());
        return ALPHABET.charAt(index);
    }

    /**
     * Add a single error to the input string.
     */
    private String addSingleRandomError(String str) {
        char letter = randomCharacterGenerator();
        int index = random.nextInt(str.length());
        while (str.charAt(index) == letter) {
            letter = randomCharacterGenerator();
        }
        return str.substring(0, index) + letter + str.substring(index + 1);
    }


    /**
     *  Takes the input string, splits it in groups of length groupLength and add a single
     *  error per group. Return a new string with errors.
     */
    public String generateErrors(String input, int groupLength) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < input.length(); i = i + groupLength) {
            int endIndex = Math.min(i + groupLength, input.length());
            String group = input.substring(i, endIndex);
            stringBuilder.append(addSingleRandomError(group));
        }
        return stringBuilder.toString();
    }
}