/*
 * We can change the below listed five changes in main() method
 * 1) Order of prototype can change
 * 2) we can declare main() method as final, synchronized and strictfp
 * 3) we can give String[] in any supported method like
 * String[] args
 * String args[]
 * String []args
 * 4)we can give String[] single dimention array as varargs like String...
 * 5)we can give any valid variable name for args.
 */

/*
 * 1.7 V changes in main() method
 */

public class OverloadMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Inside String[] Main method...");
		int[] a = { 1, 2, 3, 4, 5 };
		OverloadMain.main(a);
	}

	public static void main(int[] args) {
		// TODO Auto-generated method stub
		System.out.println("Inside int[] Main method...");
		for(int x : args){
			System.out.println(x);
		}
	}

}
