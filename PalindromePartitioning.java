/**
 * [WIP]
 * Leetcode: No running
 */

class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        //backtracking function
        backtrack(s, 0, new ArrayList<>());
        return result;
    }
    
    private void backtrack(String s, int index, List<String> substrings){
        if(index >= s.length() && substrings.size() > 0){
            result.add(new ArrayList<>(substrings));
            return;
        } 
         
        for(int i = index; i < s.length(); i++){
            String substring = s.substring(index, i);
            if(isPalindrome(substring)) {
                if(index == i) substrings.add(Character.toString(s.charAt(i)));
                else substrings.add(s.substring(index, i + 1));
                backtrack(s, i + 1, substrings);
                substrings.remove(substrings.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String s){
        int right = s.length() - 1;
        int left = 0;
        
        while(left < right){
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        
        return true;
    }
}