/// this is simply testing class and is not needed for the compiling and running of the application

// this was made to solve the issue of adding subjects like newline and spaces and input problem

import java.util.Scanner;
import java.util.ArrayList;
class Maintesting {
    private ArrayList<String> subject = new ArrayList<>();

    // this code that can print details in the console
  public static void main(String[] args) {
    // Making Scanner input Object
    Scanner input = new Scanner(System.in);
    Student student = new Student();
    student.addSubject(input);
    student.setMarks(input);
    input.close();

    int max = student.findMaxlength();
    System.out.printf("%-"+ max + "s | %-11s | %-14s | %-11s\n", "Subjects", "Total Marks", "Obtained Marks", "Percentages");
    for(int i=0; i<student.sizeSubject(); i++) {
        System.out.printf("%-" + max + "s | %-11d | %-14d | %-6.2f%%\n",
        student.getSubject(i),
        student.getsubjectTotalMarks(i),
        student.getsubjectObtMarks(i),
        student.getsPercentages(i)
        );
      }
      System.out.printf("-".repeat(50) + "\n");
      System.out.printf("%-" + max + "s | %-11d | %-14d | %6.2f%%\n", "Total",
      student.getTotalMarks(),
      student.getTotalObtMarks(),
      student.getTotalPercentage());    


  }
  
}





