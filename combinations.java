// Time Complexity : O(N!)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0){	// base case
            return result;
        }
        
        dfs(nums,0, result, new ArrayList<>());		// call the back tracking function recursively	
        result.add(new ArrayList<>());		// empty list is also a possibility
        
        return result;
    }
    
    private void dfs(int[] nums, int Startindex,List<List<Integer>> result, List<Integer> temp){
        // base case
        
        if(Startindex == nums.length){
            return;
        }
        
        // logic
        for(int i = Startindex; i < nums.length; i++){
            temp.add(nums[i]);		// firstly add the elements to the temp array and then to the result array
            result.add(new ArrayList(temp));
            dfs(nums, i + 1, result, temp);		//recursively call the function to back track and process all possibilities
            temp.remove(temp.size() - 1);		// remove the last element added to return to the previous level
        }
    }
}