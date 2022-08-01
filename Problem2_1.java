//Time Complexity: O(n*2^n)
//Space Complexity: O(2^n); since a new ArrayList is created for every call
//Code run successfully on LeetCode.

public class Problem2_1 {

    List<List<String>> result;
    public List<List<String>> partition(String s) {
        
        if(s == null || s.length() == 0)
            return new ArrayList<>();
        
        result = new ArrayList<>();
        
        helper(s, 0, new ArrayList<>());
        return result;
        
    }
    
    private void helper(String s, int index, List<String> path){
        
        if(index == s.length())
          result.add(path);
        
        for(int i = index; i < s.length(); i++){
            
            if(isPalindrome(s, index, i)){
                
                List<String> newList = new ArrayList<>(path);
                newList.add(s.substring(index, i+1));
                helper(s, i +1, newList);
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
