package CSP;

import java.util.HashMap;

public class Binary_Constrain_Logic_XOR_Constrain extends Constrain{

	Constrain Constrain_1;
	Constrain Constrain_2;
	
	public Binary_Constrain_Logic_XOR_Constrain(Constrain Constrain_1,Constrain Constrain_2) {
		this.Constrain_1=Constrain_1;
		this.Constrain_2=Constrain_2;
	}
	
	public void test(HashMap<Variable,Object> a) {
		boolean result_1;
		boolean result_2;
		Constrain_1.test(a);
		result_1=Constrain_1.result;
		Constrain_2.test(a);
		result_2=Constrain_2.result;
		
		this.result=result_1||result_2;
	}
	
	public String toString() {
		return "This is a Binary XOR Logic Constrain which takes Constrain1: \n"+
				Constrain_1.toString()+"\n"+"And Constrain_2 : \n"+
				Constrain_2.toString()+"\nAnd takes XOR between them";
	}
}
