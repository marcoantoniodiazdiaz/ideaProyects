/*
    ██████╗ ██╗ █████╗ ███████╗
    ██╔══██╗██║██╔══██╗╚══███╔╝
    ██║  ██║██║███████║  ███╔╝ 
    ██║  ██║██║██╔══██║ ███╔╝  
    ██████╔╝██║██║  ██║███████╗
    ╚═════╝ ╚═╝╚═╝  ╚═╝╚══════╝
*/

package com.colascirculares;

public class ColaCircular {

    private String[] arr = new String[5]; // Se inicializa el arreglo
    private int write = -1; // Se cola el apuntador de escritura en -1
    private int read = 0; // Se cola el apuntador de lectura en 0

    // Insertar
    public void push(String cad) {

        if (read == write && write == -1) { // Se comprueba si la lista esta llena
            System.out.println("Cola llena");
            return;
        }

        if (write == -1) write = 0; // Se comprueba para poder comenzar el llenado

        if (write < 5) { // Condicion para volver la lista de forma circular
            arr[write] = cad;
            write ++;
        } else { // Si no se cumple la condicion el valor no salta al inicio
            write = 0;
            arr[write] = cad;
            write ++;
        }
    }

    public String pop() { // Retorna el valor pedido
        String ret;

        if (write == -1) { // Se comprueba que la lista no este vacia
            return "Cola vacia";
        }

        if (read == write && write != 0) { // Se comprueba que la lista no este vacia
            write = -1;
            read = 0;
            return "Cola vacia";
        }

        if (read < 5) { // Condicion para volver la lista de forma circular
            ret = arr[read];
            arr[read] = null;
            read ++;
        } else { // Si no se cumple la condicion el valor no salta al inicio
            read = 0;
            ret = arr[read];
            arr[read] = null;
            read ++;
        }
        return ret; // Retornamos el valor
    }

    public void print() { // Se encarga de imprimir todos los valores
        System.out.println("<════════════════════════════>");
        for (String s : arr) { // Foreach de recorrido completo
            System.out.println(s);
        }
        System.out.println("<════════════════════════════>");
        System.out.println("Lector: " + read + "\nEscritor: " + write); // Muestra el valor de las variables
    }

}
