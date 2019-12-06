import javax.swing.*;

public class Ventana extends JFrame{
    private JPanel panel1;

    public Ventana() {
        this.setSize(400, 400);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String args[]) {
        Ventana();
    }
}
