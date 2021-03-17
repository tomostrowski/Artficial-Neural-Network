import java.util.ArrayList;

public class Layer {

    public ArrayList<Neuron> neuronList;
    public ArrayList<ArrayList<Double>> listOfWeights = new ArrayList<ArrayList<Double>>();

    public Layer(Integer neuronsAmount) {
        neuronList = new ArrayList<Neuron>();
        for (int i=0; i<neuronsAmount; i++){
            Neuron n = new Neuron();
            neuronList.add(n);
        }
    }

    public ArrayList<Double> calculate(ArrayList<Double> listOfPrevInputs, ArrayList<ArrayList<Double>> listOfLayerWeights){
        ArrayList<Double> listOfAllNeuronValuesOnLayer = new ArrayList<Double>();
        for (int i =0; i<neuronList.size(); i++){
          Double neuronValue = neuronList.get(i).calculate(listOfPrevInputs, listOfLayerWeights.get(i));
          listOfAllNeuronValuesOnLayer.add(neuronValue);
        }
        return listOfAllNeuronValuesOnLayer;
    }

    public ArrayList<ArrayList<Double>> genereateWeights(String filename, Integer numberOfNeuronsOnPrevLayer){
        System.out.println();
        System.out.println("----------------------------------------------------");
//        ArrayList<ArrayList<Double>> listOfWeights = new ArrayList<ArrayList<Double>>();
        for (Neuron neuron: neuronList){
             listOfWeights.add(neuron.generateWaights(filename, numberOfNeuronsOnPrevLayer));
         }
        System.out.println(listOfWeights.toString());
         return listOfWeights;
    }
}
