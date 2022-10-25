
package maquina;

import java.util.ArrayList;

public class DepVuelto{
        private ArrayList<Moneda> m;
        
        public DepVuelto(){
            m = new ArrayList<>();
        
        }
        
    public Moneda getMoneda(){
        if(m.isEmpty()){
            return null;
        }else{
            return m.remove(0);
            }
        
        }
    
    public void addMoneda(Moneda mon){
        m.add(mon);
    }
    
    public void removeMoneda(Moneda mon){
        m.remove(mon);
    
    }
    
}
