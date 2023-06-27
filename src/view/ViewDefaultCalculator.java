package view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ViewDefaultCalculator implements iGetView{
    JButton getResultButton;
    JTextField argX;
    JTextField argY;
    JComboBox operation;
    JLabel result;

    public ViewDefaultCalculator(JButton getResultButton) {
        this.getResultButton = getResultButton;
        argX = new JTextField(7);
        argY = new JTextField(7);
        result= new JLabel("результат");


        String[] items = new String[]{"+", "-", "*", "/"};
        operation = new JComboBox(items);
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
        inputPanel.add(argX);
        inputPanel.add(operation);
        inputPanel.add(new JLabel("y= "));
        inputPanel.add(argY);



        JPanel getResultPanel = new JPanel();
        getResultPanel.add(getResultButton);

        JPanel resultLabelPanel = new JPanel();

        result.setVisible(false);
        resultLabelPanel.add(result, Component.CENTER_ALIGNMENT);


        mainBox.add(Box.createVerticalGlue());
        mainBox.add(inputPanel);
        mainBox.add(getResultPanel);
        mainBox.add(resultLabelPanel);
        mainBox.add(new JLabel("История вычислений"));
        mainBox.add(new JTextField());
        mainBox.add(Box.createVerticalGlue());


        window.add(mainBox);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(500, 400);
        window.setVisible(true);
    }

    /**
     * список всех чисел введенных пользователем
     * @return {"x", "знак", "y"}
     */
    @Override
    public List<String> getArguments() {
        List<String> arguments = new ArrayList<>();
        arguments.add(argX.getText().trim());
        arguments.add(((String) operation.getSelectedItem()).trim());
        arguments.add(argY.getText().trim());
        return arguments;
    }

    /**
     * вывести сообщение об ошибке
     * @param errorMessage  текст сообщения
     */
    @Override
    public void showErrorWindow(String errorMessage) {
        JOptionPane.showMessageDialog(getResultButton, errorMessage, "Ошибка", JOptionPane.WARNING_MESSAGE);
    }

    /**
     * показать результат выполнения операции пользователю
     * @param resultStr результат
     */
    @Override
    public void setResult(String resultStr) {
        result.setText(resultStr);
        result.setVisible(true);
    }
}
