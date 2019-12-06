/*
    ██████╗ ██╗ █████╗ ███████╗
    ██╔══██╗██║██╔══██╗╚══███╔╝
    ██║  ██║██║███████║  ███╔╝ 
    ██║  ██║██║██╔══██║ ███╔╝  
    ██████╔╝██║██║  ██║███████╗
    ╚═════╝ ╚═╝╚═╝  ╚═╝╚══════╝
*/

package com.company;

public class Execute {

    // FACTORIAL
    public int fact(int n) {
        if (n==1) return 1;
        return fact(n-1) * n;
    }

    // FIBONACCI
    public int fibonacci(int n) {
        if (n==0 || n==1) return n;
        return fibonacci(n-1) + fibonacci(n-2);
    }

    public int x(int n) {
        if (n == 1) return 1;
        return x(n-1) * n;
    }
}
