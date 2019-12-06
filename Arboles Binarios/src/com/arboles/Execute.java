/*
    ██████╗ ██╗ █████╗ ███████╗
    ██╔══██╗██║██╔══██╗╚══███╔╝
    ██║  ██║██║███████║  ███╔╝ 
    ██║  ██║██║██╔══██║ ███╔╝  
    ██████╔╝██║██║  ██║███████╗
    ╚═════╝ ╚═╝╚═╝  ╚═╝╚══════╝
*/

package com.arboles;

import java.util.Scanner;

public class Execute {

    KeenTree keenTree = new KeenTree();

    Scanner sc = new Scanner(System.in);

    public void menu() {
        while (true) {
            String opc;
            System.out.println("\n" +
                    "════════════════ MENU ════════════════ \n" +
                    "1. Insertar \n" +
                    "2. Recorrido preorden\n" +
                    "3. Recorrido inorden\n" +
                    "4. Recorrido posorden\n" +
                    "5. Eliminar\n" +
                    "6. Salir \n");
            while (true) {
                System.out.print("Ingresa una opcion: ");
                opc = sc.next();
                if (opc.matches("^[1-6]$")) break;
            }

            switch (opc.charAt(0)) {
                case '1': insertar(); break;
                case '2': keenTree.preeorden(); break;
                case '3': keenTree.inorden(); break;
                case '4':
                    try {
                        keenTree.postorden();
                    } catch (Exception e) {
                        //
                    }
                    break;
                case '5': eliminar(); break;
                case '6': return;
            }
        }
    }

    public void insertar() {
        System.out.print("Ingresa el valor: ");
        keenTree.add(sc.next());
    }

    public void eliminar() {
        System.out.print("Ingresa el valor a eliminar: ");
        keenTree.delete(sc.next());
    }
}
