
package tarea3;

import java.util.ArrayList;


public class Deposito{
    private ArrayList<Bebida> v;
    
    public Deposito(int cant){
        v = new ArrayList<>(cant);

    }
    public Bebida getBebida(){
        if(v.isEmpty()){
            return null;
        }else{
            return v.remove(0);
        }
    }
    public void addBebida(Bebida drink){
        v.add(drink);
    }
}
