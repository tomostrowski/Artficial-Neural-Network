import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import javax.imageio.ImageIO;

public class ImageManager {

    public static String convertPNGtoGrayscale(String path) throws IOException {
            File input = new File("PNG/" + path);
            BufferedImage img = ImageIO.read(input);
            int width = img.getWidth();
            int height = img.getHeight();
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    int rgb = img.getRGB(x, y);
                    int r = (rgb >> 16) & 0xFF;
                    int g = (rgb >> 8) & 0xFF;
                    int b = (rgb & 0xFF);

                    // Normalize and gamma correct:
                    double rr = Math.pow(r / 255.0, 2.2);
                    double gg = Math.pow(g / 255.0, 2.2);
                    double bb = Math.pow(b / 255.0, 2.2);

                    // Calculate luminance:
                    double lum = 0.2126 * rr + 0.7152 * gg + 0.0722 * bb;

                    // Gamma compand and rescale to byte range:
                    int grayLevel = (int) (255.0 * Math.pow(lum, 1.0 / 2.2));
                    int gray = (grayLevel << 16) + (grayLevel << 8) + grayLevel;

                    img.setRGB(x, y, Math.abs(gray));
                }
            }
            File output = new File("PNG/gray" + path);
            System.out.println("Done");
            ImageIO.write(img, "png", output);

            return output.getAbsolutePath();
        }

        public static ArrayList<Integer> convertGrayscaleToArrayList (String path) throws IOException {
            BufferedImage img = ImageIO.read(new File(path));
            ArrayList<Integer> listOfImgValues = new ArrayList<Integer>();
            for (int x = 0; x < img.getWidth(); x++) {
                for (int y = 0; y < img.getHeight(); y++) {
                    listOfImgValues.add(Math.abs(img.getRGB(x, y)));
                }
            }
            return listOfImgValues;
        }

        public static ArrayList<Double> normalize (ArrayList < Integer > listOfImgValues) {
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