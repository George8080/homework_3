package tarea3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Comprador {
    private int cantidadTotal;
    private String sabor;
    private Bebida bebida;
    static public Billetera billetera= new Billetera();
    static public DepComprador depBebida= new DepComprador();//creamos una variable estatica para que los compradores futuros tengan el mismo deposito de bebidas al ser creados
    
    public Comprador(Moneda mon, int tipoBebida, Expendedor exp){
        sabor = null;
        try{
            exp.ComprarBebida(tipoBebida, mon);
        }catch (PagoIncorrectoException | NoHayBebidaException | PagoInsuficienteException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void getBebida(Expendedor drink){
        bebida = drink.getBebida();
        if(bebida != null) sabor = bebida.beber();
        depBebida.addBebida(bebida);
    }
    
    public void getVuelto(Expendedor exp){
        Moneda d;
        d = exp.getVuelto();
        billetera.addMoneda(d);
        
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
        int x=30; 
        int y=200; 
        Graphics2D buyer = (Graphics2D)g;
        
        billetera.paint(g);
        depBebida.paint(g);
        
         buyer.setColor(Color.WHITE);   //cabeza
         buyer.fillRect(x+12, y-50, 50, 50);
         
         buyer.setColor(Color.red);         //polera
         buyer.fillRect(x, y, 70, 120);
         
        buyer.setColor(Color.white);         //brazo derecho
        buyer.fillRect(x-20, y, 20, 120);
        
        buyer.setColor(Color.white);         //brazo izquierdo
        buyer.fillRect(x+70, y, 20, 120);
         
         buyer.setColor(Color.blue);        //pierna derecha
         buyer.fillRect(x, y+120, 40, 20);
         
         buyer.setColor(Color.blue);        //pierna izquierda
         buyer.fillRect(x, y+120, 30, 120);
         
          buyer.setColor(Color.blue);       //pantalon
         buyer.fillRect(x+40, y+120 , 30, 120);
         
         buyer.setColor(Color.black);       // pie izquierdo
         buyer.fillRect(x, y+220 , 37, 20);
         
         buyer.setColor(Color.black);       // pie derecho
         buyer.fillRect(x+40,y+220 , 37, 20);
      
    }
}