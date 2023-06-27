package controllers;

import model.ComplexCalculatorHistory;
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
import java.util.List;

public class ComplexCalculatorController {
    iGetView view;
    iGetModel history;
    iCalculatorService calculatorService;

    public ComplexCalculatorController() {
        JButton getResultButton = new JButton("Посчитать");
        getResultButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count();
            }
        });

        view = new ViewComplexCalculator(getResultButton);
        history = new ComplexCalculatorHistory();
        calculatorService = new ComplexCalculatorService();
    }

    /**
     * запустить калькулятор комплексных чисел
     */
    public void run() {
        view.showWindow();
    }

    /**
     * при нажатии на кнопку вычислить результат
     */
    public void count() {
        List<String> arguments = view.getArguments();
        if (!argumentsIsOk(arguments)) {
            return;
        }

        String result = calculatorService.getResult(arguments);
        if (calculatorService.getResult(arguments).equals("Ошибка вычисления")) {
            view.showErrorWindow("Ошибка вычисления");
            return;
        }

        view.setResult(result);


    }

    /**
     * проверка введенных чисел
     *
     * @param arguments
     * @return
     */
    private boolean argumentsIsOk(List<String> arguments) {
        try {
            Double.parseDouble(arguments.get(0));
            Double.parseDouble(arguments.get(1));
            Double.parseDouble(arguments.get(3));
            Double.parseDouble(arguments.get(4));
        } catch (Exception e) {
            view.showErrorWindow("Проверьте правильность введенных чисел");
            return false;
        }
        if (arguments.get(3).equals("0") && arguments.get(4).equals("0")) {
            view.showErrorWindow("На 0 делить нельзя");
            return false;
        }
        return true;
    }
}
