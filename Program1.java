/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 
 Tc : O(n * 2^n)
 Sc : O(n * 2^n)
 */
class Solution {
    
    List<List<Integer>> ret;
public List<List<Integer>> subsets(int[] nums) {
    ret = new ArrayList<>();
    helper(new ArrayList<Integer>(), 0, nums);
    return ret;
    
}
public void helper(List<Integer> curr, int i, int[]nums){
    if(i == nums.length){
        ret.add(new ArrayList<>(curr));
        return;
    }
    
    curr.add(nums[i]);
    helper(curr,i+1,nums);
    curr.remove(curr.size()-1);
    helper(curr,i+1,nums);
}
}



