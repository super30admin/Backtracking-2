
 // Time Complexity : 2 ^ n
// Space Complexity : 2 ^ n
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * Run a for loop with element as pivot and i iterating over it. 
 * For each element, traverse all the babies and add it into path. 
 * If its not in the subset, backtrack and remove the element from the path. 
 */


class Problem1 {  
    List<List<Integer>> result ;
   public List<List<Integer>> subsets(int[] nums) {
    result = new ArrayList<>();
    helper(nums, 0, new ArrayList<>());
    return result;
   }
   private void helper(int[] nums, int idx, List<Integer> path){
        result.add(new ArrayList<>(path));
        for(int i = idx; i < nums.length; i++){
            path.add(nums[i]);
            helper(nums, i+1, path);
            path.remove(path.size() - 1);
        }
   }
}