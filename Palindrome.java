// Time Complexity : O(2^n)
// Space Complexity : O(n * 2^n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        helper(s,0,new ArrayList<>(),result);
        return result;
    }
    
    private void helper(String s, int idx, List<String> path,List<List<String>> result){
        if(idx == s.length()){
            result.add(new ArrayList<>(path));
            return;
        }
        
        for(int i = idx;i<s.length();i++){
            String sub = s.substring(idx,i+1);
            if(isPalindrome(sub)){
                path.add(sub);
                helper(s,i+1,path,result);
                path.remove(path.size()-1);
            }
        }
    }
    
    public static boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        while(left < right)
        {
            if(str.charAt(left) != str.charAt(right))
            {
                return false;
            }
            left++;
            right--;
        }
        return true;
    } 
}

/*
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        helper(s,new ArrayList<>(),result);
        return result;
    }
    
    private void helper(String s, List<String> path,List<List<String>> result){
        if(s.length()==0){
            result.add(new ArrayList<>(path));
            return;
        }
        
        for(int i = 0;i<s.length();i++){
            String sub = s.substring(0,i+1);
            if(isPalindrome(sub)){
                path.add(sub);
                helper(s.substring(i+1),path,result);
                path.remove(path.size()-1);
            }
        }
    }
    
    public static boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        while(left < right)
        {
            if(str.charAt(left) != str.charAt(right))
            {
                return false;
            }
            left++;
            right--;
        }
        return true;
    } 
}*/
