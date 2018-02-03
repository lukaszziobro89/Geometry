package Shapes.Planes;
import Interfaces.GeometricObjectMethods;
import Shapes.GeometricObject;
import Shapes.Plane;
import java.io.Serializable;
import java.util.InputMismatchException;

public class Rectangle extends Plane implements GeometricObjectMethods, Serializable {

/**----- Properties/fields -----*/
    private double side1 = 1;
    private double side2 = 1;

/**----- Constructors -----*/
    public Rectangle(){
        this.area = side1 * side2;
    }

    public Rectangle(double side1, double side2) {
            setSide1(side1);
            setSide2(side2);
            this.area = side1 * side2;
    }

    public Rectangle(double side1, double side2, String name, String color, boolean isFilled) {
        super(name, color, isFilled);
        setSide1(side1);
        setSide2(side2);
        this.area = side1 * side2;
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
                "\r\n- side 2: " + this.getSide2());
    }


/**----- Method compare two rectangle -----*/
    @Override
    public int compareTo(GeometricObject geometricObject) {
        int compareValue=0;
        if (geometricObject instanceof Rectangle){
            Rectangle rectangle = (Rectangle) geometricObject;
            if (geometricObject.getArea() < rectangle.getArea()){
                compareValue = -1;
            } else if(this.getArea() > geometricObject.getArea()){
                compareValue = 1;
            } else {
                compareValue = 0;
            }
        }
        return compareValue;
    }

/** Checks if side of rectangle is correct */
    private boolean isValidSide(double side1){
        return (side1 > 0);
    }


/**----- Getters (accessors) -----*/
    private double getSide1() {
        return side1;
    }

    private double getSide2() {
        return side2;
    }

/**----- Setters (mutators) -----*/
    private void setSide1(double side1) throws InputMismatchException{
        if (!isValidSide(side1)) {
            throw new InputMismatchException("Side of rectangle must be greater then zero.");
        }
        this.side1 = side1;
    }

    private void setSide2(double side2) throws InputMismatchException{
        if (!isValidSide(side2)) {
            throw new InputMismatchException("Side of rectangle  must be greater then zero.");
        }
        this.side2 = side2;
    }

}
