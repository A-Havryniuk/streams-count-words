package com.efimchick.ifmo.streams.countwords;


import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Words {

    public String countWords(List<String> lines) {
        return lines
                .stream()
                .map(word -> word.replaceAll("[^a-zA-Zа-яА-Я]", " ").trim().toLowerCase())
                .flatMap(line -> Arrays.stream(line.split(" ")))
                .filter(word -> word.length() >= 4)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(i -> i.getValue() >= 10)
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .map(entry -> entry.getKey() + " - " + entry.getValue())
                .collect(Collectors.joining("\n"));


    }
}
