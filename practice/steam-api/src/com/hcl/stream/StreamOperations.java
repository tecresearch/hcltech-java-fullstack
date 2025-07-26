package com.hcl.stream;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamOperations {
    public static void main(String[] args) {
        List<Integer> numbers=Arrays.asList(1,2,3,4,5,6,7,8,9,0);
        List<Integer> squares=numbers.stream()
                .map(n->n*n)
                .collect(Collectors.toList());
        System.out.println("Squares"+squares);

        List<Integer> evenNumber=numbers.stream()
                .filter(n->n%2==0)
                .collect(Collectors.toList());
        System.out.println("evenNumber"+evenNumber);

        List<Integer> oddNumber=numbers.stream()
                .filter(n->n%2==1)
                .collect(Collectors.toList());
        System.out.println("oddNumber"+oddNumber);

        List<Integer> dublicateNumbers=Arrays.asList(1,2,3,4,5,6,7,8,9,0);
        List<Integer> result=  dublicateNumbers.stream()
                .distinct().collect(Collectors.toList());
        System.out.println("result"+result);
        List<String> name=List.of("Brijesh Nishad","Raushan Shrivastav","Shristh Dev");
        List<String> subString=name.stream()
                                   .flatMap(word->IntStream.range(0,word.length()-1)
                        .mapToObj(i->word.substring(i,i+2)))
                        .toList();
        System.out.println("subString"+subString);

        boolean res=numbers.stream().allMatch(n->n%2==0);
        System.out.println("res"+res);

        int allSum=numbers.stream().reduce(0, Integer::sum);
        System.out.println("allSum"+allSum);
        int minValue=numbers.stream().reduce(Integer.MAX_VALUE,(a,b)->a<b?a:b);
        System.out.println("minValue"+minValue);
        int maxValue=numbers.stream().reduce(Integer.MIN_VALUE,(a,b)->a>b?a:b);
        System.out.println("maxValue "+maxValue);

        Stream<Integer> iterated=Stream.iterate(1,n->n+1)
            .limit(5);
        iterated.forEach(System.out::println);


        Integer[] array = {15, 24, 3, 46, 56, 6, 7, 8, 9, 10};
        Stream<Integer> arrayStream = Arrays.stream(array);
        List<Integer> sortedArray = arrayStream.sorted().collect(Collectors.toList());
        System.out.println("Sorted Array: " + sortedArray);
        //use iterate for list
        List<Integer> list = Arrays.asList(15, 24, 3, 46, 56, 6, 7, 8, 9, 10);
        Stream<Integer> listStream = list.stream();
        List<Integer> sortedList = listStream.sorted().collect(Collectors.toList());
        System.out.println("Sorted List: " + sortedList);

        //use sorted with comparator
        List<String> names = Arrays.asList("Brijesh", "Raushan", "Shristh", "Dev");
        List<String> sortedNames = names.stream()
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());
        System.out.println("Sorted Names by Length: " + sortedNames);




    }
}
