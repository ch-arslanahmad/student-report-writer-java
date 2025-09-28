package display;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;

import model.*; // importing model class

public class ReportWriter {

    private boolean fileExists = false;

    // PrintWriter Object: used it as its the best for formatted writing
    PrintWriter createFile() throws IOException {
        return new PrintWriter("student-report-writer-java/student-report-writer/Report.txt");
    }

    boolean writeStudentInfo(Student student, PrintWriter thefile) {
        // write function to write details
        try {
            thefile.write("Name: " + student.getName());
            thefile.write("\tAge: " + student.getAge() + "\t");
            thefile.write("\tGrade Level: " + student.getGradeYr() + "\n");
            return true;
        } catch (Exception e) {
            System.out.print("Error writing student Info: ");
            e.printStackTrace();
            return false;
        }

    }

    // solve the object problem
    boolean writeDetails(Student student, PrintWriter thefile, Map<String, Student.Marks> data) {
        // create an object

        if (!writeStudentInfo(student, thefile)) {
            return false;
        }

        // Extract subject data into separate ArrayLists for processing
        ArrayList<String> subjects = new ArrayList<>();
        ArrayList<Integer> obtained = new ArrayList<>();
        ArrayList<Integer> total = new ArrayList<>();

        if (!extractSubjectData(data, subjects, obtained, total)) {
            System.out.println("Failed to extract subject data");
            return false;
        }

        // variable made so table made is dynamically adjusted to make the table orderly
        int max = student.findMaxlength(subjects);
        if (max <= 0) {
            System.out.println("Error: Invalid max column width calculated");
            return false;
        }

        ArrayList<Float> percentages = student.calculateSubjectPercentage(subjects, total, obtained);
        if (percentages == null || percentages.isEmpty()) {
            System.out.println("Error: Failed to calculate percentages");
            return false;
        }

        // Write the report table
        if (!writeTableHeader(thefile, max)) {
            System.out.println("Failed to write table header");
            return false;
        }

        if (!writeSubjectRows(student, thefile, data, subjects, max)) {
            System.out.println("Failed to write subject rows");
            return false;
        }

        if (!writeTotalRow(student, thefile, max, total, obtained, percentages)) {
            System.out.println("Failed to write total row");
            return false;
        }

        // closing the writing in file to prevent unexpected errors
        thefile.close();
        return true;
    }

    // Extract subject data from Map into separate ArrayLists for easier processing
    private boolean extractSubjectData(Map<String, Student.Marks> data,
            ArrayList<String> subjects,
            ArrayList<Integer> obtained,
            ArrayList<Integer> total) {
        try {
            // Validate input data
            if (data == null || data.isEmpty()) {
                System.out.println("Error: No subject data provided");
                return false;
            }

            for (Map.Entry<String, Student.Marks> entry : data.entrySet()) {
                // Validate entry components
                if (entry.getKey() == null || entry.getKey().trim().isEmpty()) {
                    System.out.println("Error: Invalid subject name found");
                    return false;
                }

                Student.Marks marks = entry.getValue(); // The Marks object
                if (marks == null) {
                    System.out.println("Error: Invalid marks data for subject: " + entry.getKey());
                    return false;
                }

                // Validate marks values
                if (marks.total() < 0 || marks.obtained() < 0 || marks.obtained() > marks.total()) {
                    System.out.println("Error: Invalid marks values for subject: " + entry.getKey());
                    return false;
                }

                // get subject name
                subjects.add(entry.getKey()); // store subjects in array

                // Access the values from the Marks object/record
                obtained.add(marks.obtained()); // Assuming Marks is a record
                total.add(marks.total()); // Assuming Marks is a record
            }
            return true;
        } catch (Exception e) {
            System.out.println("Error extracting subject data: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    // Write the table header with dynamic column width
    private boolean writeTableHeader(PrintWriter thefile, int maxColumnWidth) {
        try {
            // Validate inputs
            if (thefile == null) {
                System.out.println("Error: PrintWriter is null");
                return false;
            }
            if (maxColumnWidth < 1) {
                System.out.println("Error: Invalid column width");
                return false;
            }

            // using printf for formatted output writing in file
            thefile.printf("\n%-" + maxColumnWidth + "s | %-11s | %-14s | %-11s\n",
                    "Subjects", "Total Marks", "Obtained Marks", "Percentages");
            return true;
        } catch (Exception e) {
            System.out.println("Error writing table header: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    // Write individual subject rows with marks and percentages
    private boolean writeSubjectRows(Student student, PrintWriter thefile,
            Map<String, Student.Marks> data,
            ArrayList<String> subjects, int maxColumnWidth) {
        try {
            // Validate inputs
            if (student == null || thefile == null || data == null || subjects == null) {
                System.out.println("Error: One or more required parameters are null");
                return false;
            }
            if (subjects.isEmpty()) {
                System.out.println("Error: No subjects to write");
                return false;
            }

            // loop to write all subjects with percentages, marks etc
            for (String subject : subjects) {
                if (subject == null || !data.containsKey(subject)) {
                    System.out.println("Error: Invalid subject or missing data for: " + subject);
                    return false;
                }

                Student.Marks marks = data.get(subject);
                if (marks == null) {
                    System.out.println("Error: No marks data for subject: " + subject);
                    return false;
                }

                int obt = marks.obtained();
                int tot = marks.total();
                float perc = student.percentage(obt, tot); // Fixed parameter order: obtained, total
                thefile.printf("%-" + maxColumnWidth + "s | %-11d | %-14d | %-6.2f%%\n",
                        subject, tot, obt, perc);
            }
            return true;
        } catch (Exception e) {
            System.out.println("Error writing subject rows: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    // Write the total summary row with separator line
    private boolean writeTotalRow(Student student, PrintWriter thefile, int maxColumnWidth,
            ArrayList<Integer> total, ArrayList<Integer> obtained,
            ArrayList<Float> percentages) {
        try {
            // Validate inputs
            if (student == null || thefile == null || total == null || obtained == null || percentages == null) {
                System.out.println("Error: One or more required parameters are null");
                return false;
            }
            if (total.isEmpty() || obtained.isEmpty() || percentages.isEmpty()) {
                System.out.println("Error: Empty data arrays provided");
                return false;
            }
            if (total.size() != obtained.size() || total.size() != percentages.size()) {
                System.out.println("Error: Mismatched array sizes");
                return false;
            }

            // line to seperate the per subject details to the total
            thefile.printf("-".repeat(50) + "\n");
            // writing total details in file
            thefile.printf("%-" + maxColumnWidth + "s | %-11d | %-14d | %6.2f%%\n", "Total",
                    student.getTotalMarks(total),
                    student.getTotalObtMarks(obtained),
                    student.getTotalPercentage(percentages));
            return true;
        } catch (Exception e) {
            System.out.println("Error writing total row: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    // show in .txt file
    public void reportMaker(Student student, Map<String, Student.Marks> data) {
        // try-catch for file-making
        try {
            PrintWriter thefile = createFile();

            // write details to a file
            writeDetails(student, thefile, data);

            // close the file
            thefile.close();

        } catch (IOException e) {
            System.out.println("Error occured when making reportWriter file: ");
            e.printStackTrace();
        }

    }

    public void cliReport(Student student, Map<String, Student.Marks> data) {
        reportMaker(student, data);
        System.out.print("\n");
        try {
            Files.lines(Paths.get("student-report-writer-java/student-report-writer/Report.txt"))
                    .forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        System.out.print("\n");
    }

    // getter for file existance
    boolean fileState() {
        return fileExists;
    }
}
