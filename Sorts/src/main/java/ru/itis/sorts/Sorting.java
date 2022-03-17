package ru.itis.sorts;

import java.util.Comparator;

public interface Sorting<T> {
    void sort(T[] array, Comparator<? super T> c);
}
