
package tarea3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class DepProductos {
    private Bebida beb;
    public DepProductos(){
        beb = null;
    }
    public Bebida verContenedor(){
        return beb;
    }
    public void addBebida(Bebida b){
        beb = b;
    }
    public Bebida getBebida(){
        Bebida b = beb;
        beb = null;
        return b;
    }
    public void paint(Graphics g, int x,int y){
        Graphics2D exp = (Graphics2D)g;
        exp.setColor(Color.gray);
        exp.fillRect(x, y, 220, 50);
        if(beb != null){
           beb.setXY(x+80, y+20);
           beb.paint(g);
        }
    }
}