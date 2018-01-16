package lk.UoGNiP.GUI;

import lk.UoGNiP.Entity.Student;

import javax.swing.*;

import java.awt.*;
import java.util.List;

// VerticalHistogram class which creates an VerticalHistogram object
// Defines the layout for which the Vertical Histogram is to be displayed
public class VerticalHistogram extends JFrame{

    public VerticalHistogram(List<Student> paramList){

        super("My Vertical Histogram GUI");
        setSize(350,500);
        setResizable(false);

        // The Parent Panel for the Frame
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        add(mainPanel);

        // The Headers panel on which the category labels are to be displayed
        JPanel headersPanel = new JPanel();
        headersPanel.setLayout(new GridLayout(1,4));
        mainPanel.add(BorderLayout.NORTH,headersPanel);

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
        StarsPanel.setLayout(new GridLayout(1,4));

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

        // Creating Vertical Stars objects for each category
        // Each Vertical Star object will invoke its paint method, which will
        // paint the number of stars, passed as a argument to the constructor
        StarsPanel.add(new VerticalStars(category1));
        StarsPanel.add(new VerticalStars(category2));
        StarsPanel.add(new VerticalStars(category3));
        StarsPanel.add(new VerticalStars(category4));

        // Adding Stars Panel to the Main Panel
        mainPanel.add(BorderLayout.CENTER,StarsPanel);

        // Adding a label displaying the total number of students
        JLabel numOfStudents = new JLabel("Total number of students: "+Integer.toString(paramList.size()));
        mainPanel.add(BorderLayout.PAGE_END,numOfStudents);

        setVisible(true);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

    }

}

class VerticalStars extends JPanel{

    int numOfStars = 0;

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        int col=0;
        for(int i=0; i<numOfStars;){
            //row variable
            col=i/40;
            g2d.setFont(new Font("TimesRoman", Font.BOLD, 20));
            g2d.drawString("*",col*10,30+(i%40*10));
            i++;
        }
    }

    public VerticalStars(int paramNumOfStars){
        this.numOfStars = paramNumOfStars;
    }

}

