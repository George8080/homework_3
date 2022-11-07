
package tarea3;

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
            //sabor = bebida.beber();
        }catch (PagoIncorrectoException | NoHayBebidaException | PagoInsuficienteException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void getBebida(DepProductos drink){
        bebida = drink.getBebida();
        sabor = bebida.beber();
    }
    
    public void getVuelto(Expendedor exp){
        Moneda d;
        do{
            d = exp.getVuelto();
            if(d != null){
                cantidadTotal += d.getValor();
            }
        }while(d != null);
    }
    
    public int cuantoVuelto(){
        return cantidadTotal;
    } 
    public String queBebiste(){
        return  sabor;
    }
    
    public void paint(){}

}