package Shapes.Solids;
import Interfaces.GeometricObjectMethods;
import Shapes.GeometricObject;
import Shapes.Solid;
import java.io.Serializable;
import java.util.InputMismatchException;

public class Cube extends Solid implements GeometricObjectMethods, Serializable {
/**----- Properties/fields -----*/
    private double edge;

/**----- Constructors -----*/
    public Cube(){
        setEdge(1);
        this.area = calculateBaseArea() + calculateSideArea();
    }

    public Cube(double edge){
        setEdge(edge);
        this.area = calculateBaseArea() + calculateSideArea();
    }

    public Cube(String name, String color, boolean isFilled, double edge){
        super(name, color, isFilled);
        setEdge(edge);
        this.area = calculateBaseArea() + calculateSideArea();
    }

/** Method compares two cubes */
    @Override
    public int compareTo(GeometricObject geometricObject) {
        int compareValue=0;
        if (geometricObject instanceof Cube){
            Cube cube = (Cube) geometricObject;
            if (this.getArea() < cube.getArea()){
                compareValue = -1;
            } else if(this.getArea() > cube.getArea()){
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
                "\r\n- side area: " + this.calculateSideArea() +
                "\r\n- base area: " + this.calculateBaseArea() +
                "\r\n- volume: " + this.calculateVolume());
    }

    @Override
    public double calculateBaseArea() {
        return (2 * (Math.pow(edge,2)));
    }

    @Override
    public double calculateSideArea() {
        return (2 * (Math.pow(edge,2)));
    }

    @Override
    public double calculateVolume() {
        return (Math.pow(edge,3));
    }

/**----- Getters (accessors) -----*/
    public double getEdge() {
        return edge;
    }

/**----- Setters (mutators) -----*/
    private void setEdge(double edge) throws InputMismatchException{
        if (edge <= 0){
            throw new InputMismatchException("Edge must be greater then zero.");
        }
        this.edge = edge;
    }
}
