// Time Complexity: O(2^n)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
/* Approach:
 * Use backtracking to generate all possible substrings starting from each index, checking if each substring is a palindrome.
 * For each valid palindrome substring found, recursively process the remaining string starting from the next index.
 * When we reach the end of string (pivot == length), we've found a valid partition so add it to results.
 */

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result= new ArrayList<>();
        helper(s,0,new ArrayList<>(),result);
        return result;
    }
    private void helper(String s,int pivot,List<String> path,List<List<String>> result){
        if(pivot==s.length()){
          result.add(new ArrayList<>(path));
          return;
        }
        for(int i=pivot;i<s.length();i++){
            if (isPalindrome(s,pivot,i)){
            path.add(s.substring(pivot,i+1));
            helper(s,i+1,path,result);
            path.remove(path.size()-1);
        }
    }
}
     private boolean isPalindrome(String s, int l, int r){
        if(l==r) return true;
        while(l < r){
            if(s.charAt(l) != s.charAt(r)) return false;
            l++; r--;
        }
        return true;
    }   
}