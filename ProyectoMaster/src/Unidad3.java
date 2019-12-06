/*
    ██████╗ ██╗ █████╗ ███████╗
    ██╔══██╗██║██╔══██╗╚══███╔╝
    ██║  ██║██║███████║  ███╔╝ 
    ██║  ██║██║██╔══██║ ███╔╝  
    ██████╔╝██║██║  ██║███████╗
    ╚═════╝ ╚═╝╚═╝  ╚═╝╚══════╝
*/

import java.util.Scanner;

public class Unidad3 {

    private Scanner sc = new Scanner(System.in);

    public void run() {
        while (true) {
            String opc;
            System.out.println("" +
                    "════════════════ MENU ════════════════ \n" +
                    "1. Pilas\n" +
                    "2. Colas\n" +
                    "3. Colas Circulares\n" +
                    "4. Bicolas\n" +
                    "5. Listas Simples\n" +
                    "6. Listas Doblemente Enlazadas\n" +
                    "7. Listas Doblemente Enlazadas Circulares\n" +
                    "A. Salir \n");
            while (true) {
                System.out.print("Ingresa una opcion: ");
                opc = sc.next();
                if (opc.matches("^[1-7A]$")) break;
            }

            switch (opc.charAt(0)) {
                case '1': new com.pilas.Execute().menu(); break;
                case '2': new com.colas.Execute().menu(); break;
                case '3': new com.colascirculares.Execute().menu(); break;
                case '4': new com.bicolas.Execute().menu(); break;
                case '5': new com.listasimple.Execute().menu(); break;
                case '6': new com.listadoble.Execute().menu(); break;
                case '7': new com.listadoblecircular.Execute().menu(); break;
                case 'A': return;
            }
        }
    }
}
