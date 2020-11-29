package Logica;

import java.util.Random;

import Movimiento.Movimiento_vertical;
import Premio.Efecto_temporal;
import Premio.Objeto_precioso;

public abstract class Infectado extends Personaje {

	protected int letalidad;
	protected Particula particula;
	protected int cooldown; // duracion

	public Infectado(Juego juego) {
		super(juego);
		this.carga_viral = 100;
		this.movimiento = new Movimiento_vertical(this,Movimiento_vertical.ABAJO);
		cooldown = 45;
//		int valor;
//		Random ran = new Random();
//		valor = ran.nextInt(3);
//		if (valor == 0) {
//			premio = new Efecto_temporal(this.grafico);
//		} else {
//			if (valor == 1) {
//				premio = new Objeto_precioso(this.grafico);
//			} else {
//				premio = null;
//			}
//		}
//		valor = ran.nextInt(gameGUI.LIMITE_DER_X);
//		this.grafico.setLocation(valor, gameGUI.LIMITE_SUPERIOR);
		this.particula = null;
	}

	// si al recibir daño, se desinfecta y además tiene premio, dropeamos premio en
	// la pos posactual
	public boolean esta_infectado() {
		boolean es = false;
		if (carga_viral > 0) {
			es = true;
		}
		return es;
	}

	public void mover() {
		movimiento.mover();
	}

	public Particula lanzar_particula() {
		return new Particula(juego,this);
	}

	@Override
	public void accionar() {
		// lanzar particula
		// moverse
		if (carga_viral > 0) {
			this.mover();
			disparar();
		}

	}

	public void disparar() {
		if (this.cooldown == 0) {
			lanzar_particula();
			// TERMINAR
		} else {
			this.cooldown -= 1;
		}
	}

}
