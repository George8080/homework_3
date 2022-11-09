
package tarea3;

import javax.swing.JFrame;

public class Ventana extends JFrame{
    PanelPrincipal panel = new PanelPrincipal();
    public Ventana(){
        this.setSize(850, 700);     //Establecemos el tamaño de la ventana
        this.setResizable(false);
        setTitle("Ventana");
        this.add(panel);
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);    //Cierra la ventana
        
    }
}
