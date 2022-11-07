
package tarea3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public abstract class Moneda {
    private int serie;
    public Moneda(int s){
        serie = s;
    }
    
    public int getSerie(){
        return serie;
    }
    
    public abstract int getValor();
    public abstract void paint(Graphics g, int x, int y);
    
}

class Moneda1500 extends Moneda {
    public Moneda1500(int s){
        super(s);
    }   

    @Override
    public int getValor() {
        return 1500;
    }
    
    @Override
    public void paint(Graphics g, int x, int y){
        Graphics2D exp = (Graphics2D)g;
        exp.setColor(Color.yellow);
        exp.fillOval(x, y, 14, 14);
    }
}
class Moneda1000 extends Moneda {
    public Moneda1000(int s){
        super(s);
    }   
    
    @Override
    public int getValor() {
        return 1000;
    }
    
    @Override
    public void paint(Graphics g, int x, int y){
        Graphics2D exp = (Graphics2D)g;
        exp.setColor(Color.blue);
        exp.fillOval(x, y, 14, 14);
    }
}
class Moneda500 extends Moneda {
    public Moneda500(int s){
        super(s);
    }   
    
    @Override
    public int getValor() {
        return 500;
    }
    
    @Override
    public void paint(Graphics g, int x, int y){
        Graphics2D exp = (Graphics2D)g;
        exp.setColor(Color.green);
        exp.fillOval(x, y, 14, 14);
    }
}
class Moneda100 extends Moneda {
    public Moneda100(int s){
        super(s);
    }   
    
    @Override
    public int getValor() {
        return 100;
    }
    
    @Override
    public void paint(Graphics g, int x, int y){
        Graphics2D exp = (Graphics2D)g;
        exp.setColor(Color.red);
        exp.fillOval(x, y, 14, 14);
    }
}