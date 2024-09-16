package org.example;

import java.util.function.Predicate;

/**
 * Сигнатуры методов в данном классе не менять
 */
public class HomeWork {

    /**
     * <h1>Задание 1.</h1>
     * Реализовать метод, который подсчитывает количество подходящих по условию узлов от 0 до N.
     * <br/>
     * Пример 1:
     * список 1, 2, 3, 4, 5
     * условие x < 4
     * ответ 3
     * <br/>
     * Пример 2:
     * список 1, 2, 3, 4, 5
     * условие x < 0
     * ответ 0
     *
     * @param list односвязный список
     * @param pred условие
     * @param <T>  - тип хранимых значений в списке
     * @return количество узлов от 0 до N, где N позиция на которой первый раз условие вернуло false
     */
    public <T> int partitionBy(Node<T> list, Predicate<T> pred) {
        if (pred == null) {
            throw new IllegalArgumentException("Condition is null");
        }

        int counter = 0;

        while(list != null) {
            if (list.getValue() != null && pred.test(list.getValue())) {
                counter++;
            }
            list = list.getNext();
        }

        return counter;
    }

    /**
     * <h1>Задание 2.</h1>
     * Реализовать метод поиска элемента на позиции N в переданном односвязном списке.
     *
     * @param list односвязный список
     * @param n    позиция искомого элемента
     * @param <T>
     * @return сам элемент
     */
    public <T> T findNthElement(Node<T> list, int n) {
        if (list == null) {
            throw new IllegalArgumentException("List is null");
        }

        if (n < 0) {
            throw new IllegalArgumentException("n is negative");
        }

        int index = -1;

        while (index != n) {
            if (index + 1 == n) {
                return list.getValue();
            } else {
                if (list.getNext() == null) {
                    throw new ArrayIndexOutOfBoundsException();
                }

                index++;
                list = list.getNext();
            }
        }

        throw new IllegalArgumentException("Couldn't find element at index " + n);
    }
}
