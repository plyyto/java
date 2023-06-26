package com.company;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Main extends JFrame {

    JPanel mainpanel = new JPanel();
    JPanel footerpanel = new JPanel();
    JPanel inputpanel = new JPanel();
    JPanel outputpanel = new JPanel();
    JLabel inputlabel = new JLabel( "Прізвище");
    JLabel outputlabel = new JLabel("Моб.телефон");
    JTextField inputfield = new JTextField(20);
    JTextField outputfield = new JTextField(20);

    TreeSet<String> ts =  new TreeSet<>();
    int count = 0;

    Main() {
        super("Записна книжка");
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(Exception e) {
        }
        setSize(400, 170);
        setResizable(false);
        Container c = getContentPane();

        mainpanel.setLayout(new GridLayout(3, 1));
        footerpanel.setLayout(new GridLayout(1, 1));

        inputlabel.setPreferredSize(outputlabel.getPreferredSize());

        inputpanel.add(inputlabel);
        inputpanel.add(inputfield);
        mainpanel.add(inputpanel);

        outputpanel.add(outputlabel);
        outputpanel.add(outputfield);
        mainpanel.setBorder(BorderFactory.createEtchedBorder());
        mainpanel.add(outputpanel);

        //кнопки-----------------------------------------------------------------------
        JPanel buttonPanel = new JPanel();
        mainpanel.add(buttonPanel);

        //панель з кількістю------------------------------------------------------------
        JPanel quantityPanel = new JPanel();
        quantityPanel.setBorder(BorderFactory.createEtchedBorder());
        quantityPanel.add(new JLabel("Кількість записів "));
        JTextField quantityField = new JTextField(3);
        quantityField.setEditable(false);
        quantityPanel.add(quantityField);
        footerpanel.add(quantityPanel);

        //кнопка друку-------------------------------------------------------------------
        JButton print = new JButton("Друкувати");
        buttonPanel.add(print, BorderLayout.CENTER);

        c.add(mainpanel, BorderLayout.NORTH);

        c.add(footerpanel, BorderLayout.SOUTH);

        //копіювання---------------------------------------------------------------------
        inputfield.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                ts.add(inputfield.getText() + " " + outputfield.getText());
                inputfield.setText("");
                outputfield.setText("");
                count++;
                quantityField.setText(count + "");
            }
        });
        outputfield.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                ts.add(inputfield.getText() + " " + outputfield.getText());
                inputfield.setText("");
                outputfield.setText("");
                count++;
                quantityField.setText(count + "");
            }
        });
        //вивід в консоль--------------------------------------------------------------------
        print.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                for (String string: ts)
                {
                    System.out.println(string);
                }
            }
        });
        WindowListener wndCloser = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        };
        addWindowListener(wndCloser);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}