package tarea3;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelPrincipal extends JPanel implements MouseListener{
    Moneda mon1500=new Moneda1500(4000);
    int xExp = 170;
    int yExp = 83;
    
    private Comprador com;
    private Expendedor exp;

    public PanelPrincipal () {
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
    public void mouseClicked(MouseEvent me) {                   //esto permite que con los clicks se puedan retirar bebidas y vuelto del expendedor
        int x = me.getX( );
        int y = me.getY( );
        System.out.println(x + " " + y);
        
        if(x>=310 && x<=450 && y>=365 && y<=395 ){      
            System.out.println("Devolviendo bebida");
            if(com != null) com.getBebida(exp);
            this.repaint();                                                              
        }
        
        if(x>=220 && x<=245 && y>=325 && y<=350 ){
            System.out.println("Devolviendo vuelto");
            com.getVuelto(exp);
            this.repaint();
        }
        
        if(x>=220 && x<=250){
            if(y>=105 && y<=125){
                this.com = new Comprador(mon1500, 1, exp);
                System.out.println("Intentando comprar una coca");
            }
            else if(y>=140 && y<=160){
                this.com = new Comprador(mon1500, 2, exp);
                System.out.println("Intentando comprar una sprite");
            }
            else if(y>=175 && y<=195){
                this.com = new Comprador(mon1500, 3, exp);
                System.out.println("Intentando comprar una fanta");
            }
           this.repaint();
        }
    }

    @Override   public void mousePressed(MouseEvent e) {
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