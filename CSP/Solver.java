package CSP;

import java.util.HashMap;

public abstract class Solver {
	
	public CSP csp;
	
	
	public abstract HashMap<Variable,Object> solve();
}
