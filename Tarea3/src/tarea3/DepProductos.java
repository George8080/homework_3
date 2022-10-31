
package tarea3;


public class DepProductos {
    private Bebida beb;
    public DepProductos(){
        beb = null;
    }
    
    public void addBebida(Bebida b){
        beb = b;
    }
    public Bebida getBebida(){
        Bebida b = beb;
        beb = null;
        return b;
    }
}
