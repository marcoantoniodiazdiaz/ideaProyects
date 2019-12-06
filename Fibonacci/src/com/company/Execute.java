/*
    ██████╗ ██╗ █████╗ ███████╗
    ██╔══██╗██║██╔══██╗╚══███╔╝
    ██║  ██║██║███████║  ███╔╝ 
    ██║  ██║██║██╔══██║ ███╔╝  
    ██████╔╝██║██║  ██║███████╗
    ╚═════╝ ╚═╝╚═╝  ╚═╝╚══════╝
*/

package com.company;

import java.util.Scanner;

public class Execute {

    int cont = 0;

    private Scanner sc = new Scanner(System.in);

    public void execute() {
        int n = generateNumero();
        System.out.println(fibonacci(n));
    }

    public int fibonacci(int n) {
        if (n==0 || n==1) return n;
        return fibonacci(n-1) + fibonacci(n-2);
    }

    public int generateNumero() {
        while (true) {
            System.out.print("Ingresa cuantos valores quieres mostrar: ");
            String lr = sc.next();
            if (lr.matches("[0-9]{1,5}")) {
                return Integer.parseInt(lr);
            } else System.err.println("Campo numero no valido");
        }
    }
}
