import java.awt.image.BufferedImage;
import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import javax.imageio.ImageIO;
public class ImageToByteArray {
        public static void main(String args[]) throws Exception{
            BufferedImage img = ImageIO.read(new File("PNG/imageGray.png"));
            ArrayList<Integer> listOfImgValues = new ArrayList<Integer>();
            for(int x=0; x<img.getWidth();x++){
                for(int y=0; y< img.getHeight();y++){
                    listOfImgValues.add(Math.abs(img.getRGB(x,y)));
                }
            }
            System.out.println(listOfImgValues);
            System.out.println(normalize(listOfImgValues));
        }
    public static ArrayList<Double> normalize (ArrayList<Integer> listOfImgValues) {
        ArrayList<Double> listOfDoubles = new ArrayList<Double>();
        ArrayList<Double> listOfNormalized = new ArrayList<Double>();
        for (Integer value : listOfImgValues)
            listOfDoubles.add((double) value);
        Double min = Collections.min(listOfDoubles);
        Double max = Collections.max(listOfDoubles);
        for (Double d : listOfDoubles) {
            Double normalized = (1 * (d - min) / (max - min));
            listOfNormalized.add(normalized);
        }
        return listOfNormalized;
    }
}
