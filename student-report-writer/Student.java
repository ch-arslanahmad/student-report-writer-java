import java.util.Scanner;

public class Student {
    private String name;
    private int age;
    private int gradeYr;
  
    public String getName(Scanner input) {
        name = input.nextLine();
        return name;
    }

    public int getAge(Scanner input) {
        age = input.nextInt();
        return age;
    }

    public int getGradeYr(Scanner input) {
        gradeYr = input.nextInt();
        return gradeYr;
    }
    
    
}