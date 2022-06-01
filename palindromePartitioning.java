// Time Complexity : O(N*2^N) - n = length of string
// Space Complexity :O(N) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        if(s.length()==0 || s==null){
            return result;
        }
        
        helper(s, 0, new ArrayList<>());
        return result;
    }
    
    private void helper(String s, int pivot, List<String> path){
        //base
        if(pivot==s.length()){
            result.add(new ArrayList<>(path));
            return;
        }
        //logic
        for(int i=pivot;i<s.length();i++){
            String str = s.substring(pivot, i+1);
            if(isPalindrome(str)){
                path.add(str);
                helper(s, i+1, path);
                path.remove(path.size()-1);
            }
        }
    }
    
    private boolean isPalindrome(String s){
        int start = 0;
        int end = s.length()-1;
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
