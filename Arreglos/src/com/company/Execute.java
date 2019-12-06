package com.company;
import java.util.Scanner;
public class Execute {

    private Scanner sc = new Scanner(System.in);
    private Persona personaMethods = new Persona();
    
    public void run() {
        while (true) {
            String opc;
            System.out.println("" +
                    "════════════════ MENU ════════════════ \n" +
                    "1. Insertar \n"                            +
                    "2. Ver Todo \n"                            +
                    "3. Editar \n"                              +
                    "4. Buscar \n"                              +
                    "5. Borrar \n"                              +
                    "6. Recuperar usuario \n"                   +
                    "7. Estado de la memoria \n"                +
                    "8. Salir \n");
            while (true) {
                System.out.print("Ingresa una opcion: ");
                opc = sc.next();
                if (opc.matches("^[1-8]$")) break;
            }

            switch (opc.charAt(0)) {
                case '1': insertar(); break;
                case '2': verTodo(); break;
                case '3': editar(); break;
                case '4': buscar(); break;
                case '5': borrar(); break;
                case '6': recuperarUsuario(); break;
                case '7': System.out.println(personaMethods.arraysStatus()); break;
                case '8': return;
            }
        }
    }

    private void insertar() {
        if (personaMethods.add(new Persona(personaMethods.generateID(), personaMethods.generateNombre(), personaMethods.generateDireccion(),
                personaMethods.generateEdad(), personaMethods.generateEstadoCivil(), personaMethods.generateSalario()))) {
            System.out.println("Persona insertada");
        } else System.err.println("Arreglo lleno");
    }

    private void verTodo() {
        for (Persona persona : personaMethods.getPersonas()) if (persona != null) System.out.println(personaMethods.show(persona));
    }

    private void recuperarUsuario() {
        System.out.print("Ingresa el ID: ");
        String ID = sc.next();

        if (personaMethods.resetRemove(ID)) System.out.println("Persona recuperada");
        else System.err.println("Persona no encontrada o ya esta activa");

    }

    private void editar() {

        System.out.print("Ingresa el ID: ");
        String ID = sc.next();

        Persona persona = personaMethods.getPersona(ID);

        if (persona == null) {
            System.out.println("Persona no encontrada");
            return;
        }

        while (true) {
            String opc;
            System.out.println("" +
                    "════════════════ MENU ════════════════ \n" +
                    "1. Nombre \n" +
                    "2. Direccion \n" +
                    "3. Edad\n" +
                    "4. Estado Civil\n" +
                    "5. Salario\n" +
                    "6. Terminar \n");
            while (true) {
                System.out.print("Ingresa una opcion: ");
                opc = sc.next();
                if (opc.matches("^[1-6]$")) break;
            }

            switch (opc.charAt(0)) {
                case '1': persona.setNombre(personaMethods.generateNombre()); break;
                case '2': persona.setDireccion(personaMethods.generateDireccion()); break;
                case '3': persona.setEdad(personaMethods.generateEdad()); break;
                case '4': persona.setEstadoCivil(personaMethods.generateEstadoCivil()); break;
                case '5': persona.setSalario(personaMethods.generateSalario()); break;
                case '6': return;
            }
        }
    }

    private void buscar() {
        System.out.print("Ingresa el ID: ");
        String ID = sc.next();

        if (personaMethods.getPersona(ID) != null)
            System.out.println(personaMethods.show(personaMethods.getPersona(ID)));
        else
            System.out.println("No se encontro la persona");
    }

    private void borrar() {
        System.out.print("Ingresa el ID: ");
        String ID = sc.next();

        System.out.println("Estas seguro que de quieres eliminar este registro?: \n1. SI, 2: NO\n");
        String opc = sc.next();

        if (opc.equals("1")) {
            if (personaMethods.remove(ID)) System.out.println("Persona eliminada");
            else System.out.println("No se encontro la persona");
        } else {
            System.out.println("La persona no se elimino");
        }
    }
}
