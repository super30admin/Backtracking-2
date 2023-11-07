// Time Complexity : O(n*2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    List<List<String>> res;
    private boolean isPalindrome(String curr){
        int end = curr.length()-1,start = 0;
        while(start < end){
            if(curr.charAt(start)!=curr.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
    private void helper(String s,List<String> path,int pivot){
        if(pivot == s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = pivot; i < s.length();i++ ){
            String curr = s.substring(pivot,i+1);
            if(isPalindrome(curr)){
                path.add(curr);
                helper(s,path,i+1);
                path.remove(path.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
       this.res = new ArrayList<>();
       helper(s,new ArrayList<>(),0);
       return res; 
    }
}
