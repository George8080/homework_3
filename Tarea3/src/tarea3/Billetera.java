
package tarea3;

// Importar librerias necesarias para el funcionamiento del codigo
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Billetera {
    // Creacion de un ArrayList para almacenar las monedas recuperadas.
    private ArrayList<Moneda> mon;
    public Billetera(){
        // Constuctor para inicalizar el ArrayList.
        mon= new ArrayList<>();
    }
  
    public void addMoneda(Moneda m){
        // Ingresar una moneda al ArrayList (si es que existe).
        if(m != null){
            if(mon.size()==32) mon.remove(0);
            mon.add(m);
        }
    }
 
    public void paint(Graphics g){
        // Definir el espacio para la billetera
        int x = 80;
        int y = 280;
        Graphics2D dep = (Graphics2D) g;   
        
        // Deposito de monedas de comprador
        dep.setColor(Color.gray);          
        dep.fillRect(x - 17, y - 120, 238, 102);
        
        // Por cada moneda ingresarla en alguna de las 4 filas de la billetera de 8 elementos.
        for (int i=0; i<mon.size();i++){
            if(i<8) mon.get(i).paint(g,x-15+(i*30), y-120);
            else if(i<16) mon.get(i).paint(g,x-255+(i*30), y-95);
            else if(i<24) mon.get(i).paint(g, x-495+(i*30), y-70);
            else if(i<32) mon.get(i).paint(g, x-735+(i*30), y-45);
        }
    }
}
