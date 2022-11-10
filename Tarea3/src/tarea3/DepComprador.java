
package tarea3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

//Esta clase es el deposito de bebidas del comprador, donde se almacenan las bebidas compradas

public class DepComprador {
    private Bebida bebida;    
    private ArrayList<Bebida> beb;
    
    public DepComprador(){
        beb= new ArrayList<Bebida>();
    }
    
    public void addBebida(Bebida b){
        if(b != null){
            if(beb.size()==9) beb.remove(0);
            beb.add(b);
        }
    }
    
    public void paint (Graphics g){
        int x= 80;
        int y = 200;
        Graphics2D dep = (Graphics2D)g;
        dep.setColor(Color.gray);               //deposito de bebidas de comprador
        dep.fillRect(x - 17, y - 180, 238, 105);
        
         for(int i=0; i<beb.size();i++){
            if(i<3) beb.get(i).setXY( x-14+(i*86), y-180); 
            else if (i<6) beb.get(i).setXY( x-272+(i*86), y-143); 
            else if(i<9) beb.get(i).setXY( x-530+(i*86), y-109); 
            if(i<9) beb.get(i).paint(g);
        }
        
    }
}
