
package tarea3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.*;
import static java.lang.String.valueOf;
import javax.swing.*;

public abstract class Moneda extends JLabel {
    // "static public" conserva esta variable para todas las monedas creadas tengan una serie diferente.
    static public int last_serie = 0;
    private int serie;
    public String ser;
    //public String val;
    public Moneda(){
        serie = Moneda.last_serie;
        Moneda.last_serie++;
        ser = valueOf(serie);
        //val = "$" + valueOf(this.getValor());
    }
    
    public int getSerie(){
        return serie;
    }
    
    
    public abstract int getValor();
    public abstract void paint(Graphics g, int x, int y);
    
}

class Moneda1500 extends Moneda {
    public Moneda1500(){
    }   

    @Override
    public int getValor() {
        return 1500;
    }
    
    @Override
    public void paint(Graphics g, int x, int y){
        Graphics2D exp = (Graphics2D)g;
        exp.setColor(Color.yellow);
        exp.fillOval(x, y, 24, 24);
        Font fuente=new Font("Arial", Font.BOLD, 14);
        exp.setColor(Color.black);
        exp.setFont(fuente);
        int defPos = this.getSerie();
        int posX = x+9;
        int i = 0;
        while(defPos/10!=0){
            defPos /= 10;
            posX -= 4;
            i++;
        }
        exp.drawString(this.ser, posX, y+18);
//        fuente=new Font("Monospaced", Font.BOLD, 8);
//        exp.setFont(fuente);
//        exp.drawString(this.val, x+3, y+10);
    }
}
class Moneda1000 extends Moneda {
    public Moneda1000(){
    }   
    
    @Override
    public int getValor() {
        return 1000;
    }
    
    @Override
    public void paint(Graphics g, int x, int y){
        Graphics2D exp = (Graphics2D)g;
        exp.setColor(Color.cyan);
        exp.fillOval(x, y, 24, 24);
        Font fuente=new Font("Arial", Font.BOLD, 14);
        exp.setColor(Color.black);
        exp.setFont(fuente);
        int defPos = this.getSerie();
        int posX = x+9;
        int i = 0;
        while(defPos/10!=0){
            defPos /= 10;
            posX -= 4;
            i++;
        }
        exp.drawString(this.ser, posX, y+18);
//        fuente=new Font("Monospaced", Font.BOLD, 8);
//        exp.setFont(fuente);
//        exp.drawString(this.val, x+3, y+10);
    }
}
class Moneda500 extends Moneda {
    public Moneda500(){
    }   
    
    @Override
    public int getValor() {
        return 500;
    }
    
    @Override
    public void paint(Graphics g, int x, int y){
        Graphics2D exp = (Graphics2D)g;
        exp.setColor(Color.green);
        exp.fillOval(x, y, 24, 24);
        Font fuente=new Font("Arial", Font.BOLD, 14);
        exp.setColor(Color.black);
        exp.setFont(fuente);
        int defPos = this.getSerie();
        int posX = x+9;
        int i = 0;
        while(defPos/10!=0){
            defPos /= 10;
            posX -= 4;
            i++;
        }
        exp.drawString(this.ser, posX, y+18);
//        fuente=new Font("Monospaced", Font.BOLD, 8);
//        exp.setFont(fuente);
//        exp.drawString(this.val, x+3, y+10);
    }
}
class Moneda100 extends Moneda {
    public Moneda100(){
    }   
    
    @Override
    public int getValor() {
        return 100;
    }
    
    @Override
    public void paint(Graphics g, int x, int y){
        Graphics2D exp = (Graphics2D)g;
        
        exp.setColor(Color.red);
        exp.fillOval(x, y, 24, 24);
        Font fuente=new Font("Arial", Font.BOLD, 14);
        exp.setColor(Color.black);
        exp.setFont(fuente);
        int defPos = this.getSerie();
        int posX = x+9;
        int i = 0;
        while(defPos/10!=0){
            defPos /= 10;
            posX -= 4;
            i++;
        }
        exp.drawString(this.ser, posX, y+18);
//        fuente=new Font("Monospaced", Font.BOLD, 8);
//        exp.setFont(fuente);
//        exp.drawString(this.val, x+3, y+10);
    }
}