import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@Data
public class Network {
    private int numberOfInputs = 0;
    private ArrayList<Layer> layers= new ArrayList<Layer>();
    private ArrayList<Double> inputDataList = new ArrayList<Double>();
    private int totalNumberOfNeurons = 0;
    private String filename;
    private ArrayList<Integer> networkStructureArrayList = new ArrayList<>();


    public Network(String networkStructure) {
        String[] networkStructureArray = networkStructure.split(" ");

            this.numberOfInputs = Integer.parseInt(networkStructureArray[0]); // the fist element of array is a total number of inputs
            for (int i = 0; i < networkStructureArray.length; ++i) {   //notice that we start from 1 as first element is input layer not neurons
                int neuronsNumber = Integer.parseInt(networkStructureArray[i]); //
                networkStructureArrayList.add(neuronsNumber);
                totalNumberOfNeurons += neuronsNumber;
                if (i!=0) {
                Layer layer = new Layer(neuronsNumber);
                layers.add(layer);
                }
                filename = generateFileName();
            }
    }

    public Network(ArrayList<Integer> integersOfStructure){
        for (int i =1; i<integersOfStructure.size(); i++){
            Layer layer = new Layer(integersOfStructure.get(i));
            layers.add(layer);
        }
        numberOfInputs = integersOfStructure.get(0);
    }

    public String generateFileName() {
        DateTimeFormatter timeStampPattern = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        LocalDateTime dateTime = LocalDateTime.now();
        return "JSON/network-weights_" + dateTime.format(timeStampPattern) + ".json";
    }

    public ArrayList<ArrayList<ArrayList<Double>>> generateWeights(){
        int amountOfNeuronsOnPrevLayer = this.numberOfInputs;
        ArrayList<ArrayList<ArrayList<Double>>> listOfAllWeights = new ArrayList<ArrayList<ArrayList<Double>>>();

        for (Layer layer : layers){
            listOfAllWeights.add(layer.generateWeights(filename, amountOfNeuronsOnPrevLayer));
            amountOfNeuronsOnPrevLayer = layer.getNeuronList().size();
        }
        NetworkData networkData = new NetworkData(filename, networkStructureArrayList, listOfAllWeights);
        FilesOperation.writeJSON(networkData);
        return listOfAllWeights;
    }

    public ArrayList<Double> readInput(String inputDataString){
        String[] arrayOfStr = inputDataString.split(" ");
        for (String str : arrayOfStr){
            double inputData = Double.parseDouble(str);
            inputDataList.add(inputData);
        }
        System.out.println("Input data");
        System.out.println(inputDataList);

        return inputDataList;
    }
    public ArrayList<ArrayList<Double>> calculate(ArrayList<Double> inputDataList,
                                                  ArrayList<ArrayList<ArrayList<Double>>> weights){
        ArrayList<ArrayList<Double>> listOfAllCalculatedNeurons = new ArrayList<ArrayList<Double>>();

        for (int i =0; i<layers.size();i++){
            listOfAllCalculatedNeurons.add(
                    inputDataList = this.layers.get(i).calculate(inputDataList, weights.get(i))
            );
        }
        return listOfAllCalculatedNeurons;
    }

    public ArrayList<Double> calculateOutput(ArrayList<Double> inputDataList, 
                                             ArrayList<ArrayList<ArrayList<Double>>> weights){

        for (int i =0; i<layers.size();i++){
            inputDataList = this.layers.get(i).calculate(inputDataList, weights.get(i));
        }
        return inputDataList;
    }
}
