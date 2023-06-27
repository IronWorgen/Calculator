package services;

import java.util.List;

public interface iCalculatorService {
    /**
     * выполнить вычисления и вернуть результат
     * @param arguments список переменных и знак действия
     * @return результат вычисления
     */
    String getResult(List<String> arguments);
}
