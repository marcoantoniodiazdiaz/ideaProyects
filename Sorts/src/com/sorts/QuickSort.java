package com.sorts;/*
    ██████╗ ██╗ █████╗ ███████╗
    ██╔══██╗██║██╔══██╗╚══███╔╝
    ██║  ██║██║███████║  ███╔╝ 
    ██║  ██║██║██╔══██║ ███╔╝  
    ██████╔╝██║██║  ██║███████╗
    ╚═════╝ ╚═╝╚═╝  ╚═╝╚══════╝
*/

public class QuickSort {

    public void sort(int arr[], int start, int end) {

        if(start >= end) return;
        int pivote = arr[start];
        int left = start + 1;
        int right = end;
        while(left <= right){
            while(left <= end && arr[left] < pivote){
                left ++;
            }
            while(right > start && arr[right] >= pivote){
                right --;
            }
            if(left < right){
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }

        if(right > start){
            int temp = arr[start];
            arr[start] = arr[right];
            arr[right] = temp;
        }
        sort(arr, start, right-1);
        sort(arr, right+1, end);
    }

    public void quicksort(int sec[]) {
        sort(sec, 0, sec.length - 1);
    }
}
