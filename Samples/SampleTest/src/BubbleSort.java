
public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 5, 4, 3, 2, 1 };

		for (int i = 0; i < a.length; i++) {
			for (int j = 1; j < (a.length - i); j++) {
				if (a[j - 1] > a[j]) {
					int t = a[j - 1];
					a[j - 1] = a[j];
					a[j] = t;
				}
			}
		}

		for (int i : a) {
			System.out.println(i);
		}
	}
}
