
package tarea3;
        
public class Expendedor{
    private Deposito Sprite;
    private Deposito Fanta;
    private Deposito Coke;
    private DepVuelto dep2;
    private int money;
    
    public Expendedor(int cant, int precio){
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
    
    public Bebida ComprarBebida(int num, Moneda m) throws PagoInsuficienteException, PagoIncorrectoException, NoHayBebidaException{
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
                    return drink;
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
}
