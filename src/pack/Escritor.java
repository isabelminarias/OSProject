/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author danie
 */
public class Escritor extends Thread {
    private Semaphore s1;
    private int[] cont;
    private int lapse;
    private int lapse2;

    public Escritor(Semaphore s1, int[] cont, int lapse) {
        this.s1 = s1;
        this.cont = cont;
        this.lapse = lapse;
        lapse2 = 0;
    }
    
    public Escritor(Semaphore s1, int[] cont, int lapse, int lapse2) {
        this.s1 = s1;
        this.cont = cont;
        this.lapse = lapse;
    }
    
        
    public void run(){
        Random aux=new Random();
        while (true){
            try {
                s1.acquire(1);
                    //aqui deberia checkear tiempo
                    
                    cont[0]++;
                    ;
                s1.release(1);
                sleep(18000 - aux.nextInt(12000));
            } catch (InterruptedException ex) {
                Logger.getLogger(Escritor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
