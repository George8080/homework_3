
package tarea3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public abstract class Moneda {
    
    public Moneda(){}
    
    public String getSerie(){
        return this.toString();
    }
    
    public abstract int getValor();
    public abstract void paint(Graphics g, int x, int y);
    
}

class Moneda1500 extends Moneda {
    public Moneda1500(){}   

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
    public Moneda1000(){}
    
    @Override
    public int getValor() {
        return 1000;
    }
    
    @Override
    public void paint(Graphics g, int x, int y){
        Graphics2D exp = (Graphics2D)g;
        exp.setColor(Color.yellow);
        exp.fillOval(x, y, 14, 14);
    }
}
class Moneda500 extends Moneda {
    public Moneda500(){}
    
    @Override
    public int getValor() {
        return 500;
    }
    
    @Override
    public void paint(Graphics g, int x, int y){
        Graphics2D exp = (Graphics2D)g;
        exp.setColor(Color.yellow);
        exp.fillOval(x, y, 14, 14);
    }
}
class Moneda100 extends Moneda {
    public Moneda100(){}
    
    @Override
    public int getValor() {
        return 100;
    }
    
    @Override
    public void paint(Graphics g, int x, int y){
        Graphics2D exp = (Graphics2D)g;
        exp.setColor(Color.yellow);
        exp.fillOval(x, y, 14, 14);
    }
}