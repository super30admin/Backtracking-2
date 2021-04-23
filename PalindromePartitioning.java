// Time Complexity : O(N * 2^N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        helper(s,0,new ArrayList<>());
        return result;
    }
    private boolean isPalindrome(String str,int i ,int j){
        while (i < j)
            if(str.charAt(i++)!=str.charAt(j--))
                return false;
        return true;
        
    }
    private void helper(String s, int index, List<String> path){
        if(index == s.length()) 
            result.add(new ArrayList<>(path));
        for(int i = index ; i <s.length() ;i++){
            if(isPalindrome(s,index,i)){
                //Action
                path.add(s.substring(index,i+1));
                //Recurse
                helper(s,i+1,path);
                //Backtrack
                path.remove(path.size()-1);
            }
        }
    }
}
