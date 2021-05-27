class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        if(s == null || s.length() == 0) return result;
        helper(s, new ArrayList<>(), 0);
        return result;
    }
    
    private void helper(String s, List<String> path, int index){
        if(index == s.length()){
            result.add(new ArrayList(path));
        }
        
        for(int i = index; i < s.length(); i++){
                if(isPalindrome(s, index, i)){
                    //action
                    path.add(s.substring(index, i+1));
                    //recurse
                    helper(s, path, i + 1);
                    //backtrack
                    path.remove(path.size() - 1);
                }
            }
        }
    
    // to check whether the substring is palindrome
    private boolean isPalindrome(String s, int start, int end){
        if(start == end) return true;
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
