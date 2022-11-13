
package tarea3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;


public class Deposito{
    // Creacion de un arreglo con bebidas.
    private ArrayList<Bebida> v;
    
    public Deposito(int cant){ // Constructor. Solo inicializa el ArrayList para las bebidas.
        v = new ArrayList<Bebida>(cant);
    }
    public Bebida getBebida(){
        // Si hay una bebida removerla y retornarla, o retornar nulo si no hay.
        if(v.isEmpty()){
            return null;
        }else{
            return v.remove(0);
        }
    }
    public void addBebida(Bebida drink){
        // Añadir la bebida al deposito.
        v.add(drink);
    }
    
    public int returnSize(){
        // Retornar la cantidad de bebidas.
        return v.size();
    }
    public void paint(Graphics g, int x, int y){
        // Pintar en intrefaz el deposito y las bebidas.
        Graphics2D exp = (Graphics2D)g;
        
        // Pinar depositos
        exp.setColor(Color.gray);
        exp.fillRect(x, y, 70, 399);
        
        // Por cada bebida definir su ubicacion e imprimirla.
        for(int i=0; i<v.size();i++){
            v.get(i).setXY(x+5,y+399-33*(i+1));
            v.get(i).paint(g);
        }
    }
}