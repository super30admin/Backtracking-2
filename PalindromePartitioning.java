class Solution {
    
    List<List<String>> result = new ArrayList<>();
    
    public List<List<String>> partition(String s) {
        if(s == null || s.length() == 0){
            return result;
        }
        
        backtracking(s, 0, new ArrayList<>());
        
        return result;
        
    }
    
    private void backtracking(String s, int index, List<String> path){
        // base case
        if(index >= s.length()){
            result.add(new ArrayList<>(path));
        }
        
        //logic 
        for(int i = index; i < s.length(); i++){
            String curr = s.substring(index, i + 1);
            
            if(isPalindrome(curr)){
                path.add(curr);
                
                //recursion
                backtracking(s, i+1, path);
                
                //backtracking
                path.remove(path.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        
        while(left < right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

//time complexity: O(n* 2^n)
//Space Complexity: O(n)