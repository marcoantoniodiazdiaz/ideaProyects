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

    Scanner sc = new Scanner(System.in);
    Lista lista = new Lista();

    public void menu() {
        while (true) {
            String opc;
            System.out.println("" +
                    "════════════════ MENU ════════════════ \n" +
                    "1. Insertar \n" +
                    "2. Insertar al inicio\n" +
                    "3. Tomar\n" +
                    "4. Sobreescribir\n" +
                    "5. Imprimir\n" +
                    "6. Eliminar\n" +
                    "7. Salir \n");
            while (true) {
                System.out.print("Ingresa una opcion: ");
                opc = sc.next();
                if (opc.matches("^[1-7]$")) break;
            }

            switch (opc.charAt(0)) {
                case '1': insertar(); break;
                case '2': insertarAlInicio(); break;
                case '3': tomar();break;
                case '4': sobreeescribir(); break;
                case '5': lista.print(); break;
                case '6': eliminar(); break;
                case '7': return;
            }
        }
    }

    private void eliminar() {
        System.out.print("Ingresa la posicion: ");
        lista.remove(sc.nextInt());
    }

    private void insertar() {
        System.out.print("Ingresa un valor: ");
        lista.add(sc.next());
        lista.print();
    }

    private void insertarAlInicio() {
        System.out.print("Ingresa un valor: ");
        lista.addStart(sc.next());
        lista.print();
    }

    private void tomar() {
        System.out.print("Ingresa la posicion: ");
        System.out.println("-> " + lista.get(sc.nextInt()));
    }

    private void sobreeescribir() {
        System.out.print("Ingresa la posicion: ");
        int pos = sc.nextInt();
        System.out.print("Ingresa un valor: ");
        lista.set(sc.next(), pos);
    }
}
