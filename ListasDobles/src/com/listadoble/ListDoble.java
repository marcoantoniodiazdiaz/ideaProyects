/*
    ██████╗ ██╗ █████╗ ███████╗
    ██╔══██╗██║██╔══██╗╚══███╔╝
    ██║  ██║██║███████║  ███╔╝ 
    ██║  ██║██║██╔══██║ ███╔╝  
    ██████╔╝██║██║  ██║███████╗
    ╚═════╝ ╚═╝╚═╝  ╚═╝╚══════╝
*/

package com.listadoble;

public class ListDoble {
    Nodo center = null; // Se define un nodo inicial igual a null

    public void addLeft(String value) { // Metodo para insertar por el lado izquierdo
        if (center == null) { // Condicion del primer nodo para determinar si la lista esta vacia
            initialize(value); // Inicializar la lista
        } else {
            Nodo actually = center; // Se asigna el valor a un nodo actual, al nodo central
            Nodo next = actually.getLPointer(); // Se asigna el valor a otro nodo, sobre lo que esta a la izquierda del nodo central

            while (true) {
                if (next == null) { // Si no hay nada en el nodo siguiente, significa que el nodo actual es un extremo
                    Nodo aux = new Nodo(value); // Se crea un nuevo nodo
                    actually.setLPointer(aux); // Al nodo actual que a la izquierda no apunta a nada, se le asigna el nodo que se creo en la linea anterior
                    aux.setRPointer(actually); // El nuevo nodo tambien apunta a la derecha
                    break;
                }

                actually = actually.getLPointer(); // Se le asiga en valor a donde apunta el lado izquierdo
                next = next.getLPointer();
            }
        }
    }

    // Metodo para agregar al lado derecho
    public void addRight(String value) {
        if (center == null) { // Se comprueba que la lista no este vacia
            initialize(value); // Se inicializa
        } else {
            Nodo actually = center; // Se declara el valor actual al centro de la lista
            Nodo next = actually.getRPointer(); // next toma el valor de a donde apunta de lado derecho

            while (true) {
                if (next == null) { // En este caso, se llego al tope derecho
                    Nodo aux = new Nodo(value);
                    actually.setRPointer(aux);
                    aux.setLPointer(actually);
                    break;
                    // ^ Se colocan los apuntadores
                }

                actually = actually.getRPointer();
                next = next.getRPointer();
            }
        }
    }

    // Metodo para leer de izquierda a derecha
    public void leftRead() {

        if (isEmpty()) { // Se comprueba que la lista no este vacia
            System.err.println("Lista vacia");
            return;
        }

        Nodo actually = getLeftCorner(); // actually tiene el valor del nodo que esta asta la izquierda
        Nodo next = actually.getRPointer(); // next toma el valor de a donde apunta actually a la izquierda
        while (true) {
            if (center == null) {
                System.out.println("Lista vacia");
            } else {
                if (next == null) { // Se termina el ciclo y se muestra el ultimo valor
                    System.out.println(validateNonNull(actually.getLPointer()) + " <- " + actually.getElemento() + " -> " + validateNonNull(actually.getRPointer()));
                    break;
                } else {
                    // El ciclo continua
                    System.out.println(validateNonNull(actually.getLPointer()) + " <- " + actually.getElemento() + " -> " + validateNonNull(actually.getRPointer()));
                    actually = next;
                    next = next.getRPointer();
                }
            }
        }
    }

    // Este metodo contiene lo mismo que el lado derecho pero con los apuntadores invertidos
    public void rightRead() {
        if (isEmpty()) {
            System.err.println("Lista vacia");
            return;
        }

        Nodo actually = getRightCorner(); // Se toma ahora el nodo asta la derecha
        Nodo next = actually.getLPointer(); // Se recorre de derecha a izquierda
        while (true) {
            if (center == null) {
                System.out.println("Lista vacia");
            } else {
                if (next == null) {
                    System.out.println(validateNonNull(actually.getLPointer()) + " <- " + actually.getElemento() + " -> " + validateNonNull(actually.getRPointer()));
                    break;
                } else {
                    System.out.println(validateNonNull(actually.getLPointer()) + " <- " + actually.getElemento() + " -> " + validateNonNull(actually.getRPointer()));
                    actually = next;
                    next = next.getLPointer();
                }
            }
        }
    }

    // Metodo para eliminar
    public void remove(String value) {

        if (isEmpty()) { // Se comprueba que no este vacio
            System.err.println("Lista vacia");
            return;
        }

        if (oneElement()) { // Se comprueba si solo existe un elemento
            center = null;
            return;
        }

        Nodo left = getLeftCorner(); // Se guarda el nodo asta la izquierda
        Nodo right = getRightCorner(); // Se guarda el nodo asta la derecha

        if (left.getElemento().equals(value)) {
            left.getRPointer().setLPointer(null);
            return;
        } else if (right.getElemento().equals(value)) {
            right.getLPointer().setRPointer(null);
            return;
        }

        // De otra forma
        Nodo actually = left;
        Nodo next = actually.getRPointer();
        while (true) {
            if (center == null) {
                System.err.println("Lista vacia");
            } else {
                if (next == null) {
                    if (actually.getElemento().equals(value)) {
                        System.out.println("Eliminado: " + actually.getElemento());
                        // Se colocan adecuadamente los apuntadores para saltar el nodo actual
                        // actually.getLPointer().setRPointer(actually.getRPointer());
                        // actually.getRPointer().setLPointer(actually.getLPointer());
                    }
                    break;
                } else {
                    if (actually.getElemento().equals(value)) {
                        // Se colocan adecuadamente los apuntadores para saltar el nodo actual
                        System.out.println("Eliminado: " + actually.getElemento());
                        actually.getLPointer().setRPointer(actually.getRPointer());
                        actually.getRPointer().setLPointer(actually.getLPointer());
                        return;
                    }
                    actually = next;
                    next = next.getRPointer();
                }
            }
        }
    }

