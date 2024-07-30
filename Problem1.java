//Time = O(2^N)
//Space = O(2^N)

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // Initialize an empty list to store all the possible subsets
        List<List<Integer>> result = new ArrayList<>();
        // Call the recursive backtrack function with an empty temporary list and a starting index of 0
        backtrack(result, new ArrayList<>(), nums, 0);
        // Return the list of subsets
        return result;
    }
    
    // Recursive function to generate all possible subsets
    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start) {
        // Add the current subset (represented by tempList) to the list of subsets
        result.add(new ArrayList<>(tempList));
        // Iterate over the remaining elements in the array
        for (int i = start; i < nums.length; i++) {
            // Add the current element to the temporary list
            tempList.add(nums[i]);
            // Recursively call the backtrack function with the next element and an updated temporary list
            backtrack(result, tempList, nums, i + 1);
            // Remove the last element from the temporary list to backtrack and try other possibilities
            tempList.remove(tempList.size() - 1);
        }
    }
}
