package SDP_assignment_4;
import java.util.ArrayList;
import java.util.List;

public class ShapeArea {
    interface Shape {
        void accept(Visitor visitor);
    }
    class Circle implements Shape {
        private double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        public double getRadius() {
            return radius;
        }

        @Override
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }
    }
    class Rectangle implements Shape {
        private double width;
        private double height;

        public Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }

        public double getWidth() {
            return width;
        }

        public double getHeight() {
            return height;
        }

        @Override
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }
    }
    class Triangle implements Shape {
        private double base;
        private double height;

        public Triangle(double base, double height) {
            this.base = base;
            this.height = height;
        }

        public double getBase() {
            return base;
        }

        public double getHeight() {
            return height;
        }

        @Override
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }
    }
    interface Visitor {
        void visit(Circle circle);
        void visit(Rectangle rectangle);
        void visit(Triangle triangle);
    }
    class AreaCalculator implements Visitor {
        @Override
        public void visit(Circle circle) {
            double area = Math.PI * Math.pow(circle.getRadius(), 2);
            System.out.println("Area of Circle: " + area);
        }

        @Override
        public void visit(Rectangle rectangle) {
            double area = rectangle.getWidth() * rectangle.getHeight();
            System.out.println("Area of Rectangle: " + area);
        }

        @Override
        public void visit(Triangle triangle) {
            double area = 0.5 * triangle.getBase() * triangle.getHeight();
            System.out.println("Area of Triangle: " + area);
        }
    }
    class Drawing {
        private List<Shape> shapes = new ArrayList<>();

        public void addShape(Shape shape) {
            shapes.add(shape);
        }

        public void calculateAreas() {
            AreaCalculator areaCalculator = new AreaCalculator();
            for (Shape shape : shapes) {
                shape.accept(areaCalculator);
            }
        }
    }
}
