//Time Complexity: O(2^N)
//Space Complexity: O(2^N)

//<-----Backtrack----->

class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        if(s == null || s.length() == 0) return result;
        backtrack(s, new ArrayList<String>(), 0);
        return result;
    }
    
    private void backtrack(String s, List<String> temp, int start)
    {
          if(start >= s.length()) {
            result.add(new ArrayList<>(temp));  
            return;
        }
        for(int i = start; i < s.length(); i++)
        {
            String sub = s.substring(start, i+1);   
            if(isPalindrome(s, start, i))
            {
             temp.add(sub);
                backtrack(s, new ArrayList<>(temp), i+1);
                temp.remove(temp.size() - 1);
                
            }
        }
    }
    private boolean isPalindrome(String s, int left, int right)
    {
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