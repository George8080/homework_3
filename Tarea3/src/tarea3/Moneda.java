
package tarea3;

public abstract class Moneda {
    private DepVuelto dep;
    
    public Moneda(){}
    
    public String getSerie(){
        return this.toString();
    }
    
    public abstract int getValor();
    
}

class Moneda1500 extends Moneda {
    public Moneda1500(){}   

    @Override
    public int getValor() {
        return 1500;
    }
}
class Moneda1000 extends Moneda {
    public Moneda1000(){}
    
    @Override
    public int getValor() {
        return 1000;
    }
}
class Moneda500 extends Moneda {
    public Moneda500(){}
    
    @Override
    public int getValor() {
        return 500;
    }
}
class Moneda100 extends Moneda {
    public Moneda100(){}
    
    @Override
    public int getValor() {
        return 100;
    }
}