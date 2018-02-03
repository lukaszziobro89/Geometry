package Serialization;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LoadGeometricObjects {
    public static <T> List<T> loadObjectsFromFile(String directory, String fileName){
        // create path to file
        String path = directory + File.separator + fileName;
        // create List for deserialized objects
        List<T> deserializedGeometricObjects = new ArrayList<>();

        // create geometric object
        T element;
        boolean check  = true;
        // create stream to save objects into file
        try(ObjectInputStream inputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(path)))){
            // save each element from list into file
            while (check) {
                try {
                    element = (T)inputStream.readObject();
                    deserializedGeometricObjects.add(element);
                } catch (EOFException e) {
                    check = false;
                }catch (ClassNotFoundException ex){
                    ex.printStackTrace();
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return deserializedGeometricObjects;
    }
}
