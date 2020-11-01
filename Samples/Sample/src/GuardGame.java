
public class GuardGame {

	int answer(long x) {
		long res = x;
		if (x >= 0) {		

			String len = Long.toString(x);

			for (int i = len.length(); i >= 1; i--) {
				long r = -1;
				if(i == 1){
					r = (long) Math.pow(10, i);
				}
				else{
					r = (long) Math.pow(10, (i - 1));	
				}
				
				long mod = res % r;
				long div = res / r;
				res = mod + div;
			}
		}
		return (int) res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GuardGame game = new GuardGame();
		int ret = game.answer(123456);
		System.out.println(ret);
	}

}
