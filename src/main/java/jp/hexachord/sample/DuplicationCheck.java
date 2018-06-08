package jp.hexachord.sample;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.google.common.collect.ImmutableList;

public class DuplicationCheck {

    public static void main(String[] args) {
      List<String> list = ImmutableList.of("1", "2", "2", "3", "3", "3", "aaa", "aaa");
      List<String> duplication = list
              .stream()
              .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
              .entrySet()
              .stream()
              .filter(r -> r.getValue() > 1)
              .map(r -> r.getKey())
              .collect(Collectors.toList());
      System.out.println(duplication.toString());
    }
}
