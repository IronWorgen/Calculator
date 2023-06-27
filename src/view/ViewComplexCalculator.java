package view;

import javax.swing.*;
import java.util.List;

public class ViewComplexCalculator implements iGetView{
    JButton getResultButton;
    /** Вещественная часть первого числа     */
    JTextField num1X1;
    /** Мнимая часть первого числа     */
    JTextField num1X2;
    /** Вещественная часть первого числа     */
    JTextField num2X1;
    /** Мнимая часть второго числа     */
    JTextField num2X2;
    /**
     * мнимая единица
     */
    JLabel i;

    JComboBox operation;
    JLabel result;
    public ViewComplexCalculator(JButton getResultButton) {
        this.getResultButton = getResultButton;
        num1X1 = new JTextField(3);
        num1X2 = new JTextField(3);
        num2X1 = new JTextField(3);
        num2X2 = new JTextField(3);
        result= new JLabel("результат");
        i= new JLabel("i");

        String[] items = new String[]{"+", "-", "*", "/"};
        operation = new JComboBox(items);
    }

    /**
     * отобразить окно интерфейса
     */
    @Override
    public void showWindow() {


    }

    /**
     * список всех чисел введенных пользователем
     * @return {"x1","x2" "знак", "y1", "y2"} -
     */
    @Override
    public List<String> getArguments() {
        return null;
    }
    /**
     * вывести сообщение об ошибке
     * @param errorMessage  текст сообщения
     */

    @Override
    public void showErrorWindow(String errorMessage) {

    }
    /**
     * показать результат выполнения операции пользователю
     * @param resultStr результат
     */
    @Override
    public void setResult(String resultStr) {

    }
}
