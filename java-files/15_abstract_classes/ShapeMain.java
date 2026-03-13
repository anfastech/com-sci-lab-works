

// ┌─────────────────────────────┐
// │          Shape              │
// │         (abstract)          │
// ├─────────────────────────────┤
// │ + area(): void (abstract)   │
// └─────────────────────────────┘
//               ▲
//               │
//     ┌─────────┴─────────┐
//     │                   │
// ┌───────────────┐  ┌───────────────┐
// │   TwoDim      │  │   TreeDim     │
// │  (abstract)   │  │  (abstract)   │
// └───────────────┘  └───────────────┘
//        ▲                   ▲
//        │                   │
//     ┌──┴──┐            ┌──┴──┐
//     │     │            │     │
// ┌──────┐ ┌──────┐  ┌──────┐ ┌──────┐
// │Square│ │Triangle││sphere│ │ cube │
// └──────┘ └──────┘  └──────┘ └──────┘

abstract class Shape {
    abstract void area();
}

abstract class TwoDim extends Shape {}
abstract class TreeDim extends Shape {}

class Square extends TwoDim {
    double side;
    
    Square(double side) {
        this.side = side;
    }
    void area() {
        System.out.println("Area of square: " + (side * side));
    }
}

class Triangle extends TwoDim {
    double base, height;
    
    Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }
    void area() {
        System.out.println("Area of triangle: " + (0.5 * base * height));
    }
}

class sphere extends TreeDim {
    double radius;
    
    sphere(double radius) {
        this.radius = radius;
    }
    void area() {
        System.out.println("Surface area of sphere: " + (4 * Math.PI * radius * radius));
    }
}

class cube extends TreeDim {
    double side;
    
    cube(double side) {
        this.side = side;
    }
    void area() {
        System.out.println("Surface area of cube: " + (6 * side * side));
    }
}

public class ShapeMain {
    public static void main(String[] args) {
        Shape square = new Square(5);
        square.area();
        Shape triangle = new Triangle(10, 5);
        triangle.area();
        Shape sphere = new sphere(3);
        sphere.area();
        Shape cube = new cube(4);
        cube.area();
    }
}
