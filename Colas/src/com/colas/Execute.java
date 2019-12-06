package com.colas;/*
    ██████╗ ██╗ █████╗ ███████╗
    ██╔══██╗██║██╔══██╗╚══███╔╝
    ██║  ██║██║███████║  ███╔╝ 
    ██║  ██║██║██╔══██║ ███╔╝  
    ██████╔╝██║██║  ██║███████╗
    ╚═════╝ ╚═╝╚═╝  ╚═╝╚══════╝
*/

import java.util.Scanner;

public class Execute {

    Scanner sc = new Scanner(System.in); // Declaracion de Scanner
    Cola cola = new Cola(5); // Se instancia de la clase com.colas.Cola, con una longitud de 5

    public void menu() { // Ejecuta el metodo del menu
        while (true) { // Bucle infinito hasta que se rompa con 'return'
            String opc; // Variable de opcion
            System.out.println("" +
                    "════════════════ MENU ════════════════ \n" +
                    "1. Encolar \n" +
                    "2. Desencolar \n" +
                    "4. Salir \n");
            while (true) { // Bucle infinito hasta que se rompa con 'break'
                System.out.print("Ingresa una opcion: ");
                opc = sc.next(); // Lectura de la opcion
                if (opc.matches("^[1-3]$")) break; // Comprobacion de la opcion ingresada con regex
            }

            switch (opc.charAt(0)) { // Switch de opciones
                case '1': // Encolar
                    System.out.print("Ingresa un valor: ");
                    cola.encolar(sc.next()); // Llamada al metodo encolar
                    print();
                    break;
                case '2': // Desencolar
                    String valor = cola.desencolar(); // Llamada al metodo desencolar
                    print();
                    System.out.println("Valor -> " + valor);
                    break;
                case '3':  return;
            }
        }
    }

    private void print() { // Metodo que imprime todõ el arreglo
        for (String s : cola.getQueue()) {
            if (s != null) {
                System.out.println("-> " + s);
            }
        }
    }
}
