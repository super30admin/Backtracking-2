// Time Complexity : O(exponential) 
// Space Complexity : O(1) all lists and result is part of output
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * We use iterative approach in which, we add an empty list to result first
 * Then we iterate over all elements in nums array.
 * We create a new copy of all the existing lists in result for each element and we add current elemt to these newly created list
 * Then we add this new lists to result
*/



class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        //helper(nums, 0, new ArrayList<Integer>());
        
        //iterative apporach
        result.add(new ArrayList<>());
        
        for(int i = 0; i < nums.length;i++){
            int size = result.size();
            
            for(int j = 0; j < size;j++){
                ArrayList<Integer> newList = new ArrayList<>(result.get(j));
                newList.add(nums[i]);
                result.add(newList);
            }
        }
        return result;
    }
    
    private void helper(int[] nums, int index, ArrayList<Integer> path){
        //base
        
        //logic
        result.add(new ArrayList<>(path));
        for(int i = index; i < nums.length;i++){
            path.add(nums[i]);
            helper(nums, i+1, path);
            path.remove(path.size() - 1);
        }  
    }
}