
package tarea3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class DepVuelto{
    private ArrayList<Moneda> m;

    public DepVuelto(){
        m = new ArrayList<>();
    }
        
    public Moneda getMoneda(){
        if(m.isEmpty()){
            return null;
        }else{
            return m.remove(0);
            }
        }
    
    public void addMoneda(Moneda mon){
        m.add(mon);
    }
    
    public void paint(Graphics g, int x,int y){
        Graphics2D exp = (Graphics2D)g;
        exp.setColor(Color.gray);
        exp.fillRect(x, y, 14, 252);
        for(int i=0; i<m.size();i++){
            m.get(i).paint(g,x,y+252-14*(i+1));
        }
        
        exp.setColor(Color.gray);
        exp.fillRect(x-60, y+230, 25, 25);
        exp.setColor(Color.BLACK);
        exp.drawRect(x-58, y+232, 20, 20);
        
        
        exp.setColor(Color.gray);
        exp.fillRect(x-63, y+150, 31, 40);
        exp.setColor(Color.BLACK);
        exp.drawOval(x-59, y+159, 22, 22);
        exp.fillRect(x-49, y+163, 3,16);
    }
    
}
