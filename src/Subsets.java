import java.util.*;
/********************************************Using Recursion*******************************************/
//Time Complexity :
//Space Complexity :
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

public class Subsets {
	List<List<Integer>> result;
	public List<List<Integer>> subsets(int[] nums) {
		result = new ArrayList<>();
		//base case
		if(nums == null || nums.length == 0)
			return result;

		helper(nums, new ArrayList<>(), 0); //calling helper on nums array with a temp list and starting index 0
		return result;
	}
	private void helper(int[] nums, List<Integer> temp, int index){
		//base case
		if(index == nums.length){
			result.add(temp);
			return;
		}
		/*************logic: Don't Choose first****************/
		//logic
		//don't choose
		helper(nums, new ArrayList<>(temp), index+1);

		//choose
		temp.add(nums[index]);
		helper(nums, new ArrayList<>(temp), index+1); 
		/*************logic: Choose first****************/
		//logic
		//choose first
		List<Integer> newList = new ArrayList<>(temp);	//create a newlist and store the temp upto now in it (to avoid passing the modified temp in the not choose part)
		newList.add(nums[index]);	//add the chosen element to newlist
		helper(nums, new ArrayList<>(newList), index+1);    //pass newlist as temp

		//don't choose
		helper(nums, new ArrayList<>(temp), index+1);	//pass original temp here
	}
}

/********************************************Using Backtracking*******************************************/
//Time Complexity :
//Space Complexity : 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

class Subsets_backtrack {
	static List<List<Integer>> result;
	public static List<List<Integer>> subsets(int[] nums) {
		result = new ArrayList<>();
		//base case
		if(nums == null || nums.length == 0)
			return result;

		backtrack(nums, new ArrayList<>(), 0);
		return result;
	}
	private static void backtrack(int[] nums, List<Integer> temp, int index){
		//base case


		//logic
		result.add(new ArrayList<>(temp));
		for(int i = index; i < nums.length; i++){
			//action
			temp.add(nums[i]);
			//recurse
			backtrack(nums, temp, i+1);
			//backtrack
			temp.remove(temp.size()-1);
		}
	}

	public static void main(String[] args) {
		int[] nums  = {1,2,3};
		System.out.println(subsets(nums));
	}
}