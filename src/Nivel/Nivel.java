package Nivel;

import java.util.List;
import java.util.Random;

import Logica.Alpha;
import Logica.Beta;
import Logica.Infectado;
import Logica.Juego;

public abstract class Nivel {
	protected Juego juego;
	protected int cantInfectados;
	protected List<Infectado>[] arregloTandas;
	protected int tandaActual;
	protected int totalInfectados;
	protected boolean arrancoTanda;

	public Nivel(Juego juego, int cantTandas) {
		this.juego = juego;
		this.arregloTandas = (List<Infectado>[]) new List[cantTandas];
		this.tandaActual = 0;
		this.totalInfectados = 0;
		this.arrancoTanda = false;
	}

	// ---------------------MEJORA-NIVEL---------------------

	public void accionarNivel() {
		if (tandaActual != arregloTandas.length && arregloTandas[tandaActual].isEmpty()) {
			// avanzo a la siguiente tanda
			this.arrancoTanda = false;
			tandaActual += 1;
		}
		if (!arrancoTanda && tandaActual != arregloTandas.length) { // inserto los infectados a entidades
			for (Infectado infectado : this.arregloTandas[tandaActual]) {
				juego.insertarLuego(infectado);
			}
			this.arrancoTanda = true;
		}

	}

	public boolean terminoNivel() {
		return arregloTandas[arregloTandas.length - 1].isEmpty();
	}

	public void eliminarInfectado(Infectado infectado) {
		if (tandaActual < arregloTandas.length && !arregloTandas[tandaActual].isEmpty()) {
			this.arregloTandas[tandaActual].remove(infectado);
			this.cantInfectados -= 1;
		}
	}

	public int getCantInfectados() {
		return cantInfectados;
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
}