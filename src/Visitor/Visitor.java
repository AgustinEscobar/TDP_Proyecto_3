package Visitor;

import Logica.Alpha;
import Logica.Beta;
import Logica.Jugador;
import Logica.Particula;
import Logica.Proyectil_sanitario;
import Logica.Proyectil_sanitario_premio;
import Premio.Efecto_temporal;
import Premio.Objeto_precioso;
import Premio.Premio;

public abstract class Visitor {
	public void visit_alpha(Alpha a) {}
	public void visit_beta(Beta b) {}
	public void visit_jugador(Jugador j) {}
	public void visit_proyectil_sanitario(Proyectil_sanitario p) {}
	public void visit_proyectil_premio(Proyectil_sanitario_premio p) {}
	public void visit_premio(Premio p) {}
	public void visit_virus(Particula p) {}
	public void visit_premio_obj_precioso(Objeto_precioso o) {}
	public void visit_premio_obj_temporal(Efecto_temporal e) {}
}
