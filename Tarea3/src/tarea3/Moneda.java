
package tarea3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.*;
import static java.lang.String.valueOf;
import javax.swing.*;

public abstract class Moneda extends JLabel {
    // Creacion de los atributos de la moneda.
    
    // "static public" conserva esta variable para todas las monedas creadas y asi que todas tengan una serie diferente.
    static public int last_serie = 0;
    private int serie;
    public String ser;
    
    public Moneda(){
        // Constructor. Define la serie como entero y como texto.
        serie = Moneda.last_serie;
        ser = valueOf(serie);
        Moneda.last_serie++;
    }
    
    public int getSerie(){
        // Retorna la serie (numero).
        return serie;
    }
    
    // Define un metodos getter y un metodo para pintar en la interfaz.
    public abstract int getValor();
    public abstract void paint(Graphics g, int x, int y);
}

class Moneda1500 extends Moneda {
    public Moneda1500(){}   

    @Override
    public int getValor() { // Getter para obtener el valor de la moneda
        return 1500;
    }
    
    @Override
    public void paint(Graphics g, int x, int y){ // Metodo para imprimir la moneda
        Graphics2D exp = (Graphics2D)g;
        
        // Imprimir la moneda
        exp.setColor(Color.yellow);
        exp.fillOval(x, y, 24, 24);
        
        // Definir la fuente utilizada para la serie
        Font fuente=new Font("Arial", Font.BOLD, 14);
        exp.setColor(Color.black);
        exp.setFont(fuente);
        
        // Centrar la serie e imprimirla.
        int defPos = this.getSerie();
        int posX = x+9;
        int i = 0;
        while(defPos/10!=0){
            defPos /= 10;
            posX -= 4;
            i++;
        }
        exp.drawString(this.ser, posX, y+18);
    }
}

class Moneda1000 extends Moneda {
    public Moneda1000(){
    }   
    
    @Override
    public int getValor() { // Getter para obtener el valor de la moneda
        return 1000;
    }
    
    @Override
    public void paint(Graphics g, int x, int y){    // Metodo para imprimir la moneda
        Graphics2D exp = (Graphics2D)g;
        
        // Imprimir la moneda
        exp.setColor(Color.cyan);
        exp.fillOval(x, y, 24, 24);
        
        // Definir la fuente utilizada para la serie
        Font fuente=new Font("Arial", Font.BOLD, 14);
        exp.setColor(Color.black);
        exp.setFont(fuente);
        
        // Centrar la serie e imprimirla.
        int defPos = this.getSerie();
        int posX = x+9;
        int i = 0;
        while(defPos/10!=0){
            defPos /= 10;
            posX -= 4;
            i++;
        }
        exp.drawString(this.ser, posX, y+18);
    }
}
class Moneda500 extends Moneda {
    public Moneda500(){
    }   
    
    @Override
    public int getValor() { // Getter para obtener el valor de la moneda
        return 500;
    }
    
    @Override
    public void paint(Graphics g, int x, int y){    // Metodo para imprimir la moneda
        Graphics2D exp = (Graphics2D)g;
        
        // Imprimir la moneda
        exp.setColor(Color.green);
        exp.fillOval(x, y, 24, 24);
        
        
        // Definir la fuente utilizada para la serie
        Font fuente=new Font("Arial", Font.BOLD, 14);
        exp.setColor(Color.black);
        exp.setFont(fuente);
        
        // Centrar la serie e imprimirla.
        int defPos = this.getSerie();
        int posX = x+9;
        int i = 0;
        while(defPos/10!=0){
            defPos /= 10;
            posX -= 4;
            i++;
        }
        exp.drawString(this.ser, posX, y+18);
    }
}
class Moneda100 extends Moneda {
    public Moneda100(){
    }   
    
    @Override
    public int getValor() { // Getter para obtener el valor de la moneda
        return 100;
    }
    
    @Override
    public void paint(Graphics g, int x, int y){    // Metodo para imprimir la moneda
        Graphics2D exp = (Graphics2D)g;
        
        // Imprimir la moneda
        exp.setColor(Color.red);
        exp.fillOval(x, y, 24, 24);
        
        
        // Definir la fuente utilizada para la serie
        Font fuente=new Font("Arial", Font.BOLD, 14);
        exp.setColor(Color.black);
        exp.setFont(fuente);
        
        // Centrar la serie e imprimirla.
        int defPos = this.getSerie();
        int posX = x+9;
        int i = 0;
        while(defPos/10!=0){
            defPos /= 10;
            posX -= 4;
            i++;
        }
        exp.drawString(this.ser, posX, y+18);
    }
}