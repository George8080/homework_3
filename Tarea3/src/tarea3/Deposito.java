
package tarea3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;


public class Deposito{
    private ArrayList<Bebida> v;
    
    public Deposito(int cant){
        v = new ArrayList<Bebida>(cant);
    }
    public Bebida getBebida(){
        if(v.isEmpty()){
            return null;
        }else{
            return v.remove(0);
        }
    }
    public void addBebida(Bebida drink){
        v.add(drink);
    }
    
    public int returnSize(){
        return v.size();
    }
    public void paint(Graphics g, int x, int y){
        Graphics2D exp = (Graphics2D)g;
        exp.setColor(Color.gray);
        exp.fillRect(x, y, 70, 399);
        for(int i=0; i<v.size();i++){
            v.get(i).setXY(x+5,y+399-33*(i+1));
            v.get(i).paint(g);
        }
    }
}
