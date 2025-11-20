
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
        int vida=99;
        int ini=0;
        while(vida>0)
        try{
            synchronized(jardin){
                comerRenglon(ini, 3);
                ini++;
            }
            ini--;
            sleep(500);
            vida--;
        }
        catch(InterruptedException e){
            System.out.println("Interrupcion");
        }
        catch(ArrayIndexOutOfBoundsException e){
            ini=0;
        }
        
        
    }
    
}

(HOla)