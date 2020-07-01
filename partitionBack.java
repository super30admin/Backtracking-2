// Time Complexity :O(n2^n) n is the length of the nums array
// Space Complexity :O(n) n is the length of the nums array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :I'm confused with the time and space complexity


// Your code here along with comments explaining your approach

class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        if(s == null || s.length() == 0) return result;
        backtrack(s,new ArrayList<>(),0);
        return result;
    }
    
    private void backtrack(String s,List<String> temp, int i){
        //base case
        if(i==s.length()){
            result.add(new ArrayList<>(temp));
            return;
        }
        
        //logic
        for(int k = i;k<s.length();k++){
            if(isPalindrome(s,i, k)){
            //action
            temp.add(s.substring(i,k+1));
            
            // recurse
            backtrack(s,temp,k+1);
            
            //backtrack
            temp.remove(temp.size()-1);
            }
        }
    }
    
    private boolean isPalindrome(String s, int start,int end){
        if(start == end) return true;
        while(start < end){
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}