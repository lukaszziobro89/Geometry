package Shapes;
import Interfaces.GeometricObjectMethods;
import Interfaces.SolidsMethods;
import java.io.Serializable;

public abstract class Solid extends GeometricObject  implements GeometricObjectMethods, SolidsMethods, Comparable<GeometricObject>, Serializable {
    /** Default constructor */
    protected Solid(){
        super();
    }

    public Solid(String name, String color, boolean isFilled) {
        super(name, color, isFilled);
    }
}
