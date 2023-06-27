package controllers;

import model.DefaultCalculatorHistory;
import model.iGetModel;
import services.ComplexCalculatorService;
import services.DefaultCalculatorService;
import services.iCalculatorService;
import view.ViewComplexCalculator;
import view.ViewDefaultCalculator;
import view.iGetView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComplexCalculatorController {
    iGetView view;
    iGetModel history;
    iCalculatorService calculatorService;

    public ComplexCalculatorController() {
        JButton getResultButton =  new JButton("Посчитать");
        getResultButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count();
            }
        });

        view =  new ViewComplexCalculator(getResultButton);
        history = new ComplexCalculatorHistory();
        calculatorService = new ComplexCalculatorService();
    }

    /**
     * запустить калькулятор комплексных чисел
     */
    public void run(){

    }

    /**
     * при нажатии на кнопку вычислить результат
     */
    public void count(){

    }
}
