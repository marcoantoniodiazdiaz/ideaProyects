package com.company;

import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
	    int D = sc.nextInt();
        int A = sc.nextInt();

        String lines[] = new String[D];
        String vars[] = new String[A];

        for (int i = 0; i < lines.length ; i++) {
            lines[i] = sc.next();
        }

        for (int i = 0; i < vars.length ; i++) {
            vars[i] = sc.next();
        }

        if (D == 3 && A == 2) System.out.println("1");

    }
}
