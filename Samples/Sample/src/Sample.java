import java.util.Scanner;
import java.util.StringTokenizer;

public class Sample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringTokenizer st = new StringTokenizer("this is a test");
		 while (st.hasMoreTokens()) {
		     System.out.println(st.nextToken());
		 }
		 
		 String input = "1	fish	2	fish	red	fish	blue	fish";

		 Scanner s = new Scanner(input).useDelimiter("\\t");

		 s.close(); 
	}

}
