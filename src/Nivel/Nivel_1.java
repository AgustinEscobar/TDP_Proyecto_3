package Nivel;

import Logica.Juego;

public class Nivel_1 extends Nivel {

	public Nivel_1(Juego j) {
		super(j);
		this.cant_infectados = 5;
		int mitad = cant_infectados/2;
		this.generarTanda(listaTanda1, mitad);
		this.generarTanda(listaTanda2, this.cant_infectados - mitad);
	}
}
