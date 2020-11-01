import java.util.ArrayList;
import java.util.Collections;

public class B{
	public int countClumps(int[] nums) {
		  boolean inclump = false;
		  int clumpcnt = 0;
		  // note the start-from-1 loop
		  for (int i = 1; i < nums.length; i++) {
		      if (nums[i] == nums[i - 1]) {
		          // we are in a clump
		          if (!inclump) {
		              // this is the first time for this clump.
		              inclump = true;
		              clumpcnt++;
		          }
		      } else {
		          inclump = false;
		      }
		  }
		  return clumpcnt;
		}
	
	public int countDuplicate(int[] a){
		int count = 0;
		
		//Sort Array

		for (int i = 0; i < a.length; i++) {
			for (int j = 1; j < (a.length - i); j++) {
				if (a[j - 1] > a[j]) {
					int t = a[j - 1];
					a[j - 1] = a[j];
					a[j] = t;
				}
			}
		}
		
		for(int i = 0; i < a.length; i++){
			if(a[i] == a[i+1]){
				count++;
				continue;
			}
		}
	
		
		return count;
	}
	public static void main(String arg[]){
		B obj = new B();
		//Need sort
		
		int nums[] = {5,5,3, 2, 2, 3, 4, 4,6,6,8,8};
		
		//System.out.println(obj.countClumps(nums));
		System.out.println(obj.countDuplicate(nums));
	}
	
}