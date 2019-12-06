/*
    ██████╗ ██╗ █████╗ ███████╗
    ██╔══██╗██║██╔══██╗╚══███╔╝
    ██║  ██║██║███████║  ███╔╝ 
    ██║  ██║██║██╔══██║ ███╔╝  
    ██████╔╝██║██║  ██║███████╗
    ╚═════╝ ╚═╝╚═╝  ╚═╝╚══════╝
*/

public class Lista {

    private Nodo root;

    public Lista() {
        root = null;
    }

    public void add(int pos, String value) {
        if (pos <= size() + 1)    {
            Nodo nuevo = new Nodo ();
            nuevo.value = value;
            if (pos == 1){
                nuevo.sig = root;
                if (root!=null)
                    root.ant=nuevo;
                root = nuevo;
            } else
            if (pos == size() + 1)    {
                Nodo reco = root;
                while (reco.sig != null) {
                    reco = reco.sig;
                }
                reco.sig = nuevo;
                nuevo.ant=reco;
                nuevo.sig = null;
            } else {
                Nodo reco = root;
                for (int f = 1 ; f <= pos - 2 ; f++)
                    reco = reco.sig;
                Nodo siguiente = reco.sig;
                reco.sig = nuevo;
                nuevo.ant=reco;
                nuevo.sig = siguiente;
                siguiente.ant=nuevo;
            }
        }
    }

    public String get(int pos) {
        if (pos <= size())    {
            String value;
            if (pos == 1) {
                value = root.value;
                root = root.sig;
                if (root!=null)
                    root.ant=null;
            } else {
                Nodo reco = root;
                for (int f = 1 ; f <= pos - 2 ; f++)
                    reco = reco.sig;
                Nodo aux = reco.sig;
                reco.sig = aux.sig;
                Nodo next = aux.sig;
                if (next != null)
                    next.ant = reco;
                value = aux.value;
            }
            return value;
        } else {
            return null;
        }
    }

    public void delete (int pos) {
        if (pos <= size())    {
            if (pos == 1) {
                root = root.sig;
                if (root!=null)
                    root.ant=null;
            } else {
                Nodo reco;
                reco = root;
                for (int f = 1 ; f <= pos - 2 ; f++) {
                    reco = reco.sig;
                }
                Nodo prox = reco.sig;
                prox=prox.sig;
                reco.sig = prox;
                if (prox != null) {
                    prox.ant = reco;
                }
            }
        }
    }

    public void getAll ()
    {
        Nodo reco = root;
        while (reco != null) {
            System.out.print (reco.value + "-");
            reco = reco.sig;
        }
        System.out.println();
    }

    public int size () {
        int cant = 0;
        Nodo aux = root;
        while (aux != null) {
            aux = aux.sig;
            cant ++;
        }
        return cant;
    }

}
