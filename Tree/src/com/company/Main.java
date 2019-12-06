package com.company;

import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
	// write your code here
        int m =  sc.nextInt();

        if (!(m >= 2 && m <= 1000000)) return;

        int edades[] = new int[m];
        int cont = 0;

        for (int i = 0; i < m; i++) {
            int p = sc.nextInt();
            if (!(p >= 1 && p <= 2)) return;

            int x = sc.nextInt();
            if (!(x >= 1 && x <= 10000000)) return;

            if (p == 1) {
                edades[i] = x;
            } else if (p == 2) {
                for (int n : edades) {
                    if (x >= n && n != 0) {
                        cont ++;
                    }
                }

                System.out.println(cont);
                cont = 0;
            }
        }
    }
}
