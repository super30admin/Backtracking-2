// TC:  n * 2^n with isPalindrome function.
// SC: O(n)
class Solution {
    List<List<String>> result;

    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }

        result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>());
        // backtrackSubstring(s, new ArrayList<>());
        return result;
    }

    private void backtrack(String s, int index, List<String> path) {

        if (index >= s.length()) {
            result.add(new ArrayList<>(path));
            
            // if in for loop newList is used, this can be done instead.
            // result.add(path);
            return;
        }

        for (int i = index; i < s.length(); ++i) {
            if (isPalindrome(s, index, i)) {
                path.add(s.substring(index, i + 1));
                backtrack(s, i + 1, path);
                path.remove(path.size() - 1);


                // Another way but bad
                // Evrytime create a new list and can add directly to result like result.add(path)
                // List<String> newList = new ArrayList<>(path);
                // newList.add(s.substring(index, i + 1));
                // backtrack(s, i + 1, newList);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while(start < end) {
            if(s.charAt(start) != s.charAt(end)) {
                return false;
            }
            ++start;
            --end;
        }
        return true;
    }

    // pass substring method, without using index param
    private void backtrackSubstring(String s, List<String> path) {
        if (s.length() == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < s.length(); ++i) {
            if (isPalindrome(s, 0, i)) {
                path.add(s.substring(0, i + 1));
                backtrackSubstring(s.substring(i + 1), path);
                path.remove(path.size() - 1);
            }
        }
    }
}