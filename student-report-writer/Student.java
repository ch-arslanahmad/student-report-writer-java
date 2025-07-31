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
    boolean isValid = true;

    // creating Arraylist: subject.
    private ArrayList<String> subject = new ArrayList<>();
    // data type cannot be primitive, hence a wrapper used, Integer for 'int' datatype.
    private ArrayList<Integer> subjectTotalMarks = new ArrayList<>();
    private int totalMarks;
    private ArrayList<Integer> marks = new ArrayList<>();
    private int totalObtMarks;
    private ArrayList<Float> marksPercentage = new ArrayList<>();
    private float totalPercentage;
  

    void setDetails(Scanner input) {
        // get name
        System.out.print("Enter your name: ");
        name = input.nextLine();       
        // get age
        System.out.print("Enter your age: ");
        age = input.nextInt();
        // get grade year
        System.out.print("Enter your grade year: ");
        gradeYr = input.nextInt();

        // this is to consume the newline character left by input
        input.nextLine();

    }
    // Name getter
    public String getName() {
        return name;
    }
    
    // student age getter
    public int getAge() {
        return age;
    }
    
    // student grade getter
    public int getGradeYr() {
        return gradeYr;

    }


    // add Subject
    void addSubject(Scanner input) {
        System.out.println("Type '0' to exit.");
        int n = 1;
        while (true) {
            System.out.print("Enter subject#" + n + ": ");
            String a = input.nextLine();
            if(a.equals("0")) {
                break;
            }
            else {
                subject.add(a);
            }
            n++;

        }
    }

    // find maxlength for dynamic output
    int findMaxlength() {
        int max = subject.get(0).length();
        for(int i=1; i<subject.size(); i++) {
            if(max<subject.get(i).length()) {
                max = subject.get(i).length();
            }
        }
        if(max<10)
            max = 10;
        return max;
    }
    // getter for subject
    String getSubject(int i) {
        return subject.get(i);
    }
    // 'size' of subject arraylist
    int sizeSubject() {
        return subject.size();
    }

    // adds Marks for each subject
    void setMarks(Scanner input) {
        // runs if subject is not 0.  
        if(sizeSubject() != 0) {
            for(int i=0; i<sizeSubject(); i++) {
            System.out.print("Enter total marks of " + subject.get(i) + ": ");
            // used add() method of ArrayList for Total marks of subject: as add adds value even if list is empty
            int subjectMarks = input.nextInt();
            if(subjectMarks != 0) {
                subjectTotalMarks.add(subjectMarks);
            }
            else {
                System.out.println("Total marks cannot be zero!");
            }
            System.out.print("Enter obtained marks of " + subject.get(i) + ": ");
            // again add() method for obtained marks
            marks.add(input.nextInt());
            }
        }
        else {
            System.out.print("No subjects were added!");
        }
        
        // this is to consume the newline character left by input
        input.nextLine();
    }
// anyway keep in mind: that subject and total & obtained marks will be equal obviosly, hence add a validation for it, if needed.

    // getter for subject total marks
    int getsubjectTotalMarks(int i) {
        return subjectTotalMarks.get(i);
    }

    // 'size' of marks arraylist
    int sizesubjectMarks() {
        return subjectTotalMarks.size();
    }

    // getter for subject obtained marks
    int getsubjectObtMarks(int i) {
        return marks.get(i);
    }


    // 'size' of obtained marks arraylist
    int sizeObtMarks() {
        return marks.size();
    }

    // fixed logic: Total Marks method
    int getTotalMarks() {
        // totalMarks
        for(int i = 0; i<subjectTotalMarks.size(); i++) {
        totalMarks += subjectTotalMarks.get(i);
        }
        return totalMarks;
    }

    // total obtained-marks
    int getTotalObtMarks() {
        for(int i = 0; i<marks.size(); i++) {
        totalObtMarks += marks.get(i);
        }
        return totalObtMarks;
    }

    // find percentage
    float percentage(int num, int total) {
        float percentage = (float) num/ (float) total * 100f;
        return percentage;
    }
    
    // find percentage of specific subject
    void calculateSubjectPercentage() {

        if(subject.size() != 0) {
            for(int i=0; i<subject.size(); i++) {
                marksPercentage.add(percentage(marks.get(i),subjectTotalMarks.get(i)));
            }
        }
    }
    

    // getter for subject obtained marks
    float getsPercentages(int i) {
        calculateSubjectPercentage();
        return marksPercentage.get(i);
    }


    // 'size' of obtained marks arraylist
    int sizePercentages() {
        return marksPercentage.size();
    }


    // find Percentage as a whole
/*
simply it is an average of percentages:
so optimally average formula should be used.
avg = sum of all values / total number of values
 */
void calculateTotalPercentage() {
        // to find the maximum number to be the divisor
        try {
        if(marksPercentage.size() > 0) {
            totalPercentage =  0f;
                for(int i = 0; i<marksPercentage.size(); i++) {
                    totalPercentage += marksPercentage.get(i);
                }
        totalPercentage = totalPercentage / marksPercentage.size();
        }
        else {
            throw new Exception("You need subjects to calculate percentages of.");
        }         
        } catch (Exception e) {
            System.out.println("Error occured");
            e.printStackTrace();
        }

    }

float getTotalPercentage() {
    calculateTotalPercentage();
    return totalPercentage;
}


    
}