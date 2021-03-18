import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;

//public class RGBtoGrayscale {
//    public static void main(String[] args) throws IOException {
//        File input = new File("JPG/girl.jpg");
//        BufferedImage colorImage = ImageIO.read(input);
//        ImageFilter filter = new GrayFilter(true, 50);
//        ImageProducer producer = new FilteredImageSource(colorImage.getSource(), filter);
//        Image image = Toolkit.getDefaultToolkit().createImage(producer);
//        image.get
//}
