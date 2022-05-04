package org.example.streamapi;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MVP {

    /*
        Convert a List<String> to an object stream and for each element -> System,out.println.
     */

    public void printNames(List<String> names) {
//        names.forEach(name -> System.out.println(name));
        names.forEach(System.out::println);
    }

    /*
        Given a List<Integers>, return a List<Integer> with event numbers.
     */
    public List<Integer> returnEvenNumbers(List<Integer> numbers) {
//        List<Integer> evenNumbers = numbers
//                .stream()
//                .filter(number -> number%2 ==0)
//                .toList();
//        return evenNumbers;
        return numbers
                .stream()
                .filter(number -> number%2 ==0)
                .toList();
    }

    /*
        Given an int [], double the value of each int and return an int [].
    */
    public int[] doubleInts(int[] numbers) {
        return Arrays.stream(numbers)
                .map(number -> number*2)
                .toArray();
    }

    /*
        Given a String, return a List<String>, all caps.
     */
    public List<String> splitToAllCapsList(String input) {
        String[] arraySplitInput = input.split("");
        List<String> splitInput = Arrays.asList(arraySplitInput);
        return splitInput
                .stream()
                .map(s -> s.toUpperCase())
                .toList();

    }

    /*
    Given a list of animals:
     - filter the ones that start with a given letter
     - return sorted List<String>, all caps.
    */
    public List<String> filterByFirstLetterAndOrder(List<String> list, String letter) {
        return list
                .stream()
                .map(animal -> animal.toUpperCase())
                .filter(animal -> animal.startsWith(letter.toUpperCase()))
                .sorted()
                .toList();

    }

    /*
        Given a list of words, return elements that:
         - are shorter than the given number and
         - start with a given letter.
    */
    public List<String> filterWords(List<String> words, int maxLength, String firstLetter) {
        return words
                .stream()
                .filter(word -> word.length() < maxLength)
                .filter(word -> word.startsWith(firstLetter))
                .toList();
    }
}