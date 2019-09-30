package proj;
import java.util.Date;
import java.util.HashMap;

import CSP.*;

public class AustraliaCSP extends CSP{
	
	public AustraliaCSP() {
		Variable WA = new Variable("WA", new Domain("RGB")); 
		this.Variable_list.add(WA);
		Variable NT = new Variable("NT", new Domain("RGB"));
		this.Variable_list.add(NT);
		Variable Q = new Variable("Q", new Domain("RGB"));
		this.Variable_list.add(Q);
		Variable NSW = new Variable("NSW", new Domain("RGB"));
		this.Variable_list.add(NSW);
		Variable V = new Variable("V", new Domain("RGB"));
		this.Variable_list.add(V);
		Variable SA = new Variable("SA", new Domain("RGB"));
		this.Variable_list.add(SA);
		Variable T = new Variable("T", new Domain("RGB"));
		this.Variable_list.add(T);
		
		this.Constrains_list.add(new Binary_Not_Equal_Constrain(SA, WA));
		this.Constrains_list.add(new Binary_Not_Equal_Constrain(SA, NT));
		this.Constrains_list.add(new Binary_Not_Equal_Constrain(SA, Q));
		this.Constrains_list.add(new Binary_Not_Equal_Constrain(SA, NSW));
		this.Constrains_list.add(new Binary_Not_Equal_Constrain(SA, V));
		this.Constrains_list.add(new Binary_Not_Equal_Constrain(WA, NT));
		this.Constrains_list.add(new Binary_Not_Equal_Constrain(NT, Q));
		this.Constrains_list.add(new Binary_Not_Equal_Constrain(Q, NSW));
		this.Constrains_list.add(new Binary_Not_Equal_Constrain(NSW, V));
		
	

	}
	
	public static void main(String[] args) {
		System.out.println("Australia Map Coloring Problem (AIMA 6.1.1)");
		CSP csp = new AustraliaCSP();
		System.out.println(csp);
		System.out.println("Backtracking search solver");
		Solver solver = new BackTrackingSearchSolver(csp);
		long start = new Date().getTime();
		HashMap<Variable,Object> result = solver.solve();
		long end = new Date().getTime();
		System.out.format("time: %.3f secs\n", (end-start)/1000.0);
		
		for(Variable a:result.keySet()) {
			System.out.println(a.Variable_name+"\t"+result.get(a));
		}
	}
}
