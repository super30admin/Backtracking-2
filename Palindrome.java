//Time Complexity: O(N*2^N) where n is the length of the string s
//Space Complexity: O(2^N)

class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<List<String>>();
        if(s == null || s.length() == 0) return result;
        backtrack(s, new ArrayList<String>(), 0);
        return result;
    }
    
    private void backtrack(String s, List<String> temp, int index) {
        if(index == s.length()) {
            result.add(new ArrayList<>(temp));  
            return;
        }
        
        for(int i = index; i < s.length(); i++) { 
            String sub = s.substring(index, i+1);   
            if(isPalindrome(s, index, i)) { 
                temp.add(sub);              
                backtrack(s, temp, i+1);     
                temp.remove(temp.size()-1); 
            }
        }
    }
    
    private boolean isPalindrome(String s, int left, int right) {
        if(s == null || s.length() <= 1) return true;
        while(left <= right) {
            if(s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
        
}