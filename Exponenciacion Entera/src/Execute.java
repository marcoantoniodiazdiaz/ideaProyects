/*
    ██████╗ ██╗ █████╗ ███████╗
    ██╔══██╗██║██╔══██╗╚══███╔╝
    ██║  ██║██║███████║  ███╔╝ 
    ██║  ██║██║██╔══██║ ███╔╝  
    ██████╔╝██║██║  ██║███████╗
    ╚═════╝ ╚═╝╚═╝  ╚═╝╚══════╝
*/

import java.util.Scanner;

public class Execute {

    Scanner sc = new Scanner(System.in);

    public void exe() {
        System.out.print("Ingresa el numero a elevar: ");
        int a = sc.nextInt();
        System.out.print("Al numero que quieres elevar: ");
        int b = sc.nextInt();

        System.out.println(exponenciar(a, b));
    }

    private int exponenciar(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            if (a >= b) {
                return exponenciar(a-b, b);
            } else {
                return exponenciar(a, b-a);
            }
        }
    }

}
