package CSP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class CSP {
	public ArrayList<Variable> Variable_list=new ArrayList<Variable>();
	public HashSet<Constrain> Constrains_list=new HashSet<Constrain>();

	
	public HashMap<Variable,Object> initialize_Assignment(){
		if(Variable_list.isEmpty()) {
			System.out.println("Assignment list can not be formed due to lack of raw Variable list");
			return new HashMap<Variable,Object>();
		}else {
			HashMap<Variable,Object> Assignment_list=new HashMap<Variable,Object>();
			for(Variable i:Variable_list) {
				Assignment_list.put(i, null);
			}
			return Assignment_list;
		}
	}
	
	
	public String toString() {
		String string="This is a CSP, with following variables \n";
		for(Variable a:Variable_list) {
			string+=a.toString();
			string+="\n";
		}
		string+="With following constraints: \n";
		for(Constrain a: Constrains_list) {
			string+=a.toString();
			string+="\n";
		}
//		string +="With following initial assignment: \n";
//		for(Variable a:Assignment_list.keySet()) {
//			string+=a.Variable_name+"\t"+Assignment_list.get(a);
//			string+="\n";
//		}
		return string;
	}
	
	public void Update_List_to_Var(HashMap<Variable,Object> Assignment_list) {
		for(Variable a:Assignment_list.keySet()) {
			for(Variable b:Variable_list) {
				if(b.equals(a)) {
					b.Value=Assignment_list.get(a);
				}
			}
		}
	}
	
	public void exp_Assign(Variable var, Object value) {
		Variable target=this.Variable_list.get(this.Variable_list.indexOf(var));
		target.Value=value;
	}
	

}