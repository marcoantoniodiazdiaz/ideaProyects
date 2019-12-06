package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Persona {

    static List<Persona> list = new ArrayList<Persona>();
    Scanner sc = new Scanner(System.in);

    private String ID;
    private String nombre;
    private int edad;

    public Persona(String ID, String nombre, int edad) {
        this.ID = ID;
        this.nombre = nombre;
        this.edad = edad;
    }

    public Persona() {}

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean add(Persona persona) {
        return list.add(persona);
    }

    public boolean remove(String ID) {
        for (int i = 0; i < list.size(); i++) {
            Persona persona = list.get(i);
            if (persona.getID().equals(ID)) {
                list.remove(i);
                return true;
            }
        }

        return false;
    }

    public String show(Persona persona) {
        return "══════════════════════════════════════ \n" +
                "Nombre: " + persona.getNombre() + "\n" +
                "Edad: "+ persona.getEdad() + "\n" +
                "ID: " + persona.getID() + "";
    }

    public List<Persona> getPersonas() {
        return list;
    }

    public Persona getPersona(String ID) {

        for (Persona persona : list) {
            if (persona.getID().equals(ID)) {
                return persona;
            }
        }
        return null;
    }

    public String generateID() {
        while (true) {
            System.out.print("Ingresa tu ID: ");
            String lr = sc.next();
            if (lr.matches("^[A-Z0-9]{5}$")) {
                sc.nextLine();
                return lr;
            } else {
                System.err.println("Campo ID no valido");
            }
        }
    }

    public String generateNombre() {
        while (true) {
            System.out.print("Ingresa tu nombre: ");
            String lr = sc.nextLine();
            if (lr.matches("^[a-zA-Z\\s]+$")) {
                return lr;
            } else {
                System.err.println("Campo nombre no valido");
            }
        }
    }

    public int generateEdad() {
        while (true) {
            System.out.print("Ingresa tu edad: ");
            String lr = sc.next();
            if (lr.matches("^[0-9]{1,2}$")) {
                sc.nextLine();
                return Integer.parseInt(lr);
            } else {
                System.err.println("Campo edad no valido");
            }
        }
    }
}
