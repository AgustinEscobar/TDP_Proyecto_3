package Nivel;

import Logica.Juego;

public class Nivel_2 extends Nivel {

	public Nivel_2(Juego j) {
		super(j);
		this.cant_infectados = 10;
		int mitad = cant_infectados/2;
		this.generarTanda(listaTanda1, mitad);
		this.generarTanda(listaTanda2, this.cant_infectados - mitad);
	}
}
