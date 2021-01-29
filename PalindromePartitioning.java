// Time Complexity : O(2^n)
// Space Complexity : O(n) , n = length of the word
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Understanding how recursion & backtracking with for loop works

// Notes : For each letter in the word, check if substrings of previous or next letters are palindromes and then add to the path, then backtrack to explore other possibilities of substrings that are palindromes

public class PalindromePartitioning {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> partition(String s) {
        if(s == null) return result;
        
        List<String> path = new ArrayList<>();
        
        helper(s, 0, path);
        return result;
    }
    
    private void helper(String s, int index, List<String> path){

        if(index == s.length()){
            result.add(new ArrayList<>(path));
            return;
        }
        
        for(int i = index; i < s.length(); i++){
            if( isPalindrome(s, index, i) ){
                path.add(s.substring(index, i+1));
                helper(s, i+1, path);
                path.remove(path.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String s, int start, int end){
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
