
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
        dep2=new DepVuelto();
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
                        Moneda cien = new Moneda100();
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
        int x = 220;
        int y = 150;
        Graphics2D exp = (Graphics2D)g;
        exp.setColor(Color.black);
        exp.fillRect(x, y, 250, 300);
        Producto.paint(g,x+90,y+240);
        Coke.paint(g,x+90,y+18);
        Sprite.paint(g,x+140,y+18);
        Fanta.paint(g,x+190,y+18);
        dep2.paint(g,x+60,y+30);
    }
}
