import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import javax.imageio.ImageIO;
public class ImageToByteArray {
        public static void main(String args[]) throws Exception{
            BufferedImage img = ImageIO.read(new File("PNG/imgGray.png"));
            ArrayList<Integer> listOfImgValues = new ArrayList<Integer>();
            ArrayList<Integer> listOfNormalized = new ArrayList<Integer>();
//            ImageIO.write(img, "png", bos );

            for(int x=0; x<img.getWidth();x++){
                for(int y=0; y< img.getHeight();y++){

                    listOfImgValues.add(Math.abs(img.getRGB(x,y)));
//
                }
            }
//            System.out.println(listOfImgValues.toString());
            System.out.println(Collections.min(listOfImgValues));
            System.out.println(Collections.max(listOfImgValues));

            for( int val : listOfImgValues){
//                    normalize 0-255
//                normalized_x = (255 * (x - minimum))/(maximum - minimum)
                    int normalized = (255 * (val - Collections.min(listOfImgValues))/(Collections.max(listOfImgValues)- Collections.min(listOfImgValues)));
                    listOfNormalized.add(Math.abs(normalized));
//                    int normalized = (gray-0)/(16777216-0);
                }

            System.out.println(listOfNormalized.toString());
            System.out.println(Collections.max(listOfNormalized));

        }
}
