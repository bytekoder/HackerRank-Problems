package com.bytekoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by bshekhawat
 */
public class Java8 {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("Mercedes");
        list.add("BMW");
        list.add("Lamborghini");
        list.add("Ferrari");

        int count = 0;

        for (String cars : list) {
            if (cars.equals("Ferrari")) {
                count++;
            }
        }

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();
            if (s.equals("Ferrari")) {
                count++;
            }
        }

        long counter = list.stream().filter(s -> s.equals("Ferrari")).count();

        list.stream().filter(s -> {
            System.out.println(s);
            return s.equals("Ferrari");
        }).count();

        System.out.println(counter);

        System.out.println(Stream.of(1,2,3).reduce(0, (acc, element) -> acc + element).intValue());
    }
}
