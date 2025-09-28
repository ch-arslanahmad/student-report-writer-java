package model;

// import Scanner: input
import java.util.Scanner;

import display.Input;

// import Arraylist
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// class
public class Student {
    // Student Attributes
    private String name;
    private int age;
    private int gradeYr;
    boolean isValid = true;

    // totals.
    private int totalMarks;
    private int totalObtMarks;
    private float totalPercentage;

    // a custom record for total and obtained marks of a subject
    public record Marks(int total, int obtained) {
    }

    // default Constructor
    public Student(String name, int age, int gradeYr) {
        this.name = name;
        this.age = age;
        this.gradeYr = gradeYr;
    }

    // empty constructor

    public Student() {

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

    // SETTERS
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGradeYr(int gradeYr) {
        this.gradeYr = gradeYr;
    }

    // add Subject
    public ArrayList<String> addSubject(Scanner scanner, Input input) {
        ArrayList<String> subject = new ArrayList<>();

        System.out.println("Type '0' to exit.");
        int n = 1;
        while (true) {
            System.out.print("Enter subject#" + n + ": ");
            String a = input.getNormalInput(scanner);
            if (a.equals("0") || a.equals("-1")) {
                break;
            } else {
                subject.add(a);
            }
            n++;
        }
        return subject;

    }

    // find maxlength for dynamic output
    public int findMaxlength(ArrayList<String> subject) {
        int max = subject.get(0).length();
        for (int i = 1; i < subject.size(); i++) {
            if (max < subject.get(i).length()) {
                max = subject.get(i).length();
            }
        }
        if (max < 10)
            max = 10;
        return max;
    }

    // getter for subject
    String getSubject(ArrayList<String> subject, int i) {
        return subject.get(i);
    }

    // 'size' of subject arraylist
    int sizeSubject(ArrayList<String> subject) {
        return subject.size();
    }

    // ? assumes multiple subjects exist - (Subject) TOTAL MARKS
    public int setSubjectTotalMarks(String subject, Scanner scanner, Input input) {
        while (true) {
            System.out.print("Enter total marks of " + subject + ": ");
            int subjectTotalMarks = input.getNumInput(scanner);
            if (subjectTotalMarks > 0) {
                return subjectTotalMarks;
            } else {
                System.out.println("Total marks must be greater than zero!");
            }
        }
    }

    // assumes multiple subjects exist // ... (Subject) OBT MARKS
    public int setSubjectMarks(String subject, int subjectMarks, Scanner scanner, Input input) {
        while (true) {
            System.out.print("Enter obtained marks of " + subject + ": ");
            int obtMarks = input.getNumInput(scanner);
                if (obtMarks < 0) {
                    System.out.println("Obtained marks cannot be negative.");
                } else if (obtMarks > subjectMarks) {
                    System.out.println("Obtained marks cannot be greater than total marks (" + subjectMarks + ").");
                } else {
                    return obtMarks;
                }
            }
        }

    // adds Marks for each subject
    public Map<String, Marks> setAllMarks(ArrayList<String> subjects, Scanner scanner, Input input) {

        Map<String, Marks> marks = new HashMap<>();

        for (String subject : subjects) {
            int total = setSubjectTotalMarks(subject, scanner, input);
            int obtained = setSubjectMarks(subject, total,scanner, input);

            marks.put(subject, new Marks(total, obtained));
        }
        return marks;
    }

    // fixed logic: Total Marks method
    public int getTotalMarks(ArrayList<Integer> subjectTotalMarks) {
        // totalMarks
        for (int i = 0; i < subjectTotalMarks.size(); i++) {
            totalMarks += subjectTotalMarks.get(i);
        }
        return totalMarks;
    }

    // total obtained-marks
    public int getTotalObtMarks(ArrayList<Integer> marks) {
        for (int i = 0; i < marks.size(); i++) {
            totalObtMarks += marks.get(i);
        }
        return totalObtMarks;
    }

    // find percentage
    public float percentage(int num, int total) {
        return (float) num / (float) total * 100f;
    }

    // find percentage of specific subject
    public ArrayList<Float> calculateSubjectPercentage(ArrayList<String> subjects, ArrayList<Integer> subjectTotalMarks,
            ArrayList<Integer> marks) {

        ArrayList<Float> subjectPercentages = new ArrayList<>();

        for (int i = 0; i < subjects.size(); i++) {
            float perc = percentage(marks.get(i), subjectTotalMarks.get(i));
            subjectPercentages.add(perc);
        }
        return subjectPercentages;

    }

    // find Percentage as a whole
    /*
     * simply it is an average of percentages:
     * so optimally average formula should be used.
     * avg = sum of all values / total number of values
     */
    void calculateTotalPercentage(ArrayList<Float> marksPercentage) {
        // to find the maximum number to be the divisor
        try {
            if (marksPercentage.size() > 0) {
                totalPercentage = 0f;
                for (int i = 0; i < marksPercentage.size(); i++) {
                    totalPercentage += marksPercentage.get(i);
                }
                totalPercentage = totalPercentage / marksPercentage.size();
            } else {
                throw new Exception("You need subjects to calculate percentages of.");
            }
        } catch (Exception e) {
            System.out.println("Error occured");
            e.printStackTrace();
        }

    }

    public float getTotalPercentage(ArrayList<Float> marksPercentage) {
        calculateTotalPercentage(marksPercentage);
        return totalPercentage;
    }

}