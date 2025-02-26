/*
Iterative approach where we start with an empty set and iteratively add new elements to all existing subsets.
Process: For each element in the input array, create new subsets by adding that element to all the current subsets in result. This grows the list of subsets dynamically.
Time Complexity: O(N * 2^N), where N is the number of elements in nums (since there are 2^N subsets).
Space Complexity: O(N * 2^N) because we store all subsets, and each subset can take up to O(N) space.
 */

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());  // Add the empty subset

        for(int n : nums) {  // Loop through each element of nums
            int size = result.size();  // Get the current size of result
            for(int i = 0; i < size; i++) {  // For each subset already in result
                List<Integer> subset = new ArrayList<>(result.get(i));  // Copy the current subset
                subset.add(n);  // Add the new element
                result.add(subset);  // Add the new subset to result
            }
        }

        return result;  // Return the result containing all subsets
    }
}

/*
Backtracking using recursion.
Process: The helper function recursively adds elements to the temp list (representing a subset) and explores all possible subsets by backtracking (removing the last added element after the recursion step). The base case is when all elements have been considered.

Time Complexity: O(N * 2^N), similar to the iterative approach.
Space Complexity: O(N * 2^N) for storing all subsets, plus additional space for recursion stack, which in the worst case would be O(N).
 */

 class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        helper(nums, new ArrayList<Integer>(), 0);  // Start with an empty list and the first index
        return result;
    }

    public void helper(int[] nums, List<Integer> temp, int start) {
        result.add(new ArrayList<>(temp));  // Add the current subset (temp) to result

        for(int i = start; i < nums.length; i++) {  // Start from index 'start' and go to the end
            temp.add(nums[i]);  // Include the current element
            helper(nums, temp, i + 1);  // Recurse with the next index (not including the current element again)
            temp.remove(temp.size() - 1);  // Backtrack (remove the element added before the recursive call)
        }
    }
}