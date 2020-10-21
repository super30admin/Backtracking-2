// Time Complexity : O(N) - As we iterate through the whole string
// Space Complexity : O(N) - AS We use recursion(backtracking)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    List<List<String>> str1 = new ArrayList<>();
    public List<List<String>> partition(String s) {
        if(s.length() == 0 || s == null) return str1;
        backtrack(0,new ArrayList<String>(),s);
        return str1;
    }
    public void backtrack(int start,ArrayList<String> curr,String s1){
        if (start >= s1.length()) str1.add(new ArrayList<String>(curr));
        for(int i = start;i < s1.length();i++){
            if(isPalindrome(s1,start,i)){
              curr.add(s1.substring(start,i + 1));
              backtrack(i + 1,curr,s1);
              curr.remove(curr.size() - 1);
            } 
        }
    }
    public boolean isPalindrome(String s2,int low,int high){
        while(low < high){
            if(s2.charAt(low++) != s2.charAt(high--)) return false;
        }
        return true;
    }
}
// Your code here along with comments explaining your approach