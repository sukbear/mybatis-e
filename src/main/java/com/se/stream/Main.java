package com.se.stream;


import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * SDSD
 *
 * @author sukbear
 * @create 2018-12-07 17:19
 */

public class Main {
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));

        List<String> list = menu.stream()
                .filter(d -> {
                    System.out.println("filtering" + d.getName());
                    return d.getCalories() > 300;
                })
                .map(d -> {
                    System.out.println("mapping" + d.getName());
                    return d.getName();
                })
                .limit(3)
                .collect(Collectors.toList());
        list.stream().forEach(System.out::println);


        int calories = menu.stream().mapToInt(Dish::getCalories).sum();
        System.out.println(calories);

        IntStream intStream = menu.stream().mapToInt(Dish::getCalories);


        Stream<String> stream = Stream.of("Java 8", "Lambdas", "In", "Action");
        stream.map(String::toUpperCase).forEach(System.out::println);

        stream = Stream.empty();


        int[] nums = {1, 2, 3, 4, 5};
        int sum = Arrays.stream(nums).sum();

        long uniqueWords = 0L;
        try {
            Stream<String> lines = Files.lines(Paths.get("C:\\Users\\70475\\Desktop\\tet.txt"), Charset.defaultCharset());
            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" "))).distinct().count();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(uniqueWords);

        Map<Dish.Type, Long> typesCount = menu.stream().collect(Collectors.groupingBy(Dish::getType,Collectors.counting()));
        System.out.println(typesCount);

        Map<Boolean,List<Dish>> partitionedMenu = menu.stream().collect(Collectors.partitioningBy(Dish::isVegetarian));
        System.out.println(partitionedMenu.values());

    }


}
