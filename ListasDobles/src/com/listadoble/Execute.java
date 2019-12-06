/*
    ██████╗ ██╗ █████╗ ███████╗
    ██╔══██╗██║██╔══██╗╚══███╔╝
    ██║  ██║██║███████║  ███╔╝ 
    ██║  ██║██║██╔══██║ ███╔╝  
    ██████╔╝██║██║  ██║███████╗
    ╚═════╝ ╚═╝╚═╝  ╚═╝╚══════╝
*/

package com.listadoble;

import java.util.Scanner;

public class Execute {

    Scanner sc = new Scanner(System.in);
    ListDoble lista = new ListDoble();

    public void menu() {
        while (true) {
            String opc;
            System.out.println("" +
                    "════════════════ MENU ════════════════ \n" +
                    "1. Insertar por la izquierda\n" +
                    "2. Insertar por la derecha\n" +
                    "3. Barrido de izquierda a derecha\n" +
                    "4. Barrido de derecha a izquierda\n" +
                    "5. Eliminar\n" +
                    "6. Eliminar ultimo elemento a la izquierda\n" +
                    "7. Eliminar ultimo elemento a la derecha\n" +
                    "8. Insertar a la derecha de\n" +
                    "9. Insertar a la izquierda de\n" +
                    "A. Salir \n");
            while (true) {
                System.out.print("Ingresa una opcion: ");
                opc = sc.next();
                if (opc.matches("^[1-9A]$")) break;
            }

            switch (opc.charAt(0)) {
                case '1': insertarPorLaIzquierda(); break;
                case '2': insertarPorLaDerecha(); break;
                case '3': lista.leftRead(); break;
                case '4': lista.rightRead(); break;
                case '5': eliminar(); break;
                case '6': lista.removeLeft(); break;
                case '7': lista.removeRight(); break;
                case '8': agregarDespuesDe(); break;
                case '9': agregarAntesDe(); break;
                case 'A': return;
            }
        }
    }

    public void insertarPorLaIzquierda() {

        System.out.print("Ingresa el valor a insertar: ");
        String value = sc.next();

        lista.addLeft(value);

    }

    public void insertarPorLaDerecha() {

        System.out.print("Ingresa el valor a insertar: ");
        String value = sc.next();

        lista.addRight(value);

    }

    public void eliminar() {
        System.out.print("Ingresa el valor a eliminar: ");
        lista.remove(sc.next());
    }

    public void agregarDespuesDe() {
        System.out.print("Ingresa la referencia: ");
        String ref = sc.next();

        System.out.print("Ingresa el valor: ");
        String value = sc.next();

        lista.addRightOf(value, ref);
    }

    public void agregarAntesDe() {
        System.out.print("Ingresa la referencia: ");
        String ref = sc.next();

        System.out.print("Ingresa el valor: ");
        String value = sc.next();

        lista.addLeftOf(value, ref);
    }
}
