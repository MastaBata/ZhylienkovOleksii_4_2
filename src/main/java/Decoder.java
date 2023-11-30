import java.util.HashMap;
import java.util.Map;

public class Decoder {

    public static String decodeVowelReplacement(String word) {
        Map<Character, Character> vowelsMap = new HashMap<>();
        vowelsMap.put('1', 'a');
        vowelsMap.put('2', 'e');
        vowelsMap.put('3', 'i');
        vowelsMap.put('4', 'o');
        vowelsMap.put('5', 'u');

        StringBuilder decodedWord = new StringBuilder();
        for (char letter : word.toCharArray()) {
            if (vowelsMap.containsKey(letter)) {
                decodedWord.append(vowelsMap.get(letter));
            } else {
                decodedWord.append(letter);
            }
        }
        return decodedWord.toString();
    }

    public static String decodeMessage1(String message) {
        String[] words = message.split("\\s+");
        StringBuilder decodedMessage = new StringBuilder();

        for (String word : words) {
            decodedMessage.append(decodeVowelReplacement(word)).append(" ");
        }
        return decodedMessage.toString().trim();
    }
    public static String decodeConsonantReplacement(String word) {
        String consonants = "bcdfghjklmnpqrstvwxyz";
        StringBuilder decodedWord = new StringBuilder();

        for (char letter : word.toCharArray()) {
            char lowercase = Character.toLowerCase(letter);
            if (consonants.indexOf(lowercase) != -1) {
                char replacement = consonants.charAt((consonants.indexOf(lowercase) + 1) % consonants.length());
                if (Character.isUpperCase(letter)) {
                    decodedWord.append(Character.toUpperCase(replacement));
                } else {
                    decodedWord.append(replacement);
                }
            } else {
                decodedWord.append(letter);
            }
        }
        return decodedWord.toString();
    }
    public static String decodeMessage2(String message) {
        String[] words = message.split("\\s+");
        StringBuilder decodedMessage = new StringBuilder();

        for (String word : words) {
            if (word.matches("[1-5]+")) {
                decodedMessage.append(decodeVowelReplacement(word)).append(" ");
            } else {
                decodedMessage.append(decodeConsonantReplacement(word)).append(" ");
            }
        }
        return decodedMessage.toString().trim();
    }

    public static void main(String[] args) {
        String encryptedMessage1 = "t2st3ng"; // Закодоване повідомлення голосних
        String encryptedMessage2 = "testing"; // Закодоване повідомлення приголосних

        String decryptedMessage1 = decodeMessage1(encryptedMessage1);
        String decryptedMessage2 = decodeMessage2(encryptedMessage2);

        System.out.println("Decrypted Message 1: " + decryptedMessage1);
        System.out.println("Decrypted Message 2: " + decryptedMessage2);
    }
}
