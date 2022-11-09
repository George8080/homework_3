
package tarea3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JButton;

public class Comprador {
    private int cantidadTotal;
    private String sabor;

    private Bebida bebida;
    
    public Comprador(Moneda mon, int tipoBebida, Expendedor exp){ 
        sabor = null;
        try{
            exp.ComprarBebida(tipoBebida, mon);
        }catch (PagoIncorrectoException | NoHayBebidaException | PagoInsuficienteException | DepositoOcupadoException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void getBebida(Expendedor drink){
        bebida = drink.getBebida();
        if(bebida != null) sabor = bebida.beber();
    }
    
    public void getVuelto(Expendedor exp){
        Moneda d;
        d = exp.getVuelto();
        if(d != null)
            cantidadTotal += d.getValor();
    }
    
    public int cuantoVuelto(){
        return cantidadTotal;
    } 
    public String queBebiste(){
        return  sabor;
    }
    
    public void paint(Graphics g){
        Graphics2D buyer = (Graphics2D)g;
        
         buyer.setColor(Color.WHITE);   //cabeza
         buyer.fillOval(42, 150, 50, 50);
         
         buyer.setColor(Color.red);         //polera
         buyer.fillRect(30,200 , 70, 120);
         
        buyer.setColor(Color.white);         //brazo derecho
        buyer.fillRect(10, 200, 20, 120);
        
        buyer.setColor(Color.white);         //polera
        buyer.fillRect(100, 200, 20, 120);
         
         buyer.setColor(Color.blue);        //pierna derecha
         buyer.fillRect(30,320 , 40, 20);
         
         buyer.setColor(Color.blue);        //pierna izquierda
         buyer.fillRect(30,320 , 30, 120);
         
          buyer.setColor(Color.blue);       //pierna derecha
         buyer.fillRect(70,320 , 30, 120);
         
         buyer.setColor(Color.black);       // pie izquierdo
         buyer.fillRect(30,420 , 37, 20);
         
         buyer.setColor(Color.black);       // pie derecho
         buyer.fillRect(70,420 , 37, 20);
      
    }
}