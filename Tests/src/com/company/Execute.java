package com.company;

import java.util.Scanner;

public class Execute {
    Scanner sc = new Scanner(System.in);
    public void menu() {
        while (true) {
            String opc;
            System.out.println("" +
                    "════════════════ MENU ════════════════ \n" +
                    "1. Opcion 1 \n" +
                    "2. Opcion 2 \n" +
                    "3. Opcion 3 \n" +
                    "4. Opcion 4\n" +
                    "5. Salir \n");
            while (true) {
                System.out.print("Ingresa una opcion: ");
                opc = sc.next();
                if (opc.matches("^[1-5]$")) break;
            }

            switch (opc.charAt(0)) {
                case '1':

                    break;
                case '2':

                    break;
                case '3':

                    break;
                case '4':

                    break;
                case '5':
                    return;
            }
        }
    }
}
