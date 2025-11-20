/*UVM PC 19 nov,2025 */
public class Main
{

	public static void main(String[] args) {
		int filas = 12;
        int columnas = 16;
		char [][] mapa = new char[filas][columnas];
		for(int r = 0; r < filas; r++){
		    for(int c = 0; c < columnas; c++){
		        mapa[r][c] = '*';
		    }
		}
		HiloGusano gus = new HiloGusano(mapa);
		MonitorMapa monitor = new MonitorMapa(mapa);
		HiloJardinero jardinero = new HiloJardinero(mapa);
		System.out.println("Iniciando simulación.");
		gus.start();
		jardinero.start();
		monitor.start();

	}

}
 