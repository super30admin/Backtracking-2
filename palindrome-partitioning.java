//Time - O(exp)
//Space - O(N)
class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        if(s==null || s.length() == 0){
            return result;
        }
        backtrack(s, 0, new ArrayList<>());
        return result;
    }
    
    private void backtrack(String s, int index, List<String> set) {
        
        if(index == s.length()) {
            result.add(new ArrayList<>(set));
            return;
        }
        for(int i=index;i<s.length();i++) {
            if(isPalindrome(s, index, i)) {
                set.add(s.substring(index,i+1));
                backtrack(s, i+1, set);
                set.remove(set.size()-1);
            }
        }
    }
    
    public boolean isPalindrome(String s, int low, int high){
   while(low < high)
      if(s.charAt(low++) != s.charAt(high--)) return false;
   return true;
} 
}
