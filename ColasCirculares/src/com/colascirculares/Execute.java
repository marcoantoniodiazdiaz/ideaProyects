/*
    ██████╗ ██╗ █████╗ ███████╗
    ██╔══██╗██║██╔══██╗╚══███╔╝
    ██║  ██║██║███████║  ███╔╝ 
    ██║  ██║██║██╔══██║ ███╔╝  
    ██████╔╝██║██║  ██║███████╗
    ╚═════╝ ╚═╝╚═╝  ╚═╝╚══════╝
*/

package com.colascirculares;

import java.util.Scanner;

public class Execute {

    ColaCircular cola = new ColaCircular();
    Scanner sc = new Scanner(System.in);

    public void menu() {
        while (true) {
            String opc;
            System.out.println("" +
                    "════════════════ MENU ════════════════ \n" +
                    "1. Encolar\n" +
                    "2. Desencolar\n" +
                    "3. Salir \n");
            while (true) {
                System.out.print("Ingresa una opcion: ");
                opc = sc.next();
                if (opc.matches("^[1-3]$")) break;
            }

            switch (opc.charAt(0)) {
                case '1':
                    System.out.print("Ingresa un valor: ");
                    cola.push(sc.next());
                    cola.print();
                    break;
                case '2':
                    System.out.println("-> " + cola.pop());
                    cola.print();
                    break;
                case '3':  return;
            }
        }
    }
}
