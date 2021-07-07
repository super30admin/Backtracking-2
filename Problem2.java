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
        palindrome(s,index,new ArrayList(), new StringBuilder());
        return results;
    }
    
    private void palindrome(String s , int index,List<String> temp, StringBuilder sb){
        if(index >= s.length()){
            results.add(new ArrayList<>(temp));
            return;
        }
            
        
        for(int i = index;i<s.length();i++){
            sb.append(s.charAt(i));
            if(checkPalindrome(sb.toString())){
                temp.add(sb.toString());
                palindrome(s,i+1,temp,new StringBuilder());
                sb = new StringBuilder(temp.remove(temp.size() - 1));
            }
        }
        
        
    }
    
    
    private boolean checkPalindrome(String s){
        if(s.length() < 2)
            return true;
        
        int start  = 0;
        int last   = s.length() - 1;
        
        while(start < last){
            if(s.charAt(start) != s.charAt(last)){
                return false;
            }
            start++;
            last--;
                
        }
        return true;
    }
    
}
