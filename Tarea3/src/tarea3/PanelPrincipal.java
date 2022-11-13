
package tarea3;

// Importar librerias necesarias para el funcionamiento del codigo
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import static java.lang.String.valueOf;
import javax.swing.Timer;

public class PanelPrincipal extends JPanel implements MouseListener, ActionListener {
    // Crear los atributos del Panel Principal.
    private int xExp = 380;
    private int yExp = 80;
    private Comprador com;
    private Expendedor exp;
    private int chosenCoin;
    private int animation;
    private int counter = 0;

    public PanelPrincipal () {
        // Constructor para inicializar los atributos.
        exp = new Expendedor (12, 1000);
        
        com = new Comprador(0,0,exp);
        // Esto para tener un comprador en pantalla, de esa manera (por la manera en la que esta
        // definida) se pueda imprimir a este y sus componentes sin realizar acciones destacables.
        
        this.setBackground(Color.pink);
        this.addMouseListener(this);
        animation = 0;
        chosenCoin = 0;
    }
    
    @Override
    public void paint (Graphics g) {    // Metodo para imprimir en la interfaz.
        super.paint(g); 
        // Pintar expendedor y comprador.
        com.paint(g,animation); 
        exp.paint(g,xExp,yExp);
       
        // Conjunto de funciones para imprimir una moneda con su numero de serie centralizado
        // en la mano derecha del comprador (en caso de que no sea nulo).
        Font fuente=new Font("Arial", Font.BOLD, 14);   // Fuente de la moneda.
        g.setColor(Color.black);
        g.setFont(fuente);
        int defPos = Moneda.last_serie;
        int posX = 275+9;
        int i = 0;
        if(animation == 0){
            switch (chosenCoin) {  // Generar la figura de la moneda y definir e imprimir su serie.
                case 1:
                    g.setColor(Color.yellow);      //Moneda de 1500
                    g.fillOval(275, 375, 24, 24);
                    g.setColor(Color.black);

                    while(defPos/10!=0){
                        defPos /= 10;
                        posX -= 4;
                        i++;
                    }
                    g.drawString(valueOf(Moneda.last_serie), posX, 375+18);
                    break;
                case 2:
                    g.setColor(Color.cyan);        //Moneda de 1000
                    g.fillOval(275, 375, 24, 24);
                    g.setColor(Color.black);

                    while(defPos/10!=0){
                        defPos /= 10;
                        posX -= 4;
                        i++;
                    }
                    g.drawString(valueOf(Moneda.last_serie), posX, 375+18);
                    break;
                case 3:
                    g.setColor(Color.green);       //Moneda de 500
                    g.fillOval(275, 375, 24, 24);
                    g.setColor(Color.black);

                    while(defPos/10!=0){
                        defPos /= 10;
                        posX -= 4;
                        i++;
                    }
                    g.drawString(valueOf(Moneda.last_serie), posX, 375+18);
                    break;
                case 4:
                    g.setColor(Color.red);          //Moneda de 100
                    g.fillOval(275, 375, 24, 24);
                    g.setColor(Color.black);

                    while(defPos/10!=0){
                        defPos /= 10;
                        posX -= 4;
                        i++;
                    }
                    g.drawString(valueOf(Moneda.last_serie), posX, 375+18);
                    break;
            }
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent me) {
        // Obtener la posicion en donde se clickeo.
        int x = me.getX( );
        int y = me.getY( );
        System.out.println(x + " " + y);
        
        if(animation == 0){ // Si no estamos en la animacion...
            // Si se aprieta el boton de $1500
            if(x>=xExp-120 && x<=xExp-65 && y>=yExp+520 && y<=yExp+560){
                System.out.println("Escogio moneda de 1500");
                chosenCoin=1;
                this.repaint();
            }
            // Si se aprieta el boton de $1000
            else if(x>=xExp-190 && x<=xExp-135 && y>=yExp+520 && y<=yExp+560){
                System.out.println("Escogio moneda de 1000");
                chosenCoin=2;
                this.repaint();
            }
            // Si se aprieta el boton de $500
            else if(x>=xExp-260 && x<=xExp-200 && y>=yExp+520 && y<=yExp+560){
                System.out.println("Escogio moneda de 500");
                chosenCoin=3;
                this.repaint();
            }
            // Si se aprieta el boton de $100
            else if(x>=xExp-330 && x<=xExp-270 && y>=yExp+520 && y<=yExp+560){
                System.out.println("Escogio moneda de 100");
                chosenCoin=4;
                this.repaint();
            }    

            // Si se aprieta el deposito del producto tomar la bebida en el caso de que haya una.
            if(x>=xExp+180 && x<=xExp + 400 && y>=yExp+430 && y<=yExp+480 ){
                System.out.println("Devolviendo bebida");
                if(com != null){
                    com.getBebida(exp);
                    if(com.queBebiste()!=null){ // Si hay bebida iniciar la animacion.
                        animation = 1;
                        this.repaint();
                        Timer t = new Timer(500, this);
                        t.addActionListener(this);
                        t.start();
                    }
                }
                this.repaint();
            }
            // Si se apreto el conducto de monedas retirar la primera moneda.
            else if(x>=xExp+40 && x<=xExp+90 && y>=340+yExp && y<=390+yExp ){
                System.out.println("Devolviendo vuelto");
                com.getVuelto(exp);
                this.repaint();
            }
            // Si se apreto el boton de Cocacola intentar comprar una.
            else if(x>=xExp+25 && x<=xExp+90 && y>=yExp+40 && y<=yExp+90){
                System.out.println("Intentando comprar una coca");
                this.com = new Comprador(chosenCoin, 1, exp);
                chosenCoin = 0;
                this.repaint();
            }
            // Si se apreto el boton de Sprite intentar comprar una.
            else if(x>=xExp+25 && x<=xExp+90 && y>=yExp+100 && y<=yExp+150){
                System.out.println("Intentando comprar una sprite");
                this.com = new Comprador(chosenCoin, 2, exp);
                chosenCoin = 0;
                this.repaint();
            }
            // Si se apreto el boton de Fanta intentar comprar una.
            else if(x>=xExp+25 && x<=xExp+90 && y>=yExp+160 && y<=yExp+210){
                System.out.println("Intentando comprar una fanta");
                this.com = new Comprador(chosenCoin, 3, exp);
                chosenCoin = 0;
                this.repaint();
            }
            // Si se apreto en la expendedora (en zonas donde no estan ubicadas las acciones 
            // anteriores) rellenar los depositos de bebidas que esten vacios.
            else if(x>=xExp && x<=xExp+420 && y>=yExp && y<=yExp + 520){
                System.out.println("Rellenando contenedores vacios");
                exp.llenarContenedores(12, 1000);
                this.repaint();
            }
        }
    }

    // Metodos no ocupados relacionados con el click del mouse, puestos para no generar errores.
    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}

    // Animacion para tomar la bebida
    @Override
    public void actionPerformed(ActionEvent e) {
        if (counter == 6) { // Una vez pasado los 3 segundos (0.5 * 6)...
            ((Timer)e.getSource()).stop();  // Detener el cronometro.
            counter = 0;        // Reiniciar el contador
            com.drinkBebida();  // Beber la bebida.
            animation = 0;      // Desactivar la animacion.
            this.repaint();     // Repintar
        } else if(((Timer)e.getSource()).isRunning()) { // Si no...
            System.out.println("Count: " + (++counter));// Añadir 1 al contador.
        }
    }
}