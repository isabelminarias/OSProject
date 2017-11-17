/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;
import java.io.*;
/**
 *
 * @author SAMSUNG_
 */
public class LectorDeTexto {
    private String FileName;
    private String fileb;
    private int Timestart; 
    private int DispatchLapse;
    private int MaxControls;
    private int MaxConsoles;
    private int MaxPacks;
    private int InitProd1; 
    private int InitProd2;
    private int InitProd3;
    private int MaxProd1;
    private int MaxProd2;
    private int MaxProd3;
    private int InitAssemblers;
    private int MaxAssemblers; 
    private boolean error;
            

    public LectorDeTexto() {
        //this.FileName = "/Users/joseguerrero/Desktop/default.txt";
        this.FileName = "C:\\Users\\SAMSUNG_\\Documents\\NetBeansProjects\\FabricaPS ProyectoOS\\build\\classes\\pack\\default.txt";
        String line = new String();
        String[] lines = new String[13];
        int[] data = new int[13];
        int counter = 0; 
        int i = 0;
        boolean error=false; 
        int[] def = {0,15,30,20,40,3,2,1,5,10,3,1,4};
        String temp;
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(FileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null && counter < 13) {
                //System.out.println("Recibo la linea"+" === "+line);
                lines[counter] = line;
                temp = line.substring(8, line.length());
                //System.out.println("temp es "+temp);
                
                while (i<temp.length()){
                    //System.out.println("el caracter .."+ temp.charAt(i)+".. en la pos "+i+" es : "+Character.isDigit(temp.charAt(i)));
                    
                    if (!Character.isDigit(temp.charAt(i))){
                       error = true; 
                    }
                    i++;
                }
                
                if (error){
                    temp = String.valueOf(def[counter]);
                }
                
                
                data[counter] = Integer.valueOf(temp);
                //System.out.println("Data #"+counter+" in numbers is "+data[counter]);
                
                counter++;
            
            }
            
            
            

            // Always close files.
            bufferedReader.close();         
        }
        
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                FileName + "'");     
            int c = 0;
            while (c<13){
                data[c]=def[c];
                c++;
            }
        }
        catch(Exception e) {
               System.out.println(
                "Error en los valores introducidos en '" + 
                FileName + "'");
        }
        
        
        
        
        
        this.Timestart = data[0];           //TIMESEC tiempo en segundos
        this.DispatchLapse = data[1];       //DISPATCH LAPSE tiempo entre despachos
        this.MaxControls = data[2];         //Capacidad maxima de controles
        this.MaxConsoles = data[3];         //Capacidad maxima de consolas
        this.MaxPacks = data[4];            //Capacidad maxima de paquetes          
        this.InitProd1 = data[5];           //Productores Consola inicial
        this.InitProd2 = data[6];           //Productores Control inicial
        this.InitProd3 = data[7];           //Productores Paquete inicial
        this.MaxProd1 = data[8];            //Limite de productores de controles
        this.MaxProd2 = data[9];            //Limite de productores de consolas
        this.MaxProd3 = data[10];           //Limite de productores de paquetes
        this.InitAssemblers = data[11];     //Ensambladores inicial
        this.MaxAssemblers = data[12];      //Limite de ensambladores
        
     
        
        
        
    }
    
    
    
    
   public boolean getError(){
       return error;
   }
   public void setError(boolean error){
       this.error=error;
   }

    public int getTimestart() {
        return Timestart;
    }

    public void setTimestart(int Timestart) {
        this.Timestart = Timestart;
    }

    public int getDispatchLapse() {
        return DispatchLapse;
    }

    public void setDispatchLapse(int DispatchLapse) {
        this.DispatchLapse = DispatchLapse;
    }

    public int getMaxControls() {
        return MaxControls;
    }

    public void setMaxControls(int MaxControls) {
        this.MaxControls = MaxControls;
    }

    public int getMaxConsoles() {
        return MaxConsoles;
    }

    public void setMaxConsoles(int MaxConsoles) {
        this.MaxConsoles = MaxConsoles;
    }

    public int getMaxPacks() {
        return MaxPacks;
    }

    public void setMaxPacks(int MaxPacks) {
        this.MaxPacks = MaxPacks;
    }

    public int getInitProd1() {
        return InitProd1;
    }

    public void setInitProd1(int InitProd1) {
        this.InitProd1 = InitProd1;
    }

    public int getInitProd2() {
        return InitProd2;
    }

    public void setInitProd2(int InitProd2) {
        this.InitProd2 = InitProd2;
    }

    public int getInitProd3() {
        return InitProd3;
    }

    public void setInitProd3(int InitProd3) {
        this.InitProd3 = InitProd3;
    }

    public int getMaxProd1() {
        return MaxProd1;
    }

    public void setMaxProd1(int MaxProd1) {
        this.MaxProd1 = MaxProd1;
    }

    public int getMaxProd2() {
        return MaxProd2;
    }

    public void setMaxProd2(int MaxProd2) {
        this.MaxProd2 = MaxProd2;
    }

    public int getMaxProd3() {
        return MaxProd3;
    }

    public void setMaxProd3(int MaxProd3) {
        this.MaxProd3 = MaxProd3;
    }

    public int getInitAssemblers() {
        return InitAssemblers;
    }

    public void setInitAssemblers(int InitAssemblers) {
        this.InitAssemblers = InitAssemblers;
    }

    public int getMaxAssemblers() {
        return MaxAssemblers;
    }

    public void setMaxAssemblers(int MaxAssemblers) {
        this.MaxAssemblers = MaxAssemblers;
    }
   
    
}
        
   
    
    
    

