package Nivel;

import java.util.LinkedList;

import Logica.Infectado;
import Logica.Juego;

public class Nivel2 extends Nivel {

	public Nivel2(Juego j, int cantTandas) {
		super(j, cantTandas);
		this.cantInfectados = 10;
		int mitad = cantInfectados / 2;
		this.generarTanda(listaTanda1, mitad);
		this.generarTanda(listaTanda2, this.cantInfectados - mitad);

		for (int i = 0; i < cantTandas; i++) {
			this.arregloTandas[i] = new LinkedList<Infectado>();
			this.generarTanda(arregloTandas[i], cantInfectados);
		}
		this.cantInfectados = this.totalInfectados;
	}
}
