package glyph;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Nate on 2/26/16.
 */
public class ImageViewer extends JFrame {
    DefaultListModel<ImagePanel> listModel;
    public ImageViewer(BufferedImage... imgs) {
        listModel = new DefaultListModel<>();
        for(int i=0; i<imgs.length; i++) {
            listModel.add(i, new ImagePanel(imgs[i]));
        }
        JList<ImagePanel> listImgs = new JList<>(listModel);
        listImgs.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        listImgs.setVisibleRowCount(2);
        listImgs.setCellRenderer(new ListCellRenderer<ImagePanel>() {
            @Override
            public Component getListCellRendererComponent(JList<? extends ImagePanel> list, ImagePanel value, int index, boolean isSelected, boolean cellHasFocus) {
                return value;
            }
        });
        add(new JScrollPane(listImgs));

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMaximumSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.setVisible(true);
        this.pack();
    }
}
