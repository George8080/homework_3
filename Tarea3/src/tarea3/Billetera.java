
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
        int x = 80;
        int y = 280;
        Graphics2D dep = (Graphics2D) g;
        dep.setColor(Color.gray);               //deposito de monedas de comprador
        dep.fillRect(x - 17, y - 120, 238, 102);
        
         for (int i=0; i<mon.size();i++){
            if(i<8) mon.get(i).paint(g,x-15+(i*30), y-120);
            else if(i<16) mon.get(i).paint(g,x-255+(i*30), y-95);
            else if(i<24) mon.get(i).paint(g, x-495+(i*30), y-70);
            else if(i<32) mon.get(i).paint(g, x-735+(i*30), y-45);
        }
    }
}
