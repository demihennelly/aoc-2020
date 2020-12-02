package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class part2 {

    public static void main (String arg[]) throws FileNotFoundException {

        Scanner s1 = new Scanner(new File("src/day2/Passwords.txt"));

        List<String> passwordList = new ArrayList<>();

        while (s1.hasNext() == true) {
            String password = s1.nextLine();
            passwordList.add(password);
        }

        int validPasswordCount = 0;

        for (int i = 0; i < passwordList.size(); i++) {

            String[] passwordBreakdown = passwordList.get(i).split(" ");
            String[] numbers = passwordBreakdown[0].split("-");
            int firstNumber = Integer.parseInt(numbers[0]);
            int secondNumber = Integer.parseInt(numbers[1]);
            char character = passwordBreakdown[1].charAt(0);
            String password = passwordBreakdown[2];

            if (password.charAt(firstNumber - 1) == character && password.charAt(secondNumber - 1) != character) {
                validPasswordCount++;
            }
            if (password.charAt(firstNumber - 1) != character && password.charAt(secondNumber - 1) == character) {
                validPasswordCount++;
            }
        }

        System.out.println("Valid password count: " + validPasswordCount);
    }
}
