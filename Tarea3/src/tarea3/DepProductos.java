
package tarea3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class DepProductos {
    // Creacion de los atributos del Deposito para el Producto. Solo posee una Bebida.
    private Bebida beb;
    
    public DepProductos(){
        // Constructor. Solo inicializa la bebida.
        beb = null;
    }
    
    public Bebida verContenedor(){   // Retornar la bebida.
        return beb;
    }
    public void addBebida(Bebida b){ // Añadir una bebida.
        beb = b;
    }
    public Bebida getBebida(){       // Extraer la bebida.
        Bebida b = beb;
        beb = null;
        return b;
    }
    
    public void paint(Graphics g, int x,int y){
        // Pintar el espacio para las bebidas
        Graphics2D exp = (Graphics2D)g;
        exp.setColor(Color.gray);
        exp.fillRect(x, y, 220, 50);
        
        // Si hay una bebida colocarla en su lugar e imprimirla.
        if(beb != null){
           beb.setXY(x+80, y+20);
           beb.paint(g);
        }
    }
}
