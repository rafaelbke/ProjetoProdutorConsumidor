
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lhries
 */
public class Consumidor extends Thread{

    private Buffer buffer;

    public Consumidor(Buffer buffer) {
        this.buffer = buffer;
    }
    
    @Override
    public void run(){
        int valorConsumido = -1;
        do{
            //Consumir valor
            valorConsumido = buffer.consumir();            
           
//            try {
//                Thread.sleep(30);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(Produtor.class.getName()).log(Level.SEVERE, null, ex);
//            }
            
        }while(valorConsumido!=0);
    }

    
}
