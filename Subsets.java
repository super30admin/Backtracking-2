import java.util.ArrayList;
import java.util.List;
/**
 * Time: O(2^n)
 * Space: O(n)
 * Leetcode accepted: yes
 * Problems faced: NA
 */
public class Subsets {
	public static List<List<Integer>> result = new ArrayList<>();
	
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		System.out.println(findSubsets(nums));
	}
	
	 public static List<List<Integer>> findSubsets(int[] nums) { 
		backtracking(nums, new ArrayList<Integer>(), 0);
		return result;
	 }

	private static void backtracking(int[] nums, ArrayList<Integer> temp, int index) {
		//Add empty list or whatever temp is available
		result.add(new ArrayList<Integer>(temp));
		for(int i=index; i<nums.length; i++) {
			temp.add(nums[i]);
			backtracking(nums, temp, i+1);
			temp.remove(temp.size()-1);
		}
	}

}
