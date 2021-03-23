// Time Complexity :
O(2 ^ n * n) n is the length of the string s
// Space Complexity :
O(n) where n is the length of the string
// Did this code successfully run on Leetcode :
yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


/*
TC: O(2 ^ n * n) n is the length of the string s
SC: O(n) where n is the length of the string
*/
class Solution {
    public List<List<String>> partition(String s) {
        //Define result list
        List<List<String>> result = new ArrayList<>();
        //Define temp List that stores the valid partition sequence
        List<String> temp = new ArrayList<>();
        //call the helper function
        helper(s,0,temp,result );
        //return result
        return result;
    }
    
    private void helper(String s,int ind,List<String> temp,List<List<String>> result){
        
        //base case : when the index reaches my length of input
        //ind is the position where we are going to partition
        if(ind == s.length()){
            result.add(new ArrayList<>(temp));
            return;
        }
        
        //now recursing function
        for(int i = ind;i< s.length(); i++){
            //check if the partition is going to make a valid palindrome
            if(isPalindrome(s,ind,i)){
                temp.add(s.substring(ind,i+1));
                //make possible recursions for partitioning
                helper(s,i+1,temp,result);
                // backtrack step
                temp.remove(temp.size()-1);
            }
        }
    }
    
    private boolean isPalindrome(String s, int ind, int i){
        while(ind <= i){
            if(s.charAt(i) != s.charAt(ind)){
            return false;
            }
            else{
                ind ++;
                i--;
            }
        }
        return true;
        
    }
}