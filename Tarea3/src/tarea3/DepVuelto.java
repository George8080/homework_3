
package tarea3;

// Importar librerias necesarias para el funcionamiento del codigo
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class DepVuelto{
    private ArrayList<Moneda> m;
    // Creacion de un ArrayList de monedas para almacenar las mondeas devueltas.

    public DepVuelto(){ // Constructor del dispensador de vuelto.
        m = new ArrayList<>();  // Solo inicializa el ArrayList.
    }
        
    public Moneda getMoneda(){  
        // Metodo para sacar y retornar una moneda si es que queda una en el ArrayList.
        if(m.isEmpty()){
            return null;
        }else{
            return m.remove(0);
        }
    }
    
    public void addMoneda(Moneda mon){
        // Metodo para recibir y añadir una moneda al ArrayList
        m.add(mon);
    }
    
    public void paint(Graphics g, int x,int y){
        Graphics2D exp = (Graphics2D)g;
        // Tanques para las monedas
        exp.setColor(Color.gray);
        exp.fillRect(x, y, 24, 408);
        exp.fillRect(x+30, y, 24, 408);
        
        // Definir los colores de los focos que indican si se sobrepaso el limite del deposito.
        Color good = Color.green;
        Color bad = Color.black;
        
        // Ciclo para rellenar los dos depositos
        for(int i=0; i<m.size();i++){
            if(i>33){ // Si se quiere sobrepasar el limite de ambos.
                // Indicar con los focos que se sobrepaso el limite.
                good = Color.black;
                bad = Color.red;
                break;
            }
            else{   // Si no...
                // Indicar con los focos que aun no se sobrepasa.
                good = Color.green;
                bad = Color.black;
            }
            
            if(i<=16){  // Si el primer deposito aun tiene espacio...
                // Ingresar la bebida en el 1er deposito.
                m.get(i).paint(g,x,y+408-24*(i+1));
            }   
            else    // Si no, ingresarla en el 2do deposito.
                m.get(i).paint(g,x+30,y+408-24*(i+1-17));
        }
        
        // Creacion de los focos que indican si hay más monedas que las visibles en el deposito.
        exp.setColor(Color.darkGray);
        exp.fillRect(x+4, y-24, 46, 20);
        exp.setColor(good);
        exp.fillOval(x+8, y-22, 16, 16);
        exp.setColor(bad);
        exp.fillOval(x+30, y-22, 16, 16);
        
        // Creacion del conducto de monedas.
        exp.setColor(Color.gray);
        exp.fillRect(x-80, y+300, 50, 50);
        exp.setColor(Color.BLACK);
        exp.drawRect(x-76, y+304, 41, 41);
        exp.drawRect(x-77, y+303, 43, 43);
        
        // Conjunto de comando para imprimir la casilla para ingresar monedas (Es solo decorativa)
        exp.setColor(Color.gray);
        exp.fillRect(x-77, y+200, 45, 62);
        exp.setColor(Color.black);
        exp.fillOval(x-75, y+209, 41, 41);
        exp.setColor(Color.gray);
        exp.fillOval(x-72, y+212, 35, 35);
        exp.setColor(Color.black);
        exp.fillRect(x-57, y+215, 6,30);
    }
}