
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lhries
 */
public class Buffer {

    private Integer[] buffer;
    private int index;

    public Buffer() {
        this.buffer = new Integer[3];
        index = 0;
    }

    public synchronized void produzir(Integer valor) {
        while (index >= buffer.length) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("oi sou o produtor");
        System.out.println("Produzindo: " + valor);

        buffer[index] = valor;
        index++;
        System.out.println(Arrays.toString(buffer));
        notifyAll();
    }

    public synchronized Integer consumir() {
        while (index <= 0) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        Integer valor = buffer[index - 1];
        buffer[index - 1] = null;
        index--;
        //Imprimir valor
        System.out.println("OI Sou o consumidor ");
        System.out.println("Valor consumido: " + valor);
        //Imprimir buffer
        System.out.println(Arrays.toString(buffer));
        notifyAll();
        return valor;

    }

    public String toString() {
        return ("Buffer :" + Arrays.toString(buffer));
    }
}
