package com.se.stream;

import java.util.Iterator;
import java.util.stream.Stream;

/**
 * client
 *
 * @author sukbear
 * @create 2018-12-07 19:20
 */
public class Client {
    public static void main(String[] args) {
        Stream.iterate(0, n -> n + 2).limit(10).forEach(System.out::println);
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]}).limit(20).map(t->t[0]).forEach(System.out::println);
    }
}
