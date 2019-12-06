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

    private ListaDobleCircular lista = new ListaDobleCircular();

    private Scanner sc = new Scanner(System.in);

    public void menu() {
        while (true) {
            String opc;
            System.out.println("" +
                    "════════════════ MENU ════════════════ \n" +
                    "1. Insertar al inicio\n" +
                    "2. Insertar al final\n" +
                    "3. Recorrer\n" +
                    "4. \n" +
                    "5. Salir \n");
            while (true) {
                System.out.print("Ingresa una opcion: ");
                opc = sc.next();
                if (opc.matches("^[1-5]$")) break;
            }

            switch (opc.charAt(0)) {
                case '1':
                    insertarAlInicio();
                    break;
                case '2':
                    insertarAlFinal();
                    break;
                case '3':
                    lista.imprimir();
                    break;
                case '4':
                    break;
                case '5':
                    return;
            }
        }
    }

    public void insertarAlInicio() {
        System.out.println("Ingresa el valor: ");
        lista.insertarInicio(sc.next());
    }

    public void insertarAlFinal() {
        System.out.println("Ingresa el valor: ");
        lista.insertarInicio(sc.next());
    }
}
