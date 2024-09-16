package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HomeWorkTest {
    private HomeWork hw1 = new HomeWork();

    @Test
    public void partitionBy_ok_1() {
        Node<Integer> nodes = nodes();

        int result = hw1.partitionBy(nodes, i -> i == 1);

        Assertions.assertEquals(result, 1);
    }

    @Test
    public void partitionBy_ok_2() {
        Node<Integer> nodes = nodes();

        int result = hw1.partitionBy(nodes, i -> i % 2 == 0);

        Assertions.assertEquals(result, 2);
    }

    @Test
    public void partitionBy_ok_3() {
        Node<Integer> nodes = nodes();

        int result = hw1.partitionBy(nodes, i -> i > 10);

        Assertions.assertEquals(result, 0);
    }

    @Test
    public void partitionBy_negative_valueIsNull() {
        Node<Integer> nodes = new Node<>(1);
        nodes.setValue(null);

        int result = hw1.partitionBy(nodes, i -> i > 1);

        Assertions.assertEquals(result, 0);
    }

    @Test
    public void partitionBy_negative_predicateIsNull() {
        Node<Integer> nodes = new Node<>(1);
        nodes.setValue(null);

        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> hw1.partitionBy(nodes, null)
        );
    }

    @Test
    public void findNthElement_negative_listIsNull() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> hw1.findNthElement(null, 1)
        );
    }

    @Test
    public void findNthElement_negative_positionOutOfBound() {
        Node<Integer> nodes = nodes();

        Assertions.assertThrows(
                ArrayIndexOutOfBoundsException.class,
                () -> hw1.findNthElement(nodes, 10)
        );
    }

    @Test
    public void findNthElement_negative_positionLessThenZero() {
        Node<Integer> nodes = nodes();

        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> hw1.findNthElement(nodes, -1)
        );
    }

    @Test
    public void findNthElement_ok_1() {
        Node<Integer> nodes = nodes();

        Assertions.assertEquals(
                1,
                hw1.findNthElement(nodes, 0)
        );
    }

    @Test
    public void findNthElement_ok_2() {
        Node<Integer> nodes = nodes();

        Assertions.assertEquals(
                4,
                hw1.findNthElement(nodes, 3)
        );
    }

    @Test
    public void findNthElement_ok_3() {
        Node<Integer> nodes = nodes();

        Assertions.assertEquals(
                5,
                hw1.findNthElement(nodes, 4)
        );
    }

    private Node<Integer> nodes() {
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(3);
        Node<Integer> node4 = new Node<>(4);
        Node<Integer> node5 = new Node<>(5);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);

        return node1;
    }
}
