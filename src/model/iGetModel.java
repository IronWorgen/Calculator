package model;

public interface iGetModel {
    /**
     * сохранить операцию в файле истории
     *
     * @param operation
     */
    void setHistory(String operation);

    /**
     * @param quantity количество последних операций
     * @return список выполненных операций
     */
    String[] getOperationHistory(int quantity);
}
