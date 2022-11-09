
package tarea3;

import java.awt.Color;
import java.awt.Font;
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
        exp.fillRect(x, y, 24, 408);
        exp.fillRect(x+30, y, 24, 408);
        Color good = Color.green;
        Color bad = Color.black;
        Font fuente=new Font("Monospaced", Font.BOLD, 10);                
        exp.setFont(fuente);
        for(int i=0; i<m.size();i++){
            if(i>33){
                good = Color.black;
                bad = Color.red;
                break;
            }
            else{
                good = Color.green;
                bad = Color.black;
            }
            
            if(i<=16){
                m.get(i).paint(g,x,y+408-24*(i+1));
                //exp.setColor(Color.black);
                //exp.drawString(m.get(i).stringSerie(), x, y+408-24*(i+1));
            }
            else m.get(i).paint(g,x+30,y+408-24*(i+1-17));
        }
        exp.setColor(Color.darkGray);
        exp.fillRect(x+4, y-24, 46, 20);
        
        exp.setColor(good);
        exp.fillOval(x+8, y-22, 16, 16);
        exp.setColor(bad);
        exp.fillOval(x+30, y-22, 16, 16);
        
        exp.setColor(Color.gray);
        exp.fillRect(x-80, y+300, 50, 50);
        exp.setColor(Color.BLACK);
        exp.drawRect(x-76, y+304, 41, 41);
        exp.drawRect(x-77, y+303, 43, 43);
        
        
        
        exp.setColor(Color.gray);
        exp.fillRect(x-77, y+200, 45, 62);
        exp.setColor(Color.black);
        exp.fillOval(x-75, y+209, 41, 41);
        exp.setColor(Color.gray);
        exp.fillOval(x-72, y+212, 35, 35);
        exp.setColor(Color.black);
        exp.fillRect(x-57, y+215, 6,30);
    }
    
}
