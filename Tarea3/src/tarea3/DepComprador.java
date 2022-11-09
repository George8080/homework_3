
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
            beb.add(b);
    }
    
    public void paint (Graphics g){
        int x= 30;
        int y = 200;
        Graphics2D dep = (Graphics2D)g;
        dep.setColor(Color.gray);               //deposito de bebidas de comprador
        dep.fillRect(x - 17, y - 180, 140, 50);
        
         for(int i=0; i<beb.size();i++){
            if(i<4) beb.get(i).paint(g,x-15+(i*35), y-180);
            else if (i>3) beb.get(i).paint(g,x-155+(i*35), y-153);
        }
        
    }
}
