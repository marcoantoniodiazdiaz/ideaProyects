/*
    ██████╗ ██╗ █████╗ ███████╗
    ██╔══██╗██║██╔══██╗╚══███╔╝
    ██║  ██║██║███████║  ███╔╝ 
    ██║  ██║██║██╔══██║ ███╔╝  
    ██████╔╝██║██║  ██║███████╗
    ╚═════╝ ╚═╝╚═╝  ╚═╝╚══════╝
*/

package com.listadoblecircular;

import java.util.Scanner;

public class Execute {

    Scanner sc = new Scanner(System.in);
    ListDoble lista = new ListDoble();

    public void menu() {
        while (true) {
            String opc;
            System.out.println("" +
                    "════════════════ MENU ════════════════ \n" +
                    "1. Insertar\n" +
                    "2. Barrido de elemento en forma ascendente\n" +
                    "3. Barrido de elemento en forma decendente\n" +
                    "4. Eliminar\n" +
                    "A. Salir \n");
            while (true) {
                System.out.print("Ingresa una opcion: ");
                opc = sc.next();
                if (opc.matches("^[1-4A]$")) break;
            }

            switch (opc.charAt(0)) {
                case '1': insertar(); break;
                case '2': barridoASC(); break;
                case '3': barridoDESC(); break;
                case '4': eliminar(); break;
                case 'A': return;
            }
        }
    }

    public void insertar() {

        System.out.print("Ingresa el nombre: ");
        String nombre = sc.next();

        System.out.print("Ingresa el grupo: ");
        String grupo = sc.next();

        Persona persona = new Persona(nombre, grupo);

        lista.add(persona);

    }

    public void barridoASC() {
        System.out.print("Ingresa la referencia: ");
        String ref = sc.next();
        lista.imprimirASC(ref);
    }

    public void barridoDESC() {
        System.out.print("Ingresa la referencia: ");
        String ref = sc.next();
        lista.imprimirDESC(ref);
    }

    public void eliminar() {
        System.out.print("Ingresa la referencia: ");
        String ref = sc.next();
        lista.remove(ref);
    }

}
