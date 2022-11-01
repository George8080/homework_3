
package tarea3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

abstract class Bebida {
    private int serie;
    private int precio;
    private int tipo;
    public Bebida(int s, int p, int t){
        serie = s;
        precio = p;
        tipo = t;
        
    }
    public abstract String beber();
    public int getSerie(){
        return serie;
    }
    public int getPrecio(){
        return precio;
    }
    
    public void paint(Graphics g, int x, int y){
        Graphics2D exp = (Graphics2D)g;
        if(tipo == 3){
            exp.setColor(new Color(255,120,0));
        }
        else if(tipo == 2){
            exp.setColor(Color.white);
        }
        else if(tipo == 1){
            exp.setColor(Color.red);
        }
        exp.fillRect(x, y, 30, 20);
        
        if(tipo == 3){
            exp.setColor(Color.blue);
        }
        else if(tipo == 2){
            exp.setColor(Color.green);
        }
        else if(tipo == 1){
            exp.setColor(Color.white);
        }
        exp.fillRect(x+10, y+1, 10, 18);
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