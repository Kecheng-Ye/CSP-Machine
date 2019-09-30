package CSP;

import java.util.HashMap;

public abstract class Constrain {
	 boolean result=true;
	 public abstract void test(HashMap<Variable,Object> a);
}