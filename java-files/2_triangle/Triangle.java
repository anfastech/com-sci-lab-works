
/**
 * -------------------------
 * CLASS DIAGRAM:
 * -------------------------
 * Triangle
 * -------------------------
 * +main(args : String[]) : void
 * -------------------------
 */

class Triangle {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Please provide three integer numbers as command line arguments.");
            return;
        }

        try {
            double side1 = Double.parseDouble(args[0]);
            double side2 = Double.parseDouble(args[1]);
            double side3 = Double.parseDouble(args[2]);

            if (side1 <=0 || side2 <=0 || side3 <=0 || (side1 + side2 <= side3) || (side1 + side3 <= side2) || (side2 + side3 <= side1)) {
                System.out.println("Invalid triangle sides");
                return;
            }

            if (side1 == side2 && side2 == side3) {
                System.out.println("Equilateral triangle");
            } else if (side1 == side2 || side2 == side3 || side1 == side3) {
                System.out.println("Isosceles triangle");
            } else {
                System.out.println("Scalene triangle");
            }

            double s = (side1 + side2 + side3) / 2;
            double area = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
            System.out.println("Area of the triangle: " + area);
        }

        catch (NumberFormatException e) {
            System.out.println("Please provide valid numeric side lengths.");
        }
    }
}