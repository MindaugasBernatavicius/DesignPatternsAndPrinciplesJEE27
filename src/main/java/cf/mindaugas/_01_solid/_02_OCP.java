package cf.mindaugas._01_solid;

public class _02_OCP {

}

// 0. We have only Rectangle class and AreaCalculator for that Rectangle
class Rectangle {
   public double length;
   public double width;
}

class AreaCalculator {
   public double calculateRectangleArea(Rectangle rectangle){
       return rectangle.length * rectangle.width;
   }
    // public double calculateCircleArea(Circle circle){
    //     return (22/7) * circle.radius * circle.radius;
    // }
}

// 1. Adding another shape, requires adding another method to AreaCalculator
class Circle {
   public double radius;
}


interface Shape {
    public double calculateArea();
}

class Rectangle2 implements Shape {
    double length;
    double width;
    public double calculateArea() {
        return length * width;
    }
}

class Circle2 implements Shape {
    // private static final double PI = 22/7;
    public double radius;
    public double calculateArea() {
        // DON'T USE MAGIC CONSTANTS, use a named constant (see above)
        return (22 / 7) * radius * radius; // pi * r^2
    }
}

class Square2 implements Shape {
    double length;
    public double calculateArea() {
        return length * length;
    }
}