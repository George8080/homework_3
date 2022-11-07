
package tarea3;
        
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Expendedor{
    private Deposito Sprite;
    private Deposito Fanta;
    private Deposito Coke;
    private DepProductos Producto;
    private DepVuelto dep2;
    private int money;
    
    public Expendedor(int cant, int precio){
        Producto = new DepProductos();
        Coke= new Deposito(cant);
        Sprite= new Deposito(cant);
        Fanta= new Deposito(cant);
        dep2 = new DepVuelto();
        
        money = precio;
        
        for(int i = 0; i < cant; i++){
            Fanta.addBebida(new Fanta(1000+i,precio));
            Sprite.addBebida(new Sprite(2000+i,precio));
            Coke.addBebida(new CocaCola(3000+i,precio));
        }

    }
    
    public void ComprarBebida(int num, Moneda m) throws PagoInsuficienteException, PagoIncorrectoException, NoHayBebidaException{
        Bebida drink = null;
        String tipoBebida = null;
        if(m != null){
            if(m.getValor() >= money){
                switch (num) {
                    case 1 :
                        drink = Coke.getBebida();
                        tipoBebida = "cocacola";
                        break;
     
                    case 2 :
                        drink = Sprite.getBebida();
                        tipoBebida = "sprite";
                        break;
                    
                    case 3 :
                        drink = Fanta.getBebida();
                        tipoBebida = "fanta";
                        break;
                }
                if(drink != null){
                    for(int i = 0; i < (m.getValor()-money)/100;i++){
                        Moneda cien = new Moneda100(100);
                        dep2.addMoneda(cien);
                    }
                    Producto.addBebida(drink);
                }
                else if(tipoBebida != null){
                    dep2.addMoneda(m);
                    throw new NoHayBebidaException("Error: No quedan "+tipoBebida+"s.");
                }
                else{
                    dep2.addMoneda(m);
                    throw new NoHayBebidaException("Error: Deposito incorrecto");
                }
            } else {
                dep2.addMoneda(m);
                throw new PagoInsuficienteException("Error: Pago insuficiente.");
            }  
        } else throw new PagoIncorrectoException("Error: No ha ingresado monedas.");
    }
    public Moneda getVuelto() {
        return dep2.getMoneda();  
    }
    
    public Bebida getBebida() {
        return Producto.getBebida();
    }
    
    public void paint(Graphics g){
        int x = 170;
        int y = 75;
        Graphics2D exp = (Graphics2D)g;
        exp.setColor(Color.black);
        exp.fillRect(x, y, 300, 350);
        Producto.paint(g,x+140,y+290);
        Coke.paint(g,x+140,y+18);
        Sprite.paint(g,x+190,y+18);
        Fanta.paint(g,x+240,y+18);
        dep2.paint(g,x+110,y+20);
        
        exp.setColor(Color.red);
        exp.fillRect(x+50, y+30, 30, 20);
        
        exp.setColor(Color.green);
        exp.fillRect(x+50, y+65, 30, 20);
        
        exp.setColor(new Color(255,120,0));
        exp.fillRect(x+50, y+100, 30, 20);
        
    }
}
