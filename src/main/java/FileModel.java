import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class FileModel {
    private String filename;
    private ArrayList<Integer> structure;
    private ArrayList<ArrayList<ArrayList<Double>>> totalWeightList;
}
