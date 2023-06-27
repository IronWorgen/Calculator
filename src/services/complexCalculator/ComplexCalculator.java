package services.complexCalculator;

public class ComplexCalculator implements iCalculator{
    /**
     * сложение
     * @param num1
     * @param num2
     * @return
     */
    @Override
    public ComplexNum sum(ComplexNum num1, ComplexNum num2) {
        double resultX1 = num1.getX1()+num2.getX1();
        double resultX2 = num1.getX2()+num2.getX2();

        ComplexNum result = new ComplexNum(resultX1,resultX2);
        return result;
    }

    /**
     * вычитание
     * @param num1
     * @param num2
     * @return
     */
    @Override
    public ComplexNum subtraction(ComplexNum num1, ComplexNum num2) {
        double resultX1 = num1.getX1()-num2.getX1();
        double resultX2 = num1.getX2()-num2.getX2();

        ComplexNum result = new ComplexNum(resultX1,resultX2);
        return result;
    }
    /**
     * умножение
     * @param num1
     * @param num2
     * @return
     */
    @Override
    public ComplexNum multi(ComplexNum num1, ComplexNum num2) {
        double resultX1 = num1.getX1()*num2.getX1()-num1.getX2()*num2.getX2();
        double resultX2 = num1.getX2()*num2.getX1() + num1.getX1()*num2.getX2();

        ComplexNum result = new ComplexNum(resultX1,resultX2);
        return result;
    }
    /**
     * деление
     * @param num1
     * @param num2
     * @return
     */

    @Override
    public ComplexNum division(ComplexNum num1, ComplexNum num2) {
        double a = num1.getX1(); //num1 (a+ib)
        double b = num1.getX2(); //num1 (a+ib)
        double c = num2.getX1(); //num2 (c+id)
        double d = num2.getX2(); //num2 (c+id)

        double resultX1 = (a*c + b*d)/(c*c + d*d);
        double resultX2 = (b*c - a*d)/(c*c + d*d);

        ComplexNum result = new ComplexNum(resultX1,resultX2);
        return result;

    }


}
