class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        if(s == null || s.length() == 0) return result;
        
        helper(s,  new ArrayList<>());
        
        return result;
    }
    
    private void helper(String s, List<String> path){
        //base
        if(s.length() == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        //logic
        for(int i = 0; i < s.length(); i++){
            if(isPalindrome(s, 0, i)){
                //action
                path.add(s.substring(0, i + 1));
                //recurse
                helper(s.substring(i + 1), path); 
                //backtrack
                path.remove(path.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String s, int left, int right){
        while(left <= right){
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}