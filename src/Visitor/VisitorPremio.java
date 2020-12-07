package Visitor;

import Premio.Premio;

public class VisitorPremio extends Visitor {
	protected Premio premio;

	public VisitorPremio(Premio p) {
		premio = p;
	}
}
