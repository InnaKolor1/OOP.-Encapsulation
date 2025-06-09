
package org.skypro.skyshop.exception;

public class BestResultNotFound extends Exception{

    private final String name;

    public BestResultNotFound(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Для запроса " + name + " не нашлось статьи" + '}';
    }
}