// Time Complexity : O(2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//78. Subsets
//https://leetcode.com/problems/subsets/



class Solution {
    //Iteration with recursion
    //time: O(2^n) where is is the no. of levels in the tree
    //space: O(n) where is is the no. of levels in the tree
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        
        if(nums.length == 0 || nums == null) return result;
        
        helper(nums, 0, new ArrayList<>());
        
        return result;
    }   
        
    private void helper(int[] nums, int i, List<Integer> list){
        //base
        
        //logic
        result.add(list);
        for(int k=i; k<nums.length; k++){
            //action
            list.add(nums[k]); 
            
            //recurse
            helper(nums, k+1, new ArrayList<>(list));
            
            //backtrack
            list.remove(list.size()-1);
        }
    }
}

/*
class Solution {
    //iteration:
    //time: O(2^n) where n is is the no. of levels in the tree
    //space: O(2^n) where n is is the no. of levels in the tree
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        result.add(list);
        
        for(int i=0; i<n; i++){
            
            int size = result.size(); System.out.println(size);
            for(int j=0; j<size; j++){
                List<Integer> temp = new ArrayList<>(result.get(j));
                temp.add(nums[i]);
                result.add(temp);
            } 
        }
        return result;
    }
}
*/


/*
class Solution {
    //Backtracking:
    //time: O(2^n) where is is the no. of levels in the tree
    //space: O(n) where is is the no. of levels in the tree
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if(nums.length == 0 || nums == null) return result;
        helper(nums, 0, new ArrayList<>());
        
        return result;
    }   
        
    private void helper(int[] nums, int i, List<Integer> list){
        //base
        if(i >= nums.length) {result.add(new ArrayList<>(list)); return;}
        
        //logic
        //choose
        list.add(nums[i]);
        helper(nums, i+1, list);
        list.remove(list.size()-1);
        
        //no choose
        helper(nums, i+1, list);
        
    }   
}
*/