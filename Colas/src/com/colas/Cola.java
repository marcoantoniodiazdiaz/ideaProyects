package com.colas;/*
    ██████╗ ██╗ █████╗ ███████╗
    ██╔══██╗██║██╔══██╗╚══███╔╝
    ██║  ██║██║███████║  ███╔╝ 
    ██║  ██║██║██╔══██║ ███╔╝  
    ██████╔╝██║██║  ██║███████╗
    ╚═════╝ ╚═╝╚═╝  ╚═╝╚══════╝
*/

public class Cola {

    private int n; // Variable que controla la longitud de la cola
    private String[] queue; // Declaracion de la cola
    int end = 0; // Varible que indica el final de escritura de la cola

    public Cola(int n) { // Constructor
        this.n = n;
        this.queue = new String[n];
    }

    public void encolar(String data) { // Declaracion del metodo que inserta en la cola
        if (!isFull()) { // Comprobacion de que la cola no este llena
            queue[end] = data; // Inserta lo que le pasa de parametro en la posicion de escritura
            end ++; // Aumenta 'end' en 1
        } else { // Si la cola esta llena ejecuta la siguiente linea
            System.out.println("com.colas.Cola llena");
        }
    }

    public String desencolar() { // Declaracion del metodo que elimina un valor de la cola
        if (!isEmpty()) { // Comprobacion de que la cola no este vacia
            String r = queue[0]; // Toma el primer elemento de la cola
            for (int i = 0; i < n; i++) { // For de barrido completo (Recorrido un paso a la izquierda)
                if ((i+1) != n) { // Comproba que no se desborde la posicion
                    queue[i] = queue[i+1];
                }
            }
            queue[end-1] = null; // Se setea la ultima posicion como null
            end --; // Se reduce la variable de escritura menos 1
            return r; // Retorna el valor obtenido
        } else {
            return "com.colas.Cola vacia";
        }
    }

    private boolean isFull() {
        return (end > (n-1));
    } // Comprueba si la cola esta llena
    private boolean isEmpty() {
        return (end == 0);
    } // Comprueba que si la cola esta vacia
    public String[] getQueue() {
        return queue;
    } // Metodo que retorna la cola completa
}
