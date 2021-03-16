
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FilesOperation {

    public static void createFile(String filename) {
        try {
            FileWriter filewriter = new FileWriter(filename);
        } catch (IOException e) {
            System.out.println("An error occured.");
            e.printStackTrace();
        }
    }

    public static void writeToFile(String filename, ArrayList<Integer> networkStructure, ArrayList<ArrayList<ArrayList<Double>>> weightList) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValueAsBytes(weightList);
//            JSONObject jsonObject = new JSONObject();
//            JSONArray weights = new JSONArray();
//            JSONArray structure = new JSONArray();
//            structure.addAll(networkStructure);
//            weights.addAll(weightList);
//            jsonObject.put("structure", structure);
//            jsonObject.put("weights", weights);
//
            Files.write(Paths.get(filename), objectMapper.writeValueAsBytes(weightList));


        } catch (IOException e) {
            System.out.println("An error occured.");
            e.printStackTrace();
        }
    }

    public static void readFile(String filename) {
        try {
//            JSONParser jsonParser = new JSONParser();
//            JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(filename));
//            JSONArray jsonArray = (JSONArray) jsonObject.get("weights");
//            JSONArray jsonArray0 = (JSONArray) jsonArray.get(0);
//            JSONArray jsonArray1 = (JSONArray) jsonArray.get(1);
//            JSONArray jsonArray2 = (JSONArray) jsonArray.get(2);
//            System.out.println(jsonArray0);
//            System.out.println(jsonArray1);
//            System.out.println(jsonArray2);

            ObjectMapper mapper = new ObjectMapper();
            ArrayList<ArrayList<ArrayList<Double>>> arrayList = mapper.readValue(new File(filename), new TypeReference<ArrayList<ArrayList<ArrayList<Double>>>>() {
            });
            System.out.println(arrayList.get(0).size());

        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
