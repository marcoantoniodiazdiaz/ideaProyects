package com.sorts;/*
    ██████╗ ██╗ █████╗ ███████╗
    ██╔══██╗██║██╔══██╗╚══███╔╝
    ██║  ██║██║███████║  ███╔╝ 
    ██║  ██║██║██╔══██║ ███╔╝  
    ██████╔╝██║██║  ██║███████╗
    ╚═════╝ ╚═╝╚═╝  ╚═╝╚══════╝
*/

public class Search {

    public void busquedaSecuencial(int arr[], int find) {
        int ciclos = 0;
        for (int n : arr) {
            ciclos ++;
            if (n == find) {
                System.out.println("Encontrado");
                System.out.println("Ciclos: " + ciclos);
                return;
            }
        }
        System.out.println("No encotrado");
    }

    public void busquedaBinaria(int arr[], int find){
        int ciclos = 0;
        int n = arr.length;
        int centro, inf=0 ,sup=n-1;
        while(inf <= sup) {
            ciclos ++;
            centro = (sup + inf) / 2;
            if (arr[centro] == find) {
                System.out.println("Encontrado");
                System.out.println("Ciclos: " + ciclos);
                return;
            }
            else if(find < arr [centro] ){
                sup = centro - 1;
            }
            else {
                inf = centro + 1;
            }
        }
    }

}
