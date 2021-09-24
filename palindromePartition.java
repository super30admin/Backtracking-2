// Time Complexity : O(n * 2^N), exponential
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


public class palindromePartition {
    List<List<String>> result = new ArrayList();
    public List<List<String>> partition(String s) {
        backtrack(s, 0, new ArrayList());
        return result;
    }
    
    public void backtrack(String s, int index, ArrayList<String> path) {
        if(index == s.length()) {
            result.add(new ArrayList(path));      
        }
        
        for(int i = index; i < s.length(); i++) {
            if(isPalindrome(s, index, i)) {
                path.add(s.substring(index, i+1));
                backtrack(s, i+1, path);
                path.remove(path.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String s, int start, int end) {
        while(start < end) {
            if(s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
}
