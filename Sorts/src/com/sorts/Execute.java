package com.sorts;/*
    ██████╗ ██╗ █████╗ ███████╗
    ██╔══██╗██║██╔══██╗╚══███╔╝
    ██║  ██║██║███████║  ███╔╝ 
    ██║  ██║██║██╔══██║ ███╔╝  
    ██████╔╝██║██║  ██║███████╗
    ╚═════╝ ╚═╝╚═╝  ╚═╝╚══════╝
*/

import java.util.Calendar;
import java.util.Scanner;

public class Execute {

    Calendar calendar = null;
    Double i;
    Double f;

    public static int arr[];
    Scanner sc = new Scanner(System.in);

    public void menu() {

        definirArreglo();

        while (true) {
            String opc;
            System.out.println("" +
                    "════════════════ MENU ════════════════ \n" +
                    "1. BubbleSort \n" +
                    "2. QuickSort\n" +
                    "3. RadixSort\n" +
                    "4. MergeSort\n" +
                    "5. ShellSort\n" +
                    "6. HeapSort\n" +
                    "7. Hash\n" +
                    "8. Sequential Search\n" +
                    "9. Binary Search\n" +
                    "A. Definir arreglo\n" +
                    "B. Ver Arreglo\n" +
                    "C. Salir \n");
            while (true) {
                System.out.print("Ingresa una opcion: ");
                opc = sc.next();
                if (opc.matches("^[1-9ABC]$")) break;
            }

            switch (opc.charAt(0)) {
                case '1':
                    calendar = Calendar.getInstance();
                    i = (double) calendar.getTimeInMillis();
                    new BubbleSort().bubbleSort(arr);
                    calendar = Calendar.getInstance();
                    f = (double) calendar.getTimeInMillis();
                    System.out.println("Tiempo: " + (f-i)/1000 + "s");
                    break;
                case '2':
                    calendar = Calendar.getInstance();
                    i = (double) calendar.getTimeInMillis();
                    new QuickSort().quicksort(arr);
                    calendar = Calendar.getInstance();
                    f = (double) calendar.getTimeInMillis();
                    System.out.println("Tiempo: " + (f-i)/1000 + "s");
                    break;
                case '3':
                    calendar = Calendar.getInstance();
                    i = (double) calendar.getTimeInMillis();
                    new RadixSort().sort(arr);
                    calendar = Calendar.getInstance();
                    f = (double) calendar.getTimeInMillis();
                    System.out.println("Tiempo: " + (f-i)/1000 + "s");
                    break;
                case '4':
                    calendar = Calendar.getInstance();
                    i = (double) calendar.getTimeInMillis();
                    new MargeSort().sort(arr, arr.length);
                    calendar = Calendar.getInstance();
                    f = (double) calendar.getTimeInMillis();
                    System.out.println("Tiempo: " + (f-i)/1000 + "s");
                    break;
                case '5':
                    calendar = Calendar.getInstance();
                    i = (double) calendar.getTimeInMillis();
                    new ShellSort().sort(arr);
                    calendar = Calendar.getInstance();
                    f = (double) calendar.getTimeInMillis();
                    System.out.println("Tiempo: " + (f-i)/1000 + "s");
                    break;
                case '6':
                    calendar = Calendar.getInstance();
                    i = (double) calendar.getTimeInMillis();
                    new HeapSort().heapsort(arr);
                    calendar = Calendar.getInstance();
                    f = (double) calendar.getTimeInMillis();
                    System.out.println("Tiempo: " + (f-i)/1000 + "s");
                    break;
                case '7': new Hash().execute(); break;
                case '8': busquedaSecuencial(); break;
                case '9': busquedaBinaria(); break;
                case 'A': definirArreglo(); break;
                case 'B': printArr(); break;
                case 'C': return;
            }
        }
    }

    private void busquedaSecuencial() {
        System.out.print("Ingresa el valor a buscar: ");
        int find = sc.nextInt();

        new Search().busquedaSecuencial(arr, find);
    }

    private void busquedaBinaria() {
        System.out.print("Ingresa el valor a buscar: ");
        int find = sc.nextInt();

        new Search().busquedaBinaria(arr, find);
    }

    private void definirArreglo() {
        System.out.print("Aleatorio: 1. Si *. Nope. -> ");
        int al = sc.nextInt();
        int len;

        if (al == 1) {
            System.out.print("Longitud de arreglo: ");
            len = sc.nextInt();
            arr = new int[len];
            for (int i = 0; i < arr.length; i++) {
                arr[i] =  (int) (Math.random() * 100) + 1;
            }
            System.out.println("Arreglo generado");
        } else {
            System.out.print("Longitud de arreglo: ");
            len = sc.nextInt();
            arr = new int[len];
            for (int i = 0; i < arr.length; i++) {
                System.out.print("Ingresa un valor: ");
                arr[i] = sc.nextInt();
            }
        }
    }

    public void printArr() {
        System.out.println("Ordenado correctamente");
        for (int n : arr) {
            System.out.println("-" + n);
        }
    }
}
