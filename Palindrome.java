class Solution {
            private List<List<String>> res =  new ArrayList();

    public List<List<String>> partition(String s) {
        backT(s,  0, new ArrayList());
        return res;
        
    }
    private void backT(String s, int index, List<String> path){
        
        if(index >= s.length()) res.add(new ArrayList(path));
        //path = new ArrayList();
            
        for(int i = index; i < s.length(); i++){
            if( isPalindrome(s, index, i)){
            path.add(s.substring(index, i+1));
            backT(s, i + 1, path);
            path.remove(path.size() - 1);
            }
        }
        
    }
     boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--)) return false;
        }
        return true;
    }
        
    
}