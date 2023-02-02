package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Calculator");

        int num1 = 0;
        int num2 = 0;

        System.out.println("Enter the number 1: ");
        num1 = in.nextInt();
        System.out.println("Enter the number 2: ");
        num2 = in.nextInt();

        int numOper = 0;
        System.out.println("Enter the number operation: ");
        System.out.println("1 - + ");
        System.out.println("2 - - ");
        System.out.println("3 - * ");
        System.out.println("4 - / ");
        numOper = in.nextInt();

        int res = 0;
        if (numOper == 1)
        {
            res = num1 + num2;
            System.out.println("Result = " + res);
        }
        if (numOper == 2)
        {
            res = num1 - num2;
            System.out.println("Result = " + res);
        }
        if (numOper == 3)
        {
            res = num1 * num2;
            System.out.println("Result = " + res);
        }
        if (numOper == 4)
        {
            if (num2 != 0)
            {
                res = num1 / num2;
                System.out.println("Result = " + res);
            }
            else
            {
                System.out.println("Na zero dilutu no can");
            }
        }

    }
}