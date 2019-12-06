/*
    ██████╗ ██╗ █████╗ ███████╗
    ██╔══██╗██║██╔══██╗╚══███╔╝
    ██║  ██║██║███████║  ███╔╝ 
    ██║  ██║██║██╔══██║ ███╔╝  
    ██████╔╝██║██║  ██║███████╗
    ╚═════╝ ╚═╝╚═╝  ╚═╝╚══════╝
*/

package com.listadoblecircular;

public class ListDoble {

    Nodo inicio = null;

    public void add(Persona persona) {
        Nodo nuevo = new Nodo(persona); // Se crea un nuevo nodo para insertar
        nuevo.setSiguiente(nuevo); // Se les apunta a si mismos
        nuevo.setAnterior(nuevo);
        if (inicio == null) { // Si inicio es nulo significa que la lista esta vacia
            inicio = nuevo;
        } else {
            Nodo aux = inicio; // Se guarda en auxiliar el valor de inicio
            while ((aux.getSiguiente() != inicio) && (aux.getDato().getNombre().compareTo(persona.getNombre()) < 0)) {
                // ^ Se compara el valor del auxiliar con el nodo que contiene la referencia a la persona
                aux = aux.getSiguiente();
            }
            if((aux.getSiguiente() == inicio) && (aux.getDato().getNombre().compareTo(persona.getNombre()) < 0)) {
                // ^ Se comprieba la misma condicion del while
                // v Se apuntan los apuntadores correctamente para poder hacer la insercion
                aux.setSiguiente(nuevo);
                nuevo.setAnterior(aux);
                nuevo.setSiguiente(inicio);
                inicio.setAnterior(nuevo);
            } else {
                // v Se apuntan los apuntadores correctamente para poder hacer la insercion
                Nodo ant = aux.getAnterior();
                nuevo.setAnterior(ant);
                ant.setSiguiente(nuevo);
                nuevo.setSiguiente(aux);
                aux.setAnterior(nuevo);
                if ((aux == inicio) && (inicio.getDato().getNombre().compareTo(persona.getNombre()) > 0)) {
                    inicio = nuevo;
                }
            }
        }
    }

    // Metodo para imprimir en forma ascendente
    public void imprimirASC(String referencia) {

        if (inicio == null) { // Se comprueba si la lista no esta vacia
            System.err.println("Lista vacia");
            return; // kill a la ejecucion del metodo
        }

        Nodo comienzo = inicio; // Se asigna un nodo para inicio

        while (true) {
            if (inicio.getDato().getNombre().equals(referencia)) { // Si el nodo inicio coincide con el valor buscado entra
                System.out.println("Encontrado: " + inicio.getDato().getNombre()); // Alerta de que se a encontrado el nombre
                break; // Rompe el while
            }

            inicio = inicio.getSiguiente(); // De no haberse cumplido la condicion se a inicio, el nodo al que apuntaba

            if (comienzo == inicio) { // Si nunca en toda la vuelta entro en coincidencia, significa que no se encontro
                System.err.println("Elemento no encontrado");
                return;
            }
        }

        Nodo aux = inicio; // aux toma el valor para poder iniciar el recorrido desde donde se encontro la referencia
        do {
            // v Muestra el valor del nodo, y sus apuntadores
            System.out.println("[Nombre: " + aux.getAnterior().getDato().getNombre() + " | Grupo: " + aux.getAnterior().getDato().getGrupo() + "] <- [" + "Nombre: " + aux.getDato().getNombre() + " | Grupo: " + aux.getDato().getGrupo() + "] -> [" + "Nombre: " + aux.getSiguiente().getDato().getNombre() + " | Grupo: " + aux.getSiguiente().getDato().getGrupo() + "]");
            aux = aux.getSiguiente(); // Se asigna el siguiente nodo
        } while (aux != inicio);
    }

    // Metodo para imprimir en forma ascendente
    public void imprimirDESC(String referencia) {

        if (inicio == null) { // Se comprueba si la lista no esta vacia
            System.err.println("Lista vacia");
            return; // kill a la ejecucion del metodo
        }

        Nodo comienzo = inicio;

        while (true) {
            if (inicio.getDato().getNombre().equals(referencia)) { // Si el nodo inicio coincide con el valor buscado entra
                System.out.println("Encontrado: " + inicio.getDato().getNombre()); // Alerta de que se a encontrado el nombre
                break;
            }

            inicio = inicio.getAnterior(); // Se asigna un nodo para inicio

            if (comienzo == inicio) {
                System.err.println("Elemento no encontrado");
                return;
            }
        }

        Nodo aux = inicio; // aux toma el valor para poder iniciar el recorrido desde donde se encontro la referencia
        do {
            // v Muestra el valor del nodo, y sus apuntadores
            System.out.println("[Nombre: " + aux.getAnterior().getDato().getNombre() + " | Grupo: " + aux.getAnterior().getDato().getGrupo() + "] <- [" + "Nombre: " + aux.getDato().getNombre() + " | Grupo: " + aux.getDato().getGrupo() + "] -> [" + "Nombre: " + aux.getSiguiente().getDato().getNombre() + " | Grupo: " + aux.getSiguiente().getDato().getGrupo() + "]");
            aux = aux.getAnterior();
        } while (aux != inicio);
    }

    // Metodo de eliminacion
    public void remove(String referencia) {
        if (inicio == null) { // Se comprueba si la lista esta vacia
            System.err.println("Lista vacia");
            return;
        }

        Nodo comienzo = inicio; // Se asigna un nodo igual a inicio para guardar su valor

        if (inicio.getDato().getNombre().equals(referencia) && inicio.getAnterior() == inicio && inicio.getSiguiente() == inicio) {
            // ^ Si se cumple la condicion es que se a encontrado el valor buscado
            System.out.println("Encontrado: " + inicio.getDato().getNombre());
            inicio = null; // Como solo existe un elemento, se coloca null
            return;
        }

        while (true) {
            if (inicio.getDato().getNombre().equals(referencia)) {
                System.out.println("Encontrado: " + inicio.getDato().getNombre());

                // v Se colocan los apuntadores para saltar el nodo actual
                inicio.getAnterior().setSiguiente(inicio.getSiguiente());
                inicio.getSiguiente().setAnterior(inicio.getAnterior());

                return;
            }

            inicio = inicio.getSiguiente(); // En caso de no cumplirse la condicion se le asigna a donde apunta

            if (comienzo == inicio) { // Si entra a esta condicion es que no se encontro
                System.err.println("Elemento no encontrado");
                return;
            }
        }
    }
}
