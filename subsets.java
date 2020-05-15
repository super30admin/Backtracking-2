// Time Complexity : O(n * 2^n) 
// Space Complexity :   O(n * 2^n).
// Did this code successfully run on Leetcode :yes. 

// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//the code uses recursion plus backtrack. The code follows the pattern action, recursion and backtrack. 
//Success
//Details 
//Runtime: 1 ms, faster than 54.90% of Java online submissions for Subsets.
//Memory Usage: 39.8 MB, less than 5.74% of Java online submissions for Subsets.

]
    class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result= new ArrayList<>();
        backtrack(nums,result, 0,new ArrayList<>());
        return result;
    }
    
    private void backtrack(int[] nums,List<List<Integer>> result,int index,List<Integer> tmp){
        result.add(new ArrayList<>(tmp));
        
        for (int i=index;i<nums.length;i++){
            //action
            tmp.add(nums[i]);
            
            //recurse
            backtrack(nums,result,i+1,tmp);
            //backtrack
            tmp.remove(tmp.size()-1);
        }
    }
}