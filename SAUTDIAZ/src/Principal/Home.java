/*
    ██████╗ ██╗ █████╗ ███████╗
    ██╔══██╗██║██╔══██╗╚══███╔╝
    ██║  ██║██║███████║  ███╔╝ 
    ██║  ██║██║██╔══██║ ███╔╝  
    ██████╔╝██║██║  ██║███████╗
    ╚═════╝ ╚═╝╚═╝  ╚═╝╚══════╝
*/

package Principal;

import javax.swing.*;

public class Home extends JFrame {

    // Objetos
    JLabel titulo;

    public Home () {
        initObjets();
        addObjets();
        this.setSize(800, 700);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
    }

    private void initObjets() {
        titulo = new JLabel("Servicio Automotriz Diaz");
        titulo.setBounds(5,5, 300, 30);
        titulo.set;
    }

    private void addObjets() {
        this.add(titulo);
    }


}
