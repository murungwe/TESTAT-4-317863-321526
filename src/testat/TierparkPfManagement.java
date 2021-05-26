/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testat;

import java.util.Scanner;

/**
 *
 * @author Jen
 */
public class TierparkPfManagement {

    private static void notexistent() {
        Scanner keyboard = new Scanner(System.in);
        String weird = "hello";
        while (weird != "") {
            System.out.println("This program section is currently not implemented.\n"
                    + "Press ENTER to return to the main menu");
            weird = keyboard.nextLine();
        }

    }

    public static void main(String[] args) {
        AnimalManager myAnimalManager = new AnimalManager();
        FoodManager myFoodManager = new FoodManager();
        Scanner keyboard = new Scanner(System.in);
        String input;
        boolean mainmenu = true;
        int value;

        while (mainmenu) {
            System.out.println("TIERPARK PF-Management (Version 1.0 (C) 2021 by Group Judith & Jennifer ☺\n"
                    + "MAIN MENU\n"
                    + "Please select:\n"
                    + "Managing animals 1\n"
                    + "Managing food 2\n"
                    + "Managing staff 3\n"
                    + "Program exit 0\n"
                    + "Please enter your choice: (0/1/2) _");

            input = keyboard.nextLine();
            try {
                value = Integer.parseInt(input);

            } catch (NumberFormatException anyname) {
                value = -5;
            }
            if (value == 0) {
                System.out.println("You exited the program.");
                mainmenu = false;
            }
            if (value == 1) {
                myAnimalManager.handleAnimals();
            }
            if (value == 2) {
                myFoodManager.handleFood();

            }
            if (value == 3) {
                notexistent();
            }

        }
        System.exit(0);

    }//end of main method*/

}
