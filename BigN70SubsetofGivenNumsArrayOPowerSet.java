import java.util.ArrayList;
import java.util.List;
// Time complexity is O(2^n) as we are two choices
// space complexity is O(n) i.e the number of element (Recursive stack space)
// This solution is submitted on leetcode

public class BigN70SubsetofGivenNumsArrayOPowerSet {
	
	    List<List<Integer>> result = new ArrayList<>();
	    public List<List<Integer>> subsets(int[] nums) {
	    	//Edge case
	        if(nums == null || nums.length==0)
	            return result;
	        backtrack(nums, new ArrayList<Integer>(), 0);
	        return result;
	    }
	    private void backtrack(int[] nums, List<Integer>temp,int index){
	        // base case
	        if(index> nums.length){
	            return;
	        }
	        // logic
	        result.add(new ArrayList<>(temp));
	        for (int i = index;i<nums.length;i++){
	            temp.add(nums[i]);
	            backtrack(nums,temp,i+1);
	            temp.remove(temp.size()-1);
	        }
	    }
	}