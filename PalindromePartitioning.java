// Time Complexity:O(n×2^n)
// space complexity :O(n)
// leetcode : success

class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        
        helper(s,0,new ArrayList<String>()); 
    
        return result;
    }
    
    private void helper(String s , int index , List<String> currlist){
        
        if(index >= s.length() ){
        
           result.add(new ArrayList<String>(currlist)) ;
            return;
        }
        
        for(int i = index ; i< s.length() ; i++){
            
            if(isPalindrome(s,index,i)){
                currlist.add(s.substring(index,i+1));
            
                helper(s,i+1,currlist);
            
                currlist.remove(currlist.size() -1);
            }
            
        }
    }
    
     private boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low) != s.charAt(high)){
                return false;
            } 
            high--;
            low++;
        }
        return true;
    }
    
}