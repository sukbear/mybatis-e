package com.se.trade;

import java.util.*;
import java.util.stream.Collectors;

/**
 * mian
 *
 * @author sukbear
 * @create 2018-12-07 17:32
 */
public class Main {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        List<Transaction> transactionList = transactions.stream().filter(t -> t.getYear() == 2011).sorted(Comparator.comparing(Transaction::getValue)).collect(Collectors.toList());
        System.out.println(transactionList);

        List<String> cityList = transactions.stream().map(t -> t.getTrader().getCity()).distinct().collect(Collectors.toList());
        Set<String> set = transactions.stream().map(t -> t.getTrader().getName()).distinct().collect(Collectors.toSet());
        System.out.println(cityList);

        List<Trader> traderList = transactions.stream().map(t -> t.getTrader()).filter(t ->t.getCity().equals("Cambridge")).distinct().sorted(Comparator.comparing(Trader::getName)).collect(Collectors.toList());

        String nameStr = transactions.stream().map(t -> t.getTrader().getName()).distinct().sorted().collect(Collectors.joining());
        System.out.println(nameStr);

        boolean bool = transactions.stream().anyMatch(t -> t.getTrader().getCity().equals("Milan"));
        System.out.println(bool);

        transactions.stream().filter(t -> "Cambridge".equals(t.getTrader().getCity())).map(Transaction::getValue).forEach(System.out::println);

        Optional<Integer> max = transactions.stream().map(Transaction::getValue).reduce(Integer::max);
        System.out.println(max.get());
        max = transactions.stream().map(Transaction::getValue).reduce(Integer::min);
        System.out.println(max.get());


        Optional<Transaction> opt = transactions.stream().min(Comparator.comparing(Transaction::getValue));

        System.out.println(opt.get());
    }
}
