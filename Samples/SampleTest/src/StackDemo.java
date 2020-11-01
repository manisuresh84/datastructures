import java.util.Stack;

public class StackDemo {
	public static boolean balancedParenthensies(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '[' || c == '(' || c == '{') {
				stack.push(c);
			} else if (c == ']') {
				if (stack.isEmpty() || stack.pop() != '[') {
					return false;
				}
			} else if (c == ')') {
				if (stack.isEmpty() || stack.pop() != '(') {
					return false;
				}
			} else if (c == '}') {
				if (stack.isEmpty() || stack.pop() != '{') {
					return false;
				}
			}

		}

		return stack.isEmpty();
	}

	String[] braces(String[] values) {
		String [] out = new String[values.length];
		int i = 0;
		for (String element : values) {
			boolean b = balancedParenthensies(element);
			if (b == true) {
				out[i] = "YES";
			} else {
				out[i] = "NO";
			}
			i++;
		}
		
		return out;
	}

	public static void main(String[] args) {
		StackDemo st = new StackDemo();
		String[] a = new String[3];
		String[] b = new String[3];
		a[0] = "{{}}";
		a[1] = "{[}]";
		a[2] = "()[]{}";
 		b = st.braces(a);
 		for (String out : b) {
			System.out.println(out);
		}
	}

}
