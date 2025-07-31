import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
public class ReportWriter {

    private boolean fileExists = false;
  
    // solve the object problem
    void writeDetails(Student student) {
        // create an object
        try {
            PrintWriter thefile = new PrintWriter("Report.txt");
            thefile.write("Name: " + student.getName());
            thefile.write("\tAge: " + student.getAge() + "\t");
            thefile.write("\tGrade Level: " + student.getGradeYr() + "\n");
                int max = student.findMaxlength();
                thefile.printf("\n%-"+ max + "s | %-11s | %-14s | %-11s\n", "Subjects", "Total Marks", "Obtained Marks", "Percentages");
                for(int i=0; i<student.sizeSubject(); i++) {
                    thefile.printf("%-" + max + "s | %-11d | %-14d | %-6.2f%%\n",
                    student.getSubject(i),
                    student.getsubjectTotalMarks(i),
                    student.getsubjectObtMarks(i),
                    student.getsPercentages(i)
                    );
                }
                thefile.printf("-".repeat(50) + "\n");
                thefile.printf("%-" + max + "s | %-11d | %-14d | %6.2f%%\n", "Total",
                student.getTotalMarks(),
                student.getTotalObtMarks(),
                student.getTotalPercentage());
                thefile.close();
        } catch (IOException e) {
            System.out.println("Error Detected!");
            e.printStackTrace();
        }


    }

    void fileMaker(Student student) {
        try {
           File makeFile = new File("Report.txt");

           if(!makeFile.exists()) {
            makeFile.createNewFile();
            System.out.println("File successfully created.");
            fileExists = true;
            
            writeDetails(student);
                    if(makeFile.exists() && makeFile.length() != 0) {
                        System.out.println("Report successfully added in File.");
                }
                else {
                        System.out.println("Unable to add Report.");
                        makeFile.delete();
                        System.out.println("Hence Deleted.....");
                }
            }
           
           else {
            System.out.println("File already exists.");
            makeFile.delete();
            System.out.println("File Deleted.");
            writeDetails(student);
            System.out.println("Created newFile with the student report.");
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
