    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/subsets/
    Time Complexity for operators : o(n^n) .. n is the length of the integer array
    Extra Space Complexity for operators : o(n) for (List<String> path) without recursive stack
    Did this code successfully run on Leetcode : NA
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : 
        # Optimized approach: 
                              
            # 1. Backtracking
                    A) Call the backtracking function from main fucntion with initial values.
                    B) The backtracking function will contains input as string nums, path, index.
                    C) Base case, directly add it to the list.
                    F) In the main backtracking for loop, first add element to the list
                    E) then do backtracking, call abcktracking function by passi for index as we need repeated elements.
                    F) At the end, remove last element from the List.
                    G) in main function, return final output.
    */  

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        backtracking(new ArrayList<>(), nums,0);
        
        return answer;
    }
    
    List<List<Integer>> answer = new ArrayList<>();
    
    private void backtracking(List<Integer> path, int[] nums, int index){
            
        answer.add(new ArrayList<>(path));
        
        for(int i=index;i<nums.length;i++){
            // add
            path.add(nums[i]);
            
            // backtrack
            backtracking(path,nums,i+1);
            
            // remove
            path.remove(path.size()-1);
        }
    }
}