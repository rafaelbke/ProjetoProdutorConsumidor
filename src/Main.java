
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lhries
 */
public class Main {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        Produtor prod = new Produtor(buffer);
        Consumidor cons = new Consumidor(buffer);
        
        prod.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        cons.start();
    }
}
