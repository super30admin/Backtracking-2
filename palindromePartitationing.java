// Time Complexity : O(2^N) 
// Space Complexity : O(N) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
1. Divided the problem into subproblems and if the value is a palindrome add to final arraylist
*/


// Your code here along with comments explaining your approach

class Solution {

    List<List<String>> result = new ArrayList<>();
    public List<List<String>> partition(String s) {
        if(s.length() == 0) return result;
        backtrack(s, 0, new ArrayList<>());
        return result;
    }

    private void backtrack(String s, int index, ArrayList<String> path){
        if(index == s.length()){
            result.add(new ArrayList<>(path)); 
            return;
        }

        for(int i=index; i< s.length(); i++){

            if(isPalindrome(s, index, i)){
                path.add(s.substring(index, i+1));
                backtrack(s, i+1, path);
                path.remove(path.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s, int p1, int p2){
        if(p1 == p2) return true;
        while(p1<=p2){
            if(s.charAt(p1) != s.charAt(p2))
                return false;
            p1++;
            p2--;
        }
        return true;
    }
}
