/*
    ██████╗ ██╗ █████╗ ███████╗
    ██╔══██╗██║██╔══██╗╚══███╔╝
    ██║  ██║██║███████║  ███╔╝ 
    ██║  ██║██║██╔══██║ ███╔╝  
    ██████╔╝██║██║  ██║███████╗
    ╚═════╝ ╚═╝╚═╝  ╚═╝╚══════╝
*/

import java.io.IOException;
import java.util.Scanner;
import pkg2.pkg2.par.o.impar.ParOImpar;
import algortrecursivo.AlgortRecursivo;
import divisor.Divisor;
import factorial.i.r.FactorialIR;
import unidad2recursividadfibonacci.UNIDAD2RECURSIVIDADFIBONACCI;
import potencia.Potencia;
import sumamatrizrecursivo.Execute;
import u2.invertirn.U2InvertirN;

public class Unidad2 {

    Scanner sc = new Scanner(System.in);

    public void run() {
        while (true) {
            String opc;
            System.out.println("" +
                    "════════════════ MENU ════════════════ \n" +
                    "1. Par o impar \n" +
                    "2. Suma de numeros\n" +
                    "3. Divisor\n" +
                    "4. Factorial I-R\n" +
                    "5. Fibonacci\n" +
                    "6. Potencia\n" +
                    "7. Suma Matriz Recursivo\n" +
                    "8. Invertir N\n" +
                    "A. Salir \n");
            while (true) {
                System.out.print("Ingresa una opcion: ");
                opc = sc.next();
                if (opc.matches("^[1-8A]$")) break;
            }

            switch (opc.charAt(0)) {
                case '1':
                    try {
                        ParOImpar.execute();
                    } catch (IOException e) {
                        System.out.println("IOException Error");
                    }
                    break;
                case '2': AlgortRecursivo.execute(); break;
                case '3': Divisor.execute(); break;
                case '4': FactorialIR.execute(); break;
                case '5': UNIDAD2RECURSIVIDADFIBONACCI.execute(); break;
                case '6': Potencia.execute(); break;
                case '7': new Execute().exe(); break;
                case '8': U2InvertirN.execute(); break;
                case 'A': return;
            }
        }
    }
}
