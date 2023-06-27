package services.complexCalculator;

import services.Calculator.Logger;

public class ComplexCalculatorDecorator implements iCalculator {
    iCalculator calculator;
    Logger logger;

    public ComplexCalculatorDecorator(iCalculator calculator, Logger logger) {
        this.calculator = calculator;
        this.logger = logger;
    }

    @Override
    public ComplexNum sum(ComplexNum num1, ComplexNum num2) {
        logger.log(String.format("Первое число: %s \n второе число: %s", num1.toString(), num2.toString()));
        ComplexNum result = calculator.sum(num1, num2);
        logger.log("Вызова метода sum произошел");
        logger.log(String.format("Получение результата: %s ", result.toString()));
        return result;
    }

    @Override
    public ComplexNum subtraction(ComplexNum num1, ComplexNum num2) {
        logger.log(String.format("Первое число: %s \n второе число: %s", num1.toString(), num2.toString()));
        ComplexNum result = calculator.subtraction(num1, num2);
        logger.log("Вызова метода subtraction произошел");
        logger.log(String.format("Получение результата: %s ", result.toString()));
        return result;
    }

    @Override
    public ComplexNum multi(ComplexNum num1, ComplexNum num2) {
        logger.log(String.format("Первое число: %s \n второе число: %s", num1.toString(), num2.toString()));
        ComplexNum result = calculator.multi(num1, num2);
        logger.log("Вызова метода multi произошел");
        logger.log(String.format("Получение результата: %s ", result.toString()));
        return result;
    }

    @Override
    public ComplexNum division(ComplexNum num1, ComplexNum num2) {
        logger.log(String.format("Первое число: %s \n второе число: %s", num1.toString(), num2.toString()));
        ComplexNum result = calculator.division(num1, num2);
        logger.log("Вызова метода division произошел");
        logger.log(String.format("Получение результата: %s ", result.toString()));
        return result;
    }
}
