package graphics;

import javax.swing.*;
import java.io.*;
// import java.awt.Dimension;
// import java.awt.Graphics;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {
    private static final long serialVersionUID = 399074610321541873L;
    private Image img;

    public ImagePanel(String img) {
        this(new ImageIcon(img).getImage());
    }

    public ImagePanel(Image img) {
        this.img = img;
        Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 400);
        setPreferredSize(size);
        /*
         * setMinimumSize(size); setMaximumSize(size); setSize(size);
         */
        setLayout(null);
        add(topPanel, BorderLayout.NORTH);


    }

    public void paintComponent(Graphics g) {
        g.drawImage(img, 50, 0, null);
    }
}
