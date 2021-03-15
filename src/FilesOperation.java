import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class FilesOperation {

    public static void writeToFile(String totalNetworkWeights) {
        try {
            DateTimeFormatter timeStampPattern = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
            LocalDateTime dateTime = LocalDateTime.now();
            FileWriter myWriter = new FileWriter("network-weights_"+dateTime.format(timeStampPattern)+".txt");
            String[] weighsArray = totalNetworkWeights.split("\\[\\d.*\\]");
            for(int i=0; i<weighsArray.length; i++){
                myWriter.write(weighsArray[i]+"\n");
                System.out.println("~~");
                System.out.println(weighsArray[i]);
            }

            myWriter.close();



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
