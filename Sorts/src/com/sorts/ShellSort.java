package com.sorts;/*
    ██████╗ ██╗ █████╗ ███████╗
    ██╔══██╗██║██╔══██╗╚══███╔╝
    ██║  ██║██║███████║  ███╔╝ 
    ██║  ██║██║██╔══██║ ███╔╝  
    ██████╔╝██║██║  ██║███████╗
    ╚═════╝ ╚═╝╚═╝  ╚═╝╚══════╝
*/

public class ShellSort {
    public void sort(int arr[]) {
        int n = arr.length;

        for (int aux = n / 2; aux > 0; aux /= 2) {
            for (int i = aux; i < n; i++) {
                int key = arr[i];
                int j = i;
                while (j >= aux && arr[j - aux] > key) {
                    arr[j] = arr[j - aux];
                    j -= aux;
                }
                arr[j] = key;
            }
        }
    }
}
