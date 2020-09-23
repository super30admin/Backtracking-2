// Time Complexity : O(n*n ^ n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// Backtracking
class Solution {    
    List<List<String>> res = new ArrayList<>();
    
    public List<List<String>> partition(String s) {
        if(s==null || s.length() ==0)
            return res;
        
        backtracking(s, 0, new ArrayList<>());     
        return res;
    }
    
    // 1) output 2) input 3) index 4) current path
    private void backtracking(String s, int index, List<String> path){
        //base case
        if(index >= s.length()){
            res.add(new ArrayList<>(path));
            return;
        }  
        //recursive
        for(int i=index; i<s.length(); i++){
            String temp = s.substring(index, i+1);
            if(validPalindrome(temp)){
                path.add(temp);
                backtracking(s, i+1, path);
                path.remove(path.size()-1);
            }
        }  
    }
    
    private boolean validPalindrome(String s){
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
