// TC: O(N * pow(2,n) since we are generating every combination for every number
// SC : O(N * pow(2, N) because of recursion stack which will go for every combination of the numbers in array

// To obtain the subsets, we are trying to add every number in the resulting list for every combination of the array. Once we keep on adding our numbers into the temporary result, we add our every list formed with every combination onto result list
// We move ahead in the array with index i and add to our result once we have completed the recursion for length of the array, we trackback for every combination and check for all possible solutions.

import java.util.ArrayList;
import java.util.List;

public class subSets {

	public List<List<Integer>> subSet(int[] nums){
		
		List<List<Integer>> res = new ArrayList<>();
		if(nums == null || nums.length == 0)
			return res;
		subset(nums, 0, res, new ArrayList<>());
		return res;
	}
	
	public void subset(int[] nums, int st, List<List<Integer>> res, List<Integer> temp) {
		
		
		if( st <= nums.length)
			res.add(new ArrayList<>(temp));
		
		for(int i=st;i<nums.length;i++) {	

			temp.add(nums[i]);
			subset(nums, i+1, res, temp);
			temp.remove(temp.size()-1);
			
		}
	}
	
	public static void main(String[] args) {
		
		subSets ss = new subSets();
		int[] nums = { 11, 21, 31};
		System.out.println(ss.subSet(nums));
	}
}
