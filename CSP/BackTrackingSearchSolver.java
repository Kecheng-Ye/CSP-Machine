package CSP;

import java.util.HashMap;

public class BackTrackingSearchSolver extends Solver{
	CSP csp;
	
	public BackTrackingSearchSolver(CSP csp) {
		this.csp=csp;
	}
	
	
	public HashMap<Variable,Object> solve(){
		HashMap<Variable,Object> answer=new HashMap<Variable,Object>();
		return backtrack(answer,csp);
	}
	
	
	
	public HashMap<Variable,Object> backtrack(HashMap<Variable,Object> answer,CSP csp){
		if(Is_Complete(answer)) {
			return answer;
		}
		
		Variable new_selected=SelectUnassignedVar(answer);
		for(Object potential_value : new_selected.Variable_Domain.Domain) {
			answer.put(new_selected, potential_value);
			if(Is_Consistant(csp,answer)) {
				HashMap<Variable,Object> result=backtrack(answer,csp);
				if(result!=null){
					return result;
				}else {
					answer.remove(new_selected);
				}
			}
			answer.remove(new_selected);
		}
		return null;
	}
	
	
	
	
	public boolean Is_Complete(HashMap<Variable,Object> answer) {
		for(Variable a: csp.Variable_list) {
			if(answer.get(a)==null) {
				return false;
			}
		}
		return true;
	}
	
	public Variable SelectUnassignedVar(HashMap<Variable,Object> answer) {
		for(Variable a: csp.Variable_list) {
			if((answer.get(a)==null)) {
				return a;
			}
		}
		return null;
	}
	
	public void print(HashMap<Variable,Object> answer) {
		for(Variable a:answer.keySet()) {
			System.out.println(a.Variable_name+"\t"+answer.get(a));
		}
	}
	
	public boolean Is_Consistant(CSP csp, HashMap<Variable,Object> answer) {
		boolean result=true;
		for(Constrain a: csp.Constrains_list) {
			a.test(answer);
			if(a.result==false) {
				//System.out.println(a);
				result=false;
				break;
			}
		}
		return result;
	}
}
