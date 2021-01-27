import java.util.ArrayList;
import java.util.List;

/*
 * The Time complexity of the code is exponential.
 * and by using backtracking we have reduced space complexity.
 */

public class Subsets {

	List<List<Integer>> result;

	public List<List<Integer>> subsets(int[] nums) {

		result = new ArrayList<>();

		if (nums.length == 0 || nums == null)
			return result;

		// helper(nums, new ArrayList<>(), 0);

		backtrack(nums, new ArrayList<>(), 0);

		return result;

	}

	private void backtrack(int[] nums, List<Integer> path, int index) {

		// base

		result.add(new ArrayList<>(path));

		for (int i = index; i < nums.length; i++) {

			path.add(nums[i]);

			backtrack(nums, path, i + 1);

			path.remove(path.size() - 1);

		}

	}

//	     private void helper(int[] nums, List<Integer> path, int index){

//	         //base

//	         if(index == nums.length){

//	             result.add(new ArrayList<>(path));

//	             return;
//	         }

//	         //logic

//	         //not choosing

//	          helper(nums, path, index+1);

//	         path.add(nums[index]);

//	         //choose
//	         helper(nums, path, index+1);

//	         //backtracking
//	         path.remove(path.size()-1);
//	     }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
