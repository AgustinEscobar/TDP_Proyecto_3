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
	protected int cantInfectados;
	protected List<Infectado> listaTanda1;
	protected List<Infectado> listaTanda2;
	//
	protected boolean arrancoTanda1;
	protected boolean arrancoTanda2;
	//
//
	protected List<Infectado>[] arregloTandas;
	protected int tandaActual;
	protected int totalInfectados;
	protected boolean arrancoTanda;
//

	public Nivel(Juego juego, int cantTandas) {
		this.juego = juego;
		this.listaTanda1 = new LinkedList<Infectado>();
		this.listaTanda2 = new LinkedList<Infectado>();
		this.arrancoTanda1 = false;
		this.arrancoTanda2 = false;

		//
		this.arregloTandas = (List<Infectado>[]) new List[cantTandas];
		this.tandaActual = 0;
		this.totalInfectados = 0;
		this.arrancoTanda = false;
		//
	}

	// ---------------------MEJORA-NIVEL---------------------

	public void accionarNivel() {
		if(!arrancoTanda) { //inserto los infectados a entidades
			for(Infectado infectado : this.arregloTandas[tandaActual]) {
				juego.insertarEntidad(infectado);
			}
			this.arrancoTanda = true;
		}
	}

	public boolean terminoNivel() {
		return this.cantInfectados == 0;
	}

	public void eliminarInfectado(Infectado infectado) {
		if (!arregloTandas[tandaActual].isEmpty()) {
			this.arregloTandas[tandaActual].remove(infectado);
		}
	}

	// ------------------------------------------

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

	public int getCantInfectados() {
		return cantInfectados;
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
			this.totalInfectados += 1;
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