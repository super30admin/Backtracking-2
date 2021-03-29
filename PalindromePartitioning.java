// TC - O(n^n), SC - O(n)

class Solution {
    // create a global variable result
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> partition(String s) {
        // sanity check
        if(s == null || s.length() == 0){
            return result;
        }
        
        backtracking(s, 0, new ArrayList<>());
        return result;
    }
    
    // backtrack function
    private void backtracking(String s, int index, List<String> path){
        // base condition
        if(index >= s.length()){
            result.add(new ArrayList<>(path));
            return;
        }
        
        // Starting from index to length of string s, find the substring, check if it is palindrome, add it to path and call recursive function and at end remove last element from path to find different routes
        for(int i=index; i<s.length(); i++){
            String curr = s.substring(index, i+1);
            if(isPalindrome(curr)){
                path.add(curr);
                backtracking(s, i+1, path);
                path.remove(path.size()-1);
            }
        }
    }
    
    // palindrome check function
    private boolean isPalindrome(String s){
        int l=0, r=s.length()-1;
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