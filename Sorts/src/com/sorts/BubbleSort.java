package com.sorts;/*
    ██████╗ ██╗ █████╗ ███████╗
    ██╔══██╗██║██╔══██╗╚══███╔╝
    ██║  ██║██║███████║  ███╔╝ 
    ██║  ██║██║██╔══██║ ███╔╝  
    ██████╔╝██║██║  ██║███████╗
    ╚═════╝ ╚═╝╚═╝  ╚═╝╚══════╝
*/

public class BubbleSort {
    int temp = 0;
    public void bubbleSort(int arr[]) {

        if (arr == null) {
            System.err.println("No definido");
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < (arr.length-i); j++) {
                if (arr[j - 1] > arr[j]) {
                    // Intercambio
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
