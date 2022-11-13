package tarea3;
        
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Expendedor{
    // Creacion de los atributos de la Expendedora
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
        // Iniicializar los atributos.
        Producto = new DepProductos();
        Coke= new Deposito(cant);
        Sprite= new Deposito(cant);
        Fanta= new Deposito(cant);
        dep2 = new DepVuelto();
        money = precio;
        try{    // Intentar buscar las imagenes y definirlas.
            img = ImageIO.read(getClass().getResource("bubbles.jpg"));
            coca = ImageIO.read(getClass().getResource("cocacola.jpg"));
            fanta = ImageIO.read(getClass().getResource("fanta.png"));
            sprite = ImageIO.read(getClass().getResource("sprite.png"));
        }catch(java.io.IOException e){
            System.out.println(e.getMessage());
        }
        
        // Llenar los contenedores
        this.llenarContenedores(cant, precio);
    }
    
    public void llenarContenedores(int cant, int precio){
        // Si algun deposito esta vacio rellenarla.
        if(Fanta.returnSize()== 0){
            for(int i = 0; i < cant; i++){
                Fanta.addBebida(new Fanta(1000+serieF,precio));
                serieF++;
            }
        }
        if(Coke.returnSize()== 0){
            for(int i = 0; i < cant; i++){
                Coke.addBebida(new CocaCola(3000+serieC,precio));
                serieC++;
            }
        }
        if(Sprite.returnSize()== 0){
            for(int i = 0; i < cant; i++){
                Sprite.addBebida(new Sprite(2000+serieS,precio));
                serieS++;
            }
        }
    }
    
    public void ComprarBebida(int num, int m) throws PagoInsuficienteException, PagoIncorrectoException, NoHayBebidaException, DepositoOcupadoException{
        // Metodo para comprar una bebida.
        
        // Preparar los elementos para utilizarlos.
        Bebida drink = null;
        String tipoBebida = null;
        Moneda coin;
        // Generar la moneda pedida.
        switch(m){
            case 1:
                coin = new Moneda1500();
                break;
            case 2:
                coin = new Moneda1000();
                break;
            case 3:
                coin = new Moneda500();
                break;
            case 4:
                coin = new Moneda100();
                break;
            default:
                coin = null;
        }
        if(coin != null){   // Si hay una moneda...
            if(coin.getValor() >= money){   // Si el valor alcanza para comprar...
                if(Producto.verContenedor()==null){ // Si hay espacio para depositar una bebida en el recipiente...
                    switch (num) {
                        // Comprar la bebida pedida y definir la bebida pedida.
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
                        // Si la compra fue exitosa devolver el vuelto en monedas de 100 y añadir la bebida al deposito de productos.
                        for(int i = 0; i < (coin.getValor()-money)/100;i++){
                            Moneda cien = new Moneda100();
                            dep2.addMoneda(cien);
                        }
                        Producto.addBebida(drink);
                    }
                    else if(tipoBebida != null){ // Si no habian bebidas pero si se intento pedir una...
                        // Devolver la moneda y lanzar su respectivo error (Que no quedan de la bebida pedida).
                        dep2.addMoneda(coin);
                        throw new NoHayBebidaException("Error: No quedan "+tipoBebida+"s.");
                    }
                    else{   // Si se pidio un deposito no existente.
                        // Devolver la moneda y lanzar su respectivo error (Ingreso mal el deposito).
                        dep2.addMoneda(coin);
                        throw new NoHayBebidaException("Error: Deposito incorrecto");
                    }
                } else {    // Si ya hay una bebida en el deposito de productos.
                    // Devolver la moneda y lanzar su respectivo error (El contenedor ya tiene una bebida).
                    dep2.addMoneda(coin);
                    throw new DepositoOcupadoException("Error: Contenedor ocupado.");
                }
            } else { // Si con la moneda ingresada no alcanza.
                // Devolver la moneda y lanzar su respectivo error (El pago no alcanza).
                dep2.addMoneda(coin);
                throw new PagoInsuficienteException("Error: Pago insuficiente.");
            }  
        } else throw new PagoIncorrectoException("Error: No ha ingresado monedas.");
        // Si no lanzar el error de que no se ingreso moneda para comprar.
    }
    public Moneda getVuelto() {
        // Metodo para extraer una moneda del deposito de vuelto.
        return dep2.getMoneda();  
    }
    
    public Bebida getBebida() {
        // Metodo para extraer la bebida del deposito de productos.
        return Producto.getBebida();
    }
    
    public void paint(Graphics g, int x, int y){
        // Metodo para imprimir la expendedora.
        Graphics2D exp = (Graphics2D)g;
        
        // Usar la imagen para la expendedora.
        exp.drawImage(this.img, x, y, 420, 520, null);
        
        // Pintar los elementos de la expendedora.
        Producto.paint(g,x+180,y+430);
        Coke.paint(g,x+180,y+18);
        Sprite.paint(g,x+255,y+18);
        Fanta.paint(g,x+330,y+18);
        dep2.paint(g,x+110,y+40);
        
        // Imprimir con las imagenes los botones para elegir la bebida.
        exp.drawImage(this.coca, x+25, y+40, 65, 50, null);
        exp.drawImage(this.sprite, x+25, y+100, 65, 50, null);
        exp.drawImage(this.fanta, x+25, y+160, 65, 50, null);
    }
}