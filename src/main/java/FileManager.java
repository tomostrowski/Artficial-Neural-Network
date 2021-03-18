
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileManager {

    public static String generateFileName(String extension) {
        DateTimeFormatter timeStampPattern = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        LocalDateTime dateTime = LocalDateTime.now();
        return extension.toUpperCase()+"/network-weights_" + dateTime.format(timeStampPattern) + "."+extension;
    }
    public static String generateFileName(){
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        LocalDateTime dateTime = LocalDateTime.now();
        return "network-weights_"+dateTime.format(timeFormatter);
    }

    public static void createFile(String filename) {
        try {
            FileWriter filewriter = new FileWriter(filename);
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void writeJSON(FileModel fileModel) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new File(fileModel.getFilePath()), fileModel);
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void writeTXT(FileModel fileModel) throws IOException{
        FileWriter fileWriter = new FileWriter(fileModel.getFilePath());

    }

    public static FileModel readJSON(String filename) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        FileModel fileModel = mapper.readValue(new File("JSON/" + filename), FileModel.class);
        System.out.println(fileModel.getFilePath());
        System.out.println(fileModel.getStructure());
        System.out.println(fileModel.getTotalWeightList());
        return fileModel;
    }

//    public static NetworkData readTXT(String filename) throws IOException {
//
//
//
//        return networkData;
//    }

}