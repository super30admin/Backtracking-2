class Solution {
    public List<List<Integer>> subsets(int[] nums) {
         List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start) {
        // Add the current subset to the result list
        result.add(new ArrayList<>(tempList));
        
        // Explore further elements to include in the subset
        for (int i = start; i < nums.length; i++) {
            // Include nums[i] in the current subset
            tempList.add(nums[i]);
            // Move to the next element
            backtrack(result, tempList, nums, i + 1);
            // Backtrack: Remove the last element added
            tempList.remove(tempList.size() - 1);
        }
    }
}
