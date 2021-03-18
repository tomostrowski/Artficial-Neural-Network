import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImageGrayscaleConverter {
    public static void main(String[] args) {
        try {
            File input = new File("PNG/image.png");
            BufferedImage img = ImageIO.read(input);
            int width = img.getWidth();
            int height = img.getHeight();
            for(int x=0; x<width; x++) {
                for(int y=0; y<height; y++) {
//                    Color c = new Color(image.getRGB(j, i));
//                    int red = (int)(c.getRed() * 0.299);
//                    int green = (int)(c.getGreen() * 0.587);
//                    int blue = (int)(c.getBlue() *0.114);
//                    Color newColor = new Color(red+green+blue,
//                            red+green+blue,red+green+blue);
//                    image.setRGB(j,i,newColor.getRGB());

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



//                    img.setRGB(x, y, gray);
                    img.setRGB(x, y, Math.abs(gray));
                    System.out.println("SET"+"x: "+x+" y: "+y+" value: "+Math.abs(gray));


                }
            }
            File output = new File("PNG/imageGray.png");
            System.out.println("Done");
            ImageIO.write(img, "png", output);

            System.out.println("Reading gray image");
            BufferedImage imgGray = ImageIO.read(output);
            for(int x=0; x<imgGray.getWidth();x++){
                for(int y=0; y<imgGray.getHeight();y++){

//                    System.out.println("RGB   >>>"+"x: "+x+" y: "+y+" value: "+img.getRGB(x,y));
//                    System.out.println("GrayScale   >>>"+"x: "+x+" y: "+y+" value: "+imgGray.getRGB(x,y));
//                    System.out.println();
                }
            }
        } catch (Exception e) {}
    }
    }


