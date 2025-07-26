package com.hcl.stream;
import java.lang.System;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.stream;

/*
Stream is a sequence of elements that can be processed in parallel or sequentially.
Streams can be created from collections, arrays, or I/O channels.
Streams support functional-style operations such as map, filter, and reduce.
Streams are not data structures, but rather a view of data that allows for functional-style operations.
Streams are lazy, meaning that they do not perform any computation until a terminal operation is invoked.
Streams can be infinite, meaning that they can generate an unbounded number of elements.
Streams can be used to process large data sets in a more efficient and readable way.

 */
public class StreamCreation {
    public static void main(String[] args) {
        List<String> listOfStrings = List.of("apple", "banana", "cherry", "date", "elderberry");
        Stream<String> stream;
        stream = listOfStrings.stream();
        System.out.println("stream  from list is ");
        stream.forEach((element) -> {
            System.out.println(element);
        });
        //Stream can only works on collection or array
        String[] arrayOfStrings = {"apple", "banana", "cherry", "date", "elderberry"};
        Stream<String> streamFromArray = stream(arrayOfStrings);
        System.out.println("stream from array is ");
        streamFromArray.forEach((element) -> {
            System.out.println(element);
        });


    }
}
