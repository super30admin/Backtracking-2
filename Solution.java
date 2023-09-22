import java.util.*;

class Solution {
    List<List<Integer>> result;

    // TC:O(2^m+n) //SC: O(h)
    public List<List<Integer>> subsets(int[] nums) {
        this.result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int size = result.size(); // need to define here else we will get infinite loop issue
            for (int j = 0; j < size; j++) {
                List<Integer> li = new ArrayList<>(result.get(j));
                li.add(nums[i]);
                result.add(li);
            }
        }
        return result;
    }

    // TC: O(2^n) SC: 0(n)
    List<List<String>> result2;

    public List<List<String>> partition(String s) {
        result2 = new ArrayList<>();
        helper(s, 0, 0, new ArrayList<>(), 0);
        return result2;
    }

    public void helper(String s, int pivot, int i, List<String> path, int sum) {
        if (i == s.length()) {
            if (sum == s.length()) {
                result2.add(new ArrayList<>(path));
            }
            return;
        }
        String sub = s.substring(pivot, i + 1);
        if (isPalindrome(sub)) {
            path.add(sub);
            helper(s, i + 1, i + 1, path, sum + sub.length());
            path.remove(path.size() - 1);
        }
        helper(s, pivot, i + 1, path, sum);
    }

    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
