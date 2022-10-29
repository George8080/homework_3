
package tarea3;

import javax.swing.JFrame;

public class Ventana extends JFrame{
    public Ventana(){
        this.setSize(500, 500);     //Establecemos el tamaño de la ventana
        setTitle("Ventana");
        setLocation(750, 200);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);    //Cierra la ventana
        
    }
}
