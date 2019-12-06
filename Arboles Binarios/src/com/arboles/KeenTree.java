/*
    ██████╗ ██╗ █████╗ ███████╗
    ██╔══██╗██║██╔══██╗╚══███╔╝
    ██║  ██║██║███████║  ███╔╝ 
    ██║  ██║██║██╔══██║ ███╔╝  
    ██████╔╝██║██║  ██║███████╗
    ╚═════╝ ╚═╝╚═╝  ╚═╝╚══════╝
*/

package com.arboles;

import java.util.Stack;

public class KeenTree {

    private Nodo root;

    private Stack<Nodo> stack = new Stack<>();

    public KeenTree() {
        root = null;
    }

    public void add(String value) {

        Nodo insert = new Nodo(value);

        if (isEmpty()) {
            root = insert;
            return;
        }

        if (oneElement()) {
            if (insert.getData().compareTo(root.getData()) < 0) {
                root.setIzquierda(insert);
            } else {
                root.setDerecha(insert);
            }
            return;
        }

        Nodo aux = root;
        while (true) {
            if (insert.getData().compareTo(aux.getData()) < 0) {
                if (aux.getIzquierda() == null) {
                    aux.setIzquierda(insert);
                    return;
                } else {
                    aux = aux.getIzquierda();
                }
            } else {
                if (aux.getDerecha() == null) {
                    aux.setDerecha(insert);
                    return;
                } else {
                    aux = aux.getDerecha();
                }
            }
        }
    }

    public void inorden() {
        Nodo aux = root;

        do {
            if (aux != null) {
                stack.push(aux);
                aux = aux.getIzquierda();
            } else if (!(stack.empty())) {
                aux = stack.pop();
                System.out.println("- " + aux.getData());
                aux = aux.getDerecha();
            }
        } while (!(stack.empty()) || aux != null);

    }

    public void preeorden() {
        Nodo aux = root;

        do {
            if (aux != null) {
                stack.push(aux);
                System.out.println("- " + aux.getData());
                aux = aux.getIzquierda();
            } else if (!(stack.empty())) {
                aux = stack.pop();
                aux = aux.getDerecha();
            }
        } while (!(stack.empty()) || aux != null);

    }

    public void postorden() throws NullPointerException {

        Nodo aux = root;
        Nodo ant = root;

        boolean down = true;
        boolean up = true;

        do {
            if (down) {
                if (aux.getIzquierda() != null) {
                    stack.push(aux);
                    aux = aux.getIzquierda();
                    up = false;
                } else if (aux.getDerecha() != null) {
                    stack.push(aux);
                    aux = aux.getDerecha();
                    up = false;
                } else {
                    System.out.println("- " + aux.getData());
                    ant = aux;
                    aux = stack.pop();
                    up = true;
                    down = false;
                }
            } else if (up) {
                if (ant == aux.getIzquierda()) {
                    if (aux.getDerecha() != null) {
                        stack.push(aux);
                        down = true;
                        aux = aux.getDerecha();
                    } else {
                        System.out.println("- " + aux.getData());
                        ant = aux;
                        aux = stack.pop();
                        up = true;
                    }
                } else if (ant == aux.getDerecha()) {
                    System.out.println("- " + aux.getData());
                    ant = aux;
                    aux = stack.pop();
                    up = true;
                }
            }
        } while (aux != null || stack.empty());

    }

    public void delete(String data) {
        Nodo bef;
        Nodo aux = root;

        if (aux == null) {
            System.out.println("Arbol vacio");
        } else {
            while (true) {
                if (data.equals(aux.getData())) {
                    System.out.println("Elemento eliminado\n");

                    if (aux.getData().equals(root.getData())) {
                        bef = root;
                        aux = root.getDerecha();

                        while (true) {
                            if (aux.getDerecha() == null && aux.getIzquierda() == null) {

                                System.out.println("Elemento eliminado");

                                if (bef.getData() == root.getData()) {
                                    bef.setDerecha(null);
                                } else {
                                    bef.setIzquierda(null);
                                }

                                root.setData(aux.getData());
                                return;
                            } else {
                                if (aux.getDerecha() == null && aux.getIzquierda() != null) {
                                    bef = aux;
                                    aux = aux.getIzquierda();
                                } else if (aux.getDerecha() != null && aux.getIzquierda() == null) {
                                    bef = aux;
                                    aux = aux.getDerecha();
                                } else if (aux.getDerecha() != null && aux.getIzquierda() != null) {
                                    bef = aux;
                                    aux = aux.getIzquierda();
                                }
                            }
                        }

                    }
                    return;
                } else if (!(data.equals(aux.getData()))) {
                    if (data.compareTo(aux.getData()) < 0) {
                        aux = aux.getIzquierda();
                    } else if (data.compareTo(aux.getData()) > 0) {
                        aux = aux.getDerecha();
                    }
                }
            }
        }
    }

    private boolean isEmpty() {
        return root == null;
    }

    private boolean oneElement() {
        return root.getIzquierda() == null && root.getDerecha() == null;
    }

}
