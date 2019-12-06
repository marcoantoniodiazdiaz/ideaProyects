/*
    ██████╗ ██╗ █████╗ ███████╗
    ██╔══██╗██║██╔══██╗╚══███╔╝
    ██║  ██║██║███████║  ███╔╝ 
    ██║  ██║██║██╔══██║ ███╔╝  
    ██████╔╝██║██║  ██║███████╗
    ╚═════╝ ╚═╝╚═╝  ╚═╝╚══════╝
*/

package com.company;

import java.util.Arrays;

public class Lista {

    private int max = 1;
    private String list[] = new String[max];

    public void addStart(String value) {
        redimencionar();

        for (int i = max-2; i >= 0 ; i--) {
            list[i+1] = list[i];
        }

        list[0] = value;
        max ++;
    }

    public void add(String value) {
        redimencionar();
        list[max-1] = value;
        max ++;
    }

    public void remove(int pos) {
        String aux[] = list;

        max -= 2;
        redimencionar();

        for (int i = 0; i < aux.length; i++) {
            boolean find = false;

            if ((pos-1) == i) {
                //
            } else {
                list[i] = aux[i];
            }
        }
    }

    public String get(int pos) {
        if (pos <= 0 || pos > max-1) {
            System.err.println("Posicion no valida");
            return null;
        }
        return list[pos-1];
    }

    public void set(String value, int pos) {
        if ((pos+1) > max-1) {
            System.err.println("Posicion no valida");
        } else {
            list[pos] = value;
        }
    }

    public void print() {
        for (String s : list) {
            System.out.println(s);
        }
    }

    private void redimencionar() {
        list = Arrays.copyOf(list, max);
    }


}
