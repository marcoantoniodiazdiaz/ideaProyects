/*
    ██████╗ ██╗ █████╗ ███████╗
    ██╔══██╗██║██╔══██╗╚══███╔╝
    ██║  ██║██║███████║  ███╔╝ 
    ██║  ██║██║██╔══██║ ███╔╝  
    ██████╔╝██║██║  ██║███████╗
    ╚═════╝ ╚═╝╚═╝  ╚═╝╚══════╝
*/

package com.bicolas;

public class BicolaCase1 {

    private String[] queue; // Declaracion de la cola, como un arreglo
    // Declaracion de todas las variables
    private int max;
    private int end = 0;
    private int front = 0;
    private int cont = 0;


    public BicolaCase1(int max) { // Constructor de la cola tipo 1
        queue = new String[max];
        this.max = max;
    }

    public void insertFront(String val) { // Insertar al frente

        if (cont == max) { // Si el contador es igual a max significa que la cola esta llena
            System.out.println("Cola llena");
            return;
        }

        if (cont == 0) { // Si es igual realiza lo siguiente
            queue[front] = val;
            front --;
            end ++;
            cont ++;
        } else { // Si no se le resta al frente y aumenta el contador
            queue[front] = val;
            front --;
            cont ++;
        }

        if (front == -1) {
            front = max-1;
        }

        print(); // Mostrar
    }

    public void insertEnd(String val) { // Insertar al final

        if (cont == max) { // Si el contador es igual a max significa que la cola esta llena
            System.out.println("Cola llena");
            return;
        }

        if (cont == 0) {  // Si es igual realiza lo siguiente
            queue[end] = val;
            end ++;
            front --;
            cont ++;
        } else { // Si no se le resta al frente y aumenta el contador
            queue[end] = val;
            end ++;
            cont ++;
        }

        if (front == -1) {
            front = max-1; // Se le asigna el valor de el maximo menos 1
        }

        print();
    }

    public void poll() { // Realiza una extraccion
        if (cont == 0) { // Se comprueba si la cola esta vacia
            System.out.println("Cola vacia");
            return;
        }

        if (front != max-1) { // Si se cumple la condicion se extrae el valor
            System.out.println("Extracción: " + queue[front + 1]);
            queue[front + 1] = null;
            cont --;
            front ++;
        } else {
            front = -1;
            System.out.println("Extracción: " + queue[front + 1]);
            queue[front + 1] = null;
            cont --;
            front ++;
        }

        if (cont == 0) {
            front = 0;
            end = 0;
        }

        print(); // Se imprime el valor
    }


    public void print() { // Metodo para imprimie
        for (int i = 0; i < queue.length; i++) {
            System.out.println(queue[i]);
        }
    }

}
