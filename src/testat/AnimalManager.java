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
public class AnimalManager {

    Scanner keyboard = new Scanner(System.in);
    ArrayList animalList<Animal> = new ArrayList<Animal>();

    public void handleAnimals() {

        Scanner keyboard = new Scanner(System.in);
        boolean animalmenu = true;
        String input;
        int value;

        while (animalmenu) {
            System.out.println("TIERPARK PF-Management (Version 1.0 (C) 2021 by Group Judith & Jennifer ☺\n"
                    + "ANIMAL MENU\n"
                    + "Please select:\n"
                    + "Create new animal 1\n"
                    + "Update an animal 2\n"
                    + "Delete an animal 3\n"
                    + "Show animal list 4\n"
                    + "Back to main menu 0\n"
                    + "Please enter your choice: (0,1,2,3,4) _");

            input = keyboard.nextLine();
            try {
                value = Integer.parseInt(input);

            } catch (NumberFormatException anyname) {
                value = -1;
            }
            if (value == 0) {
                animalmenu = false;
            }
            if (value == 1) {
                addAnimal();
            }
            if (value == 2) {
                updateAnimal();

            }
            if (value == 3) {
                deleteAnimal();
            }
            if (value == 4) {
                showAnimalList();
            }

        }

    }

    public void addAnimal() {
        boolean creationmenu = true;
        Animal myAnimal = new Animal();
        String name, age_input, input, specific_type, gender_input;
        int gender = 0;
        int age = 0;
        boolean name_Status, type_Status;
        boolean health_status = true;
        boolean feeding_status = true;
        int value;
        int gender_value;

        System.out.println("Please enter the animal name(i.e. Tim): ");//name
        name = keyboard.nextLine();
        name_Status = containsOnlyLetters(name);
        while (name_Status == false) {
            System.out.println("Invalid Input. Name contains numbers. Please try again: ");
            name = keyboard.nextLine();
            name_Status = containsOnlyLetters(name);
        }

        System.out.println("Please enter the animal`s gender. 1(male) or 2(female): ");//gender
        gender_input = keyboard.nextLine();
        gender = checkInputs(gender_input, gender);
        gender_value = 1;
        while (gender_value == 1) {
            if (gender == 1) {
                gender_value = 2;
                break;
            }
            if (gender == 2) {
                gender_value = 2;
                break;
            } else {
                System.out.println("Invalid input. Please try again: ");
                gender_input = keyboard.nextLine();
                gender = checkInputs(gender_input, gender);
            }
        }

        System.out.println("Please enter the specific type of the animal (i.e. giraffe): ");
        specific_type = keyboard.nextLine();
        type_Status = containsOnlyLetters(name);
        while (type_Status == false) {
            System.out.println("Invalid Input. Type contains numbers. Please try again: ");
            name = keyboard.nextLine();
            type_Status = containsOnlyLetters(name);
        }

        System.out.println("Please enter the age of the animal: ");//age
        age_input = keyboard.nextLine();
        age = checkInputs(age_input, age);

        while (creationmenu) {
            System.out.println("TIERPARK PF-Management (Version 1.0 (C) 2021 by Group Judith & Jennifer ☺\n"
                    + "CREATION MENU\n"
                    + "Please select the following options if needed:\n"
                    + "Animal is sick and needs a doctor`s appointment 1\n"
                    + "Animal needs to be fed 2\n"
                    + "Animal is sick and needs to be fed 3\n"
                    + "Add this animal and return to animal menu 0\n"
                    + "Please enter your choice: (0,1,2,3) _");

            input = keyboard.nextLine();
            try {
                value = Integer.parseInt(input);

            } catch (NumberFormatException anyname) {
                value = -5;
            }
            if (value == 0) {
                creationmenu = false;
            }
            if (value == 1) {
                health_status = false;

            }
            if (value == 2) {
                feeding_status = false;

            }
            if (value == 3) {
                feeding_status = false;
                health_status = false;
            }

            myAnimal.setAnimalID(animalList.size());
            myAnimal.setName(name);
            myAnimal.setAge(age);
            myAnimal.setFeeding(feeding_status);
            if (gender == 1) {
                myAnimal.setGender("male");
            } else if (gender == 2) {
                myAnimal.setGender("female");
            }
            myAnimal.setHealth(health_status);
            myAnimal.setType(specific_type);
            animalList.add(myAnimal);
            creationmenu = false;
        }
    }

