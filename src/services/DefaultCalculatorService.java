package services;

import services.Calculator.CalcDecorator;
import services.Calculator.Calculator;
import services.Calculator.Logger;
import services.Calculator.iCalculable;

import java.util.List;

public class DefaultCalculatorService implements iCalculatorService {
    iCalculable calculator;


    /**
     * выполнить вычисления и вернуть результат
     *
     * @param arguments список переменных и знак действия в формате {"x", "знак", "Y"}
     * @return результат вычисления
     */
    @Override
    public String getResult(List<String> arguments) {
        this.calculator = new CalcDecorator(new Calculator(0), new Logger());

        double result = 0;
        calculator.sum(Double.parseDouble(arguments.get(0)));
        if (arguments.get(1).equals("+")) {
            calculator.sum(Double.parseDouble(arguments.get(2)));
            result = calculator.getResult();

        } else if (arguments.get(1).equals("-")) {
            calculator.subtraction(Double.parseDouble(arguments.get(2)));
            result = calculator.getResult();

        } else if (arguments.get(1).equals("*")) {
            calculator.multi(Double.parseDouble(arguments.get(2)));
            result = calculator.getResult();

        } else if (arguments.get(1).equals("/")) {
            try {
                calculator.division(Double.parseDouble(arguments.get(2)));
            } catch (Exception e) {
                return null;
            }

            result = calculator.getResult();
        }

        return Double.toString(result);
    }

}
