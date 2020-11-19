/**
 * TC : Exponential SC: O(n)
 * Approach : traverse string using 2 pointers to explore all the possibilities of partitioning the string and move forward only if curr string is palindrome,
 *            else backtrack and move until all the elements are traversed from the string.
 */
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if(s.length() == 0) return res;
        helper(s,new ArrayList<String>(), 0, res);
        return res;
    }
    
    private void helper(String s, List<String> temp, int index, List<List<String>> res){
        //Base
        if(index == s.length()){
            res.add(new ArrayList<String>(temp));
            return;
        }
        //Logic
        for(int i = index; i < s.length(); i++){
            if(isPalindrome(s,index,i)){
                //Action
                temp.add(s.substring(index,i+1));
                //Recurse
                helper(s,temp,i+1,res);
                //BackTrack
                temp.remove(temp.size()-1);
            }
            
        }
    }
    
    private boolean isPalindrome(String s, int left, int right){
        while(left < right){
            if(s.charAt(left) != s.charAt(right)) return false;
            left++; right--;
        }
        return true;
    }
}