package glyph;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Nate on 2/26/16.
 */
public class ImagePanel extends JPanel {
    BufferedImage img;
    Dimension pref;
    public ImagePanel(BufferedImage img) {
        this.img = img;
        this.pref = new Dimension(img.getWidth(), img.getHeight());
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }

    @Override
    public Dimension getPreferredSize() {
        return pref;
    }
}
