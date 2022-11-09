
package tarea3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Billetera {
  private Moneda moneda;
  private ArrayList<Moneda> mon;
  
  public Billetera(){
      mon= new ArrayList<>();
  }
  
  public void addMoneda(Moneda m){
      mon.add(m);
  }
 
  public void paint(Graphics g){
        int x = 30;
        int y = 200;
        Graphics2D dep = (Graphics2D) g;
        dep.setColor(Color.gray);               //deposito de monedas de comprador
        dep.fillRect(x - 17, y - 120, 140, 50);
        
         for (int i=0; i<mon.size();i++){
            if(i<7) mon.get(i).paint(g,x-15+(i*20), y-120);
            else if(i>6) mon.get(i).paint(g,x-155+(i*20), y-90);
        }
    }
}
