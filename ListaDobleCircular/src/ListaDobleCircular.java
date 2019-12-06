/*
    ██████╗ ██╗ █████╗ ███████╗
    ██╔══██╗██║██╔══██╗╚══███╔╝
    ██║  ██║██║███████║  ███╔╝ 
    ██║  ██║██║██╔══██║ ███╔╝  
    ██████╔╝██║██║  ██║███████╗
    ╚═════╝ ╚═╝╚═╝  ╚═╝╚══════╝
*/

public class ListaDobleCircular {

    Nodo inicio;

    public ListaDobleCircular() {
        inicio = null;
    }

    public void insertarInicio(String value){
        Nodo nuevo = new Nodo(value);
        if (inicio == null) {
            inicio = nuevo;
        } else {
            Nodo aux = inicio;
            while(aux.getSiguiente() != inicio) {
                aux = aux.getSiguiente();
                aux.setSiguiente(nuevo);
                nuevo.setAnterior(aux);
                nuevo.setSiguiente(inicio);
                inicio.setAnterior(nuevo);
                inicio = nuevo;
            }

        }
    }

    public void insertarFinal(String value){
        Nodo nuevo = new Nodo(value);
        if(inicio == null)
            inicio = nuevo;
        else{
            Nodo aux = inicio;
            while (aux.getSiguiente() != inicio) {
                aux = aux.getSiguiente();
                aux.setSiguiente(nuevo);
                nuevo.setAnterior(aux);
                nuevo.setSiguiente(inicio);
                inicio.setAnterior(nuevo);
            }
        }
    }

    public void imprimir(){
        if(inicio==null)
            System.out.println("Lista vacia");
        else{
            Nodo aux = inicio;
            System.out.print("<-> Inicio");
            do {
                System.out.print(" <-> " + aux.getElemento());
                aux = aux.getSiguiente();
            } while(aux != inicio);
            System.out.println(" <-> NULL <->");
        }
    }

    public boolean buscar(String value){
        Nodo aux = inicio;
        while((aux.getSiguiente() != inicio) && (!(aux.getElemento().equals(value))))
            aux = aux.getSiguiente();
        return aux.getElemento().equals(value);
    }

    public void eliminaValor(String d) {
        if (inicio != null){
            Nodo aux = inicio;
            Nodo ant = null;
            while (aux.getSiguiente() != inicio){
                if (aux.getElemento().equals(d)){
                    if (ant == null){
                        if (aux.getSiguiente() == inicio) {
                            inicio = null;
                        } else {
                            ant = aux.getAnterior();
                            ant.setSiguiente(aux.getSiguiente());
                            aux = aux.getSiguiente();
                            aux.setAnterior(ant);
                            inicio = aux;
                            ant = null;
                        }
                    } else {
                        aux.setAnterior(null);
                        ant.setSiguiente(aux.getSiguiente());
                        aux = aux.getSiguiente();
                        aux.setAnterior(ant);
                    }
                } else {
                    ant = aux;
                    aux = aux.getSiguiente();
                }
            }
        } else {
            System.err.println("Error");
        }
    }

}
