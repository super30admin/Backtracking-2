//Time Complexity: O(2^n)
//Space Complexity: O(n)
//Approach: We'll call backtrack function only when the current string is palindrome.
class PalindromeParitioning {
    
    List<List<String>> result = new ArrayList<>();
    
    public List<List<String>> partition(String s) {
        if (s == null || s.length() ==0) return result;
        
        backtrack(s,0,new ArrayList<String>());
        return result;
    }
    
    private void backtrack (String s,int index, List<String> temp) {
        //base case
         if (index == s.length()) {
             result.add(new ArrayList<>(temp));
             return;
         }
        
        //Logic
        for (int i= index; i < s.length();i++) {
            //a (ab), aa (b), aab()
            if (isPalindrome(s,index, i)) {
                temp.add(s.substring(index,i+1));
                backtrack(s,i+1,temp);
                temp.remove(temp.size()-1);
            }
        }
    }
    
    private boolean isPalindrome (String s, int l, int r) {
        if (l==r) return true;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r --;
        }
        
        return true;
    }
}