// Time - O(2^n) 
// Space - O(n 2 ^ n)

class Solution {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> solution = new ArrayList<>();
		List<Integer> state = new ArrayList<>();
		backtrack(solution, state, nums, 0);
		return solution;
	}

	private void backtrack(List<List<Integer>> solution, List<Integer> state, int[] nums, int start) {
		// isGoal
		solution.add(new ArrayList<>(state));

		for(int i = start; i < nums.length; i++) {
			// add candidate
			state.add(nums[i]);
			// baktrack
			backtrack(solution, state, nums, i + 1);
			//remove
			state.remove(state.size() -1);
		}
	}
}