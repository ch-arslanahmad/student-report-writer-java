import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class ReportWriter {
  
    // solve the object problem
    void writeDetails(Scanner input) {
        Student details = new Student();
        try {
            Scanner writer = new Scanner(System.in);
            FileWriter thefile = new FileWriter("Report.txt");
            thefile.write("Name: " + details.getName(input));
            thefile.write("\tAge: " + details.getAge(input));
            thefile.write("\tGrade Level: " + details.getGradeYr(input));
        } catch (IOException e) {
            System.out.println("Error Occured");
            e.printStackTrace();
        }

    }

    void fileWriter() {

        try {
           File makeFile = new File("Report.txt");
           if(!makeFile.exists()) {
            makeFile.createNewFile();
           }
           else {
            System.out.println("File already exists.");
           }
        writeDetails();
        } catch (Exception e) {
        }

    }
}
