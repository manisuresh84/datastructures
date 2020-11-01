import java.io.File;
import java.io.IOException;
import java.util.Map;

public class ProcessBuilderDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		 ProcessBuilder pb = new ProcessBuilder("sample.sh", "myArg1", "myArg2");
		 ProcessBuilder pb = new ProcessBuilder("C:\\Users\\manisx\\Documents\\Technical\\Java\\Examples\\Samples\\Sample\\src\\sample.sh");
		 /*Map<String, String> env = pb.environment();
		 env.put("VAR1", "myValue");
		 env.remove("OTHERVAR");
		 env.put("VAR2", env.get("VAR1") + "suffix");
		 pb.directory(new File("myDir"));*/
		 try {
			Process p = pb.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
