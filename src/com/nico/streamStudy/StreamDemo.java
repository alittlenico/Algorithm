package com.nico.streamStudy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author liuyi
 * @version 1.0
 * @description: TODO
 * @date 2022/7/18 17:02
 */
public class StreamDemo {

    @Test
    public void test() {
        Stream.iterate(0, n -> n + 2).limit(5);
    }

    @Test
    public void test1() {
//        List<String> wordList = Arrays.asList("Hello", "World");
//        List<String> strList = wordList.stream()
//                .map(w -> w.split(" "))
//                .flatMap(Arrays::stream)
//                .distinct()
//                .collect(Collectors.toList());
//       Arrays.asList(1, 2, 3, 4, 5).parallelStream().forEach(System.out::println);
//       Arrays.asList(1, 2, 3, 4, 5).stream().forEach(System.out::println);
       List<Integer> list = Arrays.asList(1, 2, 3, 4);
        IntSummaryStatistics collect = list.stream().collect(Collectors.summarizingInt(Integer::intValue));
        double average = collect.getAverage();
        System.out.println(average);

    }


}
