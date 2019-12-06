package com.company;

import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    static Execute exe = new Execute();

    public static void main(String[] args) {
        System.out.print("Ingresa un numero maximo: ");
        int n = Integer.parseInt(sc.next());
        for (int i = 0; i < n; i++) {
            System.out.print(exe.fibonacci(i) + ", ");
        }
    }
}
