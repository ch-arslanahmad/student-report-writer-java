// this was made to solve the issue of adding subjects like newline and spaces and input problem

import java.util.Scanner;
import java.util.ArrayList;
class Maintesting {
    private ArrayList<String> subject = new ArrayList<>();

    void addSubject(Scanner input) {
        System.out.println("Type '0' to exit.");
        int n = 1;
        while (true) {
            System.out.print("Enter subject#" + n + ": ");
            String a = input.nextLine();
            if(a.equals("0")) {
            return;
            }
            else {
            subject.add(a);
            }
            n++;

        }
    }

public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    Maintesting student = new Maintesting();
    
    student.addSubject(input);
    
}
}




