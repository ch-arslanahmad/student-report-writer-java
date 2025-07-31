// this will be the main file

// import input library: Scanner
import java.util.Scanner;
public class Main {


  // main method
  public static void main(String[] args) {
    // Making Scanner input Object
    Scanner input = new Scanner(System.in);
    Student student = new Student();
    student.getName(input);
    student.getAge(input);
    student.getGradeYr(input);

    student.addSubject(input);
    student.setMarks(input);
    input.close();

    System.out.println("Total Marks: " + student.getTotalMarks());
    System.out.println("Total Obtained Marks: " + student.getTotalObtMarks());


    student.calculateSubjectPercentage();
    System.out.println("Total Percentage: " + student.getTotalPercentage() + "%");


  }

  
}
