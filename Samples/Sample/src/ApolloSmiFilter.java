import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ApolloSmiFilter {

	public static void main(String[] args) throws IOException {

		String homeDir = "C:\\RefFile\\toc";
		// Get all the Source Owner Details into Hashmap, Key is SMI & Value is
		// Source Owner team name.

		/*Map<String, String> sourceMap = new HashMap<String, String>();
		Map<String, String> sourceNameMap = new HashMap<String, String>();
		BufferedReader in = new BufferedReader(new FileReader(homeDir + "\\" + "sourceOwners"));
		String line1 = "";
		String parts[];
		while ((line1 = in.readLine()) != null) {
			parts = line1.split("\t");
			sourceMap.put(parts[0], parts[1]);
		}
		in.close();
*/
/*		line1 = "";
		// in = new BufferedReader(new FileReader(homeDir + "\\" +
		// "source_definitions"));
		in = new BufferedReader(new FileReader(homeDir + "\\" + "part1.txt"));
		// int i = 0;
		int spos = -1;
		int epos = -1;
		String smi = "";
		String smiName = "";
		while ((line1 = in.readLine()) != null) {

			if (line1 != null) {
				
				epos = line1.length();
				spos = line1.indexOf(".com");
				smiName = line1.substring(spos + 4, epos).trim();

			}
			// System.out.print("SPos :" + spos + "EPos :" + epos + " : ");

			// System.out.println("i = " + ++i);
			
			 * parts = line1.split("\t"); System.out.println(parts[9]);
			 
			
			 * for(int j = 0 ; j < parts.length;j++){
			 * System.out.println(parts[j] + " "); }
			 
		}*/

		FileWriter writer = new FileWriter(
				  "C:\\Users\\manisx\\Documents\\Retrieval\\Apollo Update\\ReliabilityIssue\\output.txt");
				  
		  BufferedWriter out = new BufferedWriter(writer); 
		  
		  ArrayList<String> list = new ArrayList<String>(); 
		  for (String line : Files.readAllLines(Paths.get(
		  "C:\\RefFile\\toc\\Apr26Errors.log"))) {
		  
		  int sourcePos = line.indexOf("source:"); 
		  int attachPos = line.indexOf("Attachment Id");
		  int attachTypeToIncludePos = line.indexOf("attachTypeToInclude:");
		  int typePos = line.indexOf("type:");
		  String attachID = "";
		  
		  
		  
		  if (sourcePos != -1 && attachPos != -1) {
			  	  list.add(line.substring(sourcePos + 7, attachPos).trim());
			  	  System.out.print(line.substring(sourcePos + 7, attachPos).trim());
			  	  
			  	  if(attachTypeToIncludePos != -1){
			  		  attachID = line.substring(attachPos + 7 ,attachTypeToIncludePos).trim();
			  	  }
			  	  else if(typePos != -1){			  		  
			  		attachID = line.substring(attachPos + 7 ,typePos).trim();			  		  
			  	  }
			  	  System.out.println(" " + attachID);
			  	  out.write(line.substring(sourcePos + 7, attachPos).trim() + " " + attachID + "\n");
		  }
		  
		  }
		    
		  out.close();
		 
		  stripDuplicatesFromFile("C:\\Users\\manisx\\Documents\\Retrieval\\Apollo Update\\ReliabilityIssue\\output.txt");
				  
		  Set<String> set = new HashSet<String>(list); 
		  HashMap<String, Integer>  m1 = new HashMap<String, Integer>(); 
		  
		  for (String temp : set) {
		  m1.put((String) temp, (int) Collections.frequency(list, temp)); 
		  }
		  
		  HashMap<String, Integer> m2 = sortHashMapByValues(m1);
		  
		  System.out.println("DEBUGGER....................");
		  for (String key : m2.keySet()) {
			    System.out.format("SMI[%10s] Error Count [%d]\n",key,m2.get(key));
			    //System.out.println("SMI[" + key + "] " + "Error Count [" + m2.get(key) + "]");
			}
		  
		  //TreeMap<String, Integer> sortedMap = sortMapByValue(m1);
		  
/*		  FileWriter writer = new FileWriter(
		  "C:\\Users\\manisx\\Documents\\Retrieval\\Apollo Update\\ReliabilityIssue\\output.txt");
		  
		  BufferedWriter out = new BufferedWriter(writer); 
		  String sourceOwner =  "Not Available";
		  
		  for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
			 System.out.println("Key = " + entry.getKey() + ", Value = " +  entry.getValue()); // this //
		  ///statement // prints // out // my // keys // and // values
		  if(sourceMap.containsKey(entry.getKey())) {
			  sourceOwner = sourceMap.get(entry.getKey());
		  }
		  
		  
		  if (entry.getKey().length() >= 10) {
			  out.write("SMI : " + entry.getKey() + "\t" + "Error Count :" + entry.getValue() + "\t\t" +
		  " Owner Team : " + sourceOwner + "\n"); 
			  } 
		  else { 
			  out.write("SMI : " + entry.getKey() + "\t\t" + "Error Count :" + entry.getValue() + "\t\t" + " Owner Team : " + sourceOwner + "\n");
		  }
				  	  
		  
		   System.out.println("Done"); out.flush(); // Flush the buffer and
		 // write all changes to the disk }
		  
		  out.close(); // Close the file
		  }*/
	}

	public static TreeMap<String, Integer> sortMapByValue(HashMap<String, Integer> map) {
		Comparator<String> comparator = new ValueComparator(map);
		// TreeMap is a map sorted by its keys.
		// The comparator is used to sort the TreeMap by keys.
		TreeMap<String, Integer> result = new TreeMap<String, Integer>(comparator);
		result.putAll(map);
		return result;
	}
	
	public static void stripDuplicatesFromFile(String filename) {
	    BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(filename));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    Set<String> lines = new HashSet<String>(10000); // maybe should be bigger
	    String line;
	    try {
			while ((line = reader.readLine()) != null) {
			    lines.add(line);
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    try {
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(filename));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    for (String unique : lines) {
	        try {
				writer.write(unique);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        try {
				writer.newLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    try {
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static LinkedHashMap<String, Integer> sortHashMapByValues(
	        HashMap<String, Integer> passedMap) {
	    List<String> mapKeys = new ArrayList<>(passedMap.keySet());
	    List<Integer> mapValues = new ArrayList<>(passedMap.values());
	    Collections.sort(mapValues);
	    Collections.sort(mapKeys);

	    LinkedHashMap<String, Integer> sortedMap =
	        new LinkedHashMap<>();

	    Iterator<Integer> valueIt = mapValues.iterator();
	    while (valueIt.hasNext()) {
	        Integer val = valueIt.next();
	        Iterator<String> keyIt = mapKeys.iterator();

	        while (keyIt.hasNext()) {
	            String key = keyIt.next();
	            Integer comp1 = passedMap.get(key);
	            Integer comp2 = val;

	            if (comp1.equals(comp2)) {
	                keyIt.remove();
	                sortedMap.put(key, val);
	                break;
	            }
	        }
	    }
	    return sortedMap;
	}
	
	public LinkedHashMap<Integer, String> sortHashMapByValues1(
	        HashMap<Integer, String> passedMap) {
	    List<Integer> mapKeys = new ArrayList<>(passedMap.keySet());
	    List<String> mapValues = new ArrayList<>(passedMap.values());
	    Collections.sort(mapValues);
	    Collections.sort(mapKeys);

	    LinkedHashMap<Integer, String> sortedMap =
	        new LinkedHashMap<>();

	    Iterator<String> valueIt = mapValues.iterator();
	    while (valueIt.hasNext()) {
	        String val = valueIt.next();
	        Iterator<Integer> keyIt = mapKeys.iterator();

	        while (keyIt.hasNext()) {
	            Integer key = keyIt.next();
	            String comp1 = passedMap.get(key);
	            String comp2 = val;

	            if (comp1.equals(comp2)) {
	                keyIt.remove();
	                sortedMap.put(key, val);
	                break;
	            }
	        }
	    }
	    return sortedMap;
	}
}


