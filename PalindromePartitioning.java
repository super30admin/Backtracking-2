// Time COmplexity: O(2 ^ n)
// Space COmplexity: O(2 ^ n)
class Solution {

    List<List<String>> res;

    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        if(s == null || s.length() == 0) {
            return res;
        }
        helper(s, 0, new ArrayList<>());
        return res;
    }

    private void helper(String s, int start, List<String> temp) {
        if(start == s.length()) {
            res.add(new ArrayList<>(temp));
        }

        for(int i = start; i < s.length(); i++) {
            if(isPalindrome(s, start, i)) {
                temp.add(s.substring(start, i+1));
                helper(s, i+1, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s, int low, int high) {
        while(low < high)
            if(s.charAt(low++) != s.charAt(high--)) return false;
        return true;
    }
}// Time COmplexity: O(2 ^ n)
// Space COmplexity: O(2 ^ n)
class Solution {

    List<List<String>> res;

    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        if(s == null || s.length() == 0) {
            return res;
        }
        helper(s, 0, new ArrayList<>());
        return res;
    }

    private void helper(String s, int start, List<String> temp) {
        if(start == s.length()) {
            res.add(new ArrayList<>(temp));
        }

        for(int i = start; i < s.length(); i++) {
            if(isPalindrome(s, start, i)) {
                temp.add(s.substring(start, i+1));
                helper(s, i+1, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s, int low, int high) {
        while(low < high)
            if(s.charAt(low++) != s.charAt(high--)) return false;
        return true;
    }
}