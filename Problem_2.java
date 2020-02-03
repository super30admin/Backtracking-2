/*
 * Time Complexity : O(n*2^n)
 * Space complexity : O(n) --> if we consider stack space
 * Did it run successfully on leetcode : Yes
 * 
 */

class Solution {
    
    List<List<String>> result = new ArrayList<>();
    
    public List<List<String>> partition(String s) {
        
        if(s == null || s.length() == 0)
            return result;
        
        backtrack(s, 0, new ArrayList<String>());
        return result;
    }
    
    private void backtrack(String s, int index, List<String> list){
        
        //Base Case
        if(index == s.length()){
            result.add(new ArrayList<>(list));
            return;
        }
        
        for(int i=index; i<s.length(); i++){
            if(isPalindrome(s, index, i)){
                list.add(s.substring(index, i+1));
                
                backtrack(s, i+1, list);
                
                list.remove(list.size()-1);
            }
        }
    }
    
    
    private boolean isPalindrome(String str, int l, int r){
        
        while(l < r){
            if(str.charAt(l) != str.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        
        return true;
    }
}