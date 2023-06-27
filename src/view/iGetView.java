package view;

import java.util.List;

public interface iGetView {
    /**
     * отобразить окно интерфейса
     */
    void showWindow();

    /**
     *
     * @return список всех чисел введенных пользователем
     */
    List<String> getArguments();

    /**
     * вывести сообщение об ошибке
     * @param errorMessage  текст сообщения
     */
    void showErrorWindow(String errorMessage);

    /**
     * показать результат выполнения операции пользователю
     * @param resultStr результат
     */
    void setResult(String resultStr);


}
