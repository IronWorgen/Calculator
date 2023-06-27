package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame {
    JButton defaultCalculatorButton;
    JButton complexCalculatorButton;

    public MainFrame(JButton defaultCalculatorButton, JButton complexCalculatorButton) {
        this.defaultCalculatorButton = defaultCalculatorButton;
        this.complexCalculatorButton = complexCalculatorButton;
    }

    public void showWindow(){
        JFrame window = new JFrame("Выбор калькулятора");


        JLabel label = new JLabel("Выберите тип калькулятора");

        Box mainBox = Box.createVerticalBox();

        Box labelBox = Box.createHorizontalBox();
        labelBox.add(Box.createHorizontalGlue());
        labelBox.add(label);
        labelBox.add(Box.createHorizontalGlue());

        Box defaultCalculatorButtonBox = Box.createHorizontalBox();

        defaultCalculatorButtonBox.add(Box.createHorizontalGlue());
        defaultCalculatorButtonBox.add(defaultCalculatorButton);
        defaultCalculatorButtonBox.add(Box.createHorizontalGlue());



        Box complexCalculatorButtonBox = Box.createHorizontalBox();

        complexCalculatorButtonBox.add(Box.createHorizontalGlue());
        complexCalculatorButtonBox.add(complexCalculatorButton);
        complexCalculatorButtonBox.add(Box.createHorizontalGlue());


        defaultCalculatorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.setVisible(false);
            }
        });

        complexCalculatorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.setVisible(false);
            }
        });


        mainBox.add(Box.createVerticalGlue());

        mainBox.add(labelBox);
        mainBox.add(Box.createVerticalStrut(10));
        mainBox.add(defaultCalculatorButtonBox);
        mainBox.add(Box.createVerticalStrut(10));
        mainBox.add(complexCalculatorButtonBox);
        mainBox.add(Box.createVerticalGlue());



        window.add(mainBox);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(500, 400);
        window.setVisible(true);
    }

}
