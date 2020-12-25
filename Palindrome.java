/** Given a string s, partition s such that every substring of the partition is a palindrome. 
*  TC O(N * (2 pow N)) and SC O(N)
*/
class Solution {
    List<List<String>> pal = new ArrayList<>();
    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0)
            return pal;
        helper(s, 0, new ArrayList<>()); 
        return pal;
    }
    private void helper(String s, int index, List<String> temp){
        if (index == s.length()) {
            pal.add(new ArrayList<>(temp));
            return;
        }
       
        for (int i = index; i< s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                 temp.add(s.substring(index, i+1));
                 helper(s, i+1, temp);
                 temp.remove(temp.size()-1);
            }
        }
    }
    
    private boolean isPalindrome(String s, int start, int end) {
        while(start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            end--;
            start++;
        }
        return true;
    }
}

