package com.sorts;/*
    ██████╗ ██╗ █████╗ ███████╗
    ██╔══██╗██║██╔══██╗╚══███╔╝
    ██║  ██║██║███████║  ███╔╝ 
    ██║  ██║██║██╔══██║ ███╔╝  
    ██████╔╝██║██║  ██║███████╗
    ╚═════╝ ╚═╝╚═╝  ╚═╝╚══════╝
*/

public class MargeSort {
    public void sort(int[] arr, int n) {
        if (n < 2) {
            return;
        }
        int center = n / 2;
        int[] left = new int[center];
        int[] right = new int[n - center];

        for (int i = 0; i < center; i++) {
            left[i] = arr[i];
        }
        for (int i = center; i < n; i++) {
            right[i - center] = arr[i];
        }
        sort(left, center);
        sort(right, n - center);

        merge(arr, left, right, center, n - center);
    }

    private void merge(int[] a, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;

        while (i < left && j < right) {
            if (l[i] <= r[j]) {
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
    }
}
