package services.Calculator;


public class CalcDecorator implements iCalculable {
    private iCalculable oldCalc;
    private Logger logger;

    public CalcDecorator(iCalculable oldCalc, Logger log) {
        this.oldCalc = oldCalc;
        this.logger = log;
    }

    @Override
    public iCalculable sum(double arg) {
        double firstArg = oldCalc.getResult();
        logger.log(String.format("Первое значение калькулятора %f. Начало вызова метода sum с параметром %f", firstArg, arg));
        iCalculable result = oldCalc.sum(arg);
        logger.log(String.format("Вызова метода sum произошел"));
        return result;
    }

    @Override
    public iCalculable multi(double arg) {
        double firstArg = oldCalc.getResult();
        logger.log(String.format("Первое значение калькулятора %f. Начало вызова метода multi с параметром %f", firstArg, arg));
        iCalculable result = oldCalc.multi(arg);
        logger.log(String.format("Вызова метода multi произошел"));
        return result;
    }

    @Override
    public iCalculable subtraction(double arg) {
        double firstArg = oldCalc.getResult();
        logger.log(String.format("Первое значение калькулятора %f. Начало вызова метода subtraction с параметром %f", firstArg, arg));
        iCalculable result = oldCalc.subtraction(arg);
        logger.log(String.format("Вызова метода subtraction произошел"));
        return result;
    }

    @Override
    public iCalculable division(double arg) {

        double firstArg = oldCalc.getResult();
        logger.log(String.format("Первое значение калькулятора %f. Начало вызова метода division с параметром %f", firstArg, arg));
        iCalculable result = oldCalc.division(arg);
        logger.log(String.format("Вызова метода division произошел"));
        return result;

    }

    @Override
    public double getResult() {
        double result = oldCalc.getResult();
        logger.log(String.format("Получение результата %f", result));
        return result;
    }
}


