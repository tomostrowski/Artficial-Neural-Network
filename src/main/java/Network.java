import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Network {
    public int numberOfInputs = 0;
    public ArrayList<Layer> layers= new ArrayList<Layer>();
    public ArrayList<Double> inputDataList = new ArrayList<Double>();
    public int totalNumberOfNeurons = 0;
    public String filename;
    public ArrayList<Integer> networkStructureArrayList = new ArrayList<>();


    public Network(String networkStructure) {
        String[] networkStructureArray = networkStructure.split(" ");
        if (!networkStructure.contains("network-weights_") && !networkStructure.contains(".txt")) {
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
        } else {
//            FilesOperation.readFile(networkStructure);
        }
    }

    public String generateFileName() {
        DateTimeFormatter timeStampPattern = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        LocalDateTime dateTime = LocalDateTime.now();
        return "JSON/network-weights_" + dateTime.format(timeStampPattern) + ".json";
    }

    public ArrayList<ArrayList<ArrayList<Double>>>  generujWagi(){ //zwrócic a nie void didac returna
        int amountOfNeuronsOnPrevLayer = this.numberOfInputs;
        ArrayList<ArrayList<ArrayList<Double>>> listOfAllWeights = new ArrayList<ArrayList<ArrayList<Double>>>();

        for (Layer layer : layers){
//            layer.generujWagi(amountOfNeuronsOnPrevLayer);
            listOfAllWeights.add(layer.generujWagi(filename, amountOfNeuronsOnPrevLayer));
            amountOfNeuronsOnPrevLayer = layer.neuronList.size();
        }
        FilesOperation.writeToFile(filename, networkStructureArrayList,  listOfAllWeights);
        return listOfAllWeights;
    }

    public ArrayList<Double> wczytajDaneWejsciowe(String daneWejsciowe){
        String[] arrayOfStr = daneWejsciowe.split(" ");
        for (String str : arrayOfStr){
            double inputData = Double.parseDouble(str);
            inputDataList.add(inputData);
        }
        System.out.println("Dane wejściowe");
        System.out.println(inputDataList);

        return inputDataList;
    }
    public ArrayList<ArrayList<Double>> calculate(ArrayList<Double> inputDataList, ArrayList<ArrayList<ArrayList<Double> > > wagi){
        ArrayList<ArrayList<Double>> listOfAllCalculatedNeurons = new ArrayList<ArrayList<Double>>();

        for (int i =0; i<layers.size();i++){
            listOfAllCalculatedNeurons.add(
                    inputDataList = this.layers.get(i).oblicz(inputDataList, wagi.get(i))
            );
        }
        return listOfAllCalculatedNeurons;
    }

    public ArrayList<Double> obliczWyjscieZsieci(ArrayList<Double> inputDataList, ArrayList<ArrayList<ArrayList<Double> > > wagi){

        for (int i =0; i<layers.size();i++){
            inputDataList = this.layers.get(i).oblicz(inputDataList, wagi.get(i));
        }
        return inputDataList;
    }
}
