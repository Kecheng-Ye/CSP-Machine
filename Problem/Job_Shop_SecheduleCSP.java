package proj;
import java.util.Date;
import java.util.HashMap;

import CSP.*;

public class Job_Shop_SecheduleCSP extends CSP{
	
	public Job_Shop_SecheduleCSP() {
		Variable AxleF=new Variable("AxleF",new Domain("Schedule"));
		this.Variable_list.add(AxleF);
		Variable AxleB=new Variable("AxleB",new Domain("Schedule"));
		this.Variable_list.add(AxleB);
		Variable WheelRF=new Variable("WheelRF",new Domain("Schedule"));
		this.Variable_list.add(WheelRF);
		Variable WheelLF=new Variable("WheelLF",new Domain("Schedule"));
		this.Variable_list.add(WheelLF);
		Variable WheelRB=new Variable("WheelRB",new Domain("Schedule"));
		this.Variable_list.add(WheelRB);
		Variable WheelLB=new Variable("WheelLB",new Domain("Schedule"));
		this.Variable_list.add(WheelLB);
		Variable NutsRF=new Variable("NutsRF",new Domain("Schedule"));
		this.Variable_list.add(NutsRF);
		Variable NutsLF=new Variable("NutsLF",new Domain("Schedule"));
		this.Variable_list.add(NutsLF);
		Variable NutsRB=new Variable("NutsRB",new Domain("Schedule"));
		this.Variable_list.add(NutsRB);
		Variable NutsLB=new Variable("NutsLB",new Domain("Schedule"));
		this.Variable_list.add(NutsLB);
		Variable CapRF=new Variable("CapRF",new Domain("Schedule"));
		this.Variable_list.add(CapRF);
		Variable CapLF=new Variable("CapLF",new Domain("Schedule"));
		this.Variable_list.add(CapLF);
		Variable CapRB=new Variable("CapRB",new Domain("Schedule"));
		this.Variable_list.add(CapRB);
		Variable CapLB=new Variable("CapLB",new Domain("Schedule"));
		this.Variable_list.add(CapLB);
		Variable Inspect=new Variable("Inspect",new Domain("Schedule"));
		this.Variable_list.add(Inspect);
		
		
		this.Constrains_list.add(new Binary_Less_Or_Equal_Constrain(AxleF,WheelRF,10));
		this.Constrains_list.add(new Binary_Less_Or_Equal_Constrain(AxleF,Inspect,10));
		this.Constrains_list.add(new Binary_Less_Or_Equal_Constrain(AxleF,WheelLF,10));
		this.Constrains_list.add(new Binary_Less_Or_Equal_Constrain(AxleB,WheelRB,10));
		this.Constrains_list.add(new Binary_Less_Or_Equal_Constrain(AxleB,Inspect,10));
		this.Constrains_list.add(new Binary_Less_Or_Equal_Constrain(AxleB,WheelLB,10));
		this.Constrains_list.add(new Binary_Less_Or_Equal_Constrain(WheelRF,NutsRF,1));
		this.Constrains_list.add(new Binary_Less_Or_Equal_Constrain(WheelRF,Inspect,1));
		this.Constrains_list.add(new Binary_Less_Or_Equal_Constrain(NutsRF,CapRF,2));
		this.Constrains_list.add(new Binary_Less_Or_Equal_Constrain(CapRF,Inspect,1));
		this.Constrains_list.add(new Binary_Less_Or_Equal_Constrain(NutsRF,Inspect,2));
		this.Constrains_list.add(new Binary_Less_Or_Equal_Constrain(WheelLF,NutsLF,1));
		this.Constrains_list.add(new Binary_Less_Or_Equal_Constrain(WheelLF,Inspect,1));
		this.Constrains_list.add(new Binary_Less_Or_Equal_Constrain(NutsLF,CapLF,2));
		this.Constrains_list.add(new Binary_Less_Or_Equal_Constrain(CapLF,Inspect,1));
		this.Constrains_list.add(new Binary_Less_Or_Equal_Constrain(NutsLF,Inspect,2));
		this.Constrains_list.add(new Binary_Less_Or_Equal_Constrain(WheelRB,NutsRB,1));
		this.Constrains_list.add(new Binary_Less_Or_Equal_Constrain(WheelRB,Inspect,1));
		this.Constrains_list.add(new Binary_Less_Or_Equal_Constrain(NutsRB,CapRB,2));
		this.Constrains_list.add(new Binary_Less_Or_Equal_Constrain(CapRB,Inspect,1));
		this.Constrains_list.add(new Binary_Less_Or_Equal_Constrain(NutsRB,Inspect,2));
		this.Constrains_list.add(new Binary_Less_Or_Equal_Constrain(WheelLB,NutsLB,1));
		this.Constrains_list.add(new Binary_Less_Or_Equal_Constrain(WheelLB,Inspect,1));
		this.Constrains_list.add(new Binary_Less_Or_Equal_Constrain(NutsLB,CapLB,2));
		this.Constrains_list.add(new Binary_Less_Or_Equal_Constrain(CapLB,Inspect,1));
		this.Constrains_list.add(new Binary_Less_Or_Equal_Constrain(NutsLB,Inspect,2));
		this.Constrains_list.add(new Binary_Constrain_Logic_XOR_Constrain(new Binary_Less_Or_Equal_Constrain(AxleF,AxleB,10), new Binary_Less_Or_Equal_Constrain(AxleB,AxleF,10)));
		//this.Constrains_list.add(new Binary_Less_Or_Equal_Constrain(AxleF,AxleB,10));
		
		
	}
	
	

	public static void main(String[] args) {
		System.out.println("Job-shop scheduling Problem (AIMA 6.1.2)");
		CSP csp = new Job_Shop_SecheduleCSP();
		System.out.println(csp);
		System.out.println("Backtracking search solver");
		Solver solver = new BackTrackingSearchSolver(csp);
		long start = new Date().getTime();
		HashMap<Variable,Object> result = solver.solve();
		long end = new Date().getTime();
		System.out.format("time: %.3f secs\n", (end-start)/1000.0);
		//System.out.println(csp);
		
		csp.Update_List_to_Var(result);
		for(Variable a:csp.Variable_list) {
			System.out.println(a.Variable_name+"\t"+a.Value);
		}
	}
}
