
// ---------------------------------
// |            Volume             |
// ---------------------------------
// | + findVolume(side: double): double           |
// | + findVolume(length: double, breadth: double, height: double): double |
// | + findVolume(radius: double, height: double): double |
// ---------------------------------
//             ▲
//             |
// ---------------------------------
// |         VolumeMain            |
// ---------------------------------
// | + main(args: String[]): void  |
// ---------------------------------

import java.util.Scanner;

class Volume {
    double findVolume(double side) {
        return side * side * side;
    }

    double findVolume(double length, double breadth, double height) {
        return length * breadth * height;
    }

    double findVolume(double radius, double height) {
        return Math.PI * radius * radius * height;
    }
}

public class VolumeMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Volume volume = new Volume();

        System.out.println("Enter side of cube: ");
        double side = sc.nextDouble();
        System.out.println("Volume of cube: " + volume.findVolume(side));

        System.out.println("Enter length, breadth and height of cuboid: ");
        double length = sc.nextDouble();
        double breadth = sc.nextDouble();
        double height = sc.nextDouble();
        System.out.println("Volume of cuboid: " + volume.findVolume(length, breadth, height));

        System.out.println("Enter radius and height of cylinder: ");
        double radius = sc.nextDouble();
        double cylinderHeight = sc.nextDouble();
        System.out.println("Volume of cylinder: " + volume.findVolume(radius, cylinderHeight));
        
        sc.close();
    }
    
}
