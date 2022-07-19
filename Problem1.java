// Time Complexity : O(N * 2^N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes

//Problem statement: https://leetcode.com/problems/subsets/

class Problem1 {
        List<List<Integer>> output = new ArrayList();
        int n, k;

        public void backtrack(int first, ArrayList<Integer> curr, int[] nums) {
            if (curr.size() == k) {
                output.add(new ArrayList(curr));
                return;
            }
            for (int i = first; i < n; ++i) {
                curr.add(nums[i]);
                backtrack(i + 1, curr, nums);
                curr.remove(curr.size() - 1);
            }
        }

        public List<List<Integer>> subsets(int[] nums) {
            n = nums.length;
            for (k = 0; k < n + 1; ++k) {
                backtrack(0, new ArrayList<Integer>(), nums);
            }
            return output;
        }
    }