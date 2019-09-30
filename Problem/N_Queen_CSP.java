package proj;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

import CSP.*;

public class N_Queen_CSP extends CSP{

	int num;
	
	public N_Queen_CSP(int num) {
		this.num=num;
		for(int i=0;i<num;i++) {
			this.Variable_list.add(new Variable(String.valueOf(i),new Domain(String.valueOf(num))));
		}
		
		this.Constrains_list.add(new Not_Attack_Constraint(this,num));
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reader=new Scanner(System.in);
		System.out.println("N Queen Problem");
		System.out.println("How many queens do you want? ");
		int target=reader.nextInt();
		CSP csp = new N_Queen_CSP(target);
		System.out.println(csp);
		System.out.println("Backtracking search solver");
		Solver solver = new BackTrackingSearchSolver(csp);
		long start = new Date().getTime();
		HashMap<Variable,Object> result = solver.solve();
		long end = new Date().getTime();
		System.out.format("time: %.3f secs\n", (end-start)/1000.0);
		
		if(result!=null) {
			csp.Update_List_to_Var(result);
			for(Variable a:csp.Variable_list) {
				System.out.println(a.Variable_name+"\t"+a.Value);
			}
			
			printBoard(csp,target);
		}else {
			System.out.println("The problem can not be solved");
		}
		
	}

	
	public static void printBoard(CSP csp,int num) {
		System.out.println("\n\n\n");
		int[][] board=new int[num][num];
		for(Variable var:csp.Variable_list) {
			board[Integer.parseInt(var.Variable_name)][(Integer)var.Value]=1;
		}
		
		for(int[] i:board) {
			for(int b:i) {
				if(b==1) {
					System.out.print("0  ");
				}else {
					System.out.print("*  ");
				}
			}
			System.out.println("");
		}
	}
}