    // Metodo para insertar a la derecha de una referencia
    public void addRightOf(String value, String ref) {
        if (isEmpty()) { // Se comprueba si la lista no esta vacia
            System.err.println("No se encontro el elemento");
            return;
        }

        if (oneElement() && center.getElemento().equals(value)) { // Se comprueba si es el primer elemento
            Nodo aux = new Nodo(value);
            center.setRPointer(aux);
            aux.setLPointer(center);
            return;
        }

        Nodo left = getLeftCorner();
        Nodo right = getRightCorner();

        // Se comprueba si es la esquina
        if (right.getElemento().equals(ref)) {
            addRight(value);
            return;
        }

        // De otra forma
        Nodo actually = left;
        Nodo next = actually.getRPointer();
        while (true) {
            if (center == null) {
                System.err.println("Lista vacia");
            } else {
                if (next == null) {
                    break;
                } else {
                    // Continua el ciclo y se inserta el valor, se colocan los apuntadores en la posicion correcta
                    if (actually.getElemento().equals(ref)) {
                        Nodo aux = new Nodo(value);
                        actually.setRPointer(aux);
                        aux.setLPointer(actually);
                        aux.setRPointer(next);
                        next.setLPointer(aux);
                        return;
                    }
                    actually = next;
                    next = next.getRPointer();
                }
            }
        }
    }

    // Igual al metodo de insertar de lado derecho, solo con los apuntadores invertidos
    public void addLeftOf(String value, String ref) {
        if (isEmpty()) {
            System.err.println("No se encontro el elemento");
            return;
        }

        if (oneElement() && center.getElemento().equals(value)) {
            Nodo aux = new Nodo(value);
            center.setLPointer(aux);
            aux.setRPointer(center);
            return;
        }

        Nodo left = getLeftCorner();

        if (left.getElemento().equals(ref)) {
            addLeft(value);
            return;
        }

        // De otra forma
        Nodo actually = left;
        Nodo next = actually.getRPointer();
        while (true) {
            if (center == null) {
                System.err.println("Lista vacia");
            } else {
                if (next == null) {
                    break;
                } else {
                    if (actually.getElemento().equals(ref)) {
                        Nodo aux = new Nodo(value);
                        actually.setLPointer(aux);
                        aux.setRPointer(actually);
                        aux.setLPointer(next);
                        next.setRPointer(aux);
                        return;
                    }
                    actually = next;
                    next = next.getRPointer();
                }
            }
        }
    }

    // Nos reporta el ultimo nodo a la izquierda
    private Nodo getLeftCorner() {
        Nodo actually = center; // actual toma el valor del nodo central
        Nodo next = actually.getLPointer(); // next el valor al que apunta
        while (true) {
            if (center == null) { // Si no se encuentra retornamos null
                return null;
            } else {
                if (next == null) { // Si se llega al tope, retornamos ese nodo
                    return actually;
                } else { // Si no continua
                    actually = next;
                    next = next.getLPointer();
                }
            }
        }
    }

    // El mismo metodo que el anterior, solo con los apuntadores invertidos
    private Nodo getRightCorner() {
        Nodo actually = center;
        Nodo next = actually.getRPointer();
        while (true) {
            if (center == null) {
                return null;
            } else {
                if (next == null) {
                    return actually;
                } else {
                    actually = next;
                    next = next.getRPointer();
                }
            }
        }
    }

    // Nos dice si hay un elemento en la lista
    private boolean oneElement() {
        return (center.getLPointer() == null && center.getRPointer() == null);
    }

    // Nos dice si la lista esta vacia
    private boolean isEmpty() {
        return center == null;
    }

    // Elimina el ultimo valor a la izquierda
    public void removeLeft() {
        if (isEmpty()) {
            System.err.println("Lista vacia");
            return;
        }

        if (oneElement()) {
            center = null;
            return;
        }
        getLeftCorner().getRPointer().setLPointer(null); //  Si no se cumplen las condiciones anteriores se colocan los apuntadores para saltar el valor de la esquina
    }

    // Elimina el ultimo valor a la derecha
    // Es igual al metodo anterior pero con los apuntadores invertidos
    public void removeRight() {
        if (isEmpty()) {
            System.err.println("Lista vacia");
            return;
        }

        if (oneElement()) {
            center = null;
            return;
        }
        getRightCorner().getLPointer().setRPointer(null);
    }

    // Valida que el valor de un nodo no provoque un NullPointerException
    public String validateNonNull(Nodo nodo) {
        try {
            return nodo.getElemento();
        } catch (NullPointerException e) {
            return null;
        }
    }

    // Inicializa la lista
    public void initialize(String value) {
        center = new Nodo(value);
    }
}
