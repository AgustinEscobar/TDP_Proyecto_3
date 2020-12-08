package Logica;
// deba: yo la sacaria, innecesaria
public class Arma {
	protected Proyectil proyectil;
	protected Jugador jugador;

	public Arma(Proyectil p, Jugador jugador) {
		this.proyectil = p;
		this.jugador = jugador;
	}

	public Proyectil disparar() {
		return jugador.getEstado().getProyectil();
	}

	public void setProyectil(Proyectil p) {
		this.proyectil = p;
	}
}