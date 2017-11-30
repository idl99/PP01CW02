package lk.UoGNiP.GUI;

import javax.swing.*;
import java.awt.*;

public class HorizontalStars extends JPanel {

    int numOfStars = 0;

    @Override
    public void paint(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        for(int i=0; i<numOfStars; i++){
            g2d.setFont(new Font("TimesRoman", Font.BOLD, 20));
            g2d.drawString("*",20+(i*10),45);
        }
    }

    public HorizontalStars(int paramNumOfStars){
        this.numOfStars = paramNumOfStars;
    }

}