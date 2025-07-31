import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
public class ReportWriter {

    private boolean fileExists = false;
  
    // solve the object problem
    void writeDetails(Student student) {
        // create an object
        try {
            // PrintWriter Object: used it as its the best for formatted writing
            PrintWriter thefile = new PrintWriter("Report.txt");

            // write function to write details
            thefile.write("Name: " + student.getName());
            thefile.write("\tAge: " + student.getAge() + "\t");
            thefile.write("\tGrade Level: " + student.getGradeYr() + "\n");

                // variable made so table made is dynamically adjusted to make the table orderly
                int max = student.findMaxlength();
                // using printf for formatted output writing in file
                thefile.printf("\n%-"+ max + "s | %-11s | %-14s | %-11s\n", "Subjects", "Total Marks", "Obtained Marks", "Percentages");
                // loop to write all subjects with percentages, marks etc
                for(int i=0; i<student.sizeSubject(); i++) {
                    thefile.printf("%-" + max + "s | %-11d | %-14d | %-6.2f%%\n",
                    student.getSubject(i),
                    student.getsubjectTotalMarks(i),
                    student.getsubjectObtMarks(i),
                    student.getsPercentages(i)
                    );
                }
                // line to seperate the per subject details to the total
                thefile.printf("-".repeat(50) + "\n");
                // writing total details in file
                thefile.printf("%-" + max + "s | %-11d | %-14d | %6.2f%%\n", "Total",
                student.getTotalMarks(),
                student.getTotalObtMarks(),
                student.getTotalPercentage());
                // closing the writing in file to prevent unexpected errors
                thefile.close();
        } catch (IOException e) {
            System.out.println("Error Detected!");
            e.printStackTrace();
        }
    }

    void fileMaker(Student student) {
    // try-catch for file-making
        try {
            // making File object
           File makeFile = new File("Report.txt");
            // conditional to run when file doesnt exist
           if(!makeFile.exists()) {
            // function to make a file
            makeFile.createNewFile();
            System.out.println("File successfully created.");
            // now file exists hence the value
            fileExists = true;
            // calling the writeDetails method
            writeDetails(student);
                    // conditional to see if file is not empty.
                if(makeFile.exists() && makeFile.length() != 0) {
                    System.out.println("Report successfully added in File.");
                }
                else {
                    System.out.println("Unable to make file file or add the Report in file.");
                }
            }
           // when file exists
           else {
                System.out.println("File already exists.");

                makeFile.delete();
                System.out.println("Deleted the file..");
                makeFile.createNewFile();
                System.out.println("Created new File");

            // Write Report in the file
            writeDetails(student);
            System.out.println("Updated file with the student report.");
           }
        }
        catch (Exception e) {
            System.out.println("Error occured when making a file!");
        }

    }

    // getter for file existance
    boolean fileState() {
        return fileExists;
    }
}
