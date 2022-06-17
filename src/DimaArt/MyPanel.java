package DimaArt;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.Random;

public class MyPanel extends JPanel {

    final static Color bg = Color.blue;
    final static Color fg = Color.black;

    Random rand = new Random();

    public MyPanel(int width, int height) {
        setSize(width, height);
    }

    private Color getRandomColor() {
        return new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
    }

    private GradientPaint getRandomGradient(int x1, int y1, int x2, int y2){
        return new GradientPaint(x1,y1,getRandomColor(),x2, y2,getRandomColor());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int Elipse = rand.nextInt(200);
        int Elipse1 = rand.nextInt(200)+200;
        int x1 = rand.nextInt(790-Elipse);
        int y1 = rand.nextInt(790-Elipse);
        int x = 100;
        int y = 100;
        int x2 = 300;
        int y2 = 200;

        String Horizen = "Horizon";
        String Ma = "Modern Art";

        BasicStroke boldStroke = new BasicStroke(4.0f);
        g2.setStroke(boldStroke);
        int dotOriginX = rand.nextInt(750);
        int dotOriginY = rand.nextInt(750);
        g2.setPaint(fg);

        for(int j = 0; j < 30; j++) {
            for (int i = 0; i < 20; i++) {
                g2.drawLine(dotOriginX, dotOriginY, dotOriginX, dotOriginY);
                dotOriginX += 10;
            }
            dotOriginY += 10;
            dotOriginX -= 200;
        }


        BasicStroke stroke = new BasicStroke(2.0f);
        g2.setStroke(stroke);
        for(int i = 0; i <=50; i++) {
            int rectWidth = rand.nextInt(100);
            int rectHeight = rand.nextInt(200);
            int rectx = rand.nextInt(790 - rectWidth);
            int recty = rand.nextInt(790 - rectHeight);

            int randomCounter1 = rand.nextInt(2);
            int randomCounter2 = rand.nextInt(3);
            int randomCounter3 = rand.nextInt(3);
            int angle1 = rand.nextInt(361);
            int angle2 = rand.nextInt(361);
            g2.setPaint(getRandomColor());
            if(randomCounter1 == 0) {
                if(randomCounter2 == 1) {
                    AffineTransform s1 = new AffineTransform();
                    s1.setToRotation(Math.toRadians(angle1), 80, 100);
                    g2.setTransform(s1);
                    g2.fill(new Rectangle2D.Double(rectx, recty, rectWidth, rectHeight));
                }
                else{
                    g2.fill(new Rectangle2D.Double(rectx, recty, rectWidth, rectHeight));
                }
            }
            else{
                if(randomCounter3 == 1) {
                    AffineTransform s2 = new AffineTransform();
                    s2.setToRotation(Math.toRadians(angle2), 80, 100);
                    g2.setTransform(s2);
                    g2.draw(new Rectangle2D.Double(rectx, recty, rectWidth, rectHeight));

                }
                else{
                    g2.draw(new Rectangle2D.Double(rectx, recty, rectWidth, rectHeight));
                }
            }
        }

        AffineTransform affineTransform = new AffineTransform();
        affineTransform.setToRotation(Math.toRadians(0), 80, 100);
        g2.setTransform(affineTransform);

        g2.setPaint(fg);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 100));
        g2.drawString(Ma, x, y);

        for(int i = 0; i <=1; i++){
            int a = rand.nextInt(2);
            int linex = rand.nextInt(750)+20;
            int liney1 = rand.nextInt(750)+20;
            int liney2 = rand.nextInt(750)+20;
            if(a == 0) {
                g2.drawLine(linex, liney1, linex, liney2);
            }
            else{
                AffineTransform a1 = new AffineTransform();
                a1.setToRotation(Math.toRadians(90), 80, 100);
                g2.setTransform(a1);
                g2.drawLine(linex, liney1, linex, liney2);
            }
        }

        AffineTransform affineTransform1 = new AffineTransform();
        affineTransform1.setToRotation(Math.toRadians(0), 80, 100);
        g2.setTransform(affineTransform1);

        x += 100;
        y += 100;

        GradientPaint RandomGradiant = getRandomGradient(x,y,x+Elipse, y);
        g2.setPaint(RandomGradiant);
        g2.fill (new Ellipse2D.Double(x2, y2, Elipse, Elipse));
        for(int i = 1; i <= 2; i++) {
            int size = rand.nextInt(200);
            int x4 = rand.nextInt(790 - size);
            int y4 = rand.nextInt(790 - size);
            GradientPaint RG = getRandomGradient(x,y,x+Elipse, y);
            g2.setPaint(RG);
            g2.fill(new Ellipse2D.Double(x4, y4, size, size));
        }
        BasicStroke veryBoldStroke = new BasicStroke(10.0f);
        g2.setStroke(veryBoldStroke);
        g2.setColor(bg);
        g2.draw (new Ellipse2D.Double(x1, y1, Elipse1, Elipse1));
        g2.setPaint(fg);

        // Rotate 90 degree to make a vertical text
        AffineTransform at = new AffineTransform();
        at.setToRotation(Math.toRadians(90), 80, 100);
        g2.setTransform(at);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 100));
        g2.drawString(Horizen, 100, 10);

    }

}