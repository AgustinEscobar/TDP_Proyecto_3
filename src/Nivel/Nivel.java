package Nivel;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import Logica.Alpha;
import Logica.Beta;
import Logica.Infectado;
import Logica.Juego;

public abstract class Nivel {
	protected Juego juego;
	protected int cant_infectados;
	protected List<Infectado> listaTanda1;
	protected List<Infectado> listaTanda2;
	protected int cantTandas;
	//
	protected boolean arrancoTanda1;
	protected boolean arrancoTanda2;
	//
	
	public Nivel(Juego juego) {
		this.juego = juego;
		this.cantTandas = 2;
		this.listaTanda1 = new LinkedList<Infectado>();
		this.listaTanda2 = new LinkedList<Infectado>();
		this.arrancoTanda1 = false;
		this.arrancoTanda2 = false;
	}

	public List<Infectado> getPrimerTanda() {
		List<Infectado> retorno = null;
		if (!arrancoTanda1) {
			retorno = this.listaTanda1;
			this.arrancoTanda1 = true;
		}
		return retorno;
	}

	public List<Infectado> getSegundaTanda() {
		List<Infectado> retorno = null;
		if (!arrancoTanda2) {
			retorno = this.listaTanda2;
			this.arrancoTanda2 = true;
		}
		return retorno;
	}

	public int get_cant_infectados() {
		return cant_infectados;
	}

	public boolean termino_nivel() {
		return listaTanda1.isEmpty() && listaTanda2.isEmpty();
	}

	public boolean terminoPrimerTanda() {
		return listaTanda1.isEmpty();
	}

	protected void generarTanda(List<Infectado> listaTanda, int cantInfectados) {
		Random random = new Random();
		int valor;
		for (int i = 0; i < cantInfectados; i++) {
			valor = random.nextInt(3);
			if (valor == 1) {
				listaTanda.add(new Beta(juego));
			} else {
				listaTanda.add(new Alpha(juego));
			}
		}
	}

	public void eliminar_infectado(Infectado inf) {
		if (!listaTanda1.isEmpty()) {
			listaTanda1.remove(inf);
		} else {
			if (!listaTanda2.isEmpty()) {
				listaTanda2.remove(inf);
			}
		}
	}
}