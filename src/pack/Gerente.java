/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SAMSUNG_
 */
public class Gerente extends Thread{
    private Semaphore clock;
    private Cronometro c;
    private String estado;
    private boolean signal = false;

    public Gerente(Semaphore clock, Cronometro c) {
        this.clock = clock;
        this.c = c;
    }

    public String getEstado() {
        return estado;
    }

    public void disableSignal() {
        this.signal = false;
    }
    
    
    
    public boolean isSignal() {
        return signal;
    }
   
    
    
    public void dispatched(){
        this.signal = false;
    }
    
    public void run(){
        Random aux=new Random();
        while (true){
            try {
                clock.acquire(1);
                estado = "AWAKE";
                    if (c.getEstado() == "ASLEEP" && c.getDispatch()==0){
                        signal = true;
                        c.setDispatch(c.getDefaultDispatch());
                    }
                clock.release(1);
                estado = "NAPPING";
                sleep(750 - aux.nextInt(500));
            } catch (InterruptedException ex) {
                Logger.getLogger(Gerente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
