
import java.util.*;

// Time Complexity : O(2^n) where n is the length of the input array
// Space Complexity : O(n) for the recursion stack and the result list 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//O1 Recursion
class Subset1 {
    List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        helper(nums, new ArrayList<>(), 0);
        return result;
    }

    private void helper(int[] nums, List<Integer> path, int idx) {
        if (idx == nums.length) {
            result.add(path);
            return;
        }

        // not choose
        helper(nums, new ArrayList<>(path), idx + 1);
        // choose
        List<Integer> temp = new ArrayList<>(path);
        temp.add(nums[idx]);
        helper(nums, new ArrayList<>(temp), idx + 1);
    }
}

// O1 Recursion with Backtracking
class Subsets2 {
    List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        helper(nums, new ArrayList<>(), 0);
        return result;
    }

    private void helper(int[] nums, List<Integer> path, int idx) {
        if (idx == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        // not choose
        helper(nums, path, idx + 1);
        // choose
        List<Integer> temp = new ArrayList<>(path);
        temp.add(nums[idx]);
        helper(nums, temp, idx + 1);
        temp.remove(temp.size() - 1);
    }
}

// For loop recursion
class Subsets3 {
    List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        helper(nums, new ArrayList<>(), 0);
        return result;
    }

    private void helper(int[] nums, List<Integer> path, int idx) {
        result.add(new ArrayList<>(path));

        for (int i = idx; i < nums.length; i++) {
            path.add(nums[i]);
            helper(nums, path, i + 1);
            path.remove(path.size() - 1);
        }
    }
}

// Iterative approach
// Time Complexity : O(2^n) where n is the length of the input array
// Space Complexity : O(n) for the result list
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int n : nums) {
            int size = result.size();

            for (int i = 0; i < size; i++) {
                List<Integer> list = new ArrayList<>(result.get(i)); // if you don't use new ArrayList here, // Modifies
                                                                     // the original subset in result
                list.add(n);
                result.add(list);
            }
        }
        return result;
    }
}