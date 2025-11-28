package org.example;

import java.util.Comparator;
import java.util.stream.Collectors;

public class StreamsPractice {


    /*
       Intermediate Operations

       - Filter
       - Map
       - FlatMap
       - Peek
       - Distinct
       - Sorted
       - Skip
       - Limit

       Terminal Operations

       - Collect
         - groupingBy
         - paritioningBy
       - Reduce
       - Min
       - Max

    */



    public static void filterInStreams() {
        // Filter even numbers from a list of integers
        var numbers = java.util.List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        var evenNumbers = numbers.stream().filter(n -> n%2 == 0).collect(Collectors.toList());

        System.out.println(evenNumbers);
    }

    public static void mapInStreams() {
        // Map a list of strings to their lengths
        var fruits = java.util.List.of("apple", "banana", "cherry");

        var fruitsInUppercase = fruits.stream().map(f -> f.toUpperCase()).toList();
        System.out.println(fruitsInUppercase);
    }

    public static void reduceInStreams() {
        // Reduce a list of integers to their sum
        var numbers = java.util.List.of(1, 2, 3, 4, 5);

        var sum = numbers.stream().reduce(10, (a,b) -> a+b);
        System.out.println(sum);
    }

    public static void flatMapInStreams() {
        var listOfLists = java.util.List.of(
                java.util.List.of(1, 2, 3),
                java.util.List.of(4, 5),
                java.util.List.of(6, 7, 8, 9)
        );

        var finalList = listOfLists.stream().flatMap(list -> list.stream()).map(n -> n*100).toList();

        System.out.println(finalList);
    }

    public static void peekInStreams() {
        var numbers = java.util.List.of(1, 2, 3, 4, 5);

        var processedNumbers = numbers.stream()
                .peek(n -> System.out.println("Original number: " + n))
                .map(n -> n * 2)
                .peek(n -> System.out.println("Doubled number: " + n))
                .toList();

        System.out.println(processedNumbers);
    }

    public static void distinctInStreams() {
        var numbers = java.util.List.of(1, 1, 2, 1, 2, 3, 4, 5);
        var finalList = numbers.stream().distinct().toList();
        System.out.println(finalList);
    }

    public static void sortedInStreams() {
        var numbers = java.util.List.of(1, 1, 2, 1, 2, 3, 4, 5);

        var ascList = numbers.stream().sorted().toList();
        System.out.println("Ascending Order: " + ascList);

        var descList = numbers.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println("Descending Order: " + descList);
    }

    public static void skipInStreams() {
        var numbers = java.util.List.of(1, 1, 2, 1, 2, 3, 4, 5);

        var skippedList = numbers.stream().skip(2).collect(Collectors.toList());
        System.out.println(skippedList);
    }

    public static void limitInStreams() {
        var numbers = java.util.List.of(1, 1, 2, 1, 2, 3, 4, 5);

        var limitedList = numbers.stream().limit(5).collect(Collectors.toList());
        System.out.println(limitedList);
    }


    static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    // Grouping Person by Age
    public static void groupingByInStreams() {
        var people = java.util.List.of(
                new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Charlie", 30),
                new Person("David", 25)
        );

        var groupedByAge = people.stream()
                .collect(Collectors.groupingBy(Person::getAge));

        System.out.println(groupedByAge);
    }

    public static void partitioningByInStreams() {
        var people = java.util.List.of(
                new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Charlie", 30),
                new Person("David", 25)
        );

        var partitionedByAge = people.stream()
                .collect(Collectors.partitioningBy(p -> p.getAge() > 28));

        System.out.println(partitionedByAge);
    }

    public static void minInStreams() {
        var numbers = java.util.List.of(5, 3, 8, 1, 4);

        var min = numbers.stream().min(Comparator.naturalOrder());
        System.out.println("Minimum: " + min.orElse(null));
    }

    public static void maxInStreams() {
        var numbers = java.util.List.of(5, 3, 8, 1, 4);

        var max = numbers.stream().max(Comparator.naturalOrder());
        System.out.println("Minimum: " + max.orElse(null));
    }

    public static void findFirstInStreams() {
        var numbers = java.util.List.of(5, 3, 8, 1, 4);

        var first = numbers.stream().findFirst();
        System.out.println("First Element: " + first.orElse(null));
    }

    public static void anyMatchInStreams() {
        var numbers = java.util.List.of(5, 3, 8, 1, 4);

        var anyMatch = numbers.stream().anyMatch(n -> n > 6);   // Return Boolean
        System.out.println("Any Match > 6: " + anyMatch);
    }

    public static void countInStreams() {
        var numbers = java.util.List.of(5, 3, 8, 1, 4);

        var count = numbers.stream().count();
        System.out.println("Count: " + count);
    }

    public static void sumInStreams() {
        var numbers = java.util.List.of(5, 3, 8, 1, 4);

        var sum = numbers.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Sum: " + sum);
    }

    public static void main(String[] args) {
        System.out.println("\nIntermediate Operations in Streams:\n");
        filterInStreams();
        mapInStreams();
        reduceInStreams();
        flatMapInStreams();
        peekInStreams();
        distinctInStreams();
        sortedInStreams();
        skipInStreams();
        limitInStreams();

        System.out.println("\nTerminal Operations in Streams:\n");

        groupingByInStreams();
        partitioningByInStreams();
        minInStreams();
        maxInStreams();
        findFirstInStreams();
        anyMatchInStreams();
        countInStreams();
        sumInStreams();
    }
}
