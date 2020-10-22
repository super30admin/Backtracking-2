// Time Complexity : O(n*2^n), we actually have n-1 ways to add a split in the string, 2^n-1 possibilities but runtime is 2^n, O(n) to copy string
// Space Complexity : O(n), this would be the max recursion depth, O(n*2^n) if we also account for output space

// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : this problem felt similar to Subsets problem

// Your code here along with comments explaining your approach
// we are choosing to split the string first after index =0, subtree defines all possibilities we enconter by splitting after index 0
// then to split after index=1 and so on
// we proceed to check if this would be a valid partition if and only if split until now is a palindrome
// else continue with next split
// add to result of we end up at index = string.length, return 


class Solution {
    String givenString;
    List<List<String>> result;
    
    public List<List<String>> partition(String s) {
        givenString = s;
        result = new ArrayList<List<String>>();
        List<String> curSplit = new ArrayList<String>();
        int index = 0;
        
        helper(index, curSplit);
        
        return result;
    }
    
    private void helper(int index, List<String> curSplit){
        if(index==givenString.length()){
            result.add(new ArrayList<String>(curSplit));
            //return;
        }
        
        for(int i=index; i<givenString.length(); i++){
            String split = givenString.substring(index, i+1);
            
            if(isPalindrome(index, i)){
                curSplit.add(split);
                helper(i+1, curSplit);
                curSplit.remove(curSplit.size()-1);
            }
            //else continue;
        }
    }
    
    private boolean isPalindrome(int low, int high){
        while(low<high){
            if(givenString.charAt(low) == givenString.charAt(high)){
                low++;
                high--;
            }
            else return false;
        }
        return true;
    }
}