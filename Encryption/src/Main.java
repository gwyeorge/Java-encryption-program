import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Select a cipher (1 - Vigenere, 2 - Caesar): ");
        int cipherChoice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character after reading the integer

        if (cipherChoice == 1) {
            System.out.print("Enter the text to encrypt (Vigenere): ");
            String plainText = scanner.nextLine();

            System.out.print("Enter the encryption key: ");
            String key = scanner.nextLine();

            String encryptedText = VigenereCipher.encrypt(plainText, key);
            System.out.println("Encrypted Text (Vigenere): " + encryptedText);

            String decryptedText = VigenereCipher.decrypt(encryptedText, key);
            System.out.println("Decrypted Text (Vigenere): " + decryptedText);
        } else if (cipherChoice == 2) {
            System.out.print("Enter the text to encrypt (Caesar): ");
            String plainText = scanner.nextLine();

            System.out.print("Enter the shift value: ");
            int shift = scanner.nextInt();
            scanner.nextLine();

            String encryptedText = CaesarCipher.encrypt(plainText, shift);
            System.out.println("Encrypted Text (Caesar): " + encryptedText);

            String decryptedText = CaesarCipher.decrypt(encryptedText, shift);
            System.out.println("Decrypted Text (Caesar): " + decryptedText);
        } else {
            System.out.println("Invalid cipher choice.");
        }

        scanner.close();
    }
}
