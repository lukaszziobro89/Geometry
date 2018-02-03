package Shapes.Planes;
import Interfaces.GeometricObjectMethods;
import Shapes.GeometricObject;
import Shapes.Plane;
import java.io.Serializable;
import java.util.InputMismatchException;

public class Triangle extends Plane implements GeometricObjectMethods, Serializable {
/**----- Properties/fields -----*/
    private double side1;
    private double side2;
    private double side3;

/**----- Constructors -----*/
    public Triangle(){
        setSide1(1);
        setSide2(1);
        setSide3(1);
    }

    public Triangle(double side1, double side2, double side3){
        if(isValidTriangle(side1, side2, side3)){
            setSide1(side1);
            setSide2(side2);
            setSide3(side3);
        }
    }

    public Triangle(double side1, double side2, double side3 ,String name, String color, boolean isFilled){
        if(isValidTriangle(side1, side2, side3)){
            setSide1(side1);
            setSide2(side2);
            setSide3(side3);
            this.name = name;
            this.color = color;
            this.isFilled = isFilled;
        }
    }

/** A method returns true if triangle build from sides exists */
    private boolean isValidTriangle(double side1, double side2, double side3){
        if (side1 <= 0 || side2 <= 0 || side3 <= 0){
            throw new InputMismatchException("Each side of triangle must be greater then zero.");
        } else if (!(side1 + side2 > side3 && side1 + side3 > side2 && side3 + side2 > side1)){
            throw new InputMismatchException("Sides does not meet triangle condition.");
        }
        return true;
    }

/** A method named getArea() that returns the area of this triangle. */
    public double getArea(){
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

/**----- Interface methods implementations -----*/
    @Override
    public void printObjectInformation() {
        System.out.println(this.getClass().getSimpleName() +
                "\r\n- created on: " + this.dateCreated.toString() +
                "\r\n- name: " + this.getName() +
                "\r\n- color: " + this.getColor() +
                "\r\n- is filled: " + this.isFilled +
                "\r\n- area: " + this.getArea() +
                "\r\n- side 1: " + this.getSide1() +
                "\r\n- side 2: " + this.getSide2() +
                "\r\n- side 3: " + this.getSide3());
    }

/**----- Method compare two squares -----*/
    @Override
    public int compareTo(GeometricObject geometricObject) {
        int compareValue = 0;
        if (geometricObject instanceof Triangle){
            Triangle triangle = (Triangle)geometricObject;
            if (this.getArea() < triangle.getArea()){
                return -1;
            } else if(this.getArea() > triangle.getArea()){
                return 1;
            } else {
                return 0;
            }
        }
        return compareValue;
    }

/** Checks if side of triangle is correct */
    private boolean isValidSide(double side){
        return (side > 0);
    }

/**----- Setters (mutators) -----*/
    private void setSide1(double side1) throws InputMismatchException{
        if (!isValidSide(side1) && isValidTriangle(side1, side2, side3)){
            throw new InputMismatchException("Each side of triangle must be greater then zero.");
        }
        this.side1 = side1;
    }

    private void setSide2(double side2) throws InputMismatchException{
        if (!isValidSide(side2) && isValidTriangle(side1, side2, side3)){
            throw new InputMismatchException("Each side of triangle must be greater then zero.");
        }
        this.side2 = side2;
    }

    private void setSide3(double side3) throws InputMismatchException{
        if (!isValidSide(side3) && isValidTriangle(side1, side2, side3)){
            throw new InputMismatchException("Each side of triangle must be greater then zero.");
        }
        this.side3 = side3;
    }

/**----- Getters (accessors) -----*/
    private double getSide1() {
        return side1;
    }

    private double getSide2() {
        return side2;
    }

    private double getSide3() {
        return side3;
    }

}
