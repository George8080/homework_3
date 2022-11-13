
package tarea3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

//Esta clase es el deposito de bebidas del comprador, donde se almacenan las bebidas compradas

public class DepComprador {
    // Definir solo un arreglo de bebidas.
    private ArrayList<Bebida> beb;
    
    public DepComprador(){
        // Constructor. Solo inicializar el ArrayList.
        beb= new ArrayList<Bebida>();
    }
    
    public void addBebida(Bebida b){
        // Añadir bebida nueva y, si no queda espacio en el deposito, borrar la mas antigua.
        if(b != null){
            if(beb.size()==9) beb.remove(0);
            beb.add(b);
        }
    }
    
    public void paint (Graphics g){
        // Metodo para pintar el deposito.
        Graphics2D dep = (Graphics2D)g;
        
        // Definir la posicion base.
        int x= 80;
        int y = 200;
        
        // Pintar el deposito de bebidas de comprador
        dep.setColor(Color.gray);
        dep.fillRect(x - 17, y - 180, 238, 105);
        
         for(int i=0; i<beb.size();i++){    // Por cada bebida pintarla en alguna de las 3 filas.
            if(i<3) beb.get(i).setXY( x-14+(i*86), y-178); 
            else if (i<6) beb.get(i).setXY( x-272+(i*86), y-141); 
            else if(i<9) beb.get(i).setXY( x-530+(i*86), y-107); 
            if(i<9) beb.get(i).paint(g);
        }
        
    }
}
