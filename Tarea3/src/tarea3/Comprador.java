package tarea3;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Comprador {
    // Creacion de los atributos de la bebida:
    
    static public int cantidadTotal = 0;
    // Creamos una variable estatica para almacenar el valor obtenido.
    private String sabor;
    private Bebida bebida;
    static public Billetera billetera= new Billetera();
    // Creamos una variable estatica para que los compradores futuros tengan la misma al ser creados.
    static public DepComprador depBebida= new DepComprador();
    // Creamos una variable estatica para que los compradores futuros tengan el mismo deposito de bebidas al ser creados.
    
    public Comprador(int mon, int tipoBebida, Expendedor exp){ 
        // Constructor que inicializa las variables e intenta compra una bebida.
        sabor = null;
        bebida = null;
        try{    // Intentar comprar una bebida.
            exp.ComprarBebida(tipoBebida, mon);
        }catch (PagoIncorrectoException | NoHayBebidaException | PagoInsuficienteException | DepositoOcupadoException e){
            // Si no imprimir un mensaje en la terminal.
            System.out.println(e.getMessage());
        }
    }
    
    public void getBebida(Expendedor drink){
        // Si hay una bebida en el deposito de productos retirar.
        bebida = drink.getBebida();
        if(bebida != null) sabor = bebida.beber();
    }
    public void drinkBebida(){
        // Si hay una bebida beberla.
        if(bebida != null) depBebida.addBebida(bebida);
        bebida = null;
        sabor = null;
    }
    
    public void getVuelto(Expendedor exp){
        // Recibir vuelto y si no es nulo depositarlo en la billetera y extraer su valor.
        Moneda d;
        d = exp.getVuelto();
        
        if(d != null){
            billetera.addMoneda(d);
            cantidadTotal += d.getValor();
        }
    }
    
    public int cuantoVuelto(){
        // Devolver la cantidad de vuelto obtenido.
        return cantidadTotal;
    } 
    public String queBebiste(){
        // Devolver el sabor obtenido de la bebida.
        return sabor;
    }
    
    public void paint(Graphics g, int an){
        // Metodo para pintar en la interfaz al comprador.
        
        // Definir la posición base.
        int x=150; 
        int y=340; 
        Graphics2D buyer = (Graphics2D)g;
        
        // Pintar la billetera y el deposito de bebidas consumidas.
        billetera.paint(g);
        depBebida.paint(g);
        
        buyer.setColor(Color.WHITE);   // Crear la cabeza
        buyer.fillRect(x+12, y-50, 50, 50);

        buyer.setColor(Color.red);         // Crear la base de la polera
        buyer.fillRect(x, y, 70, 120);
         
        buyer.setColor(Color.white);         // Pintar el brazo izquierdo
        buyer.fillRect(x-20, y, 20, 120);
        
        if(an == 1 && bebida != null){  // Si estamos en la animacion de consumir bebida...
            buyer.setColor(Color.red);         // Imprimir la manga derecha
            buyer.fillRect(x+60, y, 40, 30); 
            bebida.setXY(x+50,y-40);    // Pintar la bebida en la mano derecha
            bebida.paint(g);
            
            buyer.setColor(Color.white);         // Pintar el brazo derecho tomando la bebida.
            buyer.fillRect(x+100, y-40, 20, 70);
            
            // Crear la onomatopeya del comprador bebiendo
            Font fuente=new Font("Monospaced", Font.BOLD, 25);
            buyer.setColor(Color.black);
            buyer.setFont(fuente);
            buyer.drawString("GLU GLU",x+65,y-53);
        }
        else{   // Si no estamos en la animacion.
            buyer.setColor(Color.white);         // Pintar brazo derecho estatico
            buyer.fillRect(x+70, y, 20, 60);

            buyer.setColor(Color.white);         // Pintar antebrazo derecho
            buyer.fillRect(x+70, y+50, 60, 20);
            
            buyer.setColor(Color.red);         // Pintar polera
            buyer.fillRect(x+60, y, 30, 40); 
        }
        buyer.setColor(Color.red);         // Pintar polera
        buyer.fillRect(x-20, y, 30, 40); 
        
        
        buyer.setColor(Color.blue);        // Pintar pierna derecha
        buyer.fillRect(x, y+120, 40, 20);
         
        buyer.setColor(Color.blue);        // Pintar pierna izquierda
        buyer.fillRect(x, y+120, 30, 120);

        buyer.setColor(Color.blue);       // Imprimir pantalon
        buyer.fillRect(x+40, y+120 , 30, 120);
         
        buyer.setColor(Color.black);       // Imprimir pie izquierdo
        buyer.fillRect(x, y+220 , 37, 20);

        buyer.setColor(Color.black);       // Imprimir pie derecho
        buyer.fillRect(x+40,y+220 , 37, 20);

        // Definir espacio para las monedas
        int z=150; 
        int w=340;
        // Definir fuente para imprimir los valores de cada moneda.
        Font fuente=new Font("Monospaced", Font.BOLD, 15);
        buyer.setColor(Color.black);
        buyer.setFont(fuente);
        
        // Imprimir monedas: 
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