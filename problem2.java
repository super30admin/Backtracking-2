class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {

        helper(s, 0, new ArrayList<>());
        return res;
        
    }
    
    public void helper(String s, int index, List<String> path ) {
        if(index == s.length()) {
            res.add(new ArrayList(path));
            return;
        }
        
        for(int i=index; i<s.length(); i++) {
            String substr = s.substring(index, i+1);
            if(isPalindrome(substr)) {
                path.add(substr);
                helper(s, i+1, path);
                path.remove(path.size()-1);
            }
        }
    }
    
    public boolean isPalindrome(String str) {
        int s=0;
        int l=str.length()-1;
        
        while(s<l) {
            if(str.charAt(s) != str.charAt(l)) {
                return false;
            }
            s++;
            l--;
        }
        
        return true;
    }
}
