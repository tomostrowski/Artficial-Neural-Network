import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Neuron {
    private int[] location;//zrobic x i y

    public Double oblicz (ArrayList<Double>listaX, ArrayList<Double>listaWag){
        double wynik =0.0;
        for (int i=0; i<listaX.size(); i++){
               wynik += listaX.get(i) * listaWag.get(i);
        }

        wynik += listaWag.get(listaWag.size() - 1);

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


    public ArrayList<Double> generujWagi(String filename, int liczbaPoprzedniejWarstwy) {
       ArrayList<Double> listOfWeights= new ArrayList<Double>();
       for (int i =0; i<liczbaPoprzedniejWarstwy+1; i++){
            double randomValue = ThreadLocalRandom.current().nextDouble(2) - 1;
            listOfWeights.add(randomValue);
       }
       return listOfWeights;
    }
}
