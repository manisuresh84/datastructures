
public class TestJava {
	
	public TestJava() throws java.lang.Exception{
		System.out.println("\nIn Constructor");
		throw new Exception();
	}
	
	public static void main(String[] args) throws java.lang.Exception {
		// TODO Auto-generated method stub
		int i = 0;
		System.out.println("i [" + i + "]");
		TestJava t = new TestJava();
	}

}