/*
    ██████╗ ██╗ █████╗ ███████╗
    ██╔══██╗██║██╔══██╗╚══███╔╝
    ██║  ██║██║███████║  ███╔╝ 
    ██║  ██║██║██╔══██║ ███╔╝  
    ██████╔╝██║██║  ██║███████╗
    ╚═════╝ ╚═╝╚═╝  ╚═╝╚══════╝
*/

import java.util.Scanner;

public class Execute {

    private Scanner sc = new Scanner(System.in);

    public void run() {
        while (true) {
            String opc;
            System.out.println("════════════════ MENU ════════════════ \n" +
                    "1. Introducción a las estructuras de datos\n" +
                    "2. Recursividad\n" +
                    "3. Estructuras lineales\n" +
                    "4. Estructuras no lineales \n" +
                    "5. Métodos de ordenamiento y busquedas\n" +
                    "A. Salir \n");
            while (true) {
                System.out.print("Ingresa una opcion: ");
                opc = sc.next();
                if (opc.matches("^[1-5A]$")) break;
            }

            switch (opc.charAt(0)) {
                case '1': new Unidad1().run(); break;
                case '2': new Unidad2().run(); break;
                case '3': new Unidad3().run(); break;
                case '4': new Unidad4().run(); break;
                case '5': new Unidad5().run(); break;
                case 'A': return;
            }
        }
    }
}