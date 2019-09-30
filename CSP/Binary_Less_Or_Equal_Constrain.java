package CSP;

import java.util.HashMap;

public class Binary_Less_Or_Equal_Constrain extends Constrain{
	Variable variable_1;
	Variable variable_2;
	Integer interval;
	
	public Binary_Less_Or_Equal_Constrain(Variable variable_1,Variable variable_2,Integer interval) {
		this.variable_1=variable_1;
		this.variable_2=variable_2;
		this.interval=interval;
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
		
		if(((Integer)a.get(variable_2)-(Integer)a.get(variable_1))>=interval) {
			this.result=true;
			return;
		}else {
			this.result=false;
			return;
		}
	}
	
	public String toString() {
		return "This is a Binary ineqaution constraint which should statisfy "+variable_1.Variable_name+"("+variable_1.Value+")"+" + "+interval+" <= "
				+variable_2.Variable_name+"("+variable_2.Value+")";
	}
}
