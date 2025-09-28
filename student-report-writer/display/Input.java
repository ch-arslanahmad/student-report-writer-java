package display;

import java.util.Scanner;
import model.*; // importing model class

public class Input {

    public Student setDetails(Student student, Scanner input) {
        // get name
        System.out.print("Enter your name: ");
        String name = getNormalInput(input);
        student.setName(name);
        // set name
        System.out.print("Enter your age: ");
        int age = getNumInput(input);
        student.setAge(age); // set age year
        System.out.print("Enter your grade year: ");
        int gradeYr = getNumInput(input);
        student.setGradeYr(gradeYr);

        return student;

    }

    // ***-- BASIC INPUT (STR/INT) --***

    public String getLowerStrInput(Scanner scanner) {
        if (scanner.hasNextLine())
            return scanner.nextLine().toLowerCase().trim();
        else
            return "-1";
    }

    public String getNormalLowerInput(Scanner scanner) {
        String input;
        do {
            input = getStrInput(scanner);
            if (input.isEmpty() || input == "-1") {
                System.out.println("Input is invalid or empty, Please type something.");
            }
        } while (input.isEmpty());
        return input;
    }

    // get String input
    public String getStrInput(Scanner scanner) {
        if (scanner.hasNextLine())
            return scanner.nextLine().trim();
        else
            return "-1";
    }

    public String getNormalInput(Scanner scanner) {
        String input;
        do {
            input = getStrInput(scanner);
            if (input.isEmpty()) {
                System.out.println("Input is empty, Please type something.");
            }
        } while (input.isEmpty());
        return input;
    }

    // INTEGER input leaves a NEWLINE character which can make the next STRING input
    // take the newline as input. so i think better approach is get input in String
    // and PARSE IT INTO INTEGER

    public int getIntInput(Scanner scanner) throws NumberFormatException {
        int number = Integer.parseInt(getStrInput(scanner));
        return number; // return integer successfully
    }

    // get VALIDATED INTEGER
    public int getNumInput(Scanner scanner) {
        // loop to only stop when valid input given
        while (true) {
            try {
                int number = getIntInput(scanner);

                return number;
            } catch (NumberFormatException e) {
                System.out.println("Enter valid Integer value. ");
            }
        }
    }

    public void close(Scanner scanner) {
        scanner.close();
    }

}
