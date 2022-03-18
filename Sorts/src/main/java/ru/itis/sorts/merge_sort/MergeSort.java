package ru.itis.sorts.merge_sort;

import ru.itis.sorts.Sorting;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class MergeSort<T> implements Sorting<T> {

    private static final boolean DEBUG = false;

    private void merge(T[] a, T[] l, T[] r, int left, int right, Comparator<? super T> c) {
        int i = 0, j = 0, k = 0;
        if (DEBUG) {
            System.out.println("BEFORE MERGE:");
            System.out.println(Arrays.toString(a));
        }
        while (i < left && j < right) {
            if (c.compare(l[i], r[j]) < 0) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
        if(DEBUG) {
            System.out.println("AFTER MERGE:");
            System.out.println(Arrays.toString(a));
        }
    }

    private void mergeSort(T[] a, int n, Comparator<? super T> c) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;

        // Нельзя просто так взять, и сделать new T() или new T[]
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
        mergeSort(l, mid, c);
        mergeSort(r, n - mid, c);

        merge(a, l, r, mid, n - mid, c);
    }

    @Override
    public void sort(T[] array, Comparator<? super T> c) {
        mergeSort(array, array.length, c);
    }
}
