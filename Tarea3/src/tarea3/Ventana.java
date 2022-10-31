
package tarea3;

import javax.swing.JFrame;

public class Ventana extends JFrame{
    PanelPrincipal panel = new PanelPrincipal();
    public Ventana(){
        this.setSize(500, 500);     //Establecemos el tamaño de la ventana
        setTitle("Ventana");
        this.add(panel);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);    //Cierra la ventana
        
    }
}
