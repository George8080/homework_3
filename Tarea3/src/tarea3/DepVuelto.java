
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
        exp.fillRect(x, y, 14, 220);
        for(int i=0; i<m.size();i++){
            m.get(i).paint(g,x,y+220-14*(i+1));
        }
    }
    
}
