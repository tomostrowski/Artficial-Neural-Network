import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[]args) throws IOException {
        System.out.println("Enter network structure or write file to upload");
        Scanner sc = new Scanner(System.in);
        String networkStructure = sc.nextLine();
        if (!networkStructure.contains("network-weights_") && !networkStructure.contains(".json")) {
            Network network = new Network(networkStructure);
            System.out.println("-------------------------------");
            System.out.println("UTWORZONO NOWĄ SIEC NEURONOWA");
            System.out.println("-------------------------------");
            System.out.printf("Liczba wejść %d ", network.numberOfInputs);
            System.out.println();
            System.out.printf("Liczba warstw: %d ", network.layers.size());
            System.out.println("");
            System.out.printf("Liczba wszystkich neuronów: %d ",network.totalNumberOfNeurons);

            System.out.println();
            System.out.println("-------------------------------------------------");

            System.out.println("Generuje losowe wagi dla każdej warstwy neuronów");
            System.out.println();
            FilesOperation.createFile(network.filename);
            var wagi = network.generujWagi(); //zapisac do pliku
            System.out.println("WYGENEROWANO WSZYSTKIE WAGI W SIECI");
            System.out.println();
            System.out.println("Podaj " + network.numberOfInputs+ " dane wyjściowe ");
            Scanner inputs = new Scanner(System.in);
            String inputString = inputs.nextLine();
            System.out.println("Przyjęto dane wejściowe");
            var wejscia = network.wczytajDaneWejsciowe(inputString);
            System.out.println();
            System.out.println("Liczba wag w całej sieci to :"+wagi.size());
            System.out.println("Lista wag w całej sieci");
            System.out.println(wagi.toString());
            System.out.println("FAZA OBLICZANIA");
            System.out.println("Obliczam wartości neuronów");
//        network.oblicz();
            System.out.println("WYNIK PRZELICZENIA CALEJ SIECI NEURONOWEJ");
            System.out.println(network.calculate(wejscia, wagi).toString());
            System.out.println("Zapis wag do pliku");
        } else {
            System.out.println("----------------------------");
            System.out.println("Wczytuje dane z pliku");
            System.out.println("----------------------------");
            NetworkData networkData = FilesOperation.readFile(networkStructure);
            Network network = new Network(networkData.structure);
            System.out.println("Odtwarzam strukturę sieci neuronowej z pliku");
            System.out.println();
            System.out.println("Podaj " + network.numberOfInputs+ " dane wyjściowe ");
            Scanner inputs = new Scanner(System.in);
            String inputString = inputs.nextLine();
            System.out.println("Przyjęto dane wejściowe");
            var wejscia = network.wczytajDaneWejsciowe(inputString);
            System.out.println("Przeliczam sieć");
            System.out.println("WYNIK PRZELICZENIA CALEJ SIECI NEURONOWEJ Z PLIKU");
            System.out.println("Liczba wszystkich wag: "+networkData.totalWeightList.size());
            System.out.println(network.calculate(wejscia, networkData.totalWeightList).toString());
            System.out.println("KONIEC");
        }


//        FilesOperation.writeToFile(networkStructure+"\n"+network.generujWagi(network.filename).toString());

        }
// 2

    }

