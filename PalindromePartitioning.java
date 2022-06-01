// Time Complexity : O(N*2^N), N is the length of string ss
// Space Complexity :O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class PalindromePartitioning {
    List<List<String>>  result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        helper(s, 0, new ArrayList<>());
        return result;
    }

    private void helper(String s, int idx, List<String>path) {
        //base
        if(idx ==  s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        //logic

        for(int i=idx; i<s.length();  i++) {

            String sub = s.substring(idx, i+1);
            if(isPalindrome(sub)) {
                //action
                path.add(sub);
                //recursion
                helper(s, i+1, path);

                //backtracking
                path.remove(path.size()-1);
            }

        }
    }

    private  boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() -1;
        while(start < end) {
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}
