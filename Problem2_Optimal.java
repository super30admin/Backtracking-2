/**
LeetCode Submitted : YES
Time Complexity : O(2^String Length)
Space Compexity : O(N) //max temp array

The idea is to traverse all characters in the string such that if its a palindrome than only process otherwise continue to next available characters.
**/

class Solution {
    List<List<String>> results = new ArrayList<>();
    public List<List<String>> partition(String s) {
        if(s == null || s.length() < 1)
            return results;
        int index = 0;
        palindrome(s,index,new ArrayList());
        return results;
    }
    
    private void palindrome(String s , int index,List<String> temp){
        if(index >= s.length()){
            results.add(new ArrayList<>(temp));
            return;
        }
            
        
        for(int i = index;i<s.length();i++){
            if(checkPalindrome(s,index,i)){
                temp.add(s.substring(index,i+1));
                palindrome(s,i+1,temp);
                temp.remove(temp.size() - 1);
            }
        }
        
        
    }
    
    
    private boolean checkPalindrome(String s, int l , int r){
        if(s.length() < 2)
            return true;
        
        
        while(l < r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
                
        }
        return true;
    }
    
}
