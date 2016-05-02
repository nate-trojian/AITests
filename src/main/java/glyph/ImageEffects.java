package glyph;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;

public class ImageEffects {
    public static BufferedImage grayscale(BufferedImage img) {
        BufferedImage ret = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
        int width = img.getWidth();
        int height = img.getHeight();

        for(int i=0; i<height; i++) {
            for(int j=0; j<width; j++) {
                Color c = new Color(img.getRGB(j, i));
                int red = (int)(c.getRed() * 0.299);
                int green = (int)(c.getGreen() * 0.587);
                int blue = (int)(c.getBlue() *0.114);
                Color newColor = new Color(red+green+blue, red+green+blue,red+green+blue);

                ret.setRGB(j,i,newColor.getRGB());
            }
        }
        return ret;
    }

    public static BufferedImage brighten(BufferedImage img, float perc) {
        BufferedImage ret;
        float scaleFactor = 1 + perc;
        RescaleOp op = new RescaleOp(scaleFactor, 0, null);
        ret = op.filter(img, null);
        return ret;
    }

    public static BufferedImage resize(BufferedImage img, int newWidth) {
        float apr = (float)img.getHeight()/(float)img.getWidth();
        int newHeight = (int)(apr*newWidth);
        BufferedImage ret = new BufferedImage(newWidth, newHeight, img.getType());
        Graphics2D g = ret.createGraphics();
        g.drawImage(img, 0, 0, newWidth, newHeight, null);
        g.dispose();
        return ret;
    }

    public static BufferedImage convertType(BufferedImage img, int newType) {
        int width = img.getWidth();
        int height = img.getHeight();
        BufferedImage ret = new BufferedImage(width, height, newType);
        Graphics2D g = ret.createGraphics();
        g.drawImage(img, 0, 0, width, height, null);
        g.dispose();
        return ret;
    }

    public static BufferedImage colorThreshold(BufferedImage img, Color grabColor, float flatThres, Color backColor) {
        int width = img.getWidth();
        int height = img.getHeight();
        int red = grabColor.getRed(), green = grabColor.getGreen(), blue = grabColor.getBlue();
        float flatThresSq = flatThres * flatThres, tempSq;
        Color tempColor;
        BufferedImage ret = new BufferedImage(width, height, img.getType());

        for(int i=0; i<width; i++) {
            for(int j=0; j<height; j++) {
                tempColor = new Color(img.getRGB(i, j));
                tempSq = (tempColor.getRed() - red)^2 + (tempColor.getGreen() - green)^2 + (tempColor.getBlue() - blue)^2;
                if(tempSq > flatThresSq) {
                    tempColor = backColor;
                } else {
                    tempColor = grabColor;
                }
                ret.setRGB(i, j, tempColor.getRGB());
            }
        }
        return ret;
    }

//    public static BufferedImage colorThreshold(BufferedImage img, Color grabColor, float perThres, Color backColor) {
//        int width = img.getWidth();
//        int height = img.getHeight();
//        BufferedImage ret = new BufferedImage(width, height, img.getType());
//
//        return ret;
//    }

//    public static BufferedImage floodFill(BufferedImage img, Color grabColor, int flatThres, Color backColor) {
//        int width = img.getWidth();
//        int height = img.getHeight();
//        BufferedImage ret = new BufferedImage(width, height, img.getType());
//
//        return ret;
//    }

//    public static BufferedImage floodFill(BufferedImage img, Color grabColor, float perThres, Color backColor) {
//        int width = img.getWidth();
//        int height = img.getHeight();
//        BufferedImage ret = new BufferedImage(width, height, img.getType());
//
//        return ret;
//    }
}
