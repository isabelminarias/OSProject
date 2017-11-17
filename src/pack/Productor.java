/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Estudiantes
 */
public class Productor extends Thread {
    private Almacen almacen;
    private Semaphore SP; 
    private Semaphore SC;
    private Semaphore SE;
    private int type;
    private boolean finished = false;

    public Productor(Almacen almacen, Semaphore SP, Semaphore SC, Semaphore SE, int type) {
        this.almacen = almacen;
        this.SP = SP;
        this.SC = SC;
        this.SE = SE;
        this.type = type;
        finished = false;
    }

    public boolean isFinished() {
        return finished;
    }

   
    
    
    public void stopMe(){
        finished = true;
    }
    
    @Override
    public void run() {
        while(!finished){
        try {
            SP.acquire(1);
            SE.acquire(1);
                almacen.Producir(almacen.getApuntP());
                almacen.setApuntP((almacen.getApuntP()+1)%almacen.getAlmacen().length);
               // almacen.Imprimir();
            SE.release(1);
            SC.release(1);
            sleep(type*1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }
    
    
    
    
}
