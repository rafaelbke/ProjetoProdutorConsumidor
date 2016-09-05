
import java.util.Random;
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
public class Produtor extends Thread{
    private Buffer buffer;

    public Produtor(Buffer buffer) {
        this.buffer = buffer;
    }
    
    @Override
    public void run(){
        int num = -1;
        do{
            num = new Random().nextInt(10000);
            buffer.produzir(num);
            
            
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(Produtor.class.getName()).log(Level.SEVERE, null, ex);
//            }
        }while(num!=0);
    }
    
}
