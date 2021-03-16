import java.util.Scanner;

public class Main {
    public static void main(String[]args){

        System.out.println("Enter network structure or write file to upload");
        Scanner sc = new Scanner(System.in);
        String networkStructure = sc.nextLine();
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
        System.out.println("Lista wag w całej sieci");
        System.out.println(wagi.toString());
        System.out.println("FAZA OBLICZANIA");
        System.out.println("Obliczam wartości neuronów");
//        network.oblicz();
        System.out.println("WYNIK PRZELICZENIA CALEJ SIECI NEURONOWEJ");
        System.out.println(network.calculate(wejscia, wagi).toString());
        System.out.println("Zapis wag do pliku");
//        FilesOperation.writeToFile(networkStructure+"\n"+network.generujWagi(network.filename).toString());

        }
// 2

    }

