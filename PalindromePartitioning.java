class Solution {
    
    // Time Complexity: O(N * 2^N)
    // Space Complexity: O(N)
    
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        // Edge Case Checking
        if(s == null || s.length() == 0)
            return result;
        int n = s.length();
        dfs(s, 0, new ArrayList(), result);
        return result;
    }
    
    private void dfs(String s, int index, List<String> path, List<List<String>> result){
        // If we have reach the end of the length - add the current combination strings to the output list
        if(index >= s.length()){
            result.add(new ArrayList(path));
            return;
        }
        
        for(int i = index; i < s.length(); i++){
             // Check if the string till point i is palidrome - if it is then proceed
            String curr = s.substring(index, i+1);
            if(isPalindrome(curr)){
                path.add(curr);
                dfs(s, i+1, path, result);
                path.remove(path.size()-1);
            }
        }
    }
    
    // Function to check if a string is palidrome or not
    private boolean isPalindrome(String s){
        int start = 0;
        int end = s.length()-1;
        
        while(start <= end){
            if(s.charAt(start) == s.charAt(end)){
                start++;
                end--;
            }else
                return false;
        }
        return true;
    }
}