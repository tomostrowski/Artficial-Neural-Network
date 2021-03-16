import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class FilesOperation {

    public static String createFile(String filename) {
        try {
            FileWriter filewriter = new FileWriter(filename);
        } catch (IOException e) {
            System.out.println("An error occured.");
            e.printStackTrace();
        }
            return filename;
    }

    public static void writeToFile(String filename, ArrayList<Integer> networkStructure, ArrayList<ArrayList<ArrayList<Double>>> weightList) {
        try {

            JSONObject jsonObject = new JSONObject();
            JSONArray weights = new JSONArray();
            JSONArray structure = new JSONArray();
            for (int s : networkStructure){
                structure.put(s);
            }
            weights.put(weightList);
            jsonObject.put("structure", structure);
            jsonObject.put("weights", weights);
//            String[] weighsArray = totalNetworkWeights.split("\\[\\d.*\\]");
//            for(int i=0; i<weighsArray.length; i++){
//                myWriter.write(weighsArray[i]+"\n");
//                System.out.println("~~");
//                System.out.println(weighsArray[i]);
//            }
            Files.write(Paths.get(filename),jsonObject.toString().getBytes());

        } catch (IOException e){
            System.out.println("An error occured.");
            e.printStackTrace();
        }
    }

    public ArrayList<ArrayList<Double>> readFile(String filename){
        try {
//            Scanner sc = new Scanner(System.in);
//            System.out.println("Write name of file");
//            String filename = sc.nextLine();
            File fileToread = new File(filename);
            Scanner myReader = new Scanner(fileToread);
            while (myReader.hasNext()){
                String network = myReader.nextLine();
                System.out.println(network);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
//        String[] arrayStr =
        return new ArrayList<ArrayList<Double>>();
    }

}
