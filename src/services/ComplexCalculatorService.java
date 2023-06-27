package services;

import services.Calculator.Logger;
import services.complexCalculator.ComplexCalculator;
import services.complexCalculator.ComplexCalculatorDecorator;
import services.complexCalculator.ComplexNum;
import services.complexCalculator.iCalculator;

import java.util.List;

public class ComplexCalculatorService implements iCalculatorService {
    iCalculator calculator;

    public ComplexCalculatorService() {
        this.calculator = new ComplexCalculatorDecorator(new ComplexCalculator(), new Logger());
    }

    /**
     * выполнить вычисления и вернуть результат
     *
     * @param arguments список переменных и знак действия
     * @return результат вычисления
     */
    @Override
    public String getResult(List<String> arguments) {
        double num1X1 = Double.parseDouble(arguments.get(0));
        double num1X2 = Double.parseDouble(arguments.get(1));
        double num2X1 = Double.parseDouble(arguments.get(3));
        double num2X2 = Double.parseDouble(arguments.get(4));
        String operation = arguments.get(2);

        ComplexNum complexNumber1 = new ComplexNum(num1X1, num1X2);
        ComplexNum complexNumber2 = new ComplexNum(num2X1, num2X2);

        ComplexNum result = null;

        if (operation.equals("+")) {
            result = calculator.sum(complexNumber1, complexNumber2);
            return String.format("(%s) + (%s) = %s", complexNumber1.toString(), complexNumber2.toString(), result.toString());
        } else if (operation.equals("-")) {
            result = calculator.subtraction(complexNumber1, complexNumber2);
            return String.format("(%s) - (%s) = %s", complexNumber1.toString(), complexNumber2.toString(), result.toString());
        } else if (operation.equals("*")) {
            result = calculator.multi(complexNumber1, complexNumber2);
            return String.format("(%s) * (%s) = %s", complexNumber1.toString(), complexNumber2.toString(), result.toString());
        } else if (operation.equals("/")) {
            result = calculator.division(complexNumber1, complexNumber2);
            return String.format("(%s) / (%s) = %s", complexNumber1.toString(), complexNumber2.toString(), result.toString());
        }
        return "Ошибка вычисления";
    }
}
