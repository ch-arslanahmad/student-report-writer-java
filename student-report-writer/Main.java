// this will be the main file

// import input library: Scanner
import java.util.Scanner;
public class Main {


  // main method
  public static void main(String[] args) {
    // Making Scanner input Object
    Scanner input = new Scanner(System.in);
    // Making Student Object
    Student student = new Student();
    // Making ReportWriter object
    ReportWriter resultReport = new ReportWriter();
    // calling methods to input main details
    student.setDetails(input);
    // calling methods to input main subject names
    student.addSubject(input);
    // calling methods to input all marks details
    student.setMarks(input);

    // create then write & format Student report in the file 
    resultReport.fileMaker(student);

    // closing the input to prevent unexpected behaviour
    input.close();


  }

  
}
