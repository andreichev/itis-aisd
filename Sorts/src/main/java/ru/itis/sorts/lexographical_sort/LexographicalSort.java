package ru.itis.sorts.lexographical_sort;

import java.util.*;

public class LexographicalSort {
    /// m - количество разрядов в одном элементе
    /// A - количество символов в алфавите
    static void sort(int[] array, int m, int A) {
        int n = array.length;
        Map<Integer, LinkedList<Integer>> table = new HashMap<>();
        for (int i = 0; i < A; i++) {
            table.put(i, new LinkedList<>());
        }

        // Шаг 1
        for (int i = 0; i < n; i++) {
            table.get(array[i] % 10).add(array[i]);
        }

        // Шаг 2 - 3
        for (int s = m - 1; s > 0; s--) {
            for (int i = 0; i < A; i++) {
                LinkedList<Integer> currentList = table.get(i);
                LinkedList<Integer> list = new LinkedList<>(currentList);
                currentList.clear();
                for (Integer x : list) {
                    int digit = (int) (x / (Math.pow(10, m - s)) % 10);
                    table.get(digit).add(x);
                }
            }
        }

        System.out.println(table);
    }

    public static void main(String[] args) {
        int[] array = {314 , 214 , 566 , 134 , 856 , 114 , 624};
        sort(array, 3, 10);
    }
}
