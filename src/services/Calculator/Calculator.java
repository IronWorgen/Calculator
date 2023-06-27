package services.Calculator;

public final class Calculator implements iCalculable {

    private double primaryArg;

    public Calculator(double primaryArg) {
        this.primaryArg = primaryArg;
    }

    @Override
    public iCalculable sum(double arg) {
        primaryArg += arg;
        return this;
    }

    @Override
    public iCalculable multi(double arg) {
        primaryArg *= arg;
        return this;
    }

    @Override
    public iCalculable subtraction(double arg) {
        primaryArg -= arg;
        return this;
    }

    @Override
    public iCalculable division(double arg) {
        primaryArg /= arg;
        return this;
    }

    @Override
    public double getResult() {
        return primaryArg;
    }
}