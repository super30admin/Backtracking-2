# Time complexity:O(2^n)
# Space complexity: 0(2^n)
# Did code run successfully on leetcode: yes
# Any problem you faced: No


class Solution {
    public List<List<Integer>> subsets(int[] nums) {
       List<List<Integer>> solution = new LinkedList<>();
       List<Integer> state = new LinkedList<>();
        backtrack(solution, state, nums, 0);
        return solution;
    }

    private void backtrack(List<List<Integer>> solution, List<Integer> state, int[] nums, int cursor){

    solution.add(new LinkedList<>(state));

    for(int i = cursor; i<nums.length; i++){
        state.add(nums[i]);
        backtrack(solution, state, nums, i + 1);
        state.remove(state.size() - 1);
    }


    }
}