
// ---------------------------------
// |           complex             |
// ---------------------------------
// | - real: int                   |
// | - imag: int                   |
// ---------------------------------
// | + readComplex(sc: Scanner): void |
// | + add(c: complex): complex     |
// | + display(): void              |
// ---------------------------------
//             ▲
//             |
// ---------------------------------
// |        ComplexSum             |
// ---------------------------------
// | + main(args: String[]): void  |
// ---------------------------------

import java.util.Scanner;

class complex {
    int real, imag;
    void readComplex(Scanner sc) {
        System.out.print("Enter real part: ");
        real = sc.nextInt();
        System.out.print("Enter imaginary part: ");
        imag = sc.nextInt();
    }

    complex add(complex c) {
        complex temp = new complex();
        temp.real = this.real + c.real;
        temp.imag = this.imag + c.imag;
        return temp;
    }

    void display() {
        System.out.println("Complex number: " + real + " + " + imag + "i");
    }
}

public class ComplexSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        complex c1 = new complex();
        complex c2 = new complex();
        complex sum;

        c1.readComplex(sc);
        c2.readComplex(sc);

        sum = c1.add(c2);

        System.out.println("First complex number:");
        c1.display();
        System.out.println("Second complex number:");
        c2.display();
        System.out.println("Sum:");
        sum.display();
        sc.close();
    }
}
