// Time Complexity :O(n*2^n)
// Space Complexity :O(n) 
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        if(s == null)return result;
        backtrack(s, new ArrayList<>(), 0);
        return result;
    }
    private void backtrack(String s, List<String> temp, int start){
        //base
        if(start == s.length()){
            result.add(new ArrayList<>(temp));
            return;
            
        }
        //logic
    
        for(int i = start; i < s.length(); i++){
            
            if(isPalindrome(s,start,i)){
                //action
                temp.add(s.substring(start, i+1));
                
                //recurse
                backtrack(s, temp, i + 1);
                
                //backtrack
                temp.remove(temp.size()-1);
            }
            
            
        }
    }
    private boolean isPalindrome(String s, int left, int right){

        if(left==right) return true;

        while(left < right){

            if(s.charAt(left) != s.charAt(right)) return false;

             left++; right--;

        }

        return true;

    }
}