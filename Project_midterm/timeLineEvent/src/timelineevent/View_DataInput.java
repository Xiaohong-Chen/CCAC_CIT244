package timelineevent;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.MatteBorder;

public class View_DataInput extends View {

    public boolean submitControl = true;
    public boolean choiseControl = false;
    public boolean backControl = true;

    /*
    public void choiseInput(){
        
        Scanner userInput = new Scanner(System.in);
        
        System.out.println("--------------------------------------------");
        System.out.println("----------- 1. COMPUTER SYSTEM   -----------");
        System.out.println("----------- 2. COMPUTER HARDWARE -----------");
        System.out.println("----------- 3. HUMAN INTEREST    -----------");
        System.out.println("----------- 4. EXIT              -----------");
        System.out.println("--------------------------------------------");
        
        choise = userInput.nextInt();
    }

    public void computerSystemInput() {

        Scanner userInput = new Scanner(System.in);
        
        System.out.println("Please Input The Title: ");
        title = userInput.next();

        System.out.println("Please Input The Year(int): ");
        year = userInput.nextInt();

        System.out.println("Please Input The Discription(String): ");
        description = userInput.next();

        System.out.println("Please Input The Model Number: ");
        modelNumber = userInput.nextInt();

        System.out.println("Please Input The Release Year: ");
        releaseYear = userInput.nextInt();

        System.out.println("Please Input The Retail Price In 2018: ");
        retailPriceIn2018 = userInput.nextDouble();

        System.out.println("Please Input The Maufacturer: ");
        manufacturer = userInput.next();

        System.out.println("Please Input The Reason Of Choosing: ");
        reasonOfChoosing = userInput.next();

    }

    public void computerHardwareInput() {

        Scanner userInput = new Scanner(System.in);
        
         System.out.println("Please Input The Title: ");
        title = userInput.next();

        System.out.println("Please Input The Year(int): ");
        year = userInput.nextInt();

        System.out.println("Please Input The Discription(String): ");
        description = userInput.next();

        System.out.println("Please Input The Model Number: ");
        modelNumber = userInput.nextInt();

        System.out.println("Please Input The Release Year: ");
        releaseYear = userInput.nextInt();

        System.out.println("Please Input The Retail Price In 2018: ");
        retailPriceIn2018 = userInput.nextDouble();

        System.out.println("Please Input The Most Important Specifications: ");
        mostImportantSpecifications = userInput.next();
    }

    public void humanInterestInput() {

        Scanner userInput = new Scanner(System.in);
        
         System.out.println("Please Input The Title: ");
        title = userInput.next();

        System.out.println("Please Input The Year(int): ");
        year = userInput.nextInt();

        System.out.println("Please Input The Discription(String): ");
        description = userInput.next();

    }
     */
    public JLabel getMainTitleJLabel(String labelName) {
        JLabel lb = new JLabel(labelName, JLabel.CENTER);
        lb.setPreferredSize(new Dimension(300, 300));
        lb.setOpaque(true);
        lb.setFont(new Font("Dialog", 1, 50));
        lb.setForeground(new Color(245, 95, 80));
        MatteBorder border = new MatteBorder(2, 2, 2, 2, new Color(250, 140, 130));

        lb.setBorder(border);

        return lb;
    }

    public JButton getChoiseJButton(String buttonName) {
        JButton b = new JButton(buttonName);
        b.setBackground(new Color(250, 140, 130));
        b.setPreferredSize(new Dimension(150, 150));
        b.setFont(new Font("Dialog", 1, 12));

        b.setForeground(Color.WHITE);
        MatteBorder border = new MatteBorder(1, 1, 1, 1, Color.WHITE);

        b.setBorder(border);
        return b;
    }

