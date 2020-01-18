// Time Complexity
// Space Complexity
// This Solution worked on LeetCode


class Solution {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> partition(String s) {
        if(s == null || s.length() ==0) return result;
        backtrack(s,0,new ArrayList<>());
        return result;
    }
    
    private void backtrack(String s, int start,List<String> temp){
        //Base Case
        if(start == s.length()){
            result.add(new ArrayList<>(temp));
            return;
        }
        // Logic
        for(int i=start ;i < s.length(); i++){
            if(ispalindrome(s,start,i)){
                temp.add(s.substring(start,i+1));
                backtrack(s,i+1,temp);
                temp.remove(temp.size() - 1);
            }
        }
    }
    private boolean ispalindrome(String s, int l, int r){
        if(l == r)    return true;
        while(l < r){
            if(s.charAt(l) != s.charAt(r))  return false;
            l++;r--;
        }
        return true;
    }
}
