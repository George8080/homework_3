
package tarea3;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import static java.lang.String.valueOf;

abstract class Bebida {
    private int serie;
    private int precio;
    private int tipo;
    private int x;
    private int y;
    public Bebida(int s, int p, int t){
        serie = s;
        precio = p;
        tipo = t;
        
    }
    public abstract String beber();
    public int getSerie(){
        return serie;
    }
    public void setXY(int ejeX, int ejeY){
        x = ejeX;
        y = ejeY;
    }
    public int getPrecio(){
        return precio;
    }
    
    public void paint(Graphics g){
        Graphics2D exp = (Graphics2D)g;
        if(tipo == 3){
            exp.setColor(new Color(255,120,0));
        }
        else if(tipo == 2){
            exp.setColor(new Color(34,139,34));
        }
        else if(tipo == 1){
            exp.setColor(Color.red);
        }
        exp.fillRect(x, y, 60, 30);
        
        if(tipo == 3){
            exp.setColor(Color.blue);
        }
        else if(tipo == 2){
            exp.setColor(Color.white);
        }
        else if(tipo == 1){
            exp.setColor(Color.white);
        }
        exp.fillRect(x+22, y+3, 15, 24);
    
    
        exp.setColor(Color.black);
        Font fuente=new Font("Monospaced", Font.BOLD, 8);
        exp.setColor(Color.black);
        exp.setFont(fuente);
        exp.drawString(valueOf(this.getSerie()), x+1, y+28);
    }
}

class CocaCola extends Bebida{
    public CocaCola(int s, int p) {
       super(s,p,1);
    }
    public String beber(){
        return "cocacola";
    }
}
class Sprite extends Bebida{
    public Sprite(int s, int p) {
       super(s,p,2);
    }
    public String beber(){
        return "sprite";
    }
}

class Fanta extends Bebida{
    public Fanta(int s, int p) {
       super(s,p,3);
    }
    public String beber(){
        return "fanta";
    }
}