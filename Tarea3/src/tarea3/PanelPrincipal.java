
package tarea3;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

public class PanelPrincipal extends JPanel{
    Moneda100 mon100=new Moneda100();
    Moneda500 mon500=new Moneda500();
    Moneda1000 mon1000=new Moneda1000();
    Moneda1500 mon1500=new Moneda1500();
    
    private Comprador com;
    private Expendedor exp;

    public PanelPrincipal () {
    exp = new Expendedor (2, 1000);
    com = new Comprador(mon1500, 1, exp);
    this.setBackground(Color.white);
    }
    
    public void paint (Graphics g) {
        super.paint(g); 
        //com.paint(g); 
        //exp.paint(g)
    }
}
