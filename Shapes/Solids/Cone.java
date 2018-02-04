package Shapes.Solids;
import Interfaces.GeometricObjectMethods;
import Shapes.GeometricObject;
import Shapes.Solid;
import java.io.Serializable;
import java.util.InputMismatchException;

public class Cone extends Solid implements GeometricObjectMethods, Serializable{
/**----- Properties/fields -----*/
    private double baseRadius;
    private double height;

/**----- Constructors -----*/
    public Cone(){
        setBaseRadius(1);
        setHeight(1);
        this.area = calculateBaseArea() + calculateSideArea();
    }

    public Cone(double baseRadius, double height){
        setBaseRadius(baseRadius);
        setHeight(height);
        this.area = calculateBaseArea() + calculateSideArea();
    }

    public Cone(double baseRadius, double height, String name, String color, boolean isFilled){
        this(baseRadius, height);
        this.area = calculateBaseArea() + calculateSideArea();
        this.name = name;
        this.color = color;
        this.isFilled = isFilled;
    }

/** Method compares two cones */
    @Override
    public int compareTo(GeometricObject geometricObject) {
        int compareValue=0;
        if (geometricObject instanceof Cone){
            Cone cone = (Cone) geometricObject;
            if (this.getArea() < cone.getArea()){
                compareValue = -1;
            } else if(this.getArea() > cone.getArea()){
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
                "\r\n- radius: " + this.getBaseRadius() +
                "\r\n- height: " + this.getHeight() +
                "\r\n- side area: " + this.calculateSideArea() +
                "\r\n- cone generatrix: " + this.calculateConeGeneratrix() +
                "\r\n- volume: " + this.calculateVolume() +
                "\r\n- height: " + this.getHeight());
    }

    @Override
    public double calculateBaseArea() {
        return (Math.PI * getBaseRadius() * getBaseRadius());
    }

    @Override
    public double calculateSideArea() {
        return (Math.PI * getBaseRadius() * calculateConeGeneratrix());
    }

    @Override
    public double calculateVolume() {
        return ((1/3) * Math.PI * getHeight() * getBaseRadius() * getBaseRadius());
    }

/** Calculate cone generatrix */
    private double calculateConeGeneratrix(){
        return (Math.sqrt(Math.pow(this.getBaseRadius(), 2) + Math.pow(this.getHeight(), 2)));
    }
/**----- Getters (accessors) -----*/
    private double getBaseRadius() {
        return baseRadius;
    }

    private double getHeight() {
        return height;
    }

/** Checks if radius is correct */
    private boolean isValidBaseRadius(double baseRadius){
        return (baseRadius > 0);
    }

    private boolean isValidHeight(double height){
        return (height > 0);
    }

/**----- Setters (mutators) -----*/
    private void setBaseRadius(double baseRadius)throws InputMismatchException {
        if (!isValidBaseRadius(baseRadius)) {
            throw new InputMismatchException("Base radius must be greater then zero.");
        }
        this.baseRadius = baseRadius;
    }

    private void setHeight(double height)throws InputMismatchException {
        if (!isValidHeight(height)) {
            throw new InputMismatchException("Height must be greater then zero.");
        }
        this.height = height;
    }

}
