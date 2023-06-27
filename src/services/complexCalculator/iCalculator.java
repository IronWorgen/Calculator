package services.complexCalculator;

import services.Calculator.Calculator;
import services.Calculator.iCalculable;

public interface iCalculator {
    /**
     * сумма
     * @param num1 первое комплексное число
     * @param num2 второе комплексное число
     * @return
     */
    ComplexNum sum(ComplexNum num1, ComplexNum num2);
    /**
     * разность
     * @param num1 первое комплексное число
     * @param num2 второе комплексное число
     * @return
     */

    ComplexNum subtraction(ComplexNum num1, ComplexNum num2);
    /**
     * умножение
     * @param num1 первое комплексное число
     * @param num2 второе комплексное число
     * @return
     */

    ComplexNum multi(ComplexNum num1, ComplexNum num2);
    /**
     * деление
     * @param num1 первое комплексное число
     * @param num2 второе комплексное число
     * @return
     */

    ComplexNum division(ComplexNum num1, ComplexNum num2);

}
