class Solution {
    /*
        TC - O(n * 2^n) - 
        n is the length of the input array, 
        2^n is the number of subsets, and n is for copying the list to the result
        SC - O(n) - for the recursion stack

        Solution uses backtracking to generate all possible subsets. 
        At each index, it makes two recursive choices:
        Exclude the current element and recurse.
        Include the current element, recurse, then remove it (backtrack) to restore the previous state.
        When the recursion reaches the end of the array (index == nums.length), 
        the current subset is copied and added to the result.
    */
    List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        this.result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return result;
    }

    private void helper(int[] nums, int index, List<Integer> list) {
        if (index == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        helper(nums, index + 1, list);

        list.add(nums[index]);
        helper(nums, index + 1, list);
        list.remove(list.size() - 1);
    }
}