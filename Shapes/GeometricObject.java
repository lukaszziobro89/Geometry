package Shapes;
import Interfaces.GeometricObjectMethods;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;
public abstract class GeometricObject implements GeometricObjectMethods, Comparable<GeometricObject>, Serializable{
/**----- Properties/fields -----*/
    protected String name = "No name";
    protected String color = "White";
    protected double area;
    protected boolean isFilled = false;
    protected Date dateCreated = new Date();

/**----- Constructors -----*/
    public GeometricObject(){
        this.dateCreated = new Date();
    }

    public GeometricObject(String name, String color, boolean isFilled) {
        this.name = name;
        this.color = color;
        this.isFilled = isFilled;
    }

/**----- Interface methods implementation -----*/
    @Override
    public void printCreationDate() {
        System.out.println("Object was created on: " + this.dateCreated.toString());
    }

    @Override
    public void printObjectInformation() {
        System.out.println(this.getClass().getSimpleName() +
                "\r\n- created on: " + this.dateCreated.toString() +
                "\r\n- name: " + this.getName() +
                "\r\n- color: " + this.getColor() +
                "\r\n- is filled: " + this.isFilled +
                "\r\n- area: " + this.getArea());
    }

/*----- COMPARATORS -----*/
/**----- Comparator that compares Rectangle objects using name as compare parameter -----*/
    public static Comparator<GeometricObject> nameComparator = new Comparator<>() {
        @Override
        public int compare(GeometricObject o1, GeometricObject o2) {
            return Integer.compare(o1.getName().compareTo(o2.getName()), 0);
        }
    };

/**----- Comparator that compares Rectangle objects using color as compare parameter -----*/
    public static Comparator<GeometricObject> colorComparator = new Comparator<>() {
        @Override
        public int compare(GeometricObject o1, GeometricObject o2) {
            return Integer.compare(o1.getColor().compareTo(o2.getColor()), 0);
        }
    };

/**----- Comparator that compares Rectangle objects using area as compare parameter -----*/
    public static Comparator<GeometricObject> areaComparator = new Comparator<>() {
        @Override
        public int compare(GeometricObject o1, GeometricObject o2) {
            return Integer.compare(Double.compare(o1.getArea(), o2.getArea()), 0);
        }
    };
/**----- Getters (accessors) -----*/

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public double getArea() {
        return area;
    }

    public boolean isFilled() {
        return isFilled;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

/**----- Setters (mutators) -----*/

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setFilled(boolean filled) {
        isFilled = filled;
    }

}
