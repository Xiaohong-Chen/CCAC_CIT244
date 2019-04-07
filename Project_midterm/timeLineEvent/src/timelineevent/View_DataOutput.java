package timelineevent;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.MatteBorder;

public class View_DataOutput {

    public boolean submitControl = false;
    public boolean choiseControl = false;
    public boolean backControl =true;

    public void displayAll(Controller c, Model m) throws Exception {

        TimelineEvent[] teArray = c.getTimelineEventArray(m);

        JFrame outputJFrame = getJFrame("TIMELINE DISPLAY");

        JPanel textJPanel = gettextJPanel();

        JPanel timelineJPanel = getTimelineJPanel();
        
        JPanel displayJPanel = getDisplayDetailJPanel();

        JScrollPane scroll = getJScrollPane();

        JPanel scrollJPanel = getScrollJPanel();

        JPanel searchJPanel = getSearchJPanel();
        

        JTextField searchJText = getSearchText();
        JButton searchJButton = getSearchButton("Enter Title");
        JButton backJButton = getSearchButton("Back");

        for (int x = 0; x < teArray.length; x++) {
            
            JPanel componentJPanel=getcomponentJPanel();
            componentJPanel.add(getTimelJLabel(String.valueOf(teArray[x].year)));
            componentJPanel.add(getTimelineDisplayJextArea(teArray[x].title, teArray[x].description));
            
            timelineJPanel.add(componentJPanel);
        }

        scroll.setViewportView(timelineJPanel);
        scrollJPanel.add(scroll);

        searchJPanel.add(searchJText);
        searchJPanel.add(searchJButton);
        searchJPanel.add(backJButton);

        displayJPanel.add(textJPanel);
        displayJPanel.add(searchJPanel);
        
        outputJFrame.add(displayJPanel);
        outputJFrame.add(scrollJPanel);
        outputJFrame.setVisible(true);

        ActionListener submitListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int m = 0; m < teArray.length; m++) {
                    if (searchJText.getText().equals(teArray[m].title)) {

                        if ("ComputerSystem".equals(teArray[m].type)) {
                            textJPanel.removeAll();
                            ComputerSystem cs = (ComputerSystem) teArray[m];
                            textJPanel.add(getComponentLabel("TPYE:"));
                            textJPanel.add(getTextArea(cs.type));
                            textJPanel.add(getComponentLabel("TITLE:"));
                            textJPanel.add(getTextArea(cs.title));
                            textJPanel.add(getComponentLabel("YEAR:"));
                            textJPanel.add(getTextArea(String.valueOf(cs.year)));
                            textJPanel.add(getComponentLabel("MODEL NUMBER:"));
                            textJPanel.add(getTextArea(String.valueOf(cs.modelNumber)));
                            textJPanel.add(getComponentLabel("RELEASE YEAR:"));
                            textJPanel.add(getTextArea(String.valueOf(cs.releaseYear)));
                            textJPanel.add(getComponentLabel("RETAIL PRICE IN 2018:"));
                            textJPanel.add(getTextArea(String.valueOf(cs.retailPriceIn2018)));
                            textJPanel.add(getComponentLabel("MAUFACTUREER:"));
                            textJPanel.add(getTextArea(cs.manufacturer));
                            textJPanel.add(getComponentLabel("REASON OF CHOOSING:"));
                            textJPanel.add(getTextArea(cs.reasonOfChoosing));
                            textJPanel.add(getComponentLabel("DESCRIPTION:"));
                            JTextArea ds = getTextArea(cs.description);
                            ds.setPreferredSize(new Dimension(300, 110));
                            textJPanel.add(ds);
                            outputJFrame.setVisible(true);

                        } else if ("ComputerHardware".equals(teArray[m].type)) {
                            ComputerHardware ch = (ComputerHardware) teArray[m];

                            textJPanel.removeAll();
                            textJPanel.add(getComponentLabel("TPYE:"));
                            textJPanel.add(getTextArea(ch.type));
                            textJPanel.add(getComponentLabel("TITLE:"));
                            textJPanel.add(getTextArea(ch.title));
                            textJPanel.add(getComponentLabel("YEAR:"));
                            textJPanel.add(getTextArea(String.valueOf(ch.year)));
                            textJPanel.add(getComponentLabel("MODEL NUMBER:"));
                            textJPanel.add(getTextArea(String.valueOf(ch.modelNumber)));
                            textJPanel.add(getComponentLabel("RELEASE YEAR:"));
                            textJPanel.add(getTextArea(String.valueOf(ch.releaseYear)));
                            textJPanel.add(getComponentLabel("RETAIL PRICE IN 2018:"));
                            textJPanel.add(getTextArea(String.valueOf(ch.retailPriceIn2018)));
                            textJPanel.add(getComponentLabel("MAUFACTUREER:"));
                            textJPanel.add(getTextArea(ch.manufacturer));
                            textJPanel.add(getComponentLabel("MOST IMPORTANT SPECIFICATIONS:"));
                            textJPanel.add(getTextArea(ch.mostImportantSpecifications));
                            textJPanel.add(getComponentLabel("DESCRIPTION:"));
                            JTextArea ds = getTextArea(ch.description);
                            ds.setPreferredSize(new Dimension(300, 110));
                            textJPanel.add(ds);
                            outputJFrame.setVisible(true);

                        } else if ("HumanInterest".equals(teArray[m].type)) {

                            HumanInterest hi = (HumanInterest) teArray[m];
                            textJPanel.removeAll();
                            textJPanel.add(getComponentLabel("TPYE:"));
                            textJPanel.add(getTextArea(hi.type));
                            textJPanel.add(getComponentLabel("TITLE:"));
                            textJPanel.add(getTextArea(hi.title));
                            textJPanel.add(getComponentLabel("YEAR:"));
                            textJPanel.add(getTextArea(String.valueOf(hi.year)));
                            textJPanel.add(getComponentLabel("MODEL NUMBER:"));

                            textJPanel.add(getComponentLabel("DESCRIPTION:"));
                            JTextArea ds = getTextArea(hi.description);
                            ds.setPreferredSize(new Dimension(300, 110));
                            textJPanel.add(ds);
                            outputJFrame.setVisible(true);

                        }

                    }
                }
            }

        };
        
        ActionListener backListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                outputJFrame.setVisible(false);
                backControl=false;
                
            }
        };

        
        backJButton.addActionListener(backListener);
        searchJButton.addActionListener(submitListener);
    }

    public JFrame getJFrame(String name) {

        JFrame frame = new JFrame(name);
        frame = new JFrame("TimeLine");
        frame.setSize(1000, 800);
        frame.getContentPane().setBackground(new Color(230, 230, 230));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 50));

        return frame;
    }

    public JTextArea getTextArea(String s) {

        JTextArea ta = new JTextArea();
        ta.setPreferredSize(new Dimension(300, 20));
        ta.setOpaque(true);
        ta.setBackground(new Color(250, 140, 130));
        ta.setFont(new Font("Dialog", 1, 14));
        ta.setForeground(new Color(230, 230, 230));
        ta.setLineWrap(true);
        ta.setText(s);

        MatteBorder border = new MatteBorder(1, 0, 1, 0, new Color(230, 230, 230));

        ta.setBorder(border);
        return ta;

    }

    public JPanel getDisplayDetailJPanel() {

        JPanel p = new JPanel();

        p.setOpaque(true);
        p.setPreferredSize(new Dimension(400, 650));
        p.setBackground(new Color(250, 140, 130));
        p.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 50));

        return p;

    }

    public JPanel getSearchJPanel() {

        JPanel p = new JPanel();

        p.setOpaque(true);
        p.setPreferredSize(new Dimension(300, 30));
        p.setBackground(new Color(250, 140, 130));
        p.setLayout(new GridLayout(1, 3));

        return p;

    }

    public JPanel getTimelineJPanel() {

        JPanel p = new JPanel();
        p.setOpaque(false);
        
        
        p.setBackground(new Color(250, 140, 130));
        //p.setBackground(Color.red);
        p.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 25));
        p.setPreferredSize(new Dimension(200, 2000));
        MatteBorder border = new MatteBorder(0, 0, 0, 0, new Color(250, 250, 250));
        p.setBorder(border);
        return p;

    }

    public JPanel getScrollJPanel() {
        JPanel p = new JPanel();
        p.setOpaque(false);
        p.setPreferredSize(new Dimension(400, 650));
        p.setLayout(new GridLayout(1, 1));
        
        return p;
    }

    public JScrollPane getJScrollPane() {
        JScrollPane sp = new JScrollPane();
        sp.setBorder(BorderFactory.createEmptyBorder());
        sp.getViewport().setBackground(new Color(230, 230, 230));
        return sp;
    }

    public JLabel getTimelJLabel(String Name) {

        JLabel l = new JLabel(Name, JLabel.CENTER);
        l.setOpaque(false);
        l.setBackground(new Color(250, 140, 130));
        l.setPreferredSize(new Dimension(50, 75));
        l.setFont(new Font("Dialog", 1, 12));
        l.setForeground(new Color(150, 150, 150));
        MatteBorder border = new MatteBorder(1, 0, 1, 0, new Color(150, 150, 150));

        l.setBorder(border);
        return l;
    }

    public JButton getSearchButton(String Name) {

        JButton b = new JButton(Name);

        b.setBackground(new Color(250, 140, 130));
        b.setPreferredSize(new Dimension(50, 30));

        b.setForeground(Color.WHITE);
        MatteBorder border = new MatteBorder(1, 1, 1, 1, new Color(230, 230, 230));

        b.setBorder(border);
        return b;
    }

    public JTextField getSearchText() {

        JTextField t = new JTextField();
        t.setPreferredSize(new Dimension(200, 30));
        t.setOpaque(true);
        t.setBackground(new Color(220, 220, 220));
        t.setFont(new Font("Dialog", 1, 14));
        t.setForeground(new Color(250, 140, 130));

        MatteBorder border = new MatteBorder(1, 1, 1, 1, new Color(250, 140, 130));

        t.setBorder(border);

        return t;

    }

    public JLabel getComponentLabel(String labelName) {

        JLabel lb = new JLabel(labelName, JLabel.LEFT);
        lb.setPreferredSize(new Dimension(300, 15));
        lb.setOpaque(false);
        lb.setFont(new Font("Dialog", 1, 12));
        lb.setForeground(new Color(230, 230, 230));

        return lb;

    }
    
    public JTextArea getTimelineDisplayJextArea(String titleName, String discription){
        
        JTextArea ta = new JTextArea();
        ta.setPreferredSize(new Dimension(275, 75));
        ta.setOpaque(true);
        ta.setBackground(new Color(250, 140, 130));
        ta.setFont(new Font("Dialog", 1, 14));
        ta.setForeground(new Color(230, 230, 230));
        ta.setLineWrap(true);
        ta.setText("Title: "+titleName+"\r\n"+"Discription: "+discription);

        MatteBorder border = new MatteBorder(0, 0, 0, 0, new Color(250, 140, 130));

        ta.setBorder(border);
        return ta;
        
        
    }

    public JPanel getcomponentJPanel(){
        JPanel p = new JPanel();
        p.setOpaque(false);
        
        
        p.setBackground(new Color(250, 140, 130));
        //p.setBackground(Color.red);
        p.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
        p.setPreferredSize(new Dimension(400, 100));
        MatteBorder border = new MatteBorder(0, 0, 0, 0, new Color(250, 140, 130));
        p.setBorder(border);
        return p;
        
    }
    
     public JPanel gettextJPanel(){
        JPanel p = new JPanel();

        p.setOpaque(true);
        p.setPreferredSize(new Dimension(400, 500));
        p.setBackground(new Color(250, 140, 130));
        p.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 5));

        return p;
        
    }
}
