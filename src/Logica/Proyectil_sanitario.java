package Logica;

import Grafico.Grafico;
import Grafico.GraficoProyectilSanitario;

public class Proyectil_sanitario extends Proyectil {

	public Proyectil_sanitario(Juego juego,Grafico grafico_jugador) {
		super(juego,grafico_jugador);
		this.grafico = new GraficoProyectilSanitario();
		this.velocidad = 8;
		this.cap_desinfeccion = 25;
		this.grafico.setLocation(grafico_jugador.getX() + this.grafico.getAncho()/3 , grafico_jugador.getY()-this.grafico.getY()-30);
		this.grafico.repaint();
		System.out.println(grafico_jugador.getX() + this.grafico.getAncho()+" | "+grafico_jugador.getY());
	}

	@Override
	public void accionar() {
		movimiento.mover();
	}

}