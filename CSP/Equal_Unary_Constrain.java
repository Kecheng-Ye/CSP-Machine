package CSP;

import java.util.HashMap;

public class Equal_Unary_Constrain extends Constrain{
	Variable variable;
	Object value;
	
	public Equal_Unary_Constrain(Variable variable,Object value) {
		this.variable=variable;
		this.value=value;
		
		if(!is_Domain()) {
			System.out.print(value+" is not in the Domian of your target variable");
			variable=null;
			value=null;
		}
	}
	
	
	public boolean is_Domain() { //check value is in the domain of variable
		boolean i=false;
		for(Object a:variable.Variable_Domain.Domain) {
			if(value.equals(a)) {
				i=true;
				break;
			}
		}
		return i;
	}
	
	public void test(HashMap<Variable,Object> a) { //check if this constrain validate
		if(a.get(variable)==null) {
			System.out.println("This variable has no value yet");
			return;
		}
		
		if(a.get(variable).equals(value)) {
			this.result=true;
		}else {
			this.result=false;
		}

	}
	
	public String toString() {
		return "This is a Unary Equal Constrain for "+variable.Variable_name+" and it's value should not be "+value;
	}
	
}
