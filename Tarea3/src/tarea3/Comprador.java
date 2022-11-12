package tarea3;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Comprador {
    static public int cantidadTotal = 0;
    private String sabor;
    private Bebida bebida;
    static public Billetera billetera= new Billetera();
    static public DepComprador depBebida= new DepComprador();//creamos una variable estatica para que los compradores futuros tengan el mismo deposito de bebidas al ser creados
    
    public Comprador(int mon, int tipoBebida, Expendedor exp){ 
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
    public void drinkBebida(){
        if(bebida != null) depBebida.addBebida(bebida);
        bebida = null;
        sabor = null;
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
        return sabor;
    }
    
    public void paint(Graphics g, int an){
        int x=150; 
        int y=340; 
        Graphics2D buyer = (Graphics2D)g;
        
        billetera.paint(g);
        depBebida.paint(g);
        
        buyer.setColor(Color.WHITE);   //cabeza
        buyer.fillRect(x+12, y-50, 50, 50);

        buyer.setColor(Color.red);         //polera
        buyer.fillRect(x, y, 70, 120);
         
        buyer.setColor(Color.white);         //brazo izquierdo
        buyer.fillRect(x-20, y, 20, 120);
        
        if(an == 1 && bebida != null){
            buyer.setColor(Color.red);         //polera
            buyer.fillRect(x+60, y, 40, 30); 
            bebida.setXY(x+50,y-40);
            bebida.paint(g);
            buyer.setColor(Color.white);         //brazo derecho
            buyer.fillRect(x+100, y-40, 20, 70);
            Font fuente=new Font("Monospaced", Font.BOLD, 25);
            buyer.setColor(Color.black);
            buyer.setFont(fuente);
            buyer.drawString("GLU GLU",x+65,y-53);
        }else{
            buyer.setColor(Color.white);         //brazo derecho
            buyer.fillRect(x+70, y, 20, 60);

            buyer.setColor(Color.white);         //brazo derecho
            buyer.fillRect(x+70, y+50, 60, 20);
            
            buyer.setColor(Color.red);         //polera
            buyer.fillRect(x+60, y, 30, 40); 
        }
        buyer.setColor(Color.red);         //polera
        buyer.fillRect(x-20, y, 30, 40); 
        
        
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

        int z=150; 
        int w=340;
         
        Font fuente=new Font("Monospaced", Font.BOLD, 15);
        buyer.setColor(Color.black);
        buyer.setFont(fuente);
        
        buyer.setColor(Color.red);          //Moneda de 100
        buyer.fillOval(z-100, w+250, 60, 60);
        buyer.setColor(Color.black);
        buyer.drawString("100", z-83, w+285);

        buyer.setColor(Color.green);       //Moneda de 500
        buyer.fillOval(z-30, w+250, 60, 60);
        buyer.setColor(Color.black);
        buyer.drawString("500", z-14, w+285);

        buyer.setColor(Color.cyan);        //Moneda de 1000
        buyer.fillOval(z+40, w+250, 60, 60);
        buyer.setColor(Color.black);
        buyer.drawString("1000", z+52, w+285);

        buyer.setColor(Color.yellow);      //Moneda de 1500
        buyer.fillOval(x+110, y+250, 60, 60);
        buyer.setColor(Color.black);
        buyer.drawString("1500", z+123, w+285);
    }
}