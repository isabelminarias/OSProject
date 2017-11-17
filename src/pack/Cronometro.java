/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import static java.lang.Thread.sleep;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SAMSUNG_
 */
public class Cronometro extends Thread {
    
    private int[] dispatch = new int[2];
    private int timeElapsed;
    private Semaphore clock;
    private String estado;
    private int start;

    public int getDispatch() {
        return dispatch[0];
    }
    
    public int getDefaultDispatch(){
        return dispatch[1];
    }

    public void setDispatch(int n){
        if (start != 0){
            dispatch[0]= dispatch[1]-start%dispatch[1];
        }
        else{
            dispatch[0]=n;
        }
        
    }

    public int getTimeElapsed() {
        return timeElapsed;
    }

    public String getEstado() {
        return estado;
    }

    public Cronometro(int dispatch, int start, Semaphore clock) {
        this.dispatch[0] = dispatch;
        this.dispatch[1] = dispatch;
        this.clock = clock;
        this.timeElapsed=start;
        estado="ASLEEP";
    }
    
    public void run(){
        
        while(true){
            try {
                clock.acquire(1);
                    if (dispatch[0] == 0){
                        dispatch[0] = dispatch[1];
                        //estado = "REBIRTH";
                    }
                    dispatch[0]--;
                    timeElapsed++;
                    estado = "AWAKE";
                    sleep(50);
                    
                clock.release(1);
                estado = "ASLEEP";
                sleep(950);
                
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Cronometro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    
}
