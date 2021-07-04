//Time complexity - O(n*2^n)
//Space complexity -O(n)

class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
      if(s == null || s.length() == 0) return result;
      backtrack(s,new ArrayList<>());
      return result;
    }
  
    private void backtrack(String s,List<String> path) {
      //base 
      if(s.length() == 0) { // when the remaining string is empty
        result.add(new ArrayList<>(path));
      }
      
      //logic
      for(int i = 0 ;i< s.length(); i++) {
        if(isPalindrome(s,0,i)){
          //action
          path.add(s.substring(0,i+1));
          //recurse
          backtrack(s.substring(i+1),path);
          //backtrack
          path.remove(path.size()-1);
        }
      }
    }
  
   private boolean isPalindrome(String s, int l, int r) {
     while(l<r) {
       if(s.charAt(l) != s.charAt(r)) {
         return false;
       }
       l++;
       r--;
     }
     return true;
   }
}