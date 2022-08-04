package week_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LuhnAlgorithm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();

        System.out.println(
                isValid(userInput));
    }

    private static String isValid(String input) {
        List<Integer> list = convertToIntArray(input);
        int sum = 0;
        int digitGroup = 1;
        for (int i = list.size() - 1; i >= 0; i--) {
            if (digitGroup == 2) {
                int tempNum = list.get(i) * 2;
                sum += tempNum > 9 ?
                        (tempNum / 10) + (tempNum % 10) :
                        tempNum;
                digitGroup = 1;
            } else {
                sum += list.get(i);
                digitGroup = 2;
            }
        }
        return sum % 10 == 0 ? defineCard(list.get(0)) : "INVALID";
    }

    private static List<Integer> convertToIntArray(String userInput) {
        List<Integer> userInputInt = new ArrayList<>();
        for (int i = 0; i < userInput.length(); i++) {
            char character = userInput.charAt(i);
            if (Character.isDigit(character)) {
                userInputInt.add(Integer.parseInt(
                        String.valueOf(character)));
            }
        }
        return userInputInt;
    }
    public static String defineCard(int firstDigit) {
        if (firstDigit == 3) return "AMEX";
        if (firstDigit == 4) return "VISA";
        if (firstDigit == 5) return "MASTERCARD";
        if (firstDigit == 6) return "DISCOVER";
        return "INVALID";
    }
}

/*

Example inputs and outputs:

4003-6000-0000-0014
VISA

378734493671000
AMEX

5105105105105100
MASTERCARD

5105 1051 0510 5100
MASTERCARD

2223016768739313
INVALID

 */
