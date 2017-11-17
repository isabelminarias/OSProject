/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

/**
 *
 * @author Estudiantes
 */
public class Almacen {
    private boolean[] almacen;
    private int apuntP;
    private int apuntC;

    public Almacen(int tam) {
        this.almacen = new boolean[tam];
        this.apuntP = 0;
        this.apuntC = 0;
    }

    public boolean[] getAlmacen() {
        return almacen;
    }

    public void setAlmacen(boolean[] almacen) {
        this.almacen = almacen;
    }

    public int getApuntP() {
        return apuntP;
    }

    public void setApuntP(int apuntP) {
        this.apuntP = apuntP;
    }

    public int getApuntC() {
        return apuntC;
    }

    public void setApuntC(int apuntC) {
        this.apuntC = apuntC;
    }
    
    public void Producir(int pos){
        almacen[pos]=true;
    }
    
    public void Consumir (int pos){
        almacen[pos]=false;
    }
    
    public int Contar(){
        int c = 0;
        for (int i = 0; i < almacen.length; i++){
            if (almacen[i]==true){
                c++;
            }
        }
        
        return c;
        
    }
    
    public boolean checkAvail(){
        int c = 0;
        for (int i=0; i<almacen.length; i++){
            if (almacen[i]==false){
                c++;
            }
        }
        
        if (c==0) {
            return true; 
        }
        else{
            return false;
        }
    }
    
    public void Imprimir(){
        System.out.println("|");
        for (int i=0; i<almacen.length; i++){
            System.out.print(almacen[i]+" ");
        }
    }
    
    
    
    
    
}
