/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

Example:

Input: "aab"
Output:
[
  ["aa","b"],
  ["a","a","b"]
]

*/

// T: O(2 ^ n)

class Solution {
    
    List<List<String>> result = new ArrayList<>();
    List<String> temp = new ArrayList<String>();
    
    public List<List<String>> partition(String s) {
        
        if(s == null || s.length() == 0)    return result;
        
        backtrack(s, 0);
        
        return result;
    }
    
    public void backtrack(String s, int index){
        
        if(index >= s.length()){
            
            result.add(new ArrayList<String>(temp));
        }
        
        for(int i = index; i < s.length(); i++){
            
            if(isPalindrome(s, index, i)){
                
                temp.add(s.substring(index, i + 1));
                backtrack(s, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }
    
    public boolean isPalindrome(String s, int index, int i){
        
        if(index == i)  return true;
        
        while(index < i){
            
            if(s.charAt(index) != s.charAt(i))  return false;
            index++;
            i--;
        }
        
        return true;
    }
}