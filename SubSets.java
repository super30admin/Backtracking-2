class Solution {
    // Time Complexity : O(n*(2^n))  
// Space Complexity : O(n)  recursion stack  -->backtrack function
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


 // Your code here along with comments explaining your approach
 /*
 1. Add num at each call and recurse through next index
 2. Use the same list at every call by backtracking the list item
 */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null) return result;
        backtrack(nums,0,new ArrayList<Integer>(),result);
        return result;     
    }
    
    private void backtrack(int[] nums,int index, List<Integer> list, List<List<Integer>> result){       

        result.add(new ArrayList(list));
        for(int i =index; i<nums.length;i++){
            list.add(nums[i]);
            backtrack(nums,i+1,list,result);
            list.remove(list.size()-1);
        }
    }
}





class Solution {
    // Time Complexity : O(n*(2^n))  
// Space Complexity : O(2^n)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


 // Your code here along with comments explaining your approach
 /*
 1. Choose or don't choose the num at each call
 2. Create new list and copy existing list at each call.
 */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null) return result;
        helper(nums,0,new ArrayList<Integer>(),result);
        return result;     
    }
    
    private void helper(int[] nums,int index, List<Integer> list, List<List<Integer>> result){       

        if(index == nums.length){
            result.add(list);
            return;
        }
        
        helper(nums,index+1, new ArrayList(list), result);
        list.add(nums[index]);
        helper(nums, index+1, new ArrayList(list), result);
        
        
    }
}





class Solution {
        // Time Complexity : O(n*(2^n))  
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


 // Your code here along with comments explaining your approach
 /*
 1. Bit manipulation, idea is to take every set bit value possible for each number of length of nums as subsets.
 
 */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for(int i=0;i<(1 << nums.length);i++){
            List<Integer> each = new ArrayList<Integer>();
            for(int j=0;j<nums.length;j++){
                if(checkBit(i,j) == 1){
                    each.add(nums[j]);
                }
            }
            ans.add(each);
        }
        return ans;
    }
    
    public static int checkBit(int n, int k){
        return ((n>>k) & (1) );
    }
}