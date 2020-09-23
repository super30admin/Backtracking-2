class Solution {
    List<List<String>> output = new ArrayList<>();

    public List<List<String>> partition(String s) {
        List<String> path = new ArrayList<>();

        backtrack(s, 0, path);

        return output;
    }

    void backtrack(String s, int index, List<String> path) {

        if (index >= s.length()) {
            output.add(new ArrayList<>(path));

            return;
        }

        // output.add(new ArrayList<>(path));

        for (int i = index; i < s.length(); i++) {
            String tmp = s.substring(index, i + 1);
            if (isPalindrome(tmp)) {
                path.add(tmp);
                backtrack(s, i + 1, path);
                path.remove(path.size() - 1);

            }

        }
    }

    boolean isPalindrome(String s) {
        int low = 0;
        int high = s.length() - 1;
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--))
                return false;
        }
        return true;
    }
}