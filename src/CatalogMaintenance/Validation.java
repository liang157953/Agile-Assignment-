/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CatalogMaintenance;

import java.io.IOException;
import java.util.Scanner;

public class Validation {
    public static boolean CheckDigit(String input) throws IOException {
        boolean checkDigit = false;
        //Check every character if the input string is in digit
        for (int r = 0; r < input.length(); r++) {
            if (Character.isDigit(input.charAt(r))) {
                checkDigit = true; //if is digit return true
            } else { //if got one of the character of the string is not digit; return false
                System.out.print(ConsoleColors.RED + "Input Must be in Digit! Please Try Again\n" + ConsoleColors.RESET);
                System.out.printf("\nPress Enter to Proceed...");
                System.in.read();
                System.out.println();
                checkDigit = false;
                break;
            }
        }
        return checkDigit;
    }

    public static boolean CheckAlphabetic(String input) throws IOException {
        boolean checkAlphabetic = false;
        //Check every character if the input string is in alphabetic
        for (int r = 0; r < input.length(); r++) {
            if (Character.isAlphabetic(input.charAt(r))) {
                checkAlphabetic = true; //if is alphabet return true
            } else { //if got one of the character of the string is not alphabet; return false
                System.out.println(ConsoleColors.RED + "Input Must be in Alphabet! Please Try Again\n" + ConsoleColors.RESET);
                System.out.printf("Press Enter to Proceed...");
                System.in.read();
                System.out.println();
                checkAlphabetic = false;
                break;
            }
        }

        return checkAlphabetic;
    }

    public static double askInputDouble(String informationText) {
        Scanner input = new Scanner(System.in);
        Boolean error = false;
        String userInp = "";
        do {
            System.out.print(informationText); //display the information of the user wants to display
            userInp = input.nextLine();
            if (!isDouble(userInp, "double")) {//Check the user input type is double
                //if not in double data type display error message and return error = true
                System.out.println(ConsoleColors.RED + "Error: must be a Double." + ConsoleColors.RESET + "\n");
                error = true;
            } else {
                error = false;
            }
        } while (error == true);
        //return the input in double
        return Double.parseDouble(userInp);
    }

    public static boolean isDouble(String input, String type) {
        try { //Check whether the input data type in double or not
            if (type.equalsIgnoreCase("double")) {
                Double.parseDouble(input);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}