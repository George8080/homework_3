
package tarea3;

import javax.swing.JFrame;
import java.awt.Dimension;

public class Ventana extends JFrame{
    PanelPrincipal panel = new PanelPrincipal(); 
    
    public Ventana(){
        panel= new PanelPrincipal();
        
        this.setSize(500, 500);     //Establecemos el tamaño de la ventana
        setTitle("Ventana");
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(200, 200));
        this.add(panel);
        //this.getContentPane().setBackground(Color.WHITE);
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);    //Cierra la ventana
    this.setSize(500, 500);     //Establecemos el tamaño de la ventana
    }  

}
