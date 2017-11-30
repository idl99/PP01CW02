package lk.UoGNiP.GUI;

import javax.swing.*;
import java.awt.*;

public class Stars extends JPanel {

    int numOfStars = 0;

    @Override
    public void paint(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        for(int i=0; i<numOfStars; i++){
            g2d.setFont(new Font("TimesRoman", Font.BOLD, 20));
            g2d.drawString("*",20+(i*10),45);
            //g2d.fillOval(20+(i*10), 30, 5, 5);
        }
    }

    public Stars(int paramNumOfStars){
        this.numOfStars = paramNumOfStars;
    }

}