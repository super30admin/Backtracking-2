/*
 * TC: O(n*(2^n)) n: length of String s.
 * SC: O(n) n: length of s for recursive stack size.
 * 
 * Approach: Implementing using 0-1 recursion with backtracking. at each recursive call, i will have two choice either to choose the substring or not.
 * if i choose then i check for contraint i.e palindrome. if it is, then add that to the list as it might be the potential candidate.
 * and recursively call the remianing of the string.After the call remove the substring.
 * 
 */

class Solution {
     List<List<String>> result;
    public List<List<String>> partition(String s) {
        this.result = new ArrayList<>();

        helper(s, 0 ,0, new ArrayList<>());
        return result;
    }

    private void helper(String s,int pivot, int idx, List<String> li){
        if(idx == s.length()){
            if(pivot == s.length()) result.add(new ArrayList<>(li));
             return;
        }
        

        //no choose
        helper(s ,pivot, idx+1, li);

       
        //choose
        String subStr = s.substring(pivot,idx+1);
        
        if(isPalindrome(subStr)){
        li.add(subStr);
        helper(s, idx+1, idx + 1, li);

        //backtrack
        li.remove(li.size() - 1);
        }
        
    }

    private boolean isPalindrome(String s){
        int left = 0;
        int right = s.length()-1;

        while(left < right){
            if(s.charAt(left) != s.charAt(right)) return false;

            left++;
            right--;
        }
    return true;
    }
}