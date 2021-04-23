/**Leetcode Question 131 - Palindrome Partioning */
/**Algorithm - Backtracking
 * Pass the string, the starting index and the path
 * Check if the current string in consideration is a palindrome or not
 * If palindrome, add it to the path and call the backtrack function again and then remove evrything from the path 
 */
/**TC - O(2^N)
 * SC -O(N)
 */
public class PalindromePartioning {
    class Solution {
        List<List<String>> result;
        public List<List<String>> partition(String s) {
            result = new ArrayList<>();
            if(s == null || s.length() == 0){
                return result;
            }
            backtrack(s, 0, new ArrayList<>());
            return result;
        }
        private void backtrack(String s, int index, List<String> path){
            //base
            if(index == s.length()){
                result.add(new ArrayList<>(path));
            }
            //logic
            for(int i =index; i< s.length(); i++){
                if(isPalindrome(s, index, i)){
                    path.add(s.substring(index, i+1));
                    backtrack(s, i+1, path);
                    path.remove(path.size()-1);
                }
            }
        }
        private boolean isPalindrome(String s, int l, int r){
            if(l==r){
                return true;
            }
            while(l<=r){
                if(s.charAt(l) != s.charAt(r)){
                    return false;
                }
                l++;
                r--;
            }
            return true;
        }
    }
}
