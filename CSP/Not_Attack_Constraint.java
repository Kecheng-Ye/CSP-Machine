package CSP;

import java.util.ArrayList;
import java.util.HashMap;

public class Not_Attack_Constraint extends Constrain{
	int[][] board;
	CSP csp;
	int num;
	
	public Not_Attack_Constraint(CSP csp,int num) {
		this.csp=csp;
		this.num=num;
		board=new int[num][num];
		for(int[] a:board) {
			for(int b:a) {
				b=0;
			}
		}
	}
	
	public void test(HashMap<Variable,Object> a) {
		for(Variable var: a.keySet()) {
			board[Integer.parseInt(var.Variable_name)][(Integer)a.get(var)]=1;
		}
		
		//print();
		
		if(is_Attack(a)) {
			this.result=false;
			board=new int[num][num];
			return;
		}
		
		this.result=true;
		
		board=new int[num][num];
	}
		
	
	public boolean is_Attack(HashMap<Variable,Object> a){
		for(Variable var: a.keySet()) {
			//System.out.println("checking "+var.Variable_name);
			for(int d=3;d<9;d++){
				if(detect(Integer.parseInt(var.Variable_name),(Integer)a.get(var),d)){
					//System.out.println("This is connected with i "+Integer.parseInt(var.Variable_name)+" j "+(Integer)a.get(var)+" d "+d);
					return true;
				}
			}
		}
		return false;
	}
	
	
	public boolean detect(int i, int j, int direction){
		ArrayList<Integer> list =new ArrayList<Integer>();
				
		list.add(board[i][j]);
		if(direction==3){
			for(int a=1;a<num;a++) {
				if(i-a<0){
					break;
				}else{
					list.add(board[i-a][j]);
				}
			}
		}else if(direction==4){
			for(int a=1;a<num;a++) {
				if(i+a>(board.length-1)){
					break;
				}else{
					list.add(board[i+a][j]);
				}
			}
		}else if(direction==5){
			for(int a=1;a<2*num;a++) {	
				if(j-a<0 ||  i-a<0 ){
					break;
				}else {
					list.add(board[i-a][j-a]);
				}
			}
		}else if(direction==6){
			for(int a=1;a<2*num;a++) {		
				if(i+a>(board.length-1) || j+a>(board[0].length-1) ){
					break;
				}else {
					list.add(board[i+a][j+a]);
				}
			}
		}else if(direction ==7){
			for(int a=1;a<2*num;a++) {
				if(i-a<0 || j+a>(board[0].length-1) ){
					break;
				}else{
					list.add(board[i-a][j+a]);
				}
			}
		}else if(direction==8){
			for(int a=1;a<2*num;a++) {
				if(i+a>(board.length-1) ||j-a<0 ){
					break;
				}else{
					list.add(board[i+a][j-a]);
				}
			}
		}
		
		int count=0;
		for(int a:list) {
			if(a==1) {
				count++;
			}
			
			if(count>=2) {
				//System.out.println("This is connected");
				return true;
			}
		}
		
		return false;
		
	}
	
	public void print() {
		for(int[] i:board) {
			for(int b:i) {
				System.out.print(b+"  ");
			}
			System.out.println("");
		}
	}
	
	public String toString() {
		String result="This is a N_Queen Not Attack Constrain for the whole CSP, And it's result is: "+this.result;
		return result;
	}
	
}
