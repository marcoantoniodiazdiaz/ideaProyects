/*
    ██████╗ ██╗ █████╗ ███████╗
    ██╔══██╗██║██╔══██╗╚══███╔╝
    ██║  ██║██║███████║  ███╔╝ 
    ██║  ██║██║██╔══██║ ███╔╝  
    ██████╔╝██║██║  ██║███████╗
    ╚═════╝ ╚═╝╚═╝  ╚═╝╚══════╝

    1. Diaz Diaz Marco Antonio
    2. Flores Castellanos Perla Guadalupe
    3. Barragan Torres Sandra
    4. Lopez Mares Marfier
*/

import java.util.Scanner;

public class Execute {

    int mat[][];
    Scanner sc = new Scanner(System.in);

    int suma (int mat[][], int nf, int nc) {
        if ((nf == 0) && (nc == 0)) { // Comprobacion de los pivotes.
            return mat[nf][nc]; // Retorna directamente la matriz.
        } else {
            if (nf > -1) {
                nc --;
                if (nc >= -1) {
                    return mat[nf][nc+1] + suma(mat, nf, nc); // Si se sigue compliendo la condicion se vuelve a llamar la funcion.
                } else {
                    return suma(mat, nf-1, 2);
                }
            } else {
                return 0;
            }
        }
    }

    public void exe() {
        mat = new int[3][3];

        while (true) {
            String opc;
            System.out.println("" +
                    "════════════════ MENU ════════════════ \n" +
                    "1. Ciclos \n" +
                    "2. Iterativo \n" +
                    "3. Salir \n");
            while (true) {
                System.out.print("Ingresa una opcion: ");
                opc = sc.next();
                if (opc.matches("^[1-3]$")) break;
            }

            switch (opc.charAt(0)) {
                case '1': ciclos(); break;
                case '2': iterativo(); break;
                case '3': return;
            }
        }
    }

    private void iterativo() {
        for (int i = 0; i < 3; i++) { // For para llenar el arreglo por columnas.
            for (int j = 0; j < 3; j++) { // For para llenar el arreglo por filas.
                mat[i][j] = generateNumber(); // Llenar el espacio en la matriz.
            }
        }

        System.out.println("La suma es: " + (suma(mat, 2, 2)));
    }

    private void ciclos() {
        for (int i = 0; i < 3; i++) { // For para llenar el arreglo por columnas.
            for (int j = 0; j < 3; j++) { // For para llenar el arreglo por filas.
                mat[i][j] = generateNumber(); // Llenar el espacio en la matriz.
            }
        }

        int n = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                n += mat[i][j];
            }
        }
        System.out.println("La suma es: " + n);
    }

    public int generateNumber() {
        while (true) {
            System.out.print("Ingresa un numero: "); // Pedir un numero
            String lr = sc.next();
            if (lr.matches("[\\d]{1,8}")) { // Expresion regular que comprueba que sea un numero valido
                sc.nextLine();
                return Integer.parseInt(lr); // Retorna el numero valido.
            } else System.err.println("Campo no numero");
        }
    }
}
