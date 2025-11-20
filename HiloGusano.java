import java.util.Random;
public class HiloGusano extends Thread {
    private char[][] jardin;
    private int filas;
    private int columnas;
    
    public HiloGusano (char [][] mundo){
        this.jardin = mundo;
        filas=jardin.length;
        columnas=jardin[0].length;
    }
    
    public void caminaRenglon(int r){
        for(int x=0;x<columnas;x++){
            jardin [r][x]='W';
        }
        
    }
    
    public void caminaColumna(int c){
        for(int x=0;x<filas;x++){
            jardin [x][c]='W';
        }
        
    }
    
    public void comerColumna(int c, int traga){
        for(int x=0;x<traga;x++){
            jardin [x][c]='C';
        }
    }
    
    public void comerRenglon(int r, int traga){
        for(int x=0;x<traga;x++){
            jardin [r][x]='C';
        }
        
    }
    
    @Override
    public void run(){
        Random random = new Random();
        int vida=500;

         while(vida > 0){
            try{
                synchronized(jardin){
                    int r = random.nextInt(filas); 
                    int c = random.nextInt(columnas);
                    int accion = random.nextInt(2); 
                    if(accion == 0){
                        int cuantoCome = random.nextInt(4) + 2;
                        if(random.nextBoolean()) 
                            comerRenglon(r, cuantoCome);
                        else 
                            comerColumna(c, cuantoCome);
                    } else {
                        if(random.nextBoolean())
                            caminaRenglon(r);
                        else
                            caminaColumna(c);
                    }
                    jardin.notify(); 
                }               
                sleep(200); 
                vida--;
            }
            catch(InterruptedException e){
                System.out.println("Interrupcion Gusano");
            }
            catch(ArrayIndexOutOfBoundsException e){
            }
        }
    }
}

