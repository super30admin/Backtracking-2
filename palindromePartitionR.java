class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        if(s == null || s.length() == 0) return result;
        
        helper(s, new ArrayList<>());
        return result;
    }
    
    private void helper(String s, List<String> path){
        if(s.length() == 0){
            result.add(path);
            return;
        }
        
        for(int i=0; i<s.length(); i++){
            if(isPalindrome(s,0,i)){
                List<String> copy = new ArrayList<>(path);
                copy.add(s.substring(0,i+1));
                helper(s.substring(i+1), copy);
            }
        }
    }
    
    private boolean isPalindrome(String s, int l, int r){
        if(l == r) return true;
        while(l<r){
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;r--;
        }
        return true;
    }
}