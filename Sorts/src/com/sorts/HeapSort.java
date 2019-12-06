/*
    ██████╗ ██╗ █████╗ ███████╗
    ██╔══██╗██║██╔══██╗╚══███╔╝
    ██║  ██║██║███████║  ███╔╝ 
    ██║  ██║██║██╔══██║ ███╔╝  
    ██████╔╝██║██║  ██║███████╗
    ╚═════╝ ╚═╝╚═╝  ╚═╝╚══════╝
*/

package com.sorts;

public class HeapSort {

    public void heapsort(int[] arr) {
        final int n = arr.length;
        for(int nodo = n/2; nodo>=0; nodo--) monticulo(arr, nodo, n - 1);
        for(int nodo = n-1; nodo>=0; nodo--) {
            int aux = arr[0];
            arr[0]    = arr[nodo];
            arr[nodo] = aux;
            monticulo(arr, 0, nodo - 1);
        }
    }

    public void monticulo(int[] arr, int nodo, int end) {
        int left = 2 * nodo + 1;
        int right = left + 1;
        int mayor;
        if (left > end) return;
        if (right > end) mayor = left;
        else mayor = arr[left] > arr[right] ? left : right;
        if (arr[nodo] < arr[mayor]) {
            int aux = arr[nodo];
            arr[nodo] = arr[mayor];
            arr[mayor]  = aux;
            monticulo(arr, mayor, end);
        }
    }

}
