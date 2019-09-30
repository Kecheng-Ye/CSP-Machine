package CSP;

import CSP.Domain.Color_Domain;

public class Variable {
	public String Variable_name;
	public Domain Variable_Domain;
	public Object Value;
	
	public Variable(String Variable_name, Domain Varaiale_Domain) {
		this.Variable_name=Variable_name;
		this.Variable_Domain=Varaiale_Domain;
		Value=null;
	}
	
	public boolean Assign_Value(Object Value) {
		boolean result=false;
		for(Object i:Variable_Domain.Domain) {
			if(Value.equals(i)) {
				result=true;
				break;
			}
		}
		
		if(!result) {
			return result;
		}
		
		this.Value=Value;
		return result;
		
	}
	
//	public void Assign_each() {
//		for(Object i:Variable_Domain.Domain) {
//			if(Assign_Value(i)) {
//				System.out.println(this.toString());
//			}
//		}
//	}
	
	
	public String toString() {
		return "This is a Variable Tuple  \n"
				+ "Name : "+Variable_name+"  "+Variable_Domain.toString()+" The value is: "+Value;
	}
}