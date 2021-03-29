//Tc: O(n.2^n)
//Sc: O(n)
//Not running in leetcode. i dont know error. help me to solve.

class Solution {
    
List<List<String>>result;
    public List<List<String>> partition(String S) {
        result = new ArrayList<>();
        if(S == null || S.length == 0)
            return result;
        backtrack(S, 0, new ArrayList<>());
        return result;
        
    }
    private void backtrack(String s, int index, List<String> path){
        if(index== S.length()){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i = index ; i< S.length(); i++){
            if(isPalindrome(S, index, i)){
                //action
                path.add(S.substring(index, i+1));
                //recurse
                backtrack(S, i+1, path);
                //backtrack
                path.remove(pathj.size()-1);
            }
        }
        private  boolean isPalindrome(String S, int l , int r){
            if(l==r)
                return true;
            while(l < r){
                if(S.charAt(l) != S.charAt(r))
                    return false;
                l++;
                r--;
            }
            return true;
        }
    }
