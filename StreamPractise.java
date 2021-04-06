package com.ishm.codingchallenge.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPractise {

    public static void main(String[] args) {
        IntStream
                .range(1,10)
                .skip(5)
                .forEach((x) -> System.out.print(x));

        System.out.println();

        Stream.of("India","US","Africa")
                .sorted()
                .findFirst() // terminal operation
                .ifPresent((x) -> System.out.println(x)); // null handler n throws exception

        String[] items = {"Toysrus","Kohls","Target","Titan","Trader Joe","Walmart"};
        Stream.of(items)
                .filter((x) -> x.startsWith("T"))
                .sorted()
                .forEach((x) -> System.out.print(x + " "));
        System.out.println();

        Arrays.stream(items)
                .map((c) -> c.toLowerCase())
                .filter((c) -> c.startsWith("t"))
                .sorted()
                .forEach((c) -> System.out.print(c+" "));


        List<Employee> list = new ArrayList<>();
        System.out.println("List Streaming");
        Employee e1 = new Employee("Hari","Ilaya", Arrays.asList("City1","City2"),26);
        Employee e2 = new Employee("Ad","Lincoln", Arrays.asList("City1","City3"),32);
        Employee e3 = new Employee("Ad","Kalam", Arrays.asList("City4","City5"),38);
        list.add(e1);list.add(e2);list.add(e3);

        list.stream()
                .filter(emp -> emp.getCities().contains("City1"))
                .map(Employee::getCities)
                .forEach(emp -> System.out.println(emp.toString()));

    }
}
