/*
 *Since the list is sorted, all we need to do is 
 *check the value at the previous index in the array. 
 *If the difference between a[n] and a[n-1] is greater than 1, then print the range.
 *I am fully aware that this code is not object-oriented - I simply want to demonstrate the algorithm.
 *
 */

public class EmptyRangeStringPrinter {

	public static void main(String args[]){
		
		printRanges();
		
	}
	
	static int[] arrayOfInts = {1,2,3,4,6,8,12,45,65,94};
	
	public static void printRanges(){
		
		for(int i = 1; i < arrayOfInts.length; i++){
			
			int lowerValue = arrayOfInts[i-1];
			int higherValue = arrayOfInts[i];
			
			if(higherValue - lowerValue > 1){
				System.out.printf("%d - %d", lowerValue, higherValue);
				System.out.println("");
			}
			
		}
	}
	
}