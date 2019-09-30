package CSP;

public class Domain {
	Object Domain[];
	
	public static enum Color_Domain{
		RED,BLUE,GREEN;
	}
	
	Integer[] Time_Domain=new Integer[27];
	
	Integer[] Eight_Queen;
	
	public Domain(String type) {
		if(type.equals("RGB")) {
			Domain=Color_Domain.values();
		}else if(type.equals("Schedule")){
			for(int i=0;i<27;i++) {
				Time_Domain[i]=i+1;
			}
			Domain=Time_Domain;
		}else {
			int num=Integer.parseInt(type);
			Eight_Queen=new Integer[num];
			for(int i=0;i<num;i++) {
				Eight_Queen[i]=i;
			}
			Domain=Eight_Queen;
		}
	}
	
	public String toString() {
		String result="This is the Domian for this variable: ";
		result+="[ ";
		for(Object i:Domain) {
			result+=i+", ";
		}
		result+="] ";
		return result;		
	}
	
	
}