    public JFrame getJrame(String name) {

        JFrame frame = new JFrame(name);
        frame = new JFrame("TimeLine");
        frame.setSize(600, 800);
        frame.getContentPane().setBackground(new Color(230, 230, 230));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 100));

        return frame;
    }

    public JLabel getComponentLabel(String labelName) {

        JLabel lb = new JLabel(labelName, JLabel.LEFT);
        lb.setPreferredSize(new Dimension(300, 15));
        lb.setOpaque(false);
        lb.setFont(new Font("Dialog", 1, 12));
        lb.setForeground(new Color(245, 95, 80));

        return lb;

    }

    public JTextField getComponentText() {

        JTextField t = new JTextField();
        t.setPreferredSize(new Dimension(300, 30));
        t.setOpaque(true);
        t.setBackground(new Color(220, 220, 220));
        t.setFont(new Font("Dialog", 1, 14));
        t.setForeground(new Color(250, 140, 130));

        MatteBorder border = new MatteBorder(1, 1, 2, 2, new Color(250, 140, 130));

        t.setBorder(border);

        return t;

    }

    public JTextArea getComponentTextArea() {
        JTextArea ta = new JTextArea();
        ta.setPreferredSize(new Dimension(300, 90));
        ta.setOpaque(true);
        ta.setBackground(new Color(220, 220, 220));
        ta.setFont(new Font("Dialog", 1, 14));
        ta.setForeground(new Color(245, 95, 80));
        ta.setLineWrap(true);

        MatteBorder border = new MatteBorder(1, 1, 2, 2, new Color(250, 140, 130));

        ta.setBorder(border);
        return ta;
    }

    public JPanel getJPanel() {
        JPanel p = new JPanel();
        p.setPreferredSize(new Dimension(300, 600));
        p.setOpaque(false);
        p.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 5));
        return p;
    }

    public JButton getJButton(String buttonName) {
        JButton b = new JButton(buttonName);
        b.setBackground(new Color(250, 140, 130));
        b.setPreferredSize(new Dimension(150, 50));

        b.setForeground(Color.WHITE);
        MatteBorder border = new MatteBorder(1, 1, 1, 1, Color.WHITE);

        b.setBorder(border);
        return b;
    }

    public void choiseInput() {
        
        //Creating a JFrame for Choise Input
        JFrame chJFrame = getJrame("CHOISE");

        //Creating a JPanel for JLabel and JTextField
        JPanel p = getJPanel();
        
        //Comfiguring the Components
        JLabel mainTitle = getMainTitleJLabel("TIMELINE");
        JButton csJButton = getChoiseJButton("COMPUTER SYSTEM");
        JButton chJButton = getChoiseJButton("COMPUTER HARDWARE");
        JButton hiJButton = getChoiseJButton("HUMAN INTEREST");
        JButton exJButton = getChoiseJButton("SEARCH DISPLAY");
        
        p.add(mainTitle);
        p.add(csJButton);
        p.add(chJButton);
        p.add(hiJButton);
        p.add(exJButton);

        chJFrame.add(p);

        chJFrame.setVisible(true);

        //Creating Action Listener for Buttons
        ActionListener choiceListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if (e.getSource() == csJButton) {
                    choise = 1;
                    choiseControl = true;
                    chJFrame.setVisible(false);
                } else if (e.getSource() == chJButton) {
                    choise = 2;
                    choiseControl = true;
                    chJFrame.setVisible(false);
                } else if (e.getSource() == hiJButton) {
                    choise = 3;
                    choiseControl = true;
                    chJFrame.setVisible(false);

                } else if (e.getSource() == exJButton) {
                    choise = 4;
                    choiseControl = true;
                    chJFrame.setVisible(false);
                }
            }
        };
        
        //Adding the Action Listener to the Choice Buttons
        while (choiseControl == false) {
            csJButton.addActionListener(choiceListener);
            chJButton.addActionListener(choiceListener);
            hiJButton.addActionListener(choiceListener);
            exJButton.addActionListener(choiceListener);
        }
    }

    public void computerSystemInput() {

        //Creating a JFrame for Computer System
        JFrame csJFrame = getJrame("COMPUTER SYSTEM");

        //Creating a JPanel for JLabel and JTextField
        JPanel p = getJPanel();

        //Creating a TITLE JLabel for ComputerSystem JFrame
        JLabel titleLabel = getComponentLabel("TITLE(String) :");

        //Creating a TITLE JTextField for ComputerSystem JFrame
        JTextField titleText = getComponentText();

        //Creating a YEAR JLabel for ComputerSystem JFrame
        JLabel yearLabel = getComponentLabel("YEAR(int) :");

        //Creating a YEAR JTextField for ComputerSystem JFrame
        JTextField yearText = getComponentText();

        //Creating a DISCRIPTION JLabel for ComputerSystem JFrame
        JLabel discriptionLabel = getComponentLabel("DISCRIPTION(String) :");

        //Creating a DISCRIPTION JTextField for ComputerSystem JFrame
        JTextArea discriptionText = getComponentTextArea();

        //Creating a MODEL NUMBER JLabel for ComputerSystem JFrame
        JLabel modelNumberLabel = getComponentLabel("MODEL NUMBER(int) :");

        //Creating a MODEL NUMBER  JTextField for ComputerSystem JFrame
        JTextField modelNumberText = getComponentText();

        //Creating a RELEASE YEAR JLabel for ComputerSystem JFrame
        JLabel releaseYearLabel = getComponentLabel("RELEASE YEAR(int) :");

        //Creating a RELEASE YEAR  JTextField for ComputerSystem JFrame
        JTextField releaseYearText = getComponentText();

        //Creating a RETAIL PRICE IN 2018 JLabel for ComputerSystem JFrame
        JLabel retailPriceIn2018Label = getComponentLabel("RETAIL PRICE IN 2018(double) :");

        //Creating a RETAIL PRICE IN 2018  JTextField for ComputerSystem JFrame
        JTextField retailPriceIn2018Text = getComponentText();

        //Creating a MANUFACTURER JLabel for ComputerSystem JFrame
        JLabel manufacturerLabel = getComponentLabel("MANUFACTURER(String) :");

        //Creating a MANUFACTURER JTextField for ComputerSystem JFrame
        JTextField manufacturerText = getComponentText();

        //Creating a REASON OF CHOOSING JLabel for ComputerSystem JFrame
        JLabel reasonOfChoosingLabel = getComponentLabel("REASON OF CHOOSING(String) :");

        //Creating a REASON OF CHOOSING JTextField for ComputerSystem JFrame
        JTextField reasonOfChoosingText = getComponentText();

        //Creating a Submit Button
        JButton submitButton = getJButton("SUBMIT");

        //Creating a Back Button
        JButton backButton = getJButton("BACK");

        //Comfiguring the Components
        p.add(titleLabel);
        p.add(titleText);
        p.add(yearLabel);
        p.add(yearText);
        p.add(modelNumberLabel);
        p.add(modelNumberText);
        p.add(releaseYearLabel);
        p.add(releaseYearText);
        p.add(retailPriceIn2018Label);
        p.add(retailPriceIn2018Text);
        p.add(manufacturerLabel);
        p.add(manufacturerText);
        p.add(reasonOfChoosingLabel);
        p.add(reasonOfChoosingText);

        p.add(discriptionLabel);
        p.add(discriptionText);

        p.add(backButton);
        p.add(submitButton);

        csJFrame.add(p);

        csJFrame.setVisible(true);

        //Creating Action Listener for Submit button
        ActionListener submitListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                //Checking if the text field is empty or not 
                if ("".equals(titleText.getText())) {
                    JOptionPane.showMessageDialog(new JFrame(), "TITLE Is Empty");
                    titleText.grabFocus();
                } else if ("".equals(yearText.getText())) {
                    JOptionPane.showMessageDialog(new JFrame(), "YEAR Is Empty");
                    yearText.grabFocus();
                } else if ("".equals(discriptionText.getText())) {
                    JOptionPane.showMessageDialog(new JFrame(), "DISCRIPTION Is Empty");
                    discriptionText.grabFocus();
                } else if ("".equals(modelNumberText.getText())) {
                    JOptionPane.showMessageDialog(new JFrame(), "RELEASE YEAR Is Empty");
                    modelNumberText.grabFocus();
                } else if ("".equals(releaseYearText.getText())) {
                    JOptionPane.showMessageDialog(new JFrame(), "RELEASE YEAR Is Empty");
                    releaseYearText.grabFocus();
                } else if ("".equals(retailPriceIn2018Text.getText())) {
                    JOptionPane.showMessageDialog(new JFrame(), "RETAIL PRICE IN 2018 Is Empty");
                    retailPriceIn2018Text.grabFocus();
                } else if ("".equals(manufacturerText.getText())) {
                    JOptionPane.showMessageDialog(new JFrame(), "MANUFACTURER Is Empty");
                    manufacturerText.grabFocus();
                } else if ("".equals(reasonOfChoosingText.getText())) {
                    JOptionPane.showMessageDialog(new JFrame(), "MOST IMPORTANT SPECIFICATIONS Is Empty");
                    reasonOfChoosingText.grabFocus();
                } else {

                    try {
                        
                        //Assigning the value 
                        title = titleText.getText();
                        year = Integer.parseInt(yearText.getText());
                        description = discriptionText.getText();
                        modelNumber = Integer.parseInt(modelNumberText.getText());
                        releaseYear = Integer.parseInt(releaseYearText.getText());
                        retailPriceIn2018 = Double.valueOf(retailPriceIn2018Text.getText());
                        manufacturer = manufacturerText.getText();
                        reasonOfChoosing = reasonOfChoosingText.getText();

                        submitControl = false;
                        csJFrame.setVisible(false);

                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(new JFrame(), "YEAR, MODELNUMBER, RELEASEYEAR, RETAILPRICE MUST BE NUMERIC");
                    }
                }
            }
        };

        //Creating Action Listener for Close button
        @SuppressWarnings("Convert2Lambda")
        ActionListener backListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                csJFrame.setVisible(false);
                backControl = false;
                submitControl = false;
            }
        };
        //Adding the Action Listener to Buttons
        backButton.addActionListener(backListener);
        submitButton.addActionListener(submitListener);
    }

    public void computerHardwareInput() {

        //Creating a JFrame for ComputerHardware
        JFrame chJFrame = getJrame("COMPUTER HARDWARE");

        //Creating a JPanel for JLabel and JTextField
        JPanel p = getJPanel();

        //Creating a TITLE JLabel for ComputerHardware JFrame
        JLabel titleLabel = getComponentLabel("TITLE :");

        //Creating a TITLE JTextField for ComputerHardware JFrame
        JTextField titleText = getComponentText();

        //Creating a YEAR JLabel for ComputerHardware JFrame
        JLabel yearLabel = getComponentLabel("YEAR :");

        //Creating a YEAR JTextField for ComputerHardwareJFrame
        JTextField yearText = getComponentText();

        //Creating a DISCRIPTION JLabel for ComputerHardware JFrame
        JLabel discriptionLabel = getComponentLabel("DISCRIPTION :");

        //Creating a DISCRIPTION JTextField for ComputerHardware JFrame
        JTextArea discriptionText = getComponentTextArea();

        //Creating a MODEL NUMBER JLabel for ComputerHardware JFrame
        JLabel modelNumberLabel = getComponentLabel("MODEL NUMBER :");

        //Creating a MODEL NUMBER  JTextField for ComputerHardware JFrame
        JTextField modelNumberText = getComponentText();

        //Creating a RELEASE YEAR JLabel for ComputerHardware JFrame
        JLabel releaseYearLabel = getComponentLabel("RELEASE YEAR :");

        //Creating a RELEASE YEAR  JTextField for ComputerHardware JFrame
        JTextField releaseYearText = getComponentText();

        //Creating a RETAIL PRICE IN 2018 JLabel for ComputerHardware JFrame
        JLabel retailPriceIn2018Label = getComponentLabel("RETAIL PRICE IN 2018 :");

        //Creating a RETAIL PRICE IN 2018  JTextField for ComputerHardware JFrame
        JTextField retailPriceIn2018Text = getComponentText();

        //Creating a MANUFACTURER JLabel for ComputerHardware JFrame
        JLabel manufacturerLabel = getComponentLabel("MANUFACTURER :");

        //Creating a MANUFACTURER JTextField for ComputerHardware JFrame
        JTextField manufacturerText = getComponentText();

        //Creating a Most Important Specifications JLabel for ComputerHardware JFrame
        JLabel mostImportantSpecificationsLabel = getComponentLabel("MOST IMPORTANT SPECIFICATIONS :");

        //Creating a Most Important Specifications JTextField for ComputerHardware JFrame
        JTextField mostImportantSpecificationsText = getComponentText();

        //Creating a Submit Button for ComputerHardware JFrame
        JButton submitButton = getJButton("SUBMIT");
        //Creating a Back Button for ComputerHardware JFrame
        JButton backButton = getJButton("BACK");

        p.add(titleLabel);
        p.add(titleText);
        p.add(yearLabel);
        p.add(yearText);
        p.add(modelNumberLabel);
        p.add(modelNumberText);
        p.add(releaseYearLabel);
        p.add(releaseYearText);
        p.add(retailPriceIn2018Label);
        p.add(retailPriceIn2018Text);
        p.add(manufacturerLabel);
        p.add(manufacturerText);
        p.add(mostImportantSpecificationsLabel);
        p.add(mostImportantSpecificationsText);

        p.add(discriptionLabel);
        p.add(discriptionText);
        p.add(backButton);
        p.add(submitButton);

        chJFrame.add(p);
        //frame.add();
        chJFrame.setVisible(true);

        ActionListener submitListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if ("".equals(titleText.getText())) {
                    JOptionPane.showMessageDialog(new JFrame(), "TITLE Is Empty");
                    titleText.grabFocus();
                } else if ("".equals(yearText.getText())) {
                    JOptionPane.showMessageDialog(new JFrame(), "YEAR Is Empty");
                    yearText.grabFocus();
                } else if ("".equals(discriptionText.getText())) {
                    JOptionPane.showMessageDialog(new JFrame(), "DISCRIPTION Is Empty");
                    discriptionText.grabFocus();
                } else if ("".equals(modelNumberText.getText())) {
                    JOptionPane.showMessageDialog(new JFrame(), "RELEASE YEAR Is Empty");
                    modelNumberText.grabFocus();
                } else if ("".equals(releaseYearText.getText())) {
                    JOptionPane.showMessageDialog(new JFrame(), "RELEASE YEAR Is Empty");
                    releaseYearText.grabFocus();
                } else if ("".equals(retailPriceIn2018Text.getText())) {
                    JOptionPane.showMessageDialog(new JFrame(), "RETAIL PRICE IN 2018 Is Empty");
                    retailPriceIn2018Text.grabFocus();
                } else if ("".equals(manufacturerText.getText())) {
                    JOptionPane.showMessageDialog(new JFrame(), "MANUFACTURER Is Empty");
                    manufacturerText.grabFocus();
                } else if ("".equals(mostImportantSpecificationsText.getText())) {
                    JOptionPane.showMessageDialog(new JFrame(), "MOST IMPORTANT SPECIFICATIONS Is Empty");
                    mostImportantSpecificationsText.grabFocus();
                } else {

                    try {

                        title = titleText.getText();
                        year = Integer.parseInt(yearText.getText());
                        description = discriptionText.getText();
                        modelNumber = Integer.parseInt(modelNumberText.getText());
                        releaseYear = Integer.parseInt(releaseYearText.getText());
                        retailPriceIn2018 = Double.valueOf(retailPriceIn2018Text.getText());
                        manufacturer = manufacturerText.getText();
                        mostImportantSpecifications = mostImportantSpecificationsText.getText();

                        submitControl = false;
                        chJFrame.setVisible(false);

                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(new JFrame(), "YEAR, MODELNUMBER, RELEASEYEAR, RETAILPRICE MUST BE NUMERIC");
                    }
                }
            }
        };
        ActionListener backListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chJFrame.setVisible(false);
                backControl = false;
                submitControl = false;
            }
        };

        backButton.addActionListener(backListener);

        submitButton.addActionListener(submitListener);

    }

    public void humanInterestInput() {

        //Creating a JFrame for HumanInterest
        JFrame hiJFrame = getJrame("HUMAN INTEREST");

        //Creating a JPanel for JLabel and JTextField
        JPanel p = getJPanel();

        //Creating a TITLE JLabel for HumanInterest JFrame
        JLabel titleLabel = getComponentLabel("TITLE :");

        //Creating a TITLE JTextField for HumanInterest JFrame
        JTextField titleText = getComponentText();

        //Creating a YEAR JLabel for HumanInterest JFrame
        JLabel yearLabel = getComponentLabel("YEAR :");

        //Creating a YEAR JTextField for HumanInterest JFrame
        JTextField yearText = getComponentText();

        //Creating a DISCRIPTION JLabel for HumanInterest JFrame
        JLabel discriptionLabel = getComponentLabel("DISCRIPTION :");

        //Creating a DISCRIPTION JTextField for HumanInterest JFrame
        JTextArea discriptionText = getComponentTextArea();

        //Creating a Submit Button for HumanInterest JFrame
        JButton submitButton = getJButton("SUBMIT");
        //Creating a Back Button for HumanInterest JFrame
        JButton backButton = getJButton("BACK");
        p.add(titleLabel);
        p.add(titleText);
        p.add(yearLabel);
        p.add(yearText);

        p.add(discriptionLabel);
        p.add(discriptionText);
        p.add(backButton);
        p.add(submitButton);

        hiJFrame.add(p);
        //frame.add();
        hiJFrame.setVisible(true);

        ActionListener submitListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if ("".equals(titleText.getText())) {
                    JOptionPane.showMessageDialog(new JFrame(), "TITLE Is Empty");
                    titleText.grabFocus();
                } else if ("".equals(yearText.getText())) {
                    JOptionPane.showMessageDialog(new JFrame(), "YEAR Is Empty");
                    yearText.grabFocus();
                } else if ("".equals(discriptionText.getText())) {
                    JOptionPane.showMessageDialog(new JFrame(), "DISCRIPTION Is Empty");
                    discriptionText.grabFocus();
                } else {

                    try {

                        title = titleText.getText();
                        year = Integer.parseInt(yearText.getText());
                        description = discriptionText.getText();

                        submitControl = false;
                        hiJFrame.setVisible(false);

                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(new JFrame(), "YEAR MUST BE NUMERIC");
                    }
                }
            }
        };

        ActionListener backListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hiJFrame.setVisible(false);
                backControl = false;
                submitControl = false;
            }
        };

        backButton.addActionListener(backListener);
        submitButton.addActionListener(submitListener);
    }

}
