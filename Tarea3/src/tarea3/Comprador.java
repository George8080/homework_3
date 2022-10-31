package tarea3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JButton;

public class Comprador {
    private int cantidadTotal;
    private String sabor;

    private DepProductos bebida;
    
    public Comprador(Moneda mon, int tipoBebida, Expendedor exp){ 
        sabor = null;
        try{
            exp.ComprarBebida(tipoBebida, mon);
            //sabor = bebida.beber();
        }catch (PagoIncorrectoException | NoHayBebidaException | PagoInsuficienteException e){
            System.out.println(e.getMessage());
        }finally{
            Moneda d;
            do{
                d = exp.getVuelto();
                if(d != null)
                {
                    cantidadTotal += d.getValor();
                }
            }while(d != null);
        }
        
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
         
         buyer.setColor(Color.blue);        //pierna izquierda
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