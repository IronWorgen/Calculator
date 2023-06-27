package services.complexCalculator;

import services.Calculator.Calculator;
import services.Calculator.iCalculable;

public interface iCalculator {
    ComplexNum sum(ComplexNum num1, ComplexNum num2);

    ComplexNum subtraction(ComplexNum num1, ComplexNum num2);

    ComplexNum multi(ComplexNum num1, ComplexNum num2);

    ComplexNum division(ComplexNum num1, ComplexNum num2);

}
