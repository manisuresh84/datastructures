import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.NavigableMap;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class EmpCaseStudy {
	NavigableMap<Integer, String> empMap;

	public NavigableMap<Integer, String> getEmpMap() {
		return empMap;
	}

	EmpCaseStudy() {
		BufferedReader br = null;

		try {

			String sCurrentLine;

			br = new BufferedReader(new FileReader("emp.txt"));
			empMap = new TreeMap<Integer, String>();

			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
				String[] line = sCurrentLine.split("\\s");
				if (line.length > 1) {
					empMap.put(Integer.parseInt(line[1]), line[0]);
				}
			}
			System.out.println("Size of Map : " + empMap.size());

			SortedSet<Integer> keys = new TreeSet<Integer>(empMap.keySet());
			for (Integer key : keys) {
				System.out.println("Key : " + key.toString() + "Value : " + empMap.get(key).toString());
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}

	String search(NavigableMap<Integer, String> empMap, Integer eno) {
		return empMap.get(eno);
	}

	SortedMap<Integer, String> search(NavigableMap<Integer, String> empMap, Integer start, Integer end) {
		return empMap.subMap(start, end);
	}

	public static void main(String[] args) {
		EmpCaseStudy emp = new EmpCaseStudy();
		System.out.println("Search Ename : " + emp.search(emp.getEmpMap(), 10));
		SortedMap<Integer, String> entry = emp.search(emp.getEmpMap(), 0, 11);

		System.out.println("Range of Employees");
		FileOutputStream fop = null;
		File file;

		try {

			file = new File("output.txt");
			fop = new FileOutputStream(file);

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			SortedSet<Integer> keys = new TreeSet<Integer>(entry.keySet());
			for (Integer key : keys) {
				System.out.println("Key : " + key.toString() + "Value : " + entry.get(key).toString());
				// get the content in bytes
				byte[] contentInBytes = entry.get(key).getBytes();

				fop.write(contentInBytes);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fop.flush();
				fop.close();

				if (fop != null) {
					fop.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}