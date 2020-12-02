package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Part2 {

    public static void main(String arg[]) throws FileNotFoundException {

        Scanner s1 = new Scanner(new File("src/day1/ExpenseReport.txt"));
        int year = 2020;
        List<Integer> expenses = new ArrayList<>();

        while (s1.hasNext() == true) {
            int line = Integer.parseInt(s1.nextLine());
            expenses.add(line);
        }

        outerloop:
        for (int i = 0; i < expenses.size(); i++) {
            for (int a = 0; a < expenses.size(); a++) {
                for (int b = 0; b < expenses.size(); b++) {
                    int sum = expenses.get(i) + expenses.get(a) + expenses.get(b);
                    if (sum == year) {
                        System.out.println("The answer is: " + expenses.get(i) * expenses.get(a) * expenses.get(b));
                        break outerloop;
                    }
                }
            }
        }
    }
}