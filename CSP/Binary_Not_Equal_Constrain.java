package CSP;

import java.util.HashMap;

public class Binary_Not_Equal_Constrain extends Constrain{
	Variable variable_1;
	Variable variable_2;
	
	public Binary_Not_Equal_Constrain(Variable variable_1,Variable variable_2) {
		this.variable_1=variable_1;
		this.variable_2=variable_2;
	}
	
	public void test(HashMap<Variable,Object> a) {
		if(a.get(variable_1)==null) {
			//System.out.println(variable_1.Variable_name+" does not have value, test failed");
			this.result=true;
			return;
		}else if(a.get(variable_2)==null) {
			//System.out.println(variable_2.Variable_name+" does not have value, test failed");
			this.result=true;
			return;
		}
		
		if(a.get(variable_1).equals(a.get(variable_2))) {
			this.result=false;
		}else {
			this.result=true;
		}
	}
	
	public String toString() {
		return "This is Binary Not Equal Constrain which compares "+variable_1.Variable_name+"("+variable_1.Value+")"+" and "
	+variable_2.Variable_name+"("+variable_1.Value+")";
	}
}
