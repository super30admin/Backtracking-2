// Time Complexity : O(n*2^n) where n is the length of the string, 2^n - possible substrings
// Space Complexity : O(n) used for recursion stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> partition(String s) {
        backtrack(s,new ArrayList<String>(),0);
        return result;
    }
    public void backtrack(String s, List<String> temp,int start){
        if(start >= s.length()) result.add(new ArrayList<>(temp));
        for(int i=start;i<s.length();i++){
            if(isPalindrome(s,start,i)){
                temp.add(s.substring(start,i+1));
                backtrack(s,temp,i+1);
                temp.remove(temp.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s,int start,int end){
        while(start<end){
            if(s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
}
