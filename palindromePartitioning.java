//Time complexity O(n)
//Space complexity O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        
        
         result = new ArrayList<>();
         if(s.length() == 0 || s == null){
            
            return result;
        }
        
        helper(s, new ArrayList(), 0);
        
        
        return result;
    }
    
    private void helper(String s, ArrayList<String> path, int index){
        
      // result.add(new ArrayList(path));
        if(index == s.length()){
            
            result.add(new ArrayList(path));
            return;
        }
       
        
        for(int i = index; i < s.length(); i ++){
            
             String curr = s.substring(index,i + 1);
            
            
            //ArrayList<Integer> temp = new ArrayList<>(path);
            if(isPalindrome(curr)){
              //  System.out.println(curr);
              //  System.out.println("hitting");
            path.add(curr);  //action
            helper(s, path, i + 1); //recurse
            path.remove(path.size() - 1); //backtrack
                
            }
            
        }
     }
    private boolean isPalindrome(String curr){
        
        if(curr.length() == 1){
            
            return true;
        }
        
        int left = 0;
        int right = curr.length() - 1;
        
        while(left < right){
            
            if(curr.charAt(left) == curr.charAt(right)){
                
                left ++;
                right --;
            }
            else{
                
                return false;
            }
        }
        return true;
        
    }
}