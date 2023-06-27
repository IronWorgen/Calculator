package services;

import services.Calculator.Logger;
import services.complexCalculator.ComplexCalculator;
import services.complexCalculator.ComplexCalculatorDecorator;
import services.complexCalculator.iCalculator;

import java.util.List;

public class ComplexCalculatorService implements iCalculatorService{
    iCalculator calculator;

    public ComplexCalculatorService() {
        this.calculator = new ComplexCalculatorDecorator(new ComplexCalculator(), new Logger());
    }

    /**
     * выполнить вычисления и вернуть результат
     * @param arguments список переменных и знак действия
     * @return результат вычисления
     */
    @Override
    public String getResult(List<String> arguments) {
        return null;
    }
}
