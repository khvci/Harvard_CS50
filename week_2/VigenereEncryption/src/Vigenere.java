import java.util.Scanner;

public class Vigenere {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String key = "alkindi"; // inventor of frequency analysis, the single most significant cryptanalytic advance until WW2
        String defaultMessage = "Started with default key [alkindi]. Better usage: $ java Vigenere [yourAlphabeticalKey]";

        //in terminal, if you write java Vigenere bacon, the key will be bacon.
        if (args.length == 1) {
            key = args[0].toLowerCase();
            for (int i = 0; i < key.length(); i++) {
                // key must not contain anything but letters.
                if (!Character.isLetter(key.charAt(i))) {
                    key = "alkindi";
                    System.out.println(defaultMessage);
                    break;
                }
            }
        } else {
            System.out.println(defaultMessage);
        }

        System.out.print("plaintext: ");
        String message = scanner.nextLine();

        String encryptedMessage = getEncryptedMessage(key, message);
        System.out.println("ciphertext: " + encryptedMessage);

    }

    private static String getEncryptedMessage(String key, String message) {

        StringBuilder encryptedMessage = new StringBuilder("");
        int keyLength = key.length();
        int keyCounter = 0; // we use a counter instead of for-loop's i, in order to prevent from counting spaces or non-alphabetic characters while encrypting

        for (int i = 0; i < message.length(); i++) {
            if (keyCounter == keyLength) {
                keyCounter = 0;
            } // prevent from indexoutofbounds. Start over from the first index instead.

            char temp = message.charAt(i);
            char encryptedLetter;

            if (temp >= 65 && temp <= 90) { // if character is between A - Z
                encryptedLetter = (char)(temp + (key.charAt(keyCounter) - 97));
                keyCounter++;

                if (encryptedLetter > 90) { // after the key added, if it's bigger than Z, start over from letter A.
                    encryptedLetter -= 26;
                }
                encryptedMessage.append(encryptedLetter);
            } else if (temp >= 97 && temp <= 122) { // if character is between a - z
                encryptedLetter = (char)(temp + (key.charAt(keyCounter) - 97));
                keyCounter++;

                if (encryptedLetter > 122) { // after the key added, if it's bigger than z, start over from letter a.
                    encryptedLetter -= 26;
                }
                encryptedMessage.append(encryptedLetter);
            } else {
                encryptedMessage.append(temp); // if it is not a letter, add that character to encrypted message as it is.
            }
        }
        return encryptedMessage.toString();
    }
}

/*
to Compile:
$ javac Vigenere.java
---------

Example inputs and outputs:

$ java Vigenere bacon
plaintext:  Meet me at the park at eleven am
ciphertext: Negh zf av huf pcfx bt gzrwep oz

$ java Vigenere
Started with default key [alkindi]. Better usage: $ java Vigenere [yourAlphabeticalKey]
plaintext: Meet me at the park at eleven am
ciphertext: Mpob zh it erm cdzk ld myhdey ku

$ java Vigenere 13
Started with default key [alkindi]. Better usage: $ java Vigenere [yourAlphabeticalKey]
plaintext: Meet me at the park at eleven am
ciphertext: Mpob zh it erm cdzk ld myhdey ku

 */