import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Area;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {

    private static void crtContour(String title, String imgName) throws InterruptedException {
        frameImage app = new frameImage(title, imgName);
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(imgName));
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        if (img == null) {
            System.out.println("Image error");
        }
        app.setShape(contour(img));
        app.setVisible(true);
        Thread.sleep(500);
        app.dispose();
    }

    private static Shape contour(BufferedImage img) {
        final int w = img.getWidth();
        final int h = img.getHeight();
        final Area s = new Area(new Rectangle(w, h));
        for (int y = 0; y < h; ++y) {
            for (int x = 0; x < w; ++x) {
                Color color = new Color(img.getRGB(x, y));
                if (color.getRed() == 255 & color.getGreen() == 255 & color.getBlue() == 255) {
                    Rectangle r = new Rectangle(x, y, 1, 1);
                    s.subtract(new Area(r));
                }
            }
        }
        return s;
    }

    public static void main(String[] args) throws InterruptedException {

        while (true) {
            crtContour("Image1","shark1.png");
            crtContour("Image2","shark2.png");
            crtContour("Image3","shark3.png");
            crtContour("Image4","shark4.png");
            crtContour("Image5","shark5.png");
            crtContour("Image6","shark6.png");
            crtContour("Image7","shark5.png");
            crtContour("Image8","shark4.png");
            crtContour("Image9","shark3.png");
            crtContour("Image10","shark2.png");
        }
    }
}
