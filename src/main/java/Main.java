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
            System.out.println("Neural Network has been created.");
            System.out.println("-------------------------------");
            System.out.printf("Number of inputs %d ", network.getNumberOfInputs());
            System.out.println();
            System.out.printf("Number of layers: %d ", network.getLayers().size());
            System.out.println("");
            System.out.printf("Total neurons: %d ",network.getTotalNumberOfNeurons());

            System.out.println();
            System.out.println("-------------------------------------------------");

            System.out.println("Generating random weights for each layer");
            System.out.println();
            FilesOperation.createFile(network.getFilename());
            var weights = network.generateWeights();
            System.out.println("Weights have been generated for whole network");
            System.out.println();
            System.out.println("Enter " + network.getNumberOfInputs()+ " inputs ");
            Scanner inp = new Scanner(System.in);
            String inputString = inp.nextLine();
            System.out.println("Inputs has been added.");
            var inputs = network.readInput(inputString);
            System.out.println();
            System.out.println("Number of weights in network :"+weights.size());
            System.out.println("List of weights");
            System.out.println(weights.toString());
            System.out.println("CALCULATING");
            System.out.println("Calculating values of neurons");
            System.out.println(network.calculate(inputs, weights).toString());
            System.out.println("Saving weighs to file");
            } else {
            System.out.println("----------------------------");
            System.out.println("Importing data from file");
            System.out.println("----------------------------");
            NetworkData networkData = FilesOperation.readJSON(networkStructure);
            Network network = new Network(networkData.structure);
            System.out.println("Building network structure from file");
            System.out.println();
            System.out.println("Enter " + network.getNumberOfInputs()+ " inputs ");
            Scanner inputs = new Scanner(System.in);
            String inputString = inputs.nextLine();
            System.out.println("Input data added");
            var inputData = network.readInput(inputString);
            System.out.println("Calculating the network");
            System.out.println("Total weights: "+networkData.totalWeightList.size());
            System.out.println(network.calculate(inputData, networkData.totalWeightList).toString());
            System.out.println("DONE");
        }
        }
// 2

    }

