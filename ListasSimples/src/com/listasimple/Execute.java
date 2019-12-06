package com.listasimple;/*
    ██████╗ ██╗ █████╗ ███████╗
    ██╔══██╗██║██╔══██╗╚══███╔╝
    ██║  ██║██║███████║  ███╔╝ 
    ██║  ██║██║██╔══██║ ███╔╝  
    ██████╔╝██║██║  ██║███████╗
    ╚═════╝ ╚═╝╚═╝  ╚═╝╚══════╝
*/

import java.util.Scanner;

public class Execute {

    ListaEnlazada lista = new ListaEnlazada();
    Scanner sc = new Scanner(System.in);

    public void menu() {
        while (true) {
            String opc;
            System.out.println("" +
                    "════════════════ MENU ════════════════ \n" +
                    "1. Inserta al inicio\n" +
                    "2. Inserta al final\n" +
                    "3. Mostrar\n" +
                    "4. Eliminar\n" +
                    "5. Agregar antes de...\n" +
                    "6. Agregar despues de...\n" +
                    "7. Eliminar Inicio\n" +
                    "8. Eliminar Final\n" +
                    "9. Buscar\n" +
                    "A. Salir \n");
            while (true) {
                System.out.print("Ingresa una opcion: ");
                opc = sc.next();
                if (opc.matches("^[1-9A]$")) break;
            }

            switch (opc.charAt(0)) {
                case '1': insertaInicio(); break;
                case '2': insertaAlFinal(); break;
                case '3': barrido(); break;
                case '4': eliminar(); break;
                case '5': agregarAntesDe(); break;
                case '6': agregarDespuesDe(); break;
                case '7': eliminarInicio(); break;
                case '8': eliminarFinal(); break;
                case '9': buscar(); break;
                case 'A': return;
            }
        }
    }

    public void insertaInicio() { // Inserta al inicio
        System.out.print("Ingresa un valor: ");
        lista.addFirst(sc.next());
    }

    public void insertaAlFinal() { // Inserta al final
        System.out.print("Ingresa un valor: ");
        lista.addLast(sc.next());
    }

    public void eliminar() { // Le pasamos un valor, se busca, y si se encuentra se elimina el indice
        System.out.print("Ingresa el elemento a eliminar: ");
        String value = sc.next();

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).equals(value)) {
                lista.remove(i);
                return;
            }
        }

        System.err.println("Elemento no encontrado");
    }

    public void barrido() { // Barrido completo
        int len = lista.size();

        if (len <= 0) {
            System.err.println("Lista vacia");
            return;
        }

        for (int i = 0; i < len; i++) {
            System.out.println(lista.get(i));
        }
    }

    public void agregarAntesDe() {
        System.out.print("Ingresa el valor a insertar antes: ");
        String val = sc.next();
        System.out.print("Referencia: ");
        String ref = sc.next();

        for (int i = 0; i < lista.size(); i++) {
            if (ref.equals(lista.get(i))) {
                if (i > 0) {
                    lista.add(val, i);
                    return;
                } else {
                    lista.add(val, 0);
                    return;
                }
            }
        }

        System.err.println("Referencia no encontrada");

    }

    public void agregarDespuesDe() {
        System.out.print("Ingresa el valor a insertar despues: ");
        String val = sc.next();
        System.out.print("Referencia: ");
        String ref = sc.next();

        for (int i = 0; i < lista.size(); i++) {
            if (ref.equals(lista.get(i))) {
                if (i > 0) {
                    lista.add(val, i+1);
                    return;
                } else {
                    lista.add(val, 0);
                    return;
                }
            }
        }

        System.err.println("Referencia no encontrada");
    }

    public void eliminarInicio() {
        lista.removeFirst();
    }

    public void eliminarFinal() {
        lista.removeLast();
    }

    public void buscar() {
        System.out.print("Ingresa la caden a buscar: ");
        String find = sc.next();

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).equals(find)) {
                System.out.println("Encontrado en la posicion " + (i+1));
                break;
            }
        }
    }

}
