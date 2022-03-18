package ru.itis.sorts.bubble_sort;

import ru.itis.sorts.Sorting;

import java.util.Comparator;

public class BubbleSort <T> implements Sorting<T> {
    @Override
    public void sort(T[] array, Comparator<? super T> c) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if(c.compare(array[i],array[j]) > 0){
                    T n = array[j];
                    array[j] = array[i];
                    array[i] = n;
                }
            }
        }
    }
}
