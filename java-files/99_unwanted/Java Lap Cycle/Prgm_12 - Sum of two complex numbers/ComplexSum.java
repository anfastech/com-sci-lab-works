import java.util.Scanner;
class Complex {
    double real;
    double imag;

    void read() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the real part: ");
        real = sc.nextDouble();
        System.out.print("Enter the imaginary part: ");
        imag = sc.nextDouble();
    }

    Complex add(Complex c){
        Complex temp = new Complex();
        temp.real = real + c.real;
        temp.imag = imag + c.imag;
        return temp;
    }

    void display() {
        System.out.println(real+"+"+imag+"i");
    }
}

public class ComplexSum {
    public static void main(String[] args) {
        Complex c1 = new Complex();
        Complex c2 = new Complex();
        Complex result;
        System.out.println("Enter 1st complex number:");
        c1.read();
        System.out.println("Enter 2nd complex number:");
        c2.read();
        result = c1.add(c2);
        System.out.print("The sum of complex numbers: ");
        result.display();
    }
}