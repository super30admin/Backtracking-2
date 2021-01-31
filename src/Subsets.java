// Time Complexity : Exponential
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
import java.util.ArrayList;
import java.util.List;

public class Subsets {
	// normal recursion method
	List<List<Integer>> result1;
	public List<List<Integer>> subsetsNormalRecursion(int[] nums) {
		result1 = new ArrayList<>();
		if (nums == null || nums.length == 0)
			return result1;
		helperNormalRecursion(nums, 0, new ArrayList<>());
		return result1;
	}

	private void helperNormalRecursion(int[] nums, int index, List<Integer> path) {
		// base
		if (index == nums.length) {
			result1.add(path);
			return;
		}
		// logic
		// don't choose
		helperNormalRecursion(nums, index + 1, new ArrayList<>(path));
		// choose
		path.add(nums[index]);
		helperNormalRecursion(nums, index + 1, new ArrayList<>(path));
	}
	
	
	//normal backtracking method
	List<List<Integer>> result2;
    public List<List<Integer>> subsetsNormalBacktrack(int[] nums) {
        result2 = new ArrayList<>();
        if(nums == null || nums.length == 0) return result2;
        helperNormalBacktrack(nums, 0, new ArrayList<>());
        return result2;
    }
    
    private void helperNormalBacktrack(int[] nums, int index, List<Integer> path){
        //base
        if(index == nums.length){
            result2.add(new ArrayList<>(path));
            return;
        }
        //logic
        //don't choose
        helperNormalBacktrack(nums, index + 1, path);
        //choose
        path.add(nums[index]);
        helperNormalBacktrack(nums, index + 1, path);
        //backtrack
        path.remove(path.size() - 1);
    }
    
    
    //Backtracking with for loop
    List<List<Integer>> result3;
    public List<List<Integer>> subsetsBacktrackWithForLoop(int[] nums) {
        result3 = new ArrayList<>();
        if(nums == null || nums.length == 0) return result3;
        helperBacktrackWithForLoop(nums, 0, new ArrayList<>());
        return result3;
    }
    
    private void helperBacktrackWithForLoop(int[] nums, int index, List<Integer> path){
        //base
        //logic
        result3.add(new ArrayList<>(path));
        for(int i = index; i<nums.length;i++){
            path.add(nums[i]);
            //recurse
            helperBacktrackWithForLoop(nums, i + 1, path);
            //backtrack
            path.remove(path.size()-1);
        }
    }
    
    
    //Recursion with For loop
    List<List<Integer>> result;
    public List<List<Integer>> subsetsRecursionWithForLoop(int[] nums) {
        result = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;
        helperRecursionWithForLoop(nums, 0, new ArrayList<>());
        return result;
    }
    
    private void helperRecursionWithForLoop(int[] nums, int index, List<Integer> path){
        //base
        //logic
        result.add(path);
        for(int i = index; i<nums.length;i++){
            List<Integer> temp = new ArrayList<>(path);
            temp.add(nums[i]);
            //recurse
            helperRecursionWithForLoop(nums, i + 1, temp);
        }
    }
}
