package Shapes.Planes;
import Interfaces.GeometricObjectMethods;
import Shapes.GeometricObject;
import Shapes.Plane;
import java.io.Serializable;
import java.util.InputMismatchException;

public class Circle extends Plane implements GeometricObjectMethods, Serializable{
/**----- Properties/fields -----*/
    private double radius = 1;

/**----- Constructors -----*/
    public Circle(){
        this.area = (Math.PI * this.radius * this.radius);
        setRadius(1);
    }

    public Circle(double radius){
        this.area = (Math.PI * this.radius * this.radius);
        setRadius(radius);
    }

    public Circle(double radius, String name, String color, boolean isFilled) {
        this(radius);
        this.name = name;
        this.color = color;
        this.isFilled = isFilled;
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
                "\r\n- radius: " + this.getRadius());
    }

/** Checks if radius is correct */
    private boolean isValidRadius(double radius){
        return (radius > 0);
    }

/**----- Getters (accessors) -----*/
    private double getRadius() {
        return radius;
    }

/**----- Setters (mutators) -----*/
    private void setRadius(double radius)throws InputMismatchException {
        if (!isValidRadius(radius)) {
            throw new InputMismatchException("Circle radius must be greater then zero.");
        }
        this.radius = radius;
    }

/** Method compare two circles */
    @Override
    public int compareTo(GeometricObject geometricObject) {
        int compareValue=0;
        if (geometricObject instanceof Circle){
            Circle circle = (Circle) geometricObject;
            if (this.getRadius() < circle.getRadius()){
                compareValue = -1;
            } else if(this.getRadius() > circle.getRadius()){
                compareValue = 1;
            } else {
                compareValue = 0;
            }
        }
        return compareValue;
    }
}
