import javax.swing.*;
import java.awt.*;

class frameImage extends JFrame  {

    frameImage(String title, String imgName) {
        super(title);
        ImageIcon Img = new ImageIcon((imgName));
        final int w = Img.getIconWidth();
        final int h = Img.getIconHeight();
        this.setBounds(200,200, w, h);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setUndecorated(true);
        Image image = new Image(this);
        image.setLayout(new BorderLayout());
        JLabel label = new JLabel(Img);
        label.setOpaque(false);
        image.add(label);
        this.setBackground(new Color(255,255,255,255));
        this.add(image);
        this.pack();
    }
}
