package controllers;

import model.CalculatorHistory;
import model.iGetModel;
import services.ComplexCalculatorService;
import services.iCalculatorService;
import view.ViewComplexCalculator;
import view.iGetView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ComplexCalculatorController {
    iGetView view;
    iGetModel history;
    iCalculatorService calculatorService;
    /**
     *  количество последних операций, который надо показать пользователю
     */
    private int historySize = 10;

    public ComplexCalculatorController() {
        JButton getResultButton = new JButton("Посчитать");
        getResultButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count();
            }
        });

        view = new ViewComplexCalculator(getResultButton, historySize);
        history = new CalculatorHistory("Complex Calculator History");
        calculatorService = new ComplexCalculatorService();
    }

    /**
     * запустить калькулятор комплексных чисел
     */
    public void run() {
        view.setHistory(history.getOperationHistory(historySize));
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
        history.setHistory(result);
        view.setHistory(history.getOperationHistory(historySize));
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
