package ru.itis.sorts.merge_sort;

import ru.itis.sorts.Sorting;

import java.lang.reflect.Array;
import java.util.Comparator;

public class MergeSort<T> implements Sorting<T> {
    Comparator<? super T> c;

    private void merge(T[] a, T[] l, T[] r, int left, int right) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (c.compare(r[i], r[j]) <= 0) {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }

    private void mergeSort(T[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        T[] l = (T[]) Array.newInstance
                (a.getClass().getComponentType(), mid);
        T[] r = (T[]) Array.newInstance
                (a.getClass().getComponentType(), n - mid);

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
    }

    @Override
    public void sort(T[] array, Comparator<? super T> c) {
        this.c = c;
        mergeSort(array, array.length);
    }
}
