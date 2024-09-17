// Time Complexity : O(2^N)
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
    public List<List<String>> partition(String s) {
        List<List<String>> result = new LinkedList<>();
        List<String> set = new LinkedList<>();
        backtrack(result,set,s,0);
        return result;
    }
    private void backtrack(List<List<String>> result, List<String> set,String s, int index){
        if(index==s.length()){
        result.add(new LinkedList<>(set));
            return;
        }
        
        for(int i=index;i<s.length();i++){
            if(isPalindrome(s,index,i)){
                set.add(s.substring(index,i+1));
                 backtrack(result,set,s,i+1);
                set.remove(set.size()-1);
            }
            
        }
        
    }
    private boolean isPalindrome(String s, int low, int high){
        while(low <= high){
        if(s.charAt(low) != s.charAt(high)){return false;}
            low++;
            high--;
        }
          return true; 
    }
}