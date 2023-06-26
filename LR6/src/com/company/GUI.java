package com.company;

import java.awt.GridLayout;
import java.awt.*;
import javax.swing.*;

public class GUI extends JFrame
{
    private  JLabel label = new JLabel("Логін: ");
    private JTextField textField = new JTextField();
    private  JLabel label2 = new JLabel("Пароль: ");
    private JTextField textField2 = new JTextField();
    private JButton button = new JButton("ОК");
    private JButton button2 = new JButton("Відміна");

    public GUI()
    {
        super("Вікно входу");
        this.setBounds(450,200,450,250);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(0,1,5,5));
        container.add(label);
        container.add(textField);
        container.add(label2);
        container.add(textField2);
        container.add(button);
        container.add(button2);

    }

}
