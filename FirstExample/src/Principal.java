import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) {

        String CIFRADO = "";

        int N = sc.nextInt();

        if (!(N >= 3 && N <= 20)) {
            return;
        }

        List<String> lines = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String line = sc.next();
            if (line.length() >= 1 && line.length() <= 100) {
                lines.add(line);
            } else {
                return;
            }
        }

        String ALL = "";

        for (String line : lines) {
            ALL += line;
        }

        int cont = 0;
        for (int i = 0; i < ALL.length(); i++) {
            if (cont == 15 && ALL.charAt(i) != 'X' && (ALL.charAt(i-1) != 'I' && ALL.charAt(i-1) != 'O')) {
                CIFRADO += ALL.charAt(i);
                cont = 0;
            } else {
                cont ++;
            }
        }

        System.out.println(CIFRADO);

        char end = CIFRADO.charAt(CIFRADO.length() - 1 );

        if (CIFRADO.contains("TRIANGULO")) {
            for (int i = 0; i < (""+end).codePointAt(0) - 63; i++) {
                for (int j = 0; j < i; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        } else if (CIFRADO.contains("CUADRADO")) {
            for (int i = 0; i < (""+end).codePointAt(0) - 63; i++) {
                for (int j = 0; j < (""+end).codePointAt(0) - 63; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }
    }


}