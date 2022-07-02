// Time Complexity : O(n*2^n), n length of substring
// Space Complexity : O(n*2^n), n length of substring
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this: No 

//sub string everytime
class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        //null
        if(s==null || s.length() == 0){
            return result;
        }
        helper(s, new ArrayList<>());
        return result;
    }
    private void helper(String s, List<String> path){
        //null
        if(s.length() == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        
        //logic
        for(int i = 0; i < s.length(); i++){
            String sb = s.substring(0, i+1);
            if(isPalindrome(sb)){
                //action
                path.add(sb);
                //recurse
                helper(s.substring(i+1),path);
                //backtrack
                path.remove(path.size()-1);
            }
        }
    }
    private boolean isPalindrome(String s){
        int start = 0;
        int end = s.length()-1;
        while(start<end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}

/*
class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        //null
        if(s==null || s.length() == 0){
            return result;
        }
        helper(s, 0, new ArrayList<>());
        return result;
    }
    private void helper(String s, int index, List<String> path){
        //null
        if(index == s.length()){
            result.add(new ArrayList<>(path));
            return;
        }
        
        //logic
        for(int i = index; i < s.length(); i++){
            String sb = s.substring(index, i+1);
            if(isPalindrome(sb)){
                //action
                path.add(sb);
                //recurse
                helper(s,i+1,path);
                //backtrack
                path.remove(path.size()-1);
            }
        }
    }
    private boolean isPalindrome(String s){
        int start = 0;
        int end = s.length()-1;
        while(start<end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
*/