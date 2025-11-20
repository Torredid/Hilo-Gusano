public class HiloJardinero extends Thread {
    private char[][] jardin;
    
    public HiloJardinero(char[][] mundo){
        this.jardin = mundo;
    }
    

    private boolean estaSucio(){
        for(int r=0; r<jardin.length; r++){
            for(int c=0; c<jardin[0].length; c++){
                if(jardin[r][c] == 'C' || jardin[r][c] == 'W'){
                    return true; 
                }
            }
        }
        return false;
    }
    
    private void limpiar(){
        for(int r=0; r<jardin.length; r++){
            for(int c=0; c<jardin[0].length; c++){
                if(jardin[r][c] == 'C' || jardin[r][c] == 'W'){
                    jardin[r][c] = '*';
                }
            }
        }
        System.out.println("Jardinero: Limpie el jardin.");
    }

    @Override
    public void run(){
        while(true){
            try{
                synchronized(jardin){
                    // Si NO esta sucio, nos esperamos
                    if(!estaSucio()){
                        System.out.println("Jardinero: Todo limpio, a dormir (wait).");
                        jardin.wait();
                    }
                    
                    // Si despertamos o estaba sucio, limpiamos
                    limpiar();
                }
                // Descansamos un poco para no saturar
                sleep(2000);
            }
            catch(InterruptedException e){
                System.out.println("Interrupcion Jardinero");
            }
        }
    }
}