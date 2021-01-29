/*
time complexity : (2 ^ n), exponential
spce complexity : O(n)
*/
class Solution {
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        
        this.res = new ArrayList<>();
        if(s.length() == 0){
            return res;
        }
        backtrack(s,0,new ArrayList<>());
        return res;
    }
    
    private void backtrack(String s, int index, List<String> path){
        if(index == s.length()){
            res.add(new ArrayList<>(path));
        }
        
        for(int i = index; i < s.length();i++){
             if(isPalindrome(s,index,i)){
            path.add(s.substring(index,i+1));
            
            backtrack(s, i + 1, path);
            
            path.remove(path.size()-1);
                
        }
        }
       
    }
    
    private boolean isPalindrome(String s, int l, int r){
        while(l < r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}