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

    Lista lista = new Lista();
    Scanner sc = new Scanner(System.in);

    public void menu() {
        while (true) {
            String opc;
            System.out.println("" +
                    "════════════════ MENU ════════════════ \n" +
                    "1. Insertar\n" +
                    "2. Borrar\n" +
                    "3. Recorrer\n" +
                    "4. \n" +
                    "5. Salir \n");
            while (true) {
                System.out.print("Ingresa una opcion: ");
                opc = sc.next();
                if (opc.matches("^[1-5]$")) break;
            }

            switch (opc.charAt(0)) {
                case '1': insertar(); break;
                case '2': borrar(); break;
                case '3': recorrer(); break;
                case '4':  break;
                case '5': return;
            }
        }
    }

    public void insertar() {
        System.out.print("Ingresa el valor: ");
        lista.add(lista.size(), sc.next());
    }

    public void borrar() {
        System.out.print("Ingresa la posicion: ");
        lista.delete(sc.nextInt());
    }

    public void recorrer() {
        lista.getAll();
    }


}
