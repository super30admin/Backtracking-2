// Problem2
// Palindrome Partitioning(https://leetcode.com/problems/palindrome-partitioning/)

// Backtrack
// Time - O(n 2 ^ n) 
// Space - O(n)
class Solution {
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<List<String>>();
        backtrack(s, 0, new ArrayList<>());
        return res;
    }
    
    private void backtrack(String s, int index, List<String> temp){
        
        // base
        if(index == s.length()){
            res.add(new ArrayList<>(temp));
            return;
        }
        //logic
        for(int i = index; i < s.length(); i++){
            
            if(isPalindrome(s, index, i)){
                
                temp.add(s.substring(index, i + 1));
                backtrack(s, i + 1, temp);
                temp.remove(temp.size() - 1);
            }
            
        }
        
    }
    
    private boolean isPalindrome(String s, int l, int r){
        if(l==r) return true;
        while(l < r){
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        
        return true;
    }
}