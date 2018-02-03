package Shapes.Planes;
import Interfaces.GeometricObjectMethods;
import Shapes.GeometricObject;
import Shapes.Plane;
import java.io.Serializable;
import java.util.InputMismatchException;

public class Square extends Plane implements GeometricObjectMethods, Serializable{
/**----- Properties/fields -----*/
    private double side;

/**----- Constructors -----*/
    public Square(){
        this.area = side * side;
    }

    public Square(double side){
        setSide(side);
    }

    public Square(double side, String name, String color, boolean isFilled){
            super(name,color,isFilled);
            setSide(side);
            this.area = side * side;
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
                "\r\n- side: " + this.getSide());
    }

/**----- Method compare two squares -----*/
    @Override
    public int compareTo(GeometricObject geometricObject) {
        int compareValue = 0;
        if(geometricObject instanceof Square){
            Square square = (Square)geometricObject;
            if(this.getArea() < square.getArea()){
                return -1;
            } else if(this.getArea() > square.getArea()){
                return 1;
            } else {
                return 0;
            }
        }
        return compareValue;
    }

/** Checks if side of square is correct */
    private boolean isValidSide(double side){
        return (side > 0);
    }
/**----- Getters (accessors) -----*/
    private double getSide() {
        return side;
    }

/**----- Setters (mutators) -----*/
    private void setSide(double side) throws InputMismatchException{
        if (!isValidSide(side)) {
            throw new InputMismatchException("Side of square must be greater then zero.");
        }
        this.side = side;
    }
}
