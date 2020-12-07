package Visitor;

import Logica.Alpha;
import Logica.Beta;
import Logica.Jugador;
import Logica.Particula;
import Logica.ProyectilSanitario;
import Logica.ProyectilSanitarioPremio;
import Premio.EfectoTemporal;
import Premio.ObjetoPrecioso;
import Premio.Premio;

public abstract class Visitor {
	public void visit_alpha(Alpha a) {}
	public void visit_beta(Beta b) {}
	public void visit_jugador(Jugador j) {}
	public void visit_proyectil_sanitario(ProyectilSanitario p) {}
	public void visit_proyectil_premio(ProyectilSanitarioPremio p) {}
	public void visit_premio(Premio p) {}
	public void visit_virus(Particula p) {}
	public void visit_premio_obj_precioso(ObjetoPrecioso o) {}
	public void visit_premio_obj_temporal(EfectoTemporal e) {}
	
}
