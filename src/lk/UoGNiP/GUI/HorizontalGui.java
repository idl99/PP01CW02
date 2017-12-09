package lk.UoGNiP.GUI;

import lk.UoGNiP.Entity.Student;


import java.util.List;

import javax.swing.*;
import java.awt.*;

// HorizontalGui class which creates an HorizontalGui object
// Defines the layout for which the Horizontal Histogram is to be displayed
public class HorizontalGui extends JFrame {

    public HorizontalGui(List<Student> paramList){

        super("My Horizontal Histogram GUI");
        setSize(500,350);

        // The Parent Panel for the Frame
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        add(mainPanel);

        // The Title panel on which the header of the histogram is to be displayed
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout());
        titlePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(BorderLayout.PAGE_START, titlePanel);
        JLabel histogramTitle = new JLabel("HORIZONTAL HISTOGRAM REPORT");
        titlePanel.add(histogramTitle);

        // The Headers panel on which the category labels are to be displayed
        JPanel headersPanel = new JPanel();
        headersPanel.setLayout(new GridLayout(4,1));
        mainPanel.add(BorderLayout.LINE_START,headersPanel);

        // Creating labels to indicate the marks' categories
        JLabel categoryLbl1 = new JLabel("0-29");
        JLabel categoryLbl2 = new JLabel("30-39");
        JLabel categoryLbl3 = new JLabel("40-69");
        JLabel categoryLbl4 = new JLabel("70-100");

        // Adding category label to the header panel
        headersPanel.add(categoryLbl1);
        headersPanel.add(categoryLbl2);
        headersPanel.add(categoryLbl3);
        headersPanel.add(categoryLbl4);

        // Defining a panel on which stars are to be printed
        JPanel StarsPanel = new JPanel();
        StarsPanel.setLayout(new GridLayout(4,1));

        int category1 = 0;
        int category2 = 0;
        int category3 = 0;
        int category4 = 0;

        // Getting number of stars to be printed under each category
        for(Student std: paramList){
            if(std.getOverallMarks()<30)category1++;
            else if(std.getOverallMarks()<40)category2++;
            else if(std.getOverallMarks()<70) category3++;
            else category4++;
        }

        // Creating Horizontal Stars objects for each category
        // Each Horizontal Star object will invoke its paint method, which will
        // paint the number of stars, passed as a argument to the constructor
        StarsPanel.add(new HorizontalStars(category1));
        StarsPanel.add(new HorizontalStars(category2));
        StarsPanel.add(new HorizontalStars(category3));
        StarsPanel.add(new HorizontalStars(category4));

        // Adding Stars Panel to the Main Panel
        mainPanel.add(BorderLayout.CENTER,StarsPanel);

        // Adding a label displaying the total number of students
        JLabel numOfStudents = new JLabel("Total number of students: "+Integer.toString(paramList.size()));
        mainPanel.add(BorderLayout.PAGE_END,numOfStudents);

        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
}

class HorizontalStars extends JPanel {

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