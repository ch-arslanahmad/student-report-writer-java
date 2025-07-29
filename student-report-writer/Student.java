// import Scanner: input
import java.util.Scanner;
// import Arraylist
import java.util.ArrayList;

// class
public class Student {
    // Student Attributes
    private String name;
    private int age;
    private int gradeYr;


    // creating Arraylist: subject.
    private ArrayList<String> subject = new ArrayList<>();
    // data type cannot be primitive, hence a wrapper used, Integer for 'int' datatype.
    private ArrayList<Integer> subjectTotalMarks = new ArrayList<>();
    private int TotalMarks;
    private ArrayList<Integer> marks = new ArrayList<>();
    private int totalObtMarks;
    private ArrayList<Float> marksPercentage = new ArrayList<>();
  
    // Name method
    public String getName(Scanner input) {
        name = input.nextLine();
        return name;
    }
    
    // student age method
    public int getAge(Scanner input) {
        age = input.nextInt();
        return age;
    }
    // student grade method
    public int getGradeYr(Scanner input) {
        gradeYr = input.nextInt();
        return gradeYr;
    }


    // add Subject
    void addSubject(Scanner input) {
        subject.add(input.nextLine());
    }

    // adds Marks for each subject
    void setMarks(Scanner input) {
        // runs if subject is not 0.  
        if(subject.size() != 0) {
            for(int i=0; i<subject.size(); i++) {
            System.out.print("Enter total marks of " + subject.get(i) + ": ");
            // used set() method of ArrayList for Total marks of subject  
            subjectTotalMarks.set(i, input.nextInt());
            System.out.print("Enter obtained marks of " + subject.get(i) + ": ");
            // again set() method for obtained marks
            marks.set(i, input.nextInt());
            }
        }
        else {
            System.out.print("No subjects were added!");
        }
    }
// anyway keep in mind: that subject and total & obtained marks will be equal obviosly, hence add a validation for it, if needed.


    float percentage(int num, int total) {
        float percentage = (float) num/ (float) total * 100f;
        return percentage;
    }
    void calculateSubjectPercentage() {

        if(subject.size() != 0) {
            for(int i=0; i<subject.size(); i++) {
                marksPercentage.set(i, percentage(marks.get(i),subjectTotalMarks.get(i)));
            }
        } 


        
    }
    
    
}