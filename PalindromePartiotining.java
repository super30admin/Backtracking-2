/*
Desc : We extract all the possible substrings and check if they are palindrome,
we use a string called path which we update with, if an invalid element occurs
we. backtrack and continue other possibilities .
Time Complexity : O(2^n)
Space Complexity : O(1)
*/
class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        if(s == null || s.length()==0) return result;
        backtrack(s,new ArrayList<>());
        return result;
    }
    private void backtrack(String s, List<String> path){
        if(s.length()==0){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i=0;i<s.length();i++){
            if(isPalindrome(s,0,i)){
                path.add(s.substring(0,i+1));
                backtrack(s.substring(i+1),path);
                path.remove(path.size()-1);
            }
        }
    }
    private boolean isPalindrome(String s,int l,int r){
        if(l == r) return true;
            while(l<r){
                if(s.charAt(l) != s.charAt(r)) return false;
                l++; r--;
            }
        return true;
    }
}
