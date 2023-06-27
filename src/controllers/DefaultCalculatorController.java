package controllers;

import model.CalculatorHistory;
import model.iGetModel;
import services.DefaultCalculatorService;
import services.iCalculatorService;
import view.ViewDefaultCalculator;
import view.iGetView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class DefaultCalculatorController {

    iGetView view;
    iGetModel history;
    iCalculatorService calculatorService;
    /**
     * количество последних операций, который надо показать пользователю
     */
    int sizeViewHistory = 10;

    public DefaultCalculatorController() {
        JButton getResultButton = new JButton("Посчитать");
        getResultButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count();
            }
        });

        view = new ViewDefaultCalculator(getResultButton, sizeViewHistory);
        history = new CalculatorHistory("Calculator History");
        calculatorService = new DefaultCalculatorService();
    }

    /**
     * запустить калькулятор
     */
    public void run() {
        view.setHistory(history.getOperationHistory(sizeViewHistory));
        view.showWindow();
    }

    /**
     * при нажатии на кнопку вычислить результат
     */
    private void count() {
        List<String> arguments = view.getArguments();
        String argX = arguments.get(0);
        String operation = arguments.get(1);
        String argY = arguments.get(2);

        if (!inputIsOk(argX, operation, argY)) {
            return;
        }

        String result = calculatorService.getResult(arguments);
        history.setHistory(String.format("%s %s %s = %s", argX, operation, argY, result));

        view.setHistory(history.getOperationHistory(sizeViewHistory));
        view.setResult(String.format("%s %s %s = %s", argX, operation, argY, result));
    }

    /**
     * проверка данных введенных пользователем
     *
     * @return данные верны -> true, false
     */
    private boolean inputIsOk(String argX, String operation, String argY) {
        try {
            Double.parseDouble(argX);
            Double.parseDouble(argY);
        } catch (Exception e) {
            view.showErrorWindow("Недопустимая переменная X или Y");
            return false;
        }

        if (operation.equals("/") && argY.equals("0")) {
            view.showErrorWindow("На 0 делить нельзя");
            return false;
        }

        return true;
    }
}
