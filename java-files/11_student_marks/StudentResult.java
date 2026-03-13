
// ---------------------------------
// |           student             |
// ---------------------------------
// | - name: String                |
// | - rollNo: int                 |
// ---------------------------------
// | + read(): void                |
// | + display(): void             |
// ---------------------------------
//             ▲
//             |
// ---------------------------------
// |           marks               |
// ---------------------------------
// | - m1: int                     |
// | - m2: int                     |
// | - m3: int                     |
// | - total: int                  |
// | - avg: double                 |
// ---------------------------------
// | + readMarks(): void           |
// | + displayMarks(): void        |
// ---------------------------------
//             ▲
//             |
// ---------------------------------
// |       StudentResult           |
// ---------------------------------
// | + main(args: String[]): void  |
// ---------------------------------

import java.util.Scanner;

class student {
    String name;
    int rollNo;
    
    void read() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name: ");
        name = sc.nextLine();
        System.out.println("Enter roll number: ");
        rollNo = sc.nextInt();

        sc.close();
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNo);
    }

}

class marks extends student {
    int m1, m2, m3;
    int total;
    double avg;

    void readMarks() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter marks for subject 1: ");
        m1 = sc.nextInt();
        System.out.println("Enter marks for subject 2: ");
        m2 = sc.nextInt();
        System.out.println("Enter marks for subject 3: ");
        m3 = sc.nextInt();
        sc.close();
    }
    void displayMarks() {
        System.out.println("Marks: " + m1 + ", " + m2 + ", " + m3);
    }
}

public class StudentResult {
    public static void main(String[] args) {
        marks studentMarks = new marks();

        studentMarks.read();
        studentMarks.readMarks();

        studentMarks.total = studentMarks.m1 + studentMarks.m2 + studentMarks.m3;
        studentMarks.avg = studentMarks.total / 3.0;

        studentMarks.display();
        studentMarks.displayMarks();
        
        System.out.println("Total Marks: " + studentMarks.total);
    }    
}
