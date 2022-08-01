//Time Complexity: O(n*2^n)
//Space Complexity: O(n); Recursion Stack Space
//Code run successfully on LeetCode.

public class Problem2_2 {

    List<List<String>> result;
    List<String> path;
    
    public List<List<String>> partition(String s) {
        
        if(s == null || s.length() == 0)
            return new ArrayList<>();
        
        result = new ArrayList<>();
        path = new ArrayList<>();
        
        helper(s, 0);
        return result;
        
    }
    
    private void helper(String s, int index){
        
        if(index == s.length())
          result.add(new ArrayList<>(path));
        
        for(int i = index; i < s.length(); i++){
            
            if(isPalindrome(s, index, i)){
                
                path.add(s.substring(index, i+1));
                helper(s, i +1);
                path.remove(path.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String s, int left, int right){
        
        while(left <= right){
            
            if(s.charAt(left) != s.charAt(right))
               return false;  
            
            left++;
            right--;
        }
        
        return true;
    }
}
