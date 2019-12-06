/*
    ██████╗ ██╗ █████╗ ███████╗
    ██╔══██╗██║██╔══██╗╚══███╔╝
    ██║  ██║██║███████║  ███╔╝ 
    ██║  ██║██║██╔══██║ ███╔╝  
    ██████╔╝██║██║  ██║███████╗
    ╚═════╝ ╚═╝╚═╝  ╚═╝╚══════╝
*/

package com.pilas;

import java.util.Scanner;

public class Execute {

    Scanner sc = new Scanner(System.in); // Declaracion de Scanner
    private int n = 5; // Longitud de la pila
    private String pila[] = new String[n]; // Declaracion de la pila
    private int cima = 0; // Variable que indica la cima

    public void menu() { // Metodo que inicia el menu
        while (true) { // Bucle infinito hasta que se rompa con 'return'
            String opc; // Variable donde se guarda la opcion del menu
            System.out.println("" + // Impresion del menu
                    "════════════════ MENU ════════════════ \n" +
                    "1. Push \n" +
                    "2. Pop \n" +
                    "3. Salir \n");
            while (true) { // Bucle infinito hasta que se rompa con 'break'
                System.out.print("Ingresa una opcion: ");
                opc = sc.next();
                if (opc.matches("^[1-3]$")) break; // Comprobacion de la opcion ingresada usando regex
            }

            switch (opc.charAt(0)) { // Switch de opciones
                case '1': push(); break; // Ejecuta metodo Push
                case '2': pop(); break; // Ejecuta metodo Pop
                case '3': return; // Termina el metodo, el programa termina
            }
        }
    }

    private void push() { // Declaracion del metodo push
        if (!isFull()) { // Comprobacon si el arreglo no esta lleno
            System.out.print("Insertar elemento: ");
            pila[cima] = sc.next(); // Se inserta en la posicion 'cima' lo que se ingrese en el teclado
            cima ++; // Cima aumenta 1
            printQueue(); // Imprime la pila
        } else { // Si el arreglo esta lleno se ejecuta la siguiente linea
            System.out.println("Pila llena");
        }
    }

    private String pop() { //  Declaracion del metodo Pop
        if (!isEmpty()) { // Comprobacion que el arreglo no este vacio
            String data = pila[cima-1]; // Se guarda en la variale 'data' lo que exista en la posicion 'cima' menos 1
            pila[cima-1] = null; // En la posicion donde se extrajo el valor, se setea null
            cima --; // Se reduce 'cima' en 1
            printQueue(); // Se imprime la pila
            return data; // El metodo retorna el valor guardado
        } else { // En caso de estar vacia, se ejecuta la siguiente linea
            System.out.println("Pila vacia");
            return "";
        }
    }

    private void printQueue() { // Metodo que imprime el arreglo
        String rotate[] = rotar(pila); // Rota el arreglo y lo guarda en un arreglo local
        for (int i = 0; i < n; i++) { // For de barrido completo
            if (rotate[i] != null) { // No imprime si el campo es null
                System.out.println("-> " + rotate[i]);
            }
        }
    }

    private boolean isEmpty() {
        return cima <= 0;
    } // Condicion que verifica si el arreglo esta vacio

    private boolean isFull() {
        return cima == n;
    }// Condicion que verifica si el arreglo esta lleno

    private String[] rotar(String[] pila) { // Metodo que invierte el arreglo
        String invertido[] = new String[5];
        int x = n-1;

        for (int i = 0; i < n; i++) {
            invertido[i] = pila[x];
            x --;
        }

        return invertido; // Retorna el arreglo invertido
    }
}
