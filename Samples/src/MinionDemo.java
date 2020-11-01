
public class MinionDemo {
	int answers(int x){
		int ret = 0;
		
		if(x !=0){
			ret = (int) (Math.pow(7, x) + answers(x - 1));
		}
		else if (x == 0){
			ret = 1;
		}
		else{
			System.out.println("Invalid Input...");
		}	
		return ret;		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MinionDemo obj = new MinionDemo();

		for (int i = 0; i <= 10; i++) {
			System.out.println("Total Employee's [" + i + "] = " + obj.answers(i));	
		}		
	}
}
