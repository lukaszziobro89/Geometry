package XMLSave;
import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class LoadXML {
    public <T> List<T> loadObjectsXML(String directory, String fileName){
        // create path to file
        String path = directory + File.separator + fileName;
        File file = new File(path);
        // create List for deserialized objects
        List<T> deserializedGeometricObject = new ArrayList<>();

        // create rectangle object
        List<T> element;
        boolean check = true;
        // create stream to save objects into file
        try(XMLDecoder inputStream = new XMLDecoder(new BufferedInputStream(new FileInputStream(file)))){
            // save each element from list into file
            deserializedGeometricObject = (List<T>)inputStream.readObject();
        } catch (FileNotFoundException ex){
            ex.printStackTrace();
        }
        return deserializedGeometricObject;
    }
}
