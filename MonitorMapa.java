public class MonitorMapa extends Thread {
    private char[][] mapa;
    public MonitorMapa(char[][] mundo){
        this.mapa = mundo;
    }
    @Override
    public void run(){
        int r, c;
        int filas = mapa.length; 
        int columnas = mapa[0].length;
 
        while(true){
            try {
                System.out.println("----------");
                for(r = 0; r < filas; r++){
                    for(c = 0; c < columnas; c++){
                        System.out.printf("|%2c|", mapa[r][c]); 
                    }   
                    System.out.println(); 
                }
                sleep(500);
 
            } catch(InterruptedException e){
                System.out.println("Interrupcion");
                Thread.currentThread().interrupt(); 
                return;
            }
        }
    }
}