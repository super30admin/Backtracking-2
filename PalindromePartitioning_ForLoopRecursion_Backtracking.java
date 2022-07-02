/* Time Complexity: O(n*2^n), n length of substring
 * Space Complexity: O(n*2^n), n length of substring
 * Did this code successfully run on Leetcode : yes
 * Any problem you faced while coding this : No
 */

class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        //null
        if(s == null || s.length() == 0) return result;
        helper(s, 0, new ArrayList<>());
        return result;
    }
    
    private void helper(String s, int index, List<String> path){
        //base
        if(index == s.length()){
            result.add(new ArrayList<>(path));
            return;
        }
        //logic
        for(int i = index; i < s.length(); i++){
            String sb = s.substring(index, i+1); // i+1 - substring() takes one extra index
            if(isPalindrome(sb)){
                //action
                path.add(sb);
                //recurse
                helper(s, i+1, path);
                //backtrack
                path.remove(path.size() - 1);
            }
        }
    }
    
    //using 2 pointers one from start of the string and one from end of the string and 
    //moving start pointer forward and end pointer backward and check the characters at           //respective pointers.
    private boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while(start < end){
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}