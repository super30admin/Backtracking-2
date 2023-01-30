// Time Complexity : O(N 2^N), N - no of elements
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Subsets {
    private List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return result;
    }

    private void helper(int[] nums, int idx, List<Integer> path) {
        if (idx == nums.length) {
            result.add(path);
            return;
        }
        helper(nums, idx + 1, path);
        List<Integer> sublist = new ArrayList<>(path);
        sublist.add(nums[idx]);
        helper(nums, idx + 1, sublist);
    }
}

// Time Complexity : O(2^N), N - no of elements
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class SubsetsRecBactrack {
    private List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return result;
    }

    private void helper(int[] nums, int idx, List<Integer> path) {
        if (idx == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        helper(nums, idx + 1, path);
        path.add(nums[idx]);
        helper(nums, idx + 1, path);
        path.remove(path.size() - 1);
    }
}

// Time Complexity : O(2^N), N - no of elements
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class SubsetsForLoopBasedBactrack1 {
    private List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();

        helper(nums, 0, new ArrayList<>());

        return result;
    }

    private void helper(int[] nums, int pivot, List<Integer> path) {
        result.add(new ArrayList<>(path));
        for (int i = pivot; i < nums.length; i++) {
            path.add(nums[i]);
            helper(nums, i + 1, path);
            path.remove(path.size() - 1);
        }

    }
}


// Time Complexity : O(2^N), N - no of elements
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class SubsetsForLoopBasedBactrack2 {
    private List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return result;
    }

    private void helper(int[] nums, int pivot, List<Integer> path) {
        result.add(path);
        for (int i = pivot; i < nums.length; i++) {
            List<Integer> sublist = new ArrayList<>(path);
            sublist.add(nums[i]);
            helper(nums, i + 1, sublist);
        }
    }
}


// Time Complexity : O(2^N), after every index the no of ways double
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class SubsetsIterative {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        result.add(new ArrayList<>());

        for (int i = 0; i < nums.length; i++) {
            int size = result.size();
            for (int j = 0; j < size; j++) {
                List<Integer> sublist = new ArrayList<>(result.get(j));
                sublist.add(nums[i]);
                result.add(sublist);
            }
        }

        return result;
    }
}