    public void updateAnimal() {
        int id = 0;
        String input, gender_input, age_input;
        String specific_type;
        boolean name_Status, type_Status;
        String name = "";
        int value, gender_value;
        int age = 0;
        int gender = 0;
        boolean updateMenu = true;
        boolean health_status = false;
        boolean feeding_status = false;

        System.out.println("Enter the AnimalId of the animal that you want to update: ");
        String animalID_input = keyboard.nextLine();
        id = checkInputs(animalID_input, id);

        while (id > animalList.size()) {
            System.out.println("Invalid input: AnimalID does not exist. Please reenter. If you want to return to the animal menu, press ENTER. ");
            animalID_input = keyboard.nextLine();
            if (animalID_input.equals("")) {
                return;
            } else {
                id = checkInputs(animalID_input, id);
            }
        }
        
        Animal myAnimal = (Animal) animalList.get(id);

        while (updateMenu) {
            System.out.println("TIERPARK PF-Management (Version 1.0 (C) 2021 by Group Judith & Jennifer ☺\n"
                    + "UPDATE MENU\n "
                    + "Which attributes of " + myAnimal.getType() + " " + myAnimal.getName() + " do you want to update?\n"
                    + "Please select:\n"
                    + "Update name 1\n"
                    + "Update gender 2\n"
                    + "Update type 3\n"
                    + "Update age 4\n"
                    + "Update Status to healthy 5\n"
                    + "Update Status to fed 6\n"
                    + "Return to animal menu 0\n"
                    + "Please enter your choice: (0,1,2,3,4,5,6) _");

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
                System.out.println("Enter the new animal name: ");
                name = keyboard.nextLine();
                name_Status = containsOnlyLetters(name);
                while (name_Status == false) {
                    System.out.println("Invalid Input. Name contains numbers. Please try again: ");
                    name = keyboard.nextLine();
                    name_Status = containsOnlyLetters(name);
                }
                myAnimal.setName(name);
            }
            if (value == 2) {
                System.out.println("Enter the corrected animal gender. 1(male) or 2(female): ");
                gender_input = keyboard.nextLine();
                gender = checkInputs(gender_input, gender);
                gender_value = 1;
                while (gender_value == 1) {
                    if (gender == 1) {
                        gender_value = 2;
                        break;
                    }
                    if (gender == 2) {
                        gender_value = 2;
                        break;
                    } else {
                        System.out.println("Invalid input. Please try again: ");
                        gender_input = keyboard.nextLine();
                        gender = checkInputs(gender_input, gender);
                    }
                }
                if (gender == 1) {
                    myAnimal.setGender("male");
                } else if (gender == 2) {
                    myAnimal.setGender("female");
                }
            }
            if (value == 3) {
                System.out.println("Enter the corrected animal type: ");
                specific_type = keyboard.nextLine();
                type_Status = containsOnlyLetters(name);
                while (type_Status == false) {
                    System.out.println("Invalid Input. Type contains numbers. Please try again: ");
                    name = keyboard.nextLine();
                    type_Status = containsOnlyLetters(name);
                }
                myAnimal.setType(specific_type);
            }
            if (value == 4) {
                System.out.println("Please enter the corrected age of the animal: ");
                age_input = keyboard.nextLine();
                age = checkInputs(age_input, age);
                myAnimal.setAge(age);
            }
            if (value == 5) {
                health_status = true;
                myAnimal.setHealth(health_status);
            }
            if (value == 6) {
                feeding_status = true;
                myAnimal.setFeeding(feeding_status);
            }
            updateMenu = false;
        }
    }

    public void deleteAnimal() {
        int id = 0;
        String input;
        int value;
        boolean deletionMenu = true;

        System.out.println("Enter the AnimalId of the animal that you want to delete: ");
        String animalID_input = keyboard.nextLine();
        id = checkInputs(animalID_input, id);

        while (id > animalList.size()) {
            System.out.println("Invalid input: AnimalID does not exist. Please reenter. If you want to return to the animal menu, press ENTER. ");
            animalID_input = keyboard.nextLine();
            if (animalID_input.equals("")) {
                return;
            } else {
                id = checkInputs(animalID_input, id);
            }
        }
        
        Animal myAnimal = (Animal) animalList.get(id);

        while (deletionMenu) {
            System.out.println("TIERPARK PF-Management (Version 1.0 (C) 2021 by Group Judith & Jennifer ☺\n"
                    + "DELETION MENU\n "
                    + "Do you want to delete " + myAnimal.getType() + " " + myAnimal.getName() + " ?\n"
                    + "Please select:\n"
                    + "Delete animal 1\n"
                    + "Return to animal menu 0\n"
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
                animalList.remove(id);
                for (int i = 0; i < animalList.size(); i++) {
                    myAnimal = (Animal) animalList.get(i);
                    myAnimal.setAnimalID(i);
                }
            }

            deletionMenu = false;
        }
    }

    public void showAnimalList() {
        boolean filtermenu = true;
        Animal myAnimal = new Animal();
        String input;
        int value;

        while (filtermenu) {
            System.out.println("TIERPARK PF-Management (Version 1.0 (C) 2021 by Group Judith & Jennifer ☺\n"
                    + "FILTER MENU\n"
                    + "Please select:\n"
                    + "Show complete list 1\n"
                    + "Show only hungry animals 2\n"
                    + "Show only sick animals 3\n"
                    + "Return to animal menu 0\n"
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
                for (int i = 0; i < animalList.size(); i++) {
                    myAnimal = (Animal) animalList.get(i);
                    if (!myAnimal.getfeeding()) {
                        System.out.println(myAnimal.toString());
                    }
                    System.out.println("\n");
                }

            }
            if (value == 1) {
                for (int i = 0; i < animalList.size(); i++) {
                    myAnimal = (Animal) animalList.get(i);
                    System.out.println(myAnimal.toString());
                }
                System.out.println("\n");
            }
            if (value == 3) {
                for (int i = 0; i < animalList.size(); i++) {
                    myAnimal = (Animal) animalList.get(i);
                    if (!myAnimal.getHealth()) {
                        System.out.println(myAnimal.toString());
                    }
                    System.out.println("\n");
                }

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
