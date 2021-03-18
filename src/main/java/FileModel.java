import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileModel {
    private String filePath;
    private ArrayList<Integer> structure;
    private ArrayList<ArrayList<ArrayList<Double>>> totalWeightList;
}
