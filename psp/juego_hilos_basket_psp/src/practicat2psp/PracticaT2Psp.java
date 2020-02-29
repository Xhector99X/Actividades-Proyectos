package practicat2psp;

import java.util.ArrayList;

public class PracticaT2Psp {

    public static void main(String[] args) {

        ArrayList<Hilo> registro = new ArrayList<Hilo>();
		
		registro.add(new Hilo("Equipo Rojo"));
		registro.add(new Hilo("Equipo Azul"));
		
		for (Hilo miHilo : registro) {
			miHilo.start();
		}
	}

}




class Hilo extends Thread {
	
	private Contador contador;
	
	public Hilo(String h){
		super(h);
		contador = new Contador();
	}
	@Override
	public void run() {

		for (int i = 0; i < 150; i++) {
			double r = Math.random();
			if (r < 0.3) {
				contador.fallos();
			} else if (r > 0.3 && r < 0.5) {
				contador.tirosLibres();
			} else if (r > 0.5 && r < 0.9) {
				contador.doble();
			} else if (r > 0.9) {
				contador.triple();
			}

			try {
				sleep(100);
			} catch (Exception e) {
				System.out.println(e.getStackTrace());
			}
		}
		contador.resultados_marcador(getName());
		
	}
}

class Contador {
	private int pTotales = 0;
	private int fallosCan;
	private int tirosLibresEnc;
	private int tiroDoble;
	private int tiroTriple;

	public void fallos() {
		pTotales+=0;
		fallosCan++;
	}
	public void tirosLibres() {
		pTotales+=1;
		tirosLibresEnc++;
	}
	public void doble() {
		pTotales+=2;
		tiroDoble++;
	}
	public void triple() {
		pTotales+=3;
		tiroTriple++;
	}

	public void resultados_marcador(String resultado) {
		System.out.println("Resultados del " + resultado);
		System.out.println("Puntos totales anotados " + pTotales);
		System.out.println("Canastas falladas " + fallosCan);
		System.out.println("Tiros libres encestados " + tirosLibresEnc);
		System.out.println("Tiros de dos encestados " + tiroDoble);
		System.out.println("Tiros de tres encestados " + tiroTriple);
		System.out.println("                     ");
        
        
    }

}
