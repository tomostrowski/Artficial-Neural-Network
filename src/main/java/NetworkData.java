import java.util.ArrayList;

public class NetworkData {
    public String filename;
    public ArrayList<Integer> structure;
    public ArrayList<ArrayList<ArrayList<Double>>> totalWeightList;

    public NetworkData(String filename, ArrayList<Integer> structure, ArrayList<ArrayList<ArrayList<Double>>> totalWeightList) {
        this.filename = filename;
        this.structure = structure;
        this.totalWeightList = totalWeightList;
    }

    public NetworkData() {
    }
}
