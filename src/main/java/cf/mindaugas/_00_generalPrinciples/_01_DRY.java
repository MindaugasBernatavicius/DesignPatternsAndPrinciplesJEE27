package cf.mindaugas._00_generalPrinciples;

import java.util.Comparator;

public class _01_DRY {
    public static void main(String[] args) {
        // DRY - don't repeat yourself
        // ... to not spread errors around
        // ... and upgrade the code easier
        // ... (not forget the places where you need to do that)

        // bubbleSortNotDry([], true)
    }

    // ... DRY with methods

    public static void bubbleSortNotDry(Person arr[], boolean reverse) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (reverse) {
                    if (arr[j].age > arr[j + 1].age) {
                        Person temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                } else {
                    if (arr[j].age < arr[j + 1].age) {
                        Person temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
        }
    }

    // ... splitting this method into two separate methods produces ever worse results

    public static void bubbleSortAsc(Person arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].age > arr[j + 1].age) {
                    Person temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void bubbleSortDesc(Person arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].age > arr[j + 1].age) {
                    Person temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // another reason why these methods are not DRY, because for each class
    // ... that you will want to sort you will need another method  or
    // ... you will want to sort by different property (or properties)
    // public static void bubbleSortDesc(Person arr[])
    // public static void bubbleSortDesc(Teacher arr[])
    // public static void bubbleSortPersonByNameDesc(Person arr[])

    private static void bubbleSortWithComparable(Comparable[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    var temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // ... even better - implement a sort that takes in Comparator and use lambdas
    private static <T> void bubbleSortWithComparable(Comparable<T>[] arr, Comparator<T> comp) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // if (arr[j].compareTo(arr[j + 1]) > 0) {
                if (comp.compare((T) arr[j], (T) arr[j + 1]) > 0) {
                    var temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}

class Employee implements Comparable<Employee> {
    @Override
    public int compareTo(Employee o) {
        return 0;
    }
}

// DRY with Classes

// 1. no inheritance
// class Tiger {
//     int age;
//     String name;
// }
//
// class Lion {
//     int age;
//     String name;
// }
//
// class Puma {
//     int age;
//     String name;
// }

// 2. w/ inheritance
class WildCat {
    int age;
    String name;
}

class Tiger extends WildCat { }

class Lion extends WildCat { }

class Puma extends WildCat { }