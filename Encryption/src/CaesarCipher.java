class CaesarCipher {
    public static String encrypt(String plainText, int shift) {
        StringBuilder encryptedText = new StringBuilder();

        for (char c : plainText.toCharArray()) {
            if (Character.isLetter(c)) {
                char encryptedChar = (char) ((c - 'A' + shift) % 26 + 'A');
                encryptedText.append(encryptedChar);
            } else {
                encryptedText.append(c);
            }
        }

        return encryptedText.toString();
    }

    public static String decrypt(String encryptedText, int shift) {
        StringBuilder decryptedText = new StringBuilder();

        for (char c : encryptedText.toCharArray()) {
            if (Character.isLetter(c)) {
                char decryptedChar = (char) ((c - 'A' - shift + 26) % 26 + 'A');
                decryptedText.append(decryptedChar);
            } else {
                decryptedText.append(c);
            }
        }

        return decryptedText.toString();
    }
}