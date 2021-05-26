/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testat;

import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Jen
 */
public class FoodManager {

    Scanner keyboard = new Scanner(System.in);
    ArrayList foodList = new ArrayList();

    public void handleFood() {

        Scanner keyboard = new Scanner(System.in);
        boolean foodmenu = true;
        String input;
        int value;

        while (foodmenu) {
            System.out.println("TIERPARK PF-Management (Version 1.0 (C) 2021 by Group Judith & Jennifer ☺\n"
                    + "FOOD MENU\n"
                    + "Please select:\n"
                    + "Create new food 1\n"
                    + "Update food 2\n"
                    + "Delete food 3\n"
                    + "Show food list 4\n"
                    + "Back to main menu 0\n"
                    + "Please enter your choice: (0,1,2,3,4) _");

            input = keyboard.nextLine();
            try {
                value = Integer.parseInt(input);

            } catch (NumberFormatException anyname) {
                value = -1;
            }
            if (value == 0) {
                foodmenu = false;
            }
            if (value == 1) {
                addFood();
            }
            if (value == 2) {
                updateFood();

            }
            if (value == 3) {
                deleteFood();
            }
            if (value == 4) {
                showFoodList();
            }

        }

    }

    public void addFood() {

        Food myFood = new Food();
        String name, type, quantity_input;
        boolean name_Status, type_Status;
        int quantity = 0;

        System.out.println("Please enter the food name(i.e.Meat): ");//food name
        name = keyboard.nextLine();
        name_Status = containsOnlyLetters(name);
        while (name_Status == false) {
            System.out.println("Invalid Input. Name contains numbers. Please try again: ");
            name = keyboard.nextLine();
            name_Status = containsOnlyLetters(name);
        }

        System.out.println("Please enter the specific type of the food (i.e. Chicken): ");//food type
        type = keyboard.nextLine();
        type_Status = containsOnlyLetters(name);
        while (type_Status == false) {
            System.out.println("Invalid Input. Type contains numbers. Please try again: ");
            name = keyboard.nextLine();
            type_Status = containsOnlyLetters(name);
        }

        System.out.println("Please enter the quantity of the food: ");//quantity
        quantity_input = keyboard.nextLine();
        quantity = checkInputs(quantity_input, quantity);

        myFood.setFoodID(foodList.size());
        myFood.setName(name);
        myFood.setQuantity(quantity);
        myFood.setType(type);
        foodList.add(myFood);
        System.out.println("Food has been successfully added.");
    }

    public void updateFood() {
        int id = 0;
        String input, quantity_input;
        String type;
        boolean name_Status, type_Status;
        String name = "";
        int value;
        int quantity = 0;
        boolean updateMenu = true;

        System.out.println("Enter the FoodID of the food that you want to update: ");
        String foodID_input = keyboard.nextLine();
        id = checkInputs(foodID_input, id);

        while (id > foodList.size()) {
            System.out.println("Invalid input: FoodID does not exist. Please reenter. If you want to return to the food menu, press ENTER. ");
            foodID_input = keyboard.nextLine();
            if (foodID_input.equals("")) {
                return;
            } else {
                id = checkInputs(foodID_input, id);
            }
        }
        
        Food myFood = (Food) foodList.get(id);

        while (updateMenu) {
            System.out.println("TIERPARK PF-Management (Version 1.0 (C) 2021 by Group Judith & Jennifer ☺\n"
                    + "FOOD UPDATE MENU\n "
                    + "Which attributes of " + myFood.getType() + " " + myFood.getName() + " do you want to update?\n"
                    + "Please select:\n"
                    + "Update name 1\n"
                    + "Update quantity 2\n"
                    + "Update type 3\n"
                    + "Return to food menu 0\n"
                    + "Please enter your choice: (0,1,2,3) _");

            input = keyboard.nextLine();
            try {
                value = Integer.parseInt(input);

            } catch (NumberFormatException anyname) {
                value = -5;
            }
            if (value == 0) {
                updateMenu = false;
            }
            if (value == 1) {
                System.out.println("Enter the new food name: ");
                name = keyboard.nextLine();
                name_Status = containsOnlyLetters(name);
                while (name_Status == false) {
                    System.out.println("Invalid Input. Name contains numbers. Please try again: ");
                    name = keyboard.nextLine();
                    name_Status = containsOnlyLetters(name);
                }
                myFood.setName(name);
            }
            if (value == 2) {
                System.out.println("Please enter the corrected quantity of the food: ");
                quantity_input = keyboard.nextLine();
                quantity = checkInputs(quantity_input, quantity);
                myFood.setQuantity(quantity);
            }

            if (value == 3) {
                System.out.println("Enter the corrected food type: ");
                type = keyboard.nextLine();
                type_Status = containsOnlyLetters(name);
                while (type_Status == false) {
                    System.out.println("Invalid Input. Type contains numbers. Please try again: ");
                    name = keyboard.nextLine();
                    type_Status = containsOnlyLetters(name);
                }
                myFood.setType(type);
            }

            updateMenu = false;
        }
    }

