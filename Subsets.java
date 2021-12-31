// Time Complexity : exponential
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

// Approach 

// We see that for each candidate we have two choices, take or not take
// we write the recursive approach for the same

class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return result;
        helper(nums, 0, new ArrayList<>());
        return result;
    }

    private void helper(int[] nums, int index, List<Integer> path) {
        if (index == nums.length) {
            result.add(path);
            return;
        }

        helper(nums, index + 1, path);
        List<Integer> newList = new ArrayList<>(path);
        newList.add(nums[index]);
        helper(nums, index + 1, newList);
    }
}

// Time Complexity : exponential
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

// Approach

// We see that for each candidate we have two choices, take or not take
// we write the iterative recursive approach for the same
// we expand on it by doing the backtracking i.e remove the element that doesnt
// give the answer
class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return result;
        helper(nums, 0, new ArrayList<>());
        return result;
    }

    private void helper(int[] nums, int index, List<Integer> path) {
        result.add(new ArrayList(path));
        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            helper(nums, i + 1, path);
            path.remove(path.size() - 1);
        }
    }
}

// Time Complexity : exponential
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

// Approach

// We see that for each candidate we have two choices, take or not take
// we write an iterative approach for this
// We iterate through the numbers and put them in the result and when we got to
// next number we append it to the previous list
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return result;
        result.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int size = result.size();
            for (int j = 0; j < size; j++) {
                List<Integer> newList = new ArrayList<>(result.get(j));
                newList.add(nums[i]);
                result.add(newList);
            }
        }
        return result;
    }
}