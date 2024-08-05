// Time Complexity : O(2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
 
class Solution {
    List<List<String>> result;
    private boolean isPalindrome(String s){
        int i=0;
        int j = s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    public void helper(String s, ArrayList<String> path, int pivot, int n){
        //base
        if(pivot == n){
            result.add(new ArrayList<>(path));
            return;
        }
        //logic
        for(int i=pivot;i<n;i++){
            String temp = s.substring(pivot, i+1);
            if(isPalindrome(temp)){
                path.add(temp);
                helper(s, path, i+1, n);
                path.remove(path.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        int n = s.length();
        helper(s, new ArrayList<>(), 0, n);
        return result;
    }
}
