/*
Time Complexity : Exponential
Space Complexity : O(N)
Idea : you partition the string in 2 parts if the first part is palindrom you recurse on the second part 
and once u reach end of the string u backtrack.
*/
class Solution {
    List<List<String>> ans;
    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();
        if(s == null || s.length() == 0){
            return ans;
        }
        helper(s,new ArrayList<String>());
        return ans;
      }
    
    public void helper(String s, List<String> part){
        if(s.length()==0){
            ans.add(new ArrayList<String>(part));
        }
        for(int i=0;i<s.length();i++){
            String pre = s.substring(0,i+1);
            if(isPalindrome(pre)){
                part.add(pre);
                helper(s.substring(i+1),part);
                part.remove(part.size()-1);
            } 
        }
    }

   public boolean isPalindrome(String s){
       int l = 0;
       int r = s.length()-1;
       while(l<r){
           if(s.charAt(l) != s.charAt(r)){
               return false;
           }
           l++;
           r--;
       }
       return true;
   }
}