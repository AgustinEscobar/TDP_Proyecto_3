package Estado;

import Logica.Jugador;
import Logica.Proyectil;
import Logica.ProyectilSanitarioPremio;
import Premio.EfectoTemporal;

public class EstadoSuperArmaSanitaria extends Estado{
	protected int cooldown;
	
	
	public EstadoSuperArmaSanitaria(Jugador jugador) {
		super(jugador);
		this.cooldown = EfectoTemporal.MAXDURACION;
		}
	
	
	public void accionarEstado() {
		this.cooldown-=2;
		if(cooldown <= 0) {
			jugador.setEstado(new EstadoNormal(jugador));
		}
	}
 

	@Override
	public Proyectil getProyectil() {
		return new ProyectilSanitarioPremio(jugador.getJuego(),jugador.getGrafico());
	}

	
}
