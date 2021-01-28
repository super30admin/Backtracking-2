class Solution {
    
    List<List<String>> result;
    
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        if(s == null || s.length() == 0) return result;
        helper(s,0,new ArrayList<>());
        return result;
    }
    
    private void helper(String s, int index, List<String> path){
        //base
        if(index == s.length()){
            result.add(new ArrayList<>(path));
            return;
        }
        //logic
        for(int i = index; i < s.length(); i++){
            if(isPalindrome(s,index,i)){
                //action
                path.add(s.substring(index, i+1));
                //recurse
                helper(s.substring(i+1), 0, path);
                path.remove(path.size()-1);
            }
        }
    }
    
    private boolean isPalindrome(String s, int l, int r){
        if(l == r) return true;
        while(l < r){
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}