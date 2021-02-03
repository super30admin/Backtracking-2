// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : some difficulty with concept but understood now


// Your code here along with comments explaining your approach

public class Palindrome {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        if(s == null || s.length() == 0){
            return result;
        }
        helper(s,0, new ArrayList<>());
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
            if(isPalindrome(s, index, i)){
                //action
                path.add(s.substring(index, i + 1));
                //recurse
                helper(s, i+1, path);
                //backtrack
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end){
        if(start == end) return true;
        while(start < end){
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }

        return true;
    }
}