package view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ViewComplexCalculator implements iGetView {
    /**
     * кнопка посчитать
     */
    JButton getResultButton;
    /**
     * Вещественная часть первого числа
     */
    JTextField num1X1;
    /**
     * Мнимая часть первого числа
     */
    JTextField num1X2;
    /**
     * Вещественная часть первого числа
     */
    JTextField num2X1;
    /**
     * Мнимая часть второго числа
     */
    JTextField num2X2;
    /**
     * выбор действия
     */
    JComboBox operation;
    /**
     * результат вычисления
     */
    JLabel result;
    /**
     * вывести поле вывода истории вычислений
     */
    JTextArea historyArea1;
    /**
     * количество последних операций которые надо показывать
     */

    int historyAreaRows;


    public ViewComplexCalculator(JButton getResultButton, int historyAreaRows) {
        this.getResultButton = getResultButton;
        num1X1 = new JTextField(3);
        num1X2 = new JTextField(3);
        num2X1 = new JTextField(3);
        num2X2 = new JTextField(3);
        result = new JLabel("результат");


        String[] items = new String[]{"+", "-", "*", "/"};
        operation = new JComboBox(items);
        historyArea1 = new JTextArea();
        this.historyAreaRows = historyAreaRows;

    }

    /**
     * отобразить окно интерфейса
     */
    @Override
    public void showWindow() {
        JFrame window = new JFrame("калькулятор");

        Box mainBox = Box.createVerticalBox();
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("x= "));
        inputPanel.add(new JLabel("("));
        inputPanel.add(num1X1);
        inputPanel.add(new JLabel(" + "));
        inputPanel.add(num1X2);
        inputPanel.add(new JLabel("i"));
        inputPanel.add(new JLabel(") "));

        inputPanel.add(operation);

        inputPanel.add(new JLabel("y= "));
        inputPanel.add(new JLabel("("));
        inputPanel.add(num2X1);
        inputPanel.add(new JLabel(" + "));
        inputPanel.add(num2X2);
        inputPanel.add(new JLabel("i"));
        inputPanel.add(new JLabel(")"));

        JPanel getResultPanel = new JPanel();
        getResultPanel.add(getResultButton);

        JPanel resultLabelPanel = new JPanel();
        result.setFont(new Font("Century Gothic", Font.BOLD, 16));
        result.setVisible(false);
        resultLabelPanel.add(result, Component.CENTER_ALIGNMENT);

        JPanel historyLabelPanel = new JPanel();
        historyLabelPanel.add(new JLabel("История вычислений"), Component.CENTER_ALIGNMENT);

        JPanel historyArea1Panel = new JPanel();
        historyArea1Panel.add(historyArea1);


        mainBox.add(Box.createVerticalGlue());
        mainBox.add(inputPanel);
        mainBox.add(getResultPanel);
        mainBox.add(resultLabelPanel);
        mainBox.add(historyLabelPanel);
        mainBox.add(historyArea1Panel);

        mainBox.add(Box.createVerticalGlue());


        window.add(mainBox);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(500, 400);
        window.setVisible(true);

    }

    /**
     * список всех чисел введенных пользователем
     *
     * @return {"x1","x2" "знак", "y1", "y2"} -
     */
    @Override
    public List<String> getArguments() {
        List<String> arguments = new ArrayList<>();
        arguments.add(num1X1.getText().trim());
        arguments.add(num1X2.getText().trim());
        arguments.add(((String) operation.getSelectedItem()).trim());
        arguments.add(num2X1.getText().trim());
        arguments.add(num2X2.getText().trim());
        return arguments;
    }

    /**
     * вывести сообщение об ошибке
     *
     * @param errorMessage текст сообщения
     */

    @Override
    public void showErrorWindow(String errorMessage) {
        JOptionPane.showMessageDialog(getResultButton, errorMessage, "Ошибка", JOptionPane.WARNING_MESSAGE);
    }

    /**
     * показать результат выполнения операции пользователю
     *
     * @param resultStr результат
     */
    @Override
    public void setResult(String resultStr) {
        result.setText(resultStr);
        result.setVisible(true);
    }

    /**
     * установить текст в поле история операций
     *
     * @param history
     */
    @Override
    public void setHistory(String[] history) {
        String historyString = "";
        if (history.length < historyAreaRows) {
            for (int i = 0; i < history.length; i++) {
                historyString += history[i] + "\n";
            }
            historyArea1.setText(historyString);
            return;
        }

        for (int i = 0; i < history.length; i++) {
            historyString += history[i] + "\n";
        }
        historyArea1.setText(historyString);
    }

}
