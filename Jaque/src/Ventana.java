/*
    ██████╗ ██╗ █████╗ ███████╗
    ██╔══██╗██║██╔══██╗╚══███╔╝
    ██║  ██║██║███████║  ███╔╝ 
    ██║  ██║██║██╔══██║ ███╔╝  
    ██████╔╝██║██║  ██║███████╗
    ╚═════╝ ╚═╝╚═╝  ╚═╝╚══════╝
*/

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {

    public Ventana() {
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        addItems();


    }

    public void addItems() {
        JLabel titulo = new JLabel("Ingresa un numero: ");
        titulo.setBounds(5, 5, 200, 25);

        TextField caja1 = new TextField("");
        caja1.setBounds(5, 35, 200, 25);

        JLabel titulo2 = new JLabel("Ingresa otro numero: ");
        titulo.setBounds(5, 65, 200, 25);

        TextField caja2 = new TextField("");
        caja1.setBounds(5, 95, 200, 25);

        this.add(titulo);
        this.add(caja1);
        this.add(titulo2);
        this.add(caja2);
    }

}
