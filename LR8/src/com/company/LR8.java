package com.company;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;
import javax.swing.*;

public class LR8 extends JFrame {

    JPanel center = new JPanel();
    JPanel vvid = new JPanel();
    JPanel vuvid = new JPanel();
    JLabel lbl1 = new JLabel("Поле вводу");
    JLabel lbl2 = new JLabel("Поле виводу");
    JTextField vvidField = new JTextField(20);
    JTextField vuvidField = new JTextField(20);
    LinkedList<String> list = new LinkedList<>();

    LR8() {
        super("Лаба 8");
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(Exception e) {
        }
        setSize(500, 150);
        setResizable(false);
        Container c = getContentPane();

        center.setLayout(new GridLayout(2, 1));

        lbl1.setPreferredSize(lbl2.getPreferredSize());

        vvid.add(lbl1);
        vvid.add(vvidField);
        center.add(vvid);

        vuvid.add(lbl2);
        vuvid.add(vuvidField);
        center.add(vuvid);

        JPanel buttonPanel = new JPanel();
        JButton copy = new JButton("Скопіювати");
        buttonPanel.add(copy, BorderLayout.CENTER);

        JButton print = new JButton("Друк");
        buttonPanel.add(print, BorderLayout.CENTER);

        c.add(center, BorderLayout.NORTH);

        c.add(buttonPanel, BorderLayout.SOUTH);

        vvidField.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                vuvidField.setText(vvidField.getText());
                list.add(vuvidField.getText());
            }
        });
        copy.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {

                vuvidField.setText(vvidField.getText());
                list.add(vuvidField.getText());
            }
        });
        print.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {

                for (var element: list)
                {
                    System.out.println(element);
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
        new LR8();
    }
}
