class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new LinkedList<>();
        List<String> state = new ArrayList<>();

        backtrack(result, state, s, 0);
        return result;

    }

    private void backtrack(List<List<String>> result, List<String> state, String s, int start) {

        if (start == s.length()) {
            result.add(new LinkedList<>(state));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (isPal(s, start, i)) {
                state.add(s.substring(start, i + 1));
                backtrack(result, state, s, i + 1);
                state.remove(state.size() - 1);
            }
        }
    }

    private boolean isPal(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}