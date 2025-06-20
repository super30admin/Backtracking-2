class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        int start = 0;
        helper(0, s, result, path);
        return result;

    }

    private void helper(int start, String s, List<List<String>> result, List<String> path) {

        // base
        if (start == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            if (palindrome(s, start, end)) {
                path.add(s.substring(start, end + 1));
                helper(end + 1, s, result, path);
                path.remove(path.size() - 1);
            }

        }
    }

    private boolean palindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;

        }
        return true;
    }
}

///
///
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        helper(nums, curr, 0, result);
        return result;

    }

    private void helper(int[] nums, List<Integer> curr, int index, List<List<Integer>> result) {
        // base
        if (index == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }

        // dont choose
        helper(nums, curr, index + 1, result);
        curr.add(nums[index]);
        helper(nums, curr, index + 1, result);
        curr.remove(curr.size() - 1);
    }
}