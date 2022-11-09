
package tarea3;
        
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Expendedor{
    private Deposito Sprite;
    private Deposito Fanta;
    private Deposito Coke;
    private DepProductos Producto;
    private DepVuelto dep2;
    private int money;
    private BufferedImage img;
    private BufferedImage coca;
    private BufferedImage fanta;
    private BufferedImage sprite;
    private int serieF = 0;
    private int serieS = 0;
    private int serieC = 0;
    
    public Expendedor(int cant, int precio){
        Producto = new DepProductos();
        Coke= new Deposito(cant);
        Sprite= new Deposito(cant);
        Fanta= new Deposito(cant);
        dep2 = new DepVuelto();
        try{
            img = ImageIO.read(getClass().getResource("bubbles.jpg"));
            coca = ImageIO.read(getClass().getResource("cocacola.jpg"));
            fanta = ImageIO.read(getClass().getResource("fanta.png"));
            sprite = ImageIO.read(getClass().getResource("sprite.png"));
        }catch(java.io.IOException e){
            System.out.println(e.getMessage());
        }
        money = precio;
        
        this.llenarContenedores(cant, precio);

    }
    
    public void llenarContenedores(int cant, int precio){
        if(Fanta.returnSize()== 0){
            for(int i = 0; i < cant; i++){
                Fanta.addBebida(new Fanta(1000+serieF,precio));
                serieF++;
            }
        }
        if(Coke.returnSize()== 0){
            for(int i = 0; i < cant; i++){
                Coke.addBebida(new CocaCola(3000+i,precio));
                serieC++;
            }
        }
        if(Sprite.returnSize()== 0){
            for(int i = 0; i < cant; i++){
                Sprite.addBebida(new Sprite(2000+i,precio));
                serieS++;
            }
        }
    }
    
    public void ComprarBebida(int num, Moneda m) throws PagoInsuficienteException, PagoIncorrectoException, NoHayBebidaException, DepositoOcupadoException{
        Bebida drink = null;
        String tipoBebida = null;
        if(m != null){
            if(m.getValor() >= money){
                if(Producto.verContenedor()==null){
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
                } else {    //COMENTAR
                    dep2.addMoneda(m);
                    throw new DepositoOcupadoException("Error: Contenedor ocupado.");
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
    
    
    
    public void paint(Graphics g, int x, int y){
        Graphics2D exp = (Graphics2D)g;
        exp.drawImage(this.img, x, y, 420, 520, null);
        Producto.paint(g,x+180,y+430);
        Coke.paint(g,x+180,y+18);
        Sprite.paint(g,x+255,y+18);
        Fanta.paint(g,x+330,y+18);
        dep2.paint(g,x+110,y+40);
        
        exp.drawImage(this.coca, x+25, y+40, 65, 50, null);
        
        exp.drawImage(this.sprite, x+25, y+100, 65, 50, null);
        
        exp.drawImage(this.fanta, x+25, y+160, 65, 50, null);
        /*Font fuente=new Font("Monospaced", Font.BOLD, 50);
        exp.setFont(fuente);
        exp.drawString("Hola", 100, 50);
        exp.drawString("Hey", x, y);
        exp.drawString("Mundo", 100, 70);*/
    }
}
