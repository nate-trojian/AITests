package glyph;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Nate on 2/25/16.
 */
public class Main {
    public static void main(String[] args) {
        CannyEdgeDetector cannyEdgeDetector = new CannyEdgeDetector();
        cannyEdgeDetector.setContrastNormalized(false);
        cannyEdgeDetector.setLowThreshold(2f);
        cannyEdgeDetector.setHighThreshold(6f);
        cannyEdgeDetector.setGaussianKernelRadius(3f);
        cannyEdgeDetector.setGaussianKernelWidth(6);
        BufferedImage startImg, grayImg, endImg, endImg2;
        try {
            //startImg = ImageEffects.brighten(ImageEffects.resize(ImageIO.read(new File("src/main/resources/Glyph1.png")), 800), 1.5f);
            startImg = ImageEffects.resize(ImageIO.read(new File("src/main/resources/Glyph2.jpg")), 800);
//            startImg = ImageEffects.resize(ImageIO.read(new File("src/main/resources/Glyph3.png")), 800);
//            startImg = ImageEffects.convertType(startImg, BufferedImage.TYPE_INT_ARGB);
//            startImg = ImageEffects.colorThreshold(startImg, new Color(92, 71, 75), 0f, Color.WHITE);
            cannyEdgeDetector.setSourceImage(startImg);
            cannyEdgeDetector.process();
            endImg = cannyEdgeDetector.getEdgesImage();

            grayImg = ImageEffects.grayscale(startImg);
            cannyEdgeDetector.setSourceImage(grayImg);
            cannyEdgeDetector.process();
            endImg2 = cannyEdgeDetector.getEdgesImage();
            System.out.println("Displaying...");
            ImageViewer imageViewer = new ImageViewer(startImg, endImg, grayImg, endImg2);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
