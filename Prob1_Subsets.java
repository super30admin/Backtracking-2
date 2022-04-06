// Time Complexity : O(2 ^ n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach



class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0)    return result;
        
        result.add(new ArrayList<>());
        
        for(int i = 0; i< nums.length; i++){
            int len = result.size();
            for(int j = 0; j< len; j++){ //Everytime we are fetching the list from result and adding the current node in that list. Then add that new it into the resultList .
                List<Integer> path = new ArrayList<>( result.get(j) );
                path.add(nums[i]);
                
                result.add(path);
            }
        }
        return result;
    }   
}

// Time Complexity : O(2 ^ n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
//For loop recursion
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        
        if(nums == null || nums.length == 0)    return result;
        
        helper(nums, 0, new ArrayList<>());
        
        return result;
    }
    public void helper(int[] nums, int pivot, List<Integer> path){
        result.add(path);
        
        //Without Backtracking
        for(int i = pivot; i < nums.length; i++){
            List<Integer> temp = new ArrayList<>(path);
            temp.add(nums[i]);
            
            helper(nums, i + 1, temp);
        }
    }
    
    //Using BackTracking
    /*
     public void helper(int[] nums, int pivot, List<Integer> path){
        //result.add(path);
        result.add(new ArrayList<>(path));
        for(int i = pivot; i < nums.length; i++){
           // List<Integer> temp = new ArrayList<>(path);
            path.add(nums[i]);
            
            helper(nums, i + 1, path);
            path.remove(path.size() - 1);
        }
    }
    
    */
//}
//*/



// Time Complexity : O(2 ^ n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/*
//0-1 Recursion
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        
        if(nums == null || nums.length == 0)    return result;
        
        helper(nums, 0, new ArrayList<>());
        
        return result;
    }
    
    public void helper(int[] nums, int pivot, List<Integer> path){
        if(pivot == nums.length){
            //result.add(path);
            
            result.add(new ArrayList<>(path));
            return;
        }
        
        //Don't choose
        helper(nums, pivot + 1, path);
        
        //Choose 
        //Without Backtracking
        // List<Integer> temp = new ArrayList<>(path);
        // temp.add(nums[pivot]);
        // helper(nums, pivot + 1, temp);
        
        //With Backtracking        
        path.add(nums[pivot]);
        helper(nums, pivot + 1, path);
        path.remove(path.size() - 1);
        
    }
}

*/