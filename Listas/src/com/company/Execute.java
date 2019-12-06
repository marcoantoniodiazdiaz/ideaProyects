package com.company;

import java.util.List;
import java.util.Scanner;

public class Execute {

    Scanner sc = new Scanner(System.in);
    Persona personaMethods = new Persona();

    public void menu() {
        while (true) {
            String opc;
            System.out.println("" +
                    "════════════════ MENU ════════════════ \n" +
                    "1. Insertar\n" +
                    "2. Buscar\n" +
                    "3. Mostrar Todo\n" +
                    "4. Editar\n" +
                    "5. Eliminar\n" +
                    "6. Salir \n");
            while (true) {
                System.out.print("Ingresa una opcion: ");
                opc = sc.next();
                if (opc.matches("^[1-6]$")) break;
            }

            switch (opc.charAt(0)) {
                case '1':
                    insertar();
                    break;
                case '2':
                    buscar();
                    break;
                case '3':
                    mostrar();
                    break;
                case '4':
                    editar();
                    break;
                case '5':
                    eliminar();
                    break;
                case '6':
                    return;
            }
        }
    }

    public void insertar() {
        String ID = personaMethods.generateID();
        System.out.println(ID);
        String nombre = personaMethods.generateNombre();
        int edad = personaMethods.generateEdad();

        Persona persona = new Persona(ID, nombre, edad);
        if (personaMethods.add(persona)) {
            System.out.println("Persona agregada");
        } else {
            System.out.println("No se pudo agregar a la persona");
        }
    }

    public void buscar() {
        System.out.print("Ingresa un ID: ");
        String ID = sc.next();
        Persona persona = personaMethods.getPersona(ID);
        if (persona != null) {
            System.out.println(personaMethods.show(persona));
        }
    }

    public void mostrar() {
        List<Persona> personas = personaMethods.getPersonas();
        for (Persona persona :
                personas) {
            System.out.println(personaMethods.show(persona));
        }
    }

    public void eliminar() {
        System.out.print("Ingresa un ID: ");
        String ID = sc.next();
        if (personaMethods.remove(ID)) {
            System.out.println("Persona eliminada");
        } else {
            System.out.println("Persona no encontrada");
        }
    }

    public void editar() {
        while (true) {
            String opc;
            System.out.println("" +
                    "═══════════════ EDITAR ═══════════════ \n" +
                    "1. ID \n" +
                    "2. Nombre \n" +
                    "3. Edad \n" +
                    "4. Salir \n");
            while (true) {
                System.out.print("Ingresa una opcion: ");
                opc = sc.next();
                if (opc.matches("^[1-4]$")) break;
            }

            switch (opc.charAt(0)) {
                case '1':
                    personaMethods.setID(personaMethods.generateID());
                    System.out.println("Campo actualizado");
                    break;
                case '2':
                    personaMethods.setNombre(personaMethods.generateNombre());
                    System.out.println("Campo actualizado");
                    break;
                case '3':
                    personaMethods.setEdad(personaMethods.generateEdad());
                    System.out.println("Campo actualizado");
                    break;
                case '4':
                    return;
            }
        }
    }

}
