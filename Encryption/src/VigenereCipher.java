import java.util.Scanner;

public class VigenereCipher {
    public static String encrypt(String plainText, String key) {
        StringBuilder encryptedText = new StringBuilder();
        int keyIndex = 0;

        for (char c : plainText.toCharArray()) {
            if (Character.isLetter(c)) {
                int plainChar = Character.toUpperCase(c) - 'A';
                int keyChar = Character.toUpperCase(key.charAt(keyIndex % key.length())) - 'A';
                int encryptedChar = (plainChar + keyChar) % 26;
                encryptedText.append((char) (encryptedChar + 'A'));
                keyIndex++;
            } else {
                encryptedText.append(c);
            }
        }

        return encryptedText.toString();
    }

    public static String decrypt(String encryptedText, String key) {
        StringBuilder decryptedText = new StringBuilder();
        int keyIndex = 0;

        for (char c : encryptedText.toCharArray()) {
            if (Character.isLetter(c)) {
                int encryptedChar = Character.toUpperCase(c) - 'A';
                int keyChar = Character.toUpperCase(key.charAt(keyIndex % key.length())) - 'A';
                int decryptedChar = (encryptedChar - keyChar + 26) % 26;
                decryptedText.append((char) (decryptedChar + 'A'));
                keyIndex++;
            } else {
                decryptedText.append(c);
            }
        }

        return decryptedText.toString();
    }

}