    public void deleteFood() {
        int id = 0;
        String input;
        int value;
        boolean deletionMenu = true;

        System.out.println("Enter the FoodId of the food that you want to delete: ");
        String foodID_input = keyboard.nextLine();
        id = checkInputs(foodID_input, id);

        while (id > foodList.size()) {
            System.out.println("Invalid input: FoodID does not exist. Please reenter. If you want to return to the food menu, press ENTER. ");
            foodID_input = keyboard.nextLine();
            if (foodID_input.equals("")) {
                return;
            } else {
                id = checkInputs(foodID_input, id);
            }
        }
       
        Food myFood = (Food) foodList.get(id);

        while (deletionMenu) {
            System.out.println("TIERPARK PF-Management (Version 1.0 (C) 2021 by Group Judith & Jennifer ☺\n"
                    + "FOOD DELETION MENU\n "
                    + "Do you want to delete the food " + myFood.getType() + " " + myFood.getName() + " ?\n"
                    + "Please select:\n"
                    + "Delete food 1\n"
                    + "Return to food menu 0\n"
                    + "Please enter your choice: (0,1,) _");

            input = keyboard.nextLine();
            try {
                value = Integer.parseInt(input);

            } catch (NumberFormatException anyname) {
                value = -5;
            }
            if (value == 0) {
                deletionMenu = false;
            }
            if (value == 1) {
                foodList.remove(id);
                for (int i = 0; i < foodList.size(); i++) {
                    myFood = (Food) foodList.get(i);
                    myFood.setFoodID(i);
                }
            }

            deletionMenu = false;
        }
    }

    public void showFoodList() {
        boolean filtermenu = true;
        Food myFood = new Food();
        String input;
        int value;
        String foodname;
        Boolean foodname_status;

        while (filtermenu) {
            System.out.println("TIERPARK PF-Management (Version 1.0 (C) 2021 by Group Judith & Jennifer ☺\n"
                    + "FILTER MENU\n"
                    + "Please select:\n"
                    + "Show complete list of foods 1\n"
                    + "Show all foods with low quantity(<30 units) 2\n"
                    + "Show all foods with same name(i.e. meat) 3\n"
                    + "Return to food menu 0\n"
                    + "Please enter your choice: (0,1,2,3) _");

            input = keyboard.nextLine();
            try {
                value = Integer.parseInt(input);

            } catch (NumberFormatException anyname) {
                value = -5;
            }
            if (value == 0) {
                filtermenu = false;
            }
            if (value == 2) {
                for (int i = 0; i < foodList.size(); i++) {
                    myFood = (Food) foodList.get(i);
                    if (myFood.getQuantity() < 30) {
                        System.out.println(myFood.toString());
                    }
                    System.out.println("\n");
                }

            }
            if (value == 1) {
                for (int i = 0; i < foodList.size(); i++) {
                    myFood = (Food) foodList.get(i);
                    System.out.println(myFood.toString());
                }
                System.out.println("\n");
            }
            if (value == 3) {
                System.out.println("Please enter the name of food that you want to filter: ");
                foodname = keyboard.nextLine();
                foodname_status = containsOnlyLetters(foodname);
                while (foodname_status == false) {
                    System.out.println("Invalid Input. Name contains numbers. Please try again: ");
                    foodname = keyboard.nextLine();
                    foodname_status = containsOnlyLetters(foodname);
                }
                for (int i = 0; i < foodList.size(); i++) {
                    myFood = (Food) foodList.get(i);
                    if (myFood.getName().equals(foodname)) {
                        System.out.println(myFood.toString());
                    }

                }
                System.out.println("If there is no output, there is no food with the name " + foodname + ".");
                System.out.println("\n");
            }
            filtermenu = false;
        }
    }

    public boolean containsOnlyLetters(String string) {//checks if string contains only letters
        char[] chars = string.toCharArray();
        for (char c : chars) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }

        return true;
    }

    public boolean isInteger(String age_input) { //checks if its convertable to a number
        try {
            Integer.parseInt(age_input);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public int checkInputs(String age_input, int age) {//converts to number if it fulfills conditions
        int value = 1;
        while (value == 1) {
            if (isInteger(age_input) == true) {
                value = 2;
                age = Integer.parseInt(age_input);
            } else {
                System.out.println("Invalid input. Please try again: ");
                age_input = keyboard.nextLine();
            }
        }
        return age;
    }

}


