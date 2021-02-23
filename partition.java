// Time Complexity : O(2*n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        helper(0, result, new ArrayList<String>(), s);
        return result;
    }

    public void helper(int start, List<List<String>> result, List<String> temp, String s) {
        
        if(start == s.length()) {
            result.add(new ArrayList(temp));
            return;
        }
        
        for(int i=start;i<s.length();i++) {
            
            if(isPalindrome(s, start,i)) {
                
                temp.add(s.substring(start,i+1));
                helper(i+1, result, temp, s);
                temp.remove(temp.size()-1);
            }
        }
        
    }
    

    boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--)) return false;
        }
        return true;
    }
}
