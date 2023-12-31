package services.complexCalculator;

import java.text.DecimalFormat;

public class ComplexNum {
    /**
     * действительная часть комплексного числа
     */
    private double x1;
    /**
     * мнимая часть комплексного числа
     */
    private double x2;

    public ComplexNum(double x1, double x2) {
        this.x1 = x1;
        this.x2 = x2;
    }

    public double getX1() {
        return x1;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public double getX2() {
        return x2;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("###.###");

        if (x2 == 0 && x1 == 0) {
            return "0";
        } else if (x2 == 0) {
            return decimalFormat.format(x1);
        } else if (x1 == 0) {

            return decimalFormat.format(x2) + "i";
        }

        if (x2 < 0) {
            return decimalFormat.format(x1) + " - " + decimalFormat.format(x2 * (-1)) + "i";
        }
        return decimalFormat.format(x1) + " + " + decimalFormat.format(x2) + "i";
    }
}
