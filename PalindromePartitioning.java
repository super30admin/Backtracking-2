// Time Complexity : N * O(2^N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes

class Solution {
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        res  = new ArrayList<>();
        if(s==null || s.length() == 0){
            return res;
        }
        helper(s,0, new ArrayList<>());
        return res;
    }
    void helper(String s, int index, List<String> path){
        if(index==s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=index;i<s.length();i++){
            if(isPalindrome(s,index,i)){
                path.add(s.substring(index,i+1));
                helper(s,i+1,path);
                path.remove(path.size()-1);
            }
        }
    }
    boolean isPalindrome(String s,int left,int right){
        while(left<=right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}