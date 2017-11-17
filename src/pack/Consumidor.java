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
public class Consumidor extends Thread{
    private Almacen a1;
    private Almacen a2;
    private Almacen a3;
    private Semaphore SP1;
    private Semaphore SP2;
    private Semaphore SP3;
    private Semaphore SC;
    private Semaphore SE1;
    private Semaphore SE2;
    private Semaphore SE3;
    private boolean finished = false;
    private int count;
    int steps = 0;
    
    
    public void stopMe(){
        finished = true;
    }

    public Consumidor(Almacen a1, Almacen a2, Almacen a3, 
            Semaphore SP1, Semaphore SP2, Semaphore SP3, 
            Semaphore SC, Semaphore SE1, Semaphore SE2, Semaphore SE3) {
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
        this.SP1 = SP1;
        this.SP2 = SP2;
        this.SP3 = SP3;
        this.SC = SC;
        this.SE1 = SE1;
        this.SE2 = SE2;
        this.SE3 = SE3;
        count = 0;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
    
    
    @Override
    public void run() {
        while(!finished){
        try {
            
            SC.acquire(2);
            if (a1.Contar()>=2 && steps == 0){
            SE1.acquire(1);
            
                a1.Consumir(a1.getApuntC());
                a1.Consumir((a1.getApuntC()+1)%a1.getAlmacen().length);
                a1.setApuntC((a1.getApuntC()+2)%a1.getAlmacen().length);
                //almacen.Imprimir();
                steps++;
            SE1.release(1);
            SP1.release(2);
            }
            
            if (a2.Contar()>0 && steps == 1){
            SE2.acquire(1);
            
                a2.Consumir(a2.getApuntC());
                a2.setApuntC((a2.getApuntC()+1)%a2.getAlmacen().length);
                steps++;
            SE2.release(1);
            SP2.release(1);
            }
            
            if(a3.Contar()>0 && steps == 2){
            SE3.acquire(1);
            
                a3.Consumir(a3.getApuntC());
                a3.setApuntC((a3.getApuntC()+1)%a3.getAlmacen().length);
                steps++;
            SE3.release(1);
            SP3.release(1);
            }
            
            if (steps == 3){
            count++;
            sleep(2000);
            steps = 0;
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Consumidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }
    
    
    
    
}

