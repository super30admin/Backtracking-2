// Approach 1 - 0/1 Recursion
// Time Complexity : O(2^n)
// Space Complexity : O(2^n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// We can use recursion and keep track of current Index and current path
// when we recurse either choose or don't choose element at curIdx
// If choosing, update curPath and curIdx, else just update curIdx
// Since curPath is a reference we need to use backtracking and delete the element once we have explored that path

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return result;
    }
    private void helper(int nums[], int curIdx, List<Integer> curPath){
        if(curIdx==nums.length)
        {
            result.add(new ArrayList<>(curPath));
            return;
        }
        helper(nums,curIdx+1,curPath);
        curPath.add(nums[curIdx]);
        helper(nums,curIdx+1,curPath);
        curPath.remove(curPath.size()-1);
    }
}

// Approach 2 - for loop recursion
// Time Complexity : O(2^n)
// Space Complexity : O(2^n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Similar to Approach 1 but here choose scenario is done by recursion
// Not choosing scenario is taken care by the for loop
// No base case since we are using for loop that loops till end of nums array

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return result;
    }
    private void helper(int nums[], int curIdx, List<Integer> curPath){
        result.add(new ArrayList<>(curPath));
        for(int i=curIdx; i<nums.length; i++){
            curPath.add(nums[i]);
            helper(nums,i+1,curPath);
            curPath.remove(curPath.size()-1);
        }
    }
}

// Approach 3 - nested iterations
// Time Complexity : O(n* 2^n)
// Space Complexity : O(2^n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// We can use nested iterations. Initalize result array with empty array
// Outer loop will go over the nums array
// Inner loop will create deep copy and add element at index i to each of the lists currently in the result array

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        result.add(new ArrayList<>());
        for(int i=0;i<nums.length;i++)
        {   int size = result.size();
            for(int j=0;j<size;j++){
                List<Integer> temp = new ArrayList<>(result.get(j));
                temp.add(nums[i]);
                result.add(temp);
            }
        }
        return result;
    }
}
