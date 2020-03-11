// Time Complexity :O(2^N)
// Space Complexity :O(2^N)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

//
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result =new LinkedList<>();
        List<Integer> set=new LinkedList<>();
        backtrack(nums,result,set,0);
        return result;
    }
    private void backtrack(int[] nums,List<List<Integer>> result,List<Integer> set,int index){
      result.add(new LinkedList<>(set));
        for(int i=index;i<nums.length;i++){
          set.add(nums[i]); 
          backtrack(nums,result,set,i+1);
          set.remove(set.size()-1);
        }
    }
}