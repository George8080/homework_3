
package tarea3;

// Importar librerias necesarias para el funcionamiento del codigo
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import static java.lang.String.valueOf;

abstract class Bebida {
    // Creacion de los atributos de la bebida
    private int serie;
    private int precio;
    private int tipo;
    private int x;
    private int y;
    
    public Bebida(int s, int p, int t){
        // Constructor para definir la serie, el precio y el tipo de bebida.
        serie = s;
        precio = p;
        tipo = t;
        
    }
    public abstract String beber();
    // Metodo abstracto que sera dirigido a las bebidas.
    
    public int getSerie(){
        // Getter para devolver la serie.
        return serie;
    }
    public void setXY(int ejeX, int ejeY){
        // Setter para definir los ejes X e Y de las bebidas.
        x = ejeX;
        y = ejeY;
    }
    public int getPrecio(){
        // Getter para devolver el precio de la bebida.
        return precio;
    }
    
    public void paint(Graphics g){
        // Metodo para definir las bebidas.
        Graphics2D exp = (Graphics2D)g;
        
        // Dependiendo del tipo ingresado en el constructor definir un color u otro la bebida.
        if(tipo == 3){
            exp.setColor(new Color(255,120,0));
        }
        else if(tipo == 2){
            exp.setColor(new Color(34,139,34));
        }
        else if(tipo == 1){
            exp.setColor(Color.red);
        }
        // Imprimir la bebida.
        exp.fillRect(x, y, 60, 30);
        
        // Tambien definir el "logo" dependiendo de la bebida.
        if(tipo == 3){
            exp.setColor(Color.blue);
        }
        else if(tipo == 2 || tipo == 1){
            exp.setColor(Color.white);
        }
        // Pintar el logo.
        exp.fillRect(x+22, y+3, 15, 24);
    
        // Conjunto de codigos para imprimir la serie.
        exp.setColor(Color.black);
        Font fuente=new Font("Monospaced", Font.BOLD, 8);
        exp.setColor(Color.black);
        exp.setFont(fuente);
        exp.drawString(valueOf(this.getSerie()), x+1, y+28);
    }
}

class CocaCola extends Bebida{
    public CocaCola(int s, int p) {
        // Constructor que envia los datos de serie y precio ingresado + el tipo de bebida, representado con el numero 1.
        super(s,p,1);
    }
    public String beber(){
        // Devolver el tipo de bebida como String ("cocacola")
        return "cocacola";
    }
}
class Sprite extends Bebida{
    public Sprite(int s, int p) {
        // Constructor que envia los datos de serie y precio ingresado + el tipo de bebida, representado con el numero 2.
        super(s,p,2);
    }
    public String beber(){
        // Devolver el tipo de bebida como String ("sprite")
        return "sprite";
    }
}

class Fanta extends Bebida{
    public Fanta(int s, int p) {
        // Constructor que envia los datos de serie y precio ingresado + el tipo de bebida, representado con el numero 3.
       super(s,p,3);
    }
    public String beber(){
        // Devolver el tipo de bebida como String ("fanta")
        return "fanta";
    }
}