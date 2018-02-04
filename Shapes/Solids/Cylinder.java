package Shapes.Solids;
import Interfaces.GeometricObjectMethods;
import Shapes.GeometricObject;
import Shapes.Solid;
import java.io.Serializable;
import java.util.InputMismatchException;

public class Cylinder extends Solid implements GeometricObjectMethods, Serializable {
/**----- Properties/fields -----*/
    private double cylinderRadius;
    private double cylinderHeight;

/**----- Constructors -----*/
    public Cylinder(){
        setCylinderRadius(1);
        setCylinderHeight(1);
        this.area = 2 * calculateBaseArea() + calculateSideArea();
    }

    public Cylinder(double cylinderRadius, double cylinderHeight){
        setCylinderRadius(cylinderRadius);
        setCylinderHeight(cylinderHeight);
        this.area = 2 * calculateBaseArea() + calculateSideArea();
    }

    public Cylinder(String name, String color, boolean isFilled, double cylinderRadius, double cylinderHeight) {
        super(name, color, isFilled);
        this.cylinderRadius = cylinderRadius;
        this.cylinderHeight = cylinderHeight;
    }

/** Method compares two cylinders */
    @Override
    public int compareTo(GeometricObject geometricObject) {
        int compareValue=0;
        if (geometricObject instanceof Cone){
            Cylinder cylinder = (Cylinder) geometricObject;
            if (this.getArea() < cylinder.getArea()){
                compareValue = -1;
            } else if(this.getArea() > cylinder.getArea()){
                compareValue = 1;
            } else {
                compareValue = 0;
            }
        }
        return compareValue;
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
                "\r\n- radius: " + this.getCylinderRadius() +
                "\r\n- height: " + this.getCylinderHeight() +
                "\r\n- side area: " + this.calculateSideArea() +
                "\r\n- base area: " + this.calculateBaseArea() +
                "\r\n- volume: " + this.calculateVolume());
    }

    @Override
    public double calculateBaseArea() {
        return (Math.PI * getCylinderRadius() * getCylinderRadius());
    }

    @Override
    public double calculateSideArea() {
        return (2 * Math.PI * getCylinderRadius() * getCylinderHeight());
    }

    @Override
    public double calculateVolume() {
        return (calculateBaseArea() * getCylinderHeight());
    }

/** Checks if radius is correct*/
    private boolean isValidCylinderRadius(double cylinderRadius){
        return (cylinderRadius > 0);
    }

/** Checks if radius is correct*/
    private boolean isValidCylinderHeight(double cylinderHeight){
        return (cylinderHeight > 0);
    }


/**----- Getters (accessors) -----*/
    private double getCylinderRadius() {
        return cylinderRadius;
    }

    private double getCylinderHeight() {
        return cylinderHeight;
    }

/**----- Setters (mutators) -----*/
    private void setCylinderRadius(double cylinderRadius) throws InputMismatchException{
        if(!isValidCylinderRadius(cylinderRadius)){
            throw new InputMismatchException("Radius must be greater then zero.");
        }
        this.cylinderRadius = cylinderRadius;
    }

    private void setCylinderHeight(double cylinderHeight) throws InputMismatchException{
        if (!isValidCylinderHeight(cylinderHeight)){
            throw new InputMismatchException("Height of cylinder must be greater then zero.");
        }
        this.cylinderHeight = cylinderHeight;
    }

}
