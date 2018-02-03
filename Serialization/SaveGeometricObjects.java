package Serialization;
import java.io.*;
import java.util.List;

public class SaveGeometricObjects {
    /** Method that save serializable list of the same type objects
     * into file name under provided path */
    public static <T> void saveObjectsIntoFile(List<T> geometricObjectList, String directory, String fileName){

        // create path to file
        String path = directory + File.separator + fileName;

        // create stream to save objects into file
        try(ObjectOutputStream outputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(path)))){
            // save each element from list into file
            for (T element : geometricObjectList) {
                outputStream.writeObject(element);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
