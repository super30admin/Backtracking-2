class Solution {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> partition(String s) {
        if(s == null || s.length() == 0) {
            return result;
        }
        helper(s, 0, new ArrayList<>());
        return result;
    }
    private void helper(String s, int start, List<String> curr) {
        if(start >= s.length()) {
            result.add(new ArrayList<>(curr));
            return;
        }
        for(int end = start; end < s.length(); end++) {
            if(isValid(s, start, end)) {
                curr.add(s.substring(start, end + 1));
                helper(s, end + 1, curr);
                curr.remove(curr.size() - 1);
            }
        }
    }
    private boolean isValid(String s, int l, int r) {
        while(l < r) {
            if(s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}