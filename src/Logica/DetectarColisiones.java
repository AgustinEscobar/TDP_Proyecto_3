package Logica;

import Grafico.Grafico;

public class DetectarColisiones {
	protected Entidad entidad;
	protected Juego juego;

	public DetectarColisiones(Entidad entidad, Juego juego) {
		this.entidad = entidad;
		this.juego = juego;
	}

	public void detectarColision() {
		Grafico graficoEntidad = entidad.getGrafico();
		for (Entidad entidadActual : juego.entidades()) {
			if (entidad != entidadActual) {
				if (graficoEntidad.getRectangle().intersects(entidadActual.getGrafico().getRectangle())) {
					this.entidad.aceptar(entidadActual.getVisitor());
				}
			}
		}
	}
}
