class Triangle {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Please provide three side lengths of the triangle.");
            return;
        }

        try {
            double a = Double.parseDouble(args[0]);
            double b = Double.parseDouble(args[1]);
            double c = Double.parseDouble(args[2]);

            // Check if sides form a valid triangle
            if (a <= 0 || b <= 0 || c <= 0 || (a + b <= c) || (a + c <= b) || (b + c <= a)) {
                System.out.println("Invalid triangle sides.");
                return;
            }

            // Determine the type of triangle
            if (a == b && b == c) {
                System.out.println("The triangle is equilateral.");
            } else if (a == b || b == c || a == c) {
                System.out.println("The triangle is isosceles.");
            } else {
                System.out.println("The triangle is scalene.");
            }

            // Calculate the area using Heron's formula
            double s = (a + b + c) / 2;
            double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
            System.out.println("Area of the triangle is: " + area);

        } catch (NumberFormatException e) {
            System.out.println("Please provide valid numerical side lengths.");
        }
    }
}
