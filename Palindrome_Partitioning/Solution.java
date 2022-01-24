// Time Complexity : O(N * exponential) 
// Space Complexity : O(N) recursive stack
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * We use backtracking approach.
 * Here we add current char to our temp list and generate possible combinations from that char using recursion.
 * Then we do backrackaing to remove it from list.
 * For each generated combo, we check if it a palindrome using two pointers approach
*/

class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        helper(s, 0, new ArrayList<String>());
        return result;
    }
    
    private void helper(String s, int index, ArrayList<String> temp){
        //base
        if(index == s.length()){
            result.add(new ArrayList<>(temp));
        }
        
        //logic
        for(int i = index; i < s.length();i++){
            String curr = s.substring(index, i+1);
            if(isPalindrome(curr)){
                temp.add(curr);
                helper(s, i+1, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String curr){
        if(curr.length() == 0 || curr.equals(""))return true;
        int one = 0;
        int two = curr.length() -1;
        
        while(one <= two){
            if(curr.charAt(one) != curr.charAt(two))return false;
            one++;
            two--;
        }
        
        return true;
    }
}