/*
    ██████╗ ██╗ █████╗ ███████╗
    ██╔══██╗██║██╔══██╗╚══███╔╝
    ██║  ██║██║███████║  ███╔╝ 
    ██║  ██║██║██╔══██║ ███╔╝  
    ██████╔╝██║██║  ██║███████╗
    ╚═════╝ ╚═╝╚═╝  ╚═╝╚══════╝
*/

package com.bicolas;

import java.util.Scanner;

public class Execute {

    Scanner sc = new Scanner(System.in);
    BicolaCase1 bicolaCase1 = new BicolaCase1(5);
    BicolaCase2 bicolaCase2 = new BicolaCase2(5);

    public void menu() {
        while (true) {
            String opc;
            System.out.println("" +
                    "════════════════ MENU ════════════════ \n" +
                    "1. Bicola Caso 1 \n" +
                    "2. Bicola Caso 2 \n" +
                    "3. Salir \n");
            while (true) {
                System.out.print("Ingresa una opcion: ");
                opc = sc.next();
                if (opc.matches("^[1-3]$")) break;
            }

            switch (opc.charAt(0)) {
                case '1': bicolaCase1Menu(); break;
                case '2': bicolaCase2Menu(); break;
                case '3': return;
            }
        }
    }

    public void bicolaCase1Menu() {
        while (true) {
            String opc;
            System.out.println("" +
                    "════════════════ MENU ════════════════ \n" +
                    "1. Inserta en frente \n" +
                    "2. Insertar por el final \n" +
                    "3. Eliminar \n" +
                    "4. Salir \n");
            while (true) {
                System.out.print("Ingresa una opcion: ");
                opc = sc.next();
                if (opc.matches("^[1-4]$")) break;
            }

            switch (opc.charAt(0)) {
                case '1': bicolaCase1.insertFront(pedirValor()); break;
                case '2': bicolaCase1.insertEnd(pedirValor()); break;
                case '3': bicolaCase1.poll(); break;
                case '4': return;
            }
        }
    }

    public void bicolaCase2Menu() {
        while (true) {
            String opc;
            System.out.println("" +
                    "════════════════ MENU ════════════════ \n" +
                    "1. Inserta en frente \n" +
                    "2. Elimina por el final \n" +
                    "3. Elimina por el frente\n" +
                    "4. Salir \n");
            while (true) {
                System.out.print("Ingresa una opcion: ");
                opc = sc.next();
                if (opc.matches("^[1-4]$")) break;
            }

            switch (opc.charAt(0)) {
                case '1': bicolaCase2.insertFront(pedirValor()); break;
                case '2': bicolaCase2.deleteEnd(); break;
                case '3': bicolaCase2.deleteFront(); break;
                case '4': return;
            }
        }
    }

    private String pedirValor() {
        System.out.print("Ingresa un valor: ");
        return sc.next();
    }

}
