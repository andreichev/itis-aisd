package ru.itis.sorts;

import ru.itis.sorts.bubble_sort.BubbleSort;
import ru.itis.sorts.merge_sort.MergeSort;

public class SortingTest {
    static final int ARRAY_SIZE = 1000;
    static final boolean PRINT_ARRAY = false;

    static <T> void fillArray(RandomElementGenerator<T> generator, T[] array) {
        for(int i = 0; i < array.length; i++) {
            array[i] = generator.generate(i);
        }
    }

    static <T> void printArray(T[] array) {
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] array = new Integer[ARRAY_SIZE];
        fillArray(index -> (int) (Math.random() * 100), array);
        if(PRINT_ARRAY) {
            printArray(array);
        }

        long startTime = System.nanoTime();
        Sorting<Integer> sorting = new MergeSort<>();
        sorting.sort(array, Integer::compare);
        long endTime = System.nanoTime();

        if(PRINT_ARRAY) {
            printArray(array);
        }

        System.out.println((endTime - startTime) / 1000);
    }
}
