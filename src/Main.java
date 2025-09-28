// this will be the main file

// import input library: Scanner
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import display.*;
import model.*;

public class Main {

  int mainMenu(Scanner scanner, Input input) {
    String[] options = { "TXT file", "CLI version" };
    int count = 1;
    for (String option : options) {
      System.out.println(count + ". " + option);
      count++;
    }
    System.out.print("\nEnter your choice: ");
    return input.getNumInput(scanner);

  }

  // main method
  public static void main(String[] args) {
    Main main = new Main(); // creating an object of Main

    // Making Scanner input Object
    Scanner scanner = new Scanner(System.in);
    // Making Student Object
    Student student = new Student();
    // Making ReportWriter object
    ReportWriter resultReport = new ReportWriter();
    // calling methods to input main details

    Input input = new Input();
    boolean run = true;
    while (run) {
      int choice = main.mainMenu(scanner, input);
      switch (choice) {
        case 0: {
          return;
        }
        case 1: {
          input.setDetails(student, scanner);
          // calling methods to input main subject names
          ArrayList<String> subjects = student.addSubject(scanner, input);
          // calling methods to input all marks details
          Map<String, Student.Marks> data = student.setAllMarks(subjects, scanner, input); // all the subjects,
                                                                                           // obtained, total
          // create then write & format Student report in the file
          resultReport.reportMaker(student, data);
          // closing the input to prevent unexpected behaviour
        }
          break;
        case 2: {
          input.setDetails(student, scanner);
          // calling methods to input main subject names
          ArrayList<String> subjects = student.addSubject(scanner, input);
          // calling methods to input all marks details
          Map<String, Student.Marks> data = student.setAllMarks(subjects, scanner, input); // all the subjects,
                                                                                           // obtained, total
          // create then write & format Student report in the file
          resultReport.reportMaker(student, data);
          // create then write & format Student report in the file
          resultReport.cliReport(student, data);
        }
          break;
        default:
          System.out.println("Enter valid number.");
          break;
      }

    }
    // closing the input to prevent unexpected behaviour
    scanner.close();
  }
}
