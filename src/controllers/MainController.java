package controllers;

import view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainController {
    MainFrame mainFrame;

    public MainController() {
        JButton defaultCalculatorButton = new JButton("Калькулятор");
        defaultCalculatorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                runDefaultCalculator();
            }
        });

        JButton complexCalculatorButton = new JButton("Комплексный калькулятор");
        complexCalculatorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                runComplexCalculator();
            }
        });
        this.mainFrame = new MainFrame(defaultCalculatorButton, complexCalculatorButton);
    }

    /**
     * запуск окна выбора калькулятора
     */
    public void run(){mainFrame.showWindow();}

    /**
     * передать управление контроллеру обычного калькулятора
     */
    private void runDefaultCalculator(){
        DefaultCalculatorController defaultCalculatorController = new DefaultCalculatorController();
        defaultCalculatorController.run();
    }

    /**
     * передать управление контроллеру калькулятора комплексных чисел
     */
    private void runComplexCalculator(){
        ComplexCalculatorController defaultCalculatorController = new ComplexCalculatorController();
        defaultCalculatorController.run();
    }


}
