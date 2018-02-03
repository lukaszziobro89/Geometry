package XMLSave;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SaveXML {
    public static <E> void saveObjectsXML(List<E> geometricObjectList, String directory, String fileName){

        // create path to file
        String path = directory + File.separator + fileName;
        // create list and add all elements go it
        List<E> encodedElements = new ArrayList<>(geometricObjectList);
        // add elements to list

        // create stream to save objects into file
        try(XMLEncoder outputStream = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(path)))){
            // save each element from list into file
            outputStream.writeObject(encodedElements);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
