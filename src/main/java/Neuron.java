import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Neuron {
    private int[] location;

    public Double calculate(ArrayList<Double>listX, ArrayList<Double> listOfWeights){
        double wynik =0.0;
        for (int i=0; i<listX.size(); i++){
               wynik += listX.get(i) * listOfWeights.get(i);
        }

        wynik += listOfWeights.get(listOfWeights.size() - 1);

        return this.FunkcjaAktywacji(wynik);
    }

    Double FunkcjaAktywacji(Double wynik){

        //implementacja funkcji aktyawcji wzór

        return 1 / (1 + Math.exp(-1 * wynik));
    }

    public Neuron() {
    }

    public Neuron(int[] location) {
        this.location = location;
    }


    public ArrayList<Double> generateWeights(String filename, int sizeOfPrevLayer) {
       ArrayList<Double> listOfWeights= new ArrayList<Double>();
       for (int i =0; i<sizeOfPrevLayer+1; i++){
            double randomValue = ThreadLocalRandom.current().nextDouble(2) - 1;
            listOfWeights.add(randomValue);
       }
       return listOfWeights;
    }
}
