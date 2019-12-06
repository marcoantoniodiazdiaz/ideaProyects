package com.company;

import java.util.Scanner;

public class Persona {

    private int maxLen = 100; // Longitud del arreglo
    private Persona[] arr = new Persona[maxLen]; // Arreglo Principal
    private int fillIndex = 0; // Indice de llenado
    private Scanner sc = new Scanner(System.in); // Scanner

    private String ID;
    private String nombre;
    private String direccion;
    private byte edad; // 0-99
    private byte estadoCivil; // 0 = SOLTERO, 1 = CASADO
    private Double salario;
    private boolean active;

    // Constructor de personas
    public Persona(String ID, String nombre, String direccion, byte edad, byte estadoCivil, Double salario) {
        this.ID = ID;
        this.nombre = nombre;
        this.direccion = direccion;
        this.edad = edad;
        this.estadoCivil = estadoCivil;
        this.salario = salario;
        this.active = true;
    }

    // Constructor para instanciar metodos
    public Persona() {
        this.active = false;
    }

    // GETTERS AND SETTERS
    public String getID() {
        return ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public byte getEdad() {
        return edad;
    }

    public void setEdad(byte edad) {
        this.edad = edad;
    }

    public byte getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(byte estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    // Retornar todas las personas
    public Persona[] getPersonas() {
        Persona[] arrAux = new Persona[maxLen];
        int fill = 0;
        for (Persona persona : arr) {
            if (persona != null) {
                if (persona.isActive()) {
                    arrAux[fill] = persona;
                    fill++;
                }
            } else break;
        }
        return arrAux;
    }

    // Retornar una persona
    public Persona getPersona(String ID) {
        for (Persona persona : arr) {
            if (persona != null) {
                if (persona.getID().equals(ID) && persona.isActive()) return persona;
            } else break;
        }
        return null;
    }

    // Activar un objeto
    public boolean resetRemove(String ID) {
        for (Persona persona : arr) {
            if (persona != null) {
                if (persona.getID().equals(ID) && !persona.isActive()) {
                    persona.setActive(true);
                    return true;
                }
            }
        }
        return false;
    }

    // Agregar persona al arreglo
    public boolean add(Persona persona) {

        if ((fillIndex + 1) == maxLen) return false;

        for (int i = 0; i < arr.length; i++) {
            Persona p = arr[i];
            if (p != null) {
                if (p.getID().equals(persona.getID())) {
                    arr[i] = persona;
                    return true;
                }
            } else {
                fillIndex = i;
                arr[fillIndex] = persona;
                return true;
            }
        }
        return false;
    }

    // Desactivar una persona
    public boolean remove(String ID) {
        for (Persona persona : arr) {
            if (persona != null) {
                if (persona.getID().equals(ID) && persona.isActive()) {
                    persona.setActive(false);
                    return true;
                }
            }
        }

        return false;
    }

    // Comprueba si la persona existe
    private boolean idExists(String ID) {
        for (Persona persona : arr) {
            if (persona != null)
                if (persona.getID().equals(ID) && persona.isActive()) return true;
                else break;
        }
        return false;
    }

    // Retorna el mensaje de acuerdo a la coincidencia de una persona
    public String show(Persona persona) {
        return "" +
                "══════════════════════════════════════\n" +
                "RFC: " + persona.getID() + "\n" +
                "Nombre: " + persona.getNombre() + "\n" +
                "Direccion: " + persona.getDireccion() + "\n" +
                "Edad: " + persona.getEdad() + "\n" +
                "Estado Civil: " + persona.getEstadoCivil() + "\n" +
                "Salario: " + persona.getSalario() + "\n";
    }

    // Comprieba los campos que estan activados
    public String arraysStatus() {
        int trash = 0, active = 0;
        for (Persona persona : arr) {
            if (persona != null) {
                if (!persona.isActive()) trash++;
                else active++;
            } else break;
        }

        return "═══════════════ STATUS ═══════════════\n" +
                "Espacios disponibles: " + (maxLen - (trash + active)) + "\n" +
                "Espacios basura: " + trash + "\n" +
                "Personas activas: " + active + "\n";
    }

    // GENERATES
    public String generateID() {
        while (true) {
            System.out.print("Ingresa tu ID: ");
            String lr = sc.next();
            if (lr.matches("^[A-Z\\d]{5}$")) {
                if (idExists(lr)) System.out.println("El ID ya existe");
                else {
                    sc.nextLine();
                    return lr;
                }
            } else System.err.println("Campo ID no valido");
        }
    }

    public String generateNombre() {
        while (true) {
            System.out.print("Ingresa tu nombre: ");
            String lr = sc.nextLine();
            if (lr.matches("^[a-zA-Z\\s]+$")) return lr;
            else System.err.println("Campo nombre no valido");
        }
    }

    public String generateDireccion() {
        while (true) {
            System.out.print("Ingresa tu direccion: ");
            String lr = sc.nextLine();
            if (lr.matches("^[\\w\\s]+\\s#[\\d]+\\s[\\w\\s]+$")) return lr;
            else System.err.println("Campo direccion no valido");
        }
    }

    public byte generateEdad() {
        while (true) {
            System.out.print("Ingresa tu edad: ");
            String lr = sc.next();
            if (lr.matches("^[\\d]{1,2}$")) {
                sc.nextLine();
                return (byte) Integer.parseInt(lr);
            } else System.err.println("Campo edad no valido");
        }
    }

    public byte generateEstadoCivil() {
        while (true) {
            System.out.print("Ingresa tu estado civil: ");
            String lr = sc.next();
            if (lr.matches("^([01])$")) {
                sc.nextLine();
                return (byte) Integer.parseInt(lr);
            } else System.err.println("Campo estado civil no valido");
        }
    }

    public Double generateSalario() {
        while (true) {
            System.out.print("Ingresa tu salario: ");
            String lr = sc.next();
            if (lr.matches("^[\\d]+(\\.[\\d]+)?$")) {
                sc.nextLine();
                return Double.parseDouble(lr);
            } else System.err.println("Campo salario no valido");
        }
    }
}
