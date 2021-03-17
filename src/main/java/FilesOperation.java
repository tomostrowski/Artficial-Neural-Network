
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

public class FilesOperation {

    public static void createFile(String filename) {
        try {
            FileWriter filewriter = new FileWriter(filename);
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void writeJSON(NetworkData networkData) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new File(networkData.filename), networkData);
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void writeTXT(NetworkData networkData) throws IOException{
        FileWriter fileWriter = new FileWriter(networkData.filename);

    }

    public static NetworkData readJSON(String filename) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        NetworkData networkData = mapper.readValue(new File("JSON/" + filename), NetworkData.class);
        System.out.println(networkData.filename);
        System.out.println(networkData.structure);
        System.out.println(networkData.totalWeightList);
        return networkData;
    }

//    public static NetworkData readTXT(String filename) throws IOException {
//
//
//
//        return networkData;
//    }

}