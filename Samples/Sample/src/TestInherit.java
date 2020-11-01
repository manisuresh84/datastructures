class A {
	public void displayA() {
		System.out.println("Class A Display A....");
	}
}

class B extends A {
	
}

public class TestInherit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A obj = new B();
		obj.displayA();		
	}

}
