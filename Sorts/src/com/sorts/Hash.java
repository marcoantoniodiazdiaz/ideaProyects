package com.sorts;/*
    ██████╗ ██╗ █████╗ ███████╗
    ██╔══██╗██║██╔══██╗╚══███╔╝
    ██║  ██║██║███████║  ███╔╝ 
    ██║  ██║██║██╔══██║ ███╔╝  
    ██████╔╝██║██║  ██║███████╗
    ╚═════╝ ╚═╝╚═╝  ╚═╝╚══════╝
*/

import java.util.Arrays;
import java.util.Scanner;

public class Hash {

    static Scanner sc = new Scanner(System.in);

    static private String[] a;
    static private int t;

    public static void search(String[] arr, String[] a) {

        for (int i = 0; i < arr.length; i++) {
            String elemento = arr[i];
            int aux = Integer.parseInt(elemento) % 7;
            System.out.println("Indice " + aux + " : " + elemento);

            while (a[aux] != "-1") {
                aux++;
                System.out.println("Cambio en el indice " + (aux - 1) + " al indice " + aux);

                aux %= t;

            }
            a[aux] = elemento;
        }
        show();

    }

    public static void show() {
        int cont = 0, i, j;
        for (int k = 0; k < 1; k++) {
            cont += 8;

            System.out.println();
            for (int l = cont - 8; l < cont; l++) {
                System.out.format("| %3s " + " ", l);

            }
            System.out.println("|");

            System.out.println();
            for (int l = cont - 8; l < cont; l++) {

                if (a[l].equals("-1")) {
                    System.out.println("|    ");

                } else {
                    System.out.print(String.format("| %3s " + " ", a[l]));
                }

            }
            System.out.println("|");

            System.out.println();

        }

    }
    public static String find(String elemento) {
        int aux = Integer.parseInt(elemento) % 7;
        int cont = 0;
        while (a[aux] != "-1") {
            if (a[aux].equals(elemento)) {
                System.out.println("El elemento " + elemento + " esta en el indice " + aux);
                return a[aux];
            }
            aux++;
            aux %= t;
            cont++;
            if (cont > 7) {
                break;
            }

        }
        return null;
    }

    public void execute() {

        try {
            String[] arr = new String[100];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = "" + ((int)(Math.random() * 100) + 1);
            }


            Hash.search(arr, Hash.a);
            Hash.show();
            System.out.print("Elemento a buscar: ");
            String buscar = sc.next();

            String buscado = Hash.find(buscar);

            if (buscado == null) {
                System.out.println("No encontrado");
            }

        } catch (NullPointerException e) {}
    }
}
