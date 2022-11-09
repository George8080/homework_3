
package tarea3;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelPrincipal extends JPanel implements MouseListener{
    Moneda mon100=new Moneda100();
    Moneda mon500=new Moneda500();
    Moneda mon1000=new Moneda1000();
    Moneda mon1500=new Moneda1500();
    private int xExp = 380;
    private int yExp = 80;
    
    private Comprador com;
    private Expendedor exp;

    public PanelPrincipal () {
        // 12 máximo visible
        exp = new Expendedor (12, 1000);
        com = new Comprador(null,0,exp);
        this.setBackground(Color.pink);
        this.addMouseListener(this);
    }
    
    @Override
    public void paint (Graphics g) {
        super.paint(g); 
        com.paint(g); 
        exp.paint(g,xExp,yExp);
    }
    
    @Override
    public void mouseClicked(MouseEvent me) {
        int x = me.getX( );
        int y = me.getY( );
        System.out.println(x + " " + y);
        
        if(x>=xExp+180 && x<=xExp + 400 && y>=yExp+430 && y<=yExp+480 ){
            System.out.println("Devolviendo bebida");
            if(com != null) com.getBebida(exp);
            this.repaint();
        }
        
        else if(x>=xExp+40 && x<=xExp+90 && y>=340+yExp && y<=390+yExp ){
            System.out.println("Devolviendo vuelto");
            com.getVuelto(exp);
            this.repaint();
        }
        
        else if(x>=xExp+25 && x<=xExp+90 && y>=yExp+40 && y<=yExp+90){
            System.out.println("Intentando comprar una coca");
            this.com = new Comprador(mon1500, 1, exp);
            this.repaint();
        }
        else if(x>=xExp+25 && x<=xExp+90 && y>=yExp+100 && y<=yExp+150){
            System.out.println("Intentando comprar una sprite");
            this.com = new Comprador(mon1500, 2, exp);
            this.repaint();
        }
        else if(x>=xExp+25 && x<=xExp+90 && y>=yExp+160 && y<=yExp+210){
            System.out.println("Intentando comprar una fanta");
            this.com = new Comprador(mon1500, 3, exp);
            this.repaint();
        }
        else if(x>=xExp && x<=xExp+420 && y>=yExp && y<=yExp + 520){
            System.out.println("Rellenando contenedores vacios");
            exp.llenarContenedores(12, 1000);
            this.repaint();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        ;//throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        ;//throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        ;//throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseExited(MouseEvent e) {
        ;//throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
