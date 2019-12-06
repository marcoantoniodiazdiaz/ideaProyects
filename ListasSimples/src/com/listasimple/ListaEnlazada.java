package com.listasimple;/*
    ██████╗ ██╗ █████╗ ███████╗
    ██╔══██╗██║██╔══██╗╚══███╔╝
    ██║  ██║██║███████║  ███╔╝ 
    ██║  ██║██║██╔══██║ ███╔╝  
    ██████╔╝██║██║  ██║███████╗
    ╚═════╝ ╚═╝╚═╝  ╚═╝╚══════╝
*/

public class ListaEnlazada {

    private Nodo primero;
    private Nodo ultimo;
    private int tam;

    public ListaEnlazada() { // Constructor
        primero = null; // Inicializacion de los apuntadores
        ultimo = null;
        tam = 0; // Variable que comprueba el tamaño de la lista
    }

    public boolean isEmpty() {
        return tam == 0;
    } // Comprueba si la lista esta vacia

    public int size() {
        return tam;
    } // Retorna el tamaño de la lista

    public String get(int index) { // Toma el valor de un nodo deacuerdo a su indice

        if (isEmpty() || (index < 0 || index >= size())) { // Comprueba si esta vacia o si el indice no es valido
            return null;
        } else if (index == 0) { // Comprueba si el indice es igual a 0, entonces es el principio
            return getFirst(); // Retorna el primer valor
        } else if (index == size() - 1) { // Comprueba si el indice es igual a el maximo, entonces es el final
            return getLast(); // Retorna el ultimo valor
        } else {

            Nodo buscado = getNode(index); // Buscado llama al metodo que retorna el nodo

            return buscado.getElemento();

        }
    }

    public String getFirst() { // Retorna el primer nodo

        if (isEmpty()) { // Se comprueba si la lista esta vacia
            return null;
        } else {
            return primero.getElemento(); // Retorna el primer nodo
        }
    }

    public String getLast() {
        if (isEmpty()) { // Se comprueba si la lista esta vacia
            return null;
        } else {
            return ultimo.getElemento(); // Retorna el ultimo nodo
        }
    }

    private Nodo getNode(int index) { // Retorna un nodo deacuerdo su indice

        if (isEmpty() || (index < 0 || index >= size())) { // Se comprueba si la lista esta vacia y que los indices son correctos
            return null;
        } else if (index == 0) { // Si se cumple retorna el valor del primer nodo
            return primero;
        } else if (index == size() - 1) {
            return ultimo; // Si se cumple retorna el valor del ultimo nodo
        } else {

            Nodo buscado = primero;

            int contador = 0;
            while (contador < index) {
                contador++;
                buscado = buscado.getSiguiente();
            }

            return buscado;

        }

    }

    public String addLast(String elemento) { // Agrega al final

        Nodo aux;

        if (isEmpty()) { // Comprueba si la lista esta vacia
            return addFirst(elemento);
        } else {

            aux = new Nodo(elemento, null);

            ultimo.setSiguiente(aux); // Se colocan los apuntadores para poder recorrese
            ultimo = aux;

        }

        tam ++; // Aumenta el tamaño de la lista
        return ultimo.getElemento(); // Retorna el ultimo valor

    }

    public String addFirst(String elemento) { // Agrega al principio

        Nodo aux;

        if (isEmpty()) { // Comprueba si la lista esta vacia
            aux = new Nodo(elemento, null);
            primero = aux;
            ultimo = aux;
        } else {
            Nodo primeroActual = primero; // Se colocan los apuntadores para poder recorrese
            aux = new Nodo(elemento, primeroActual);
            primero = aux;
        }


        tam ++; // Aumenta el tamaño de la lista
        return primero.getElemento(); // Retorna el ultimo valor
    }

    public String add(String elemento, int index) { // Agrega en un indice

        if (index == 0) { // Se comprueba si es una la posicion 1
            return addFirst(elemento); // Se agrega al inicio
        } else if (index == size()) { // Si es el tamaño maximo
            return addLast(elemento);
        } else if ((index < 0 || index >= size())) {
            return null;
        } else {
            // Apuntadores para recorrer el arreglo
            Nodo buscado_anterior = getNode(index - 1);
            Nodo buscado_actual = getNode(index);
            Nodo aux = new Nodo(elemento, buscado_actual);
            buscado_anterior.setSiguiente(aux);
            tam ++;
            return getNode(index).getElemento();

        }

    }

    // Elimina el primer elemento de la lista
    public String removeFirst() {
        if (isEmpty()) { // Comprueba que la lista no este vacia
            return null;
        } else {
            String elemento = primero.getElemento(); // elemento se inicia en el primer elemento

            // Se apunta para saltar el primer elemento
            Nodo aux = primero.getSiguiente();
            primero = null;
            primero = aux;

            // Si es el utlimo valor se cola en null
            if (size() == 1) {
                ultimo = null;
            }

            tam --; //  El tamaño de la lista se reduce en 1

            return elemento;

        }

    }

    // Elimina el ultimo elemento de la lista
    public String removeLast() {

        if (isEmpty()) { // Comprueba que la lista no este vacia
            return null;
        } else {

            String elemento = ultimo.getElemento(); // elemento se inicia en el primer elemento
            // Se apunta para saltar el primer elemento
            Nodo aux = getNode(size() - 2);

            if (aux == null) {

                ultimo = null;

                if (size() == 2) {
                    ultimo = primero;
                } else {
                    primero = null;
                }

            } else {
                // Se salta el apuntador
                ultimo = null;
                ultimo = aux;
                ultimo.setSiguiente(null);
            }

            tam --;

            return elemento;

        }

    }

    // Metodo de eliminacion
    public String remove(int index) {
        if (isEmpty() || (index < 0 || index >= size())) { //  Comprueba que la lista no este vacia o el indice sea invalido
            return null;
        } else if (index == 0) {
            return removeFirst(); // Elimina el primer nodo
        } else if (index == size() - 1) {
            return removeLast(); // Elimina el ultimo nodo
        } else {
            // Si no se cumplieron las condiciones anteriores, entonces se colocan los nodos para saltar el apuntador de el nodo a eliminar
            Nodo nodo_anterior = getNode(index - 1);
            Nodo nodo_actual = getNode(index);
            String elemento = nodo_actual.getElemento();
            Nodo nodo_siguiente = nodo_actual.getSiguiente();
            nodo_anterior.setSiguiente(nodo_siguiente);

            tam --; // Se reduce el valor de la lista

            return elemento;

        }
    }
}
