package lk.UoGNiP.GUI;

import lk.UoGNiP.Entity.Student;

import javax.swing.*;

import java.awt.*;
import java.util.List;

public class VerticalGui extends JFrame{

    public VerticalGui(List<Student> paramList){

        super("My Vertical Histogram GUI");
        setSize(350,500);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        add(mainPanel);

        JPanel headersPanel = new JPanel();
        headersPanel.setLayout(new GridLayout(1,4));
        JLabel marksHeader1 = new JLabel("0-29");
        JLabel marksHeader2 = new JLabel("30-39");
        JLabel marksHeader3 = new JLabel("40-69");
        JLabel marksHeader4 = new JLabel("70-100");
        headersPanel.add(marksHeader1);
        headersPanel.add(marksHeader2);
        headersPanel.add(marksHeader3);
        headersPanel.add(marksHeader4);
        mainPanel.add(BorderLayout.NORTH,headersPanel);

        JPanel StarsPanel = new JPanel();
        StarsPanel.setLayout(new GridLayout(1,4));

        int category1 = 0;
        int category2 = 0;
        int category3 = 0;
        int category4 = 0;

        for(Student std: paramList){
            if(std.getOverallMarks()<30)category1++;
            else if(std.getOverallMarks()<40)category2++;
            else if(std.getOverallMarks()<70) category3++;
            else category4++;
        }

        mainPanel.add(BorderLayout.CENTER,StarsPanel);
        StarsPanel.add(new VerticalStars(category1));
        StarsPanel.add(new VerticalStars(category2));
        StarsPanel.add(new VerticalStars(category3));
        StarsPanel.add(new VerticalStars(category4));

        JLabel numOfStudents = new JLabel("Total number of students: "+Integer.toString(paramList.size()));
        mainPanel.add(BorderLayout.PAGE_END,numOfStudents);

        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

}
