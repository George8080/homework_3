
package tarea3;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import static java.lang.String.valueOf;
import javax.swing.Timer;

public class PanelPrincipal extends JPanel implements MouseListener, ActionListener {
    private int xExp = 380;
    private int yExp = 80;
    
    private Comprador com;
    private Expendedor exp;
    private int chosenCoin;
    private int animation;
    private int counter = 0;

    public PanelPrincipal () {
        // 12 máximo visible
        exp = new Expendedor (12, 1000);
        com = new Comprador(0,0,exp);
        this.setBackground(Color.pink);
        this.addMouseListener(this);
        animation = 0;
    }
    
    @Override
    public void paint (Graphics g) {
        super.paint(g); 
        com.paint(g,animation); 
        exp.paint(g,xExp,yExp);
        
        Font fuente=new Font("Arial", Font.BOLD, 14);
        g.setColor(Color.black);
        g.setFont(fuente);
        int defPos = Moneda.last_serie;
        int posX = 275+9;
        int i = 0;
        switch (chosenCoin) {
            case 1:
                g.setColor(Color.yellow);      //Moneda de 1500
                g.fillOval(275, 375, 24, 24);
                g.setColor(Color.black);
               
                while(defPos/10!=0){
                    defPos /= 10;
                    posX -= 4;
                    i++;
                }
                g.drawString(valueOf(Moneda.last_serie), posX, 375+18);
                break;
            case 2:
                g.setColor(Color.cyan);        //Moneda de 1000
                g.fillOval(275, 375, 24, 24);
                g.setColor(Color.black);
                
                while(defPos/10!=0){
                    defPos /= 10;
                    posX -= 4;
                    i++;
                }
                g.drawString(valueOf(Moneda.last_serie), posX, 375+18);
                break;
            case 3:
                g.setColor(Color.green);       //Moneda de 500
                g.fillOval(275, 375, 24, 24);
                g.setColor(Color.black);
                
                while(defPos/10!=0){
                    defPos /= 10;
                    posX -= 4;
                    i++;
                }
                g.drawString(valueOf(Moneda.last_serie), posX, 375+18);
                break;
            case 4:
                g.setColor(Color.red);          //Moneda de 100
                g.fillOval(275, 375, 24, 24);
                g.setColor(Color.black);
                
                while(defPos/10!=0){
                    defPos /= 10;
                    posX -= 4;
                    i++;
                }
                g.drawString(valueOf(Moneda.last_serie), posX, 375+18);
                break;
            default:
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent me) {
        int x = me.getX( );
        int y = me.getY( );
        System.out.println(x + " " + y);
        
        if(animation == 0){
            if(x>=xExp-120 && x<=xExp-65 && y>=yExp+520 && y<=yExp+560){
                System.out.println("Escogio moneda de 1500");
                chosenCoin=1;
                this.repaint();
            }
            else if(x>=xExp-190 && x<=xExp-135 && y>=yExp+520 && y<=yExp+560){
                System.out.println("Escogio moneda de 1000");
                chosenCoin=2;
                this.repaint();
            }
             else if(x>=xExp-260 && x<=xExp-200 && y>=yExp+520 && y<=yExp+560){
                System.out.println("Escogio moneda de 500");
                chosenCoin=3;
                this.repaint();
            }
             else if(x>=xExp-330 && x<=xExp-270 && y>=yExp+520 && y<=yExp+560){
                System.out.println("Escogio moneda de 100");
                chosenCoin=4;
                this.repaint();
            }    


            if(x>=xExp+180 && x<=xExp + 400 && y>=yExp+430 && y<=yExp+480 ){
                System.out.println("Devolviendo bebida");
                if(com != null){
                    com.getBebida(exp);
                    if(com.queBebiste()!=null){
                        animation = 1;
                        this.repaint();
                        Timer t = new Timer(500, this);
                        t.addActionListener(this);
                        t.start();
                    }
                }
                this.repaint();
            }

            else if(x>=xExp+40 && x<=xExp+90 && y>=340+yExp && y<=390+yExp ){
                System.out.println("Devolviendo vuelto");
                com.getVuelto(exp);
                this.repaint();
            }

            else if(x>=xExp+25 && x<=xExp+90 && y>=yExp+40 && y<=yExp+90){
                System.out.println("Intentando comprar una coca");
                this.com = new Comprador(chosenCoin, 1, exp);
                chosenCoin = 0;
                this.repaint();
            }
            else if(x>=xExp+25 && x<=xExp+90 && y>=yExp+100 && y<=yExp+150){
                System.out.println("Intentando comprar una sprite");
                this.com = new Comprador(chosenCoin, 2, exp);
                chosenCoin = 0;
                this.repaint();
            }
            else if(x>=xExp+25 && x<=xExp+90 && y>=yExp+160 && y<=yExp+210){
                System.out.println("Intentando comprar una fanta");
                this.com = new Comprador(chosenCoin, 3, exp);
                chosenCoin = 0;
                this.repaint();
            }
            else if(x>=xExp && x<=xExp+420 && y>=yExp && y<=yExp + 520){
                System.out.println("Rellenando contenedores vacios");
                exp.llenarContenedores(12, 1000);
                this.repaint();
            }
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (counter == 6) {
            ((Timer)e.getSource()).stop();
            counter = 0;
            com.drinkBebida();
            animation = 0;
            this.repaint();
        } else if(((Timer)e.getSource()).isRunning()) {
            System.out.println("Count: " + (++counter));
        }
    }
}