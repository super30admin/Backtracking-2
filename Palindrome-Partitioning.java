class Solution {
    
    List<List<String>> output;
    public List<List<String>> partition(String s) {
        
        output = new ArrayList<>();
        
        if (s == null || s.length() == 0)return output;
        
        backtrack(s, 0, new ArrayList<>());
        return output;
        
    }
    
    private void backtrack(String s, int start, List<String> currentPath){
        
        if (start == s.length()){
            output.add(new ArrayList<>(currentPath));
        }
        
        for (int x = start; x < s.length(); x++){
            String substr = s.substring(start, x+1);
            if (isPalindrome(substr)){
                currentPath.add(substr);
                backtrack(s,x+1,currentPath);
                currentPath.remove(currentPath.size() -1 );
            }
        }
    }
    
    private boolean isPalindrome(String s){
        int start = 0;
        int end = s.length() - 1;
        
        while(start<end){
            if (s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}