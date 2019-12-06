/*
    ██████╗ ██╗ █████╗ ███████╗
    ██╔══██╗██║██╔══██╗╚══███╔╝
    ██║  ██║██║███████║  ███╔╝ 
    ██║  ██║██║██╔══██║ ███╔╝  
    ██████╔╝██║██║  ██║███████╗
    ╚═════╝ ╚═╝╚═╝  ╚═╝╚══════╝
*/

package com.bicolas;

public class BicolaCase2 {

    private String queue[]; // Declaracion de la cola, como un arreglo
    // Declaracion de todas las variables
    private int end = 0;
    private int front = 0;
    private int cont = 0;
    private int max;

    public BicolaCase2(int max) { // Constructor de la cola tipo 1
        queue = new String[max];
        this.max = max;
    }

    public void deleteFront() { // Elimina el frente
        if (cont == 0) { // Se determina si la cola esta vacia
            System.out.println("Cola vacia");
            return;
        }

        if (cont > 0 && front != (max-1)) { // Colocacion de los valores en la posicion para eliminar
            queue[front + 1] = null;
            front ++;
            cont --;
        } else if (front == (max-1)) {
            queue[0] = null;
            cont --;
        }

        if (cont == 0) {
            front = 0;
            end = 0;
        }

        print(); // Imprimir el valor
    }

    public void deleteEnd() { // Elimina el final
        if (cont == 0) {
            System.out.println("Cola vacia");
            return;
        }

        if (cont > 0) { // Apuntadores en los valores correctos para la eliminacion
            queue[end] = null;
            end --;
            cont --;
        }

        if (end == -1) {
            end = (max-1);
        }

        if (cont == 0) {
            front = 0;
            end = 0;
        }

        print(); // Imprimir la cola
    }

    public void insertFront(String val) { // Si el contador es igual a max significa que la cola esta llena
        if (cont == max) {
            System.out.println("Cola llena");
            return;
        }

        if (front == 0 && end == 0) { // Si es igual realiza lo siguiente
            queue[front] = val;
            front --;
            cont ++;
        } else { // Si no se le resta al frente y aumenta el contador
            queue[front] = val;
            front --;
            cont ++;
        }

        if (front == -1 || end != 0) {
            front = (max-1);
        }

        if (front == max) {
            front = 0;
        }

        if (end == max) {
            end = 0;
        }

        print();
    }

    public void print() { // Metodo de impresion completa de la cola
        for (int i = 0; i < queue.length; i++) {
            System.out.println(queue[i]);
        }
    }
}
