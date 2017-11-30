package lk.UoGNiP.GUI;

import javax.swing.*;
import java.awt.*;

public class VerticalStars extends JPanel{

    int numOfStars = 0;

    @Override
    public void paint(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        for(int i=0; i<numOfStars; i++){
            g2d.setFont(new Font("TimesRoman", Font.BOLD, 20));
            g2d.drawString("*",10,30+(i*20));
        }
    }

    public VerticalStars(int paramNumOfStars){
        this.numOfStars = paramNumOfStars;
    }

}
