package Shapes;
import Interfaces.GeometricObjectMethods;
import java.io.Serializable;
public abstract class Plane extends GeometricObject  implements GeometricObjectMethods, Comparable<GeometricObject>, Serializable {
    /** Default constructor */
    protected Plane(){
        super();
    }


    public Plane(String name, String color, boolean isFilled) {
        super(name, color, isFilled);
    }
}
