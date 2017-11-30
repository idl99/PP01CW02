package lk.UoGNiP.GUI;

import lk.UoGNiP.Entity.Student;


import java.util.List;

import javax.swing.*;
import java.awt.*;


public class TestGUI extends JFrame {


    public TestGUI(List<Student> paramList){

        super("My lk.UoGNiP.GUI.Stars GUI");
        setSize(500,350);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        add(mainPanel);

        JLabel histogramTitle = new JLabel("HORIZONTAL HISTOGRAM REPORT");
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout());
        titlePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titlePanel.add(histogramTitle);

        mainPanel.add(BorderLayout.PAGE_START, titlePanel);

        JPanel headersPanel = new JPanel();
        headersPanel.setLayout(new GridLayout(4,1));
        mainPanel.add(BorderLayout.LINE_START,headersPanel);

        JLabel marksHeader1 = new JLabel("0-29");
        JLabel marksHeader2 = new JLabel("30-39");
        JLabel marksHeader3 = new JLabel("49-69");
        JLabel marksHeader4 = new JLabel("70-100");

        headersPanel.add(marksHeader1);
        headersPanel.add(marksHeader2);
        headersPanel.add(marksHeader3);
        headersPanel.add(marksHeader4);

        JPanel StarsPanel = new JPanel();
        StarsPanel.setLayout(new GridLayout(4,1));

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
        StarsPanel.add(new Stars(category1));
        StarsPanel.add(new Stars(category2));
        StarsPanel.add(new Stars(category3));
        StarsPanel.add(new Stars(category4));

        JLabel numOfStudents = new JLabel("Total number of students: "+Integer.toString(paramList.size()));
        mainPanel.add(BorderLayout.PAGE_END,numOfStudents);

        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
}