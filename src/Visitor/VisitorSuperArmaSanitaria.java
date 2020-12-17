package Visitor;

import Estado.EstadoSuperArmaSanitaria;
import Logica.Jugador;
import Premio.PremioSuperArmaSanitaria;

public class VisitorSuperArmaSanitaria extends Visitor{
			
		protected PremioSuperArmaSanitaria premio;
	
		public VisitorSuperArmaSanitaria(PremioSuperArmaSanitaria p) {
			premio=p;
		}
		
		public void visitJugador(Jugador j) {
			j.setEstado(new EstadoSuperArmaSanitaria(j));
			premio.eliminar();
		}
		
		
}
