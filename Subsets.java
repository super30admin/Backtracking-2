import java.util.LinkedList;
import java.util.Queue;

// Time Complexity : O(2 power n) where n = number of elements in array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
//78. Subsets (Medium) - https://leetcode.com/problems/subsets/
class Solution {
    
    //List<List<Integer>> result;
    
    public List<List<Integer>> subsets(int[] nums) {
    	// recursive approach
//        result = new ArrayList<>();
//        helper(nums, 0, new ArrayList<>());
//        return result;
//    }
//    
//    private void helper(int[] nums, int pivot, List<Integer> path) {
//        // base
//        // logic
//        result.add(new ArrayList<>(path));
//        for (int i = pivot; i < nums.length; i++) {
//            // action
//            path.add(nums[i]);
//            
//            // recurse
//            helper(nums, i+1, path);
//            
//            // backtrack
//            path.remove(path.size()-1);
//        }
    	
    	// iterative approach
    	List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        
        for (int i = 0; i < nums.length; i++) {
            int size = result.size();
            
            for (int j = 0; j < size; j++) {
                List<Integer> temp = new ArrayList<>(result.get(j));
                temp.add(nums[i]);
                result.add(temp);
            }
        }
        
        return result;
    }
}