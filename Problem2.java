
// Time Complexity :exponential O(2^n)
// Space Complexity :O(1) for backtracking, O(n) for recursion
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
class Solution {
    //for loop based recursion with backtracking
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        helper(s,new ArrayList<>());
        return result;
    }
    public void helper(String s, List<String> path){
        //base condition where we have used all the characters in string
        if(s.length()==0){
            result.add(new ArrayList<>(path));
            return;
        }
        //logic
        for(int i=0;i<s.length();i++){
            //checking if until that pivot its palindrome or not, if yes then add it to the path and recurse
            if(isPalindrome(s,0,i)){
                path.add(s.substring(0,i+1));
                //recurse
                helper(s.substring(i+1),path);
                //backtrack
                path.remove(path.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s, int left, int right){
        while(left<right){
            if(s.charAt(left)!=s.charAt(right))return false;
            left++;
            right--;
        }
        return true;
    }
}