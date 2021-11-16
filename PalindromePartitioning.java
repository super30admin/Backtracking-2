// Time Complexity : O(2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result=new ArrayList<>();
    
        List<String> list=new ArrayList<>();
        helper(s, 0,list);
        return result;
    }
    
    public void helper(String nums, int index, List<String> currList){
        if(index==nums.length()){
           
             result.add(new ArrayList(currList));
            
            return;
        }
        
        for(int i=index; i<nums.length();i++){
           
            if(isPalindrome(nums.substring(index,i+1))){
              
                 currList.add(nums.substring(index,i+1));
                  helper(nums, i+1, currList);
            
            currList.remove(currList.size()-1);
            }
        }
    }
    
    public boolean isPalindrome(String s) {
        s=s.replaceAll("[^A-Za-z0-9]","").toLowerCase();
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}