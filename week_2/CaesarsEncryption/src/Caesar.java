import java.util.Scanner;

public class Caesar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int key = 0;
        if (args.length == 1) {
            key = Integer.parseInt(args[0]);
            key %= 26;
        } //in terminal, if you write java Caesar 13, the key will be 13.

        System.out.print("plaintext: ");
        String message = scanner.nextLine();

        String encryptedMessage = getEncryptedMessage(key, message);
        System.out.println("ciphertext: " + encryptedMessage);
    }

    private static String getEncryptedMessage(int key, String message) {
        StringBuilder encryptedMessage = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char temp = message.charAt(i);
            char encryptedLetter = (char)(temp + key);
            if (temp >= 65 && temp <= 90) {
                if (encryptedLetter > 90) {
                    encryptedLetter -= 26;
                }
                encryptedMessage.append(encryptedLetter);
            } else if (temp >= 97 && temp <= 122) {
                if (encryptedLetter > 122) {
                    encryptedLetter -= 26;
                }
                encryptedMessage.append(encryptedLetter);
            } else {
                encryptedMessage.append(temp);
            }
        }
        return encryptedMessage.toString();
    }
}

/*
Example inputs and outputs:

$ java caesar 13
plaintext:  hello, world
ciphertext: uryyb, jbeyq

$ java caesar 13
plaintext:  be sure to drink your Ovaltine
ciphertext: or fher gb qevax lbhe Binygvar

$ java caesar 1
plaintext:  HELLO
ciphertext: IFMMP
 */