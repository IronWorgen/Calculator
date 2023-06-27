package services.Calculator;

public interface iCalculable {
    iCalculable sum(double arg);
    iCalculable subtraction(double arg);
    iCalculable multi(double arg);
    iCalculable division(double arg);
    double getResult();
}
