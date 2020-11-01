
public class GuardGame2 {

	int answer(long x) {
		long res = 0;
		if (x >= 0) {		

			String len = Long.toString(x);
						
			for (int i = 1; i<= len.length(); i++) {
				int sum = Integer.parseInt(len, i);
				res = res + sum;
				}
		}
		return (int) res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GuardGame2 game = new GuardGame2();
		int ret = game.answer(123456);
		System.out.println(ret);
	}

}
