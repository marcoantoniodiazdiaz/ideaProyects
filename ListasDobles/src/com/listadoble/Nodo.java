/*
    ██████╗ ██╗ █████╗ ███████╗
    ██╔══██╗██║██╔══██╗╚══███╔╝
    ██║  ██║██║███████║  ███╔╝ 
    ██║  ██║██║██╔══██║ ███╔╝  
    ██████╔╝██║██║  ██║███████╗
    ╚═════╝ ╚═╝╚═╝  ╚═╝╚══════╝
*/

package com.listadoble;

public class Nodo {
    private Nodo LPointer;
    private Nodo RPointer;
    private String elemento;

    public Nodo(String elemento) {
        this.LPointer = null;
        this.RPointer = null;
        this.elemento = elemento;
    }

    public Nodo getLPointer() {
        return LPointer;
    }

    public void setLPointer(Nodo LPointer) {
        this.LPointer = LPointer;
    }

    public Nodo getRPointer() {
        return RPointer;
    }

    public void setRPointer(Nodo RPointer) {
        this.RPointer = RPointer;
    }

    public String getElemento() {
        return elemento;
    }

    /* public void setElemento(String elemento) {
        this.elemento = elemento;
    } */
}
