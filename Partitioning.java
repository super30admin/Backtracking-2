////Time Complexity: O(2^n).
//Space Complexity: O(1).



class Solution {
    List<List<String>> result;
    
    public List<List<String>> partition(String s) {
        
    result = new ArrayList<>();
    if(s.length() == 0 || s == null) return result;
        
    helper(s, 0, new ArrayList<>());
    
    return result;
    }
    
    private void helper(String s, int index, ArrayList<String> path){
    //base
        if(index == s.length()){
            result.add(new ArrayList<>(path));
        }
    //logic
        
        for(int i = index; i < s.length(); i++){
            
            //check if new string is palindrome? 
            if(isPalindrome(s, index, i)){
                //add it to the list
                path.add(s.substring(index, i+1));
                helper(s, i+1, path);
                path.remove(path.size()-1);
            }
        }
    }
    
    private boolean isPalindrome(String s, int left, int right){
        while(left <= right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
            
        }
        
    return true;
    }
}