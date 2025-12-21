// Time Complexity: O(n * 2^n), n = length of input array, because each element can double the number of subsets
// Space Complexity: O(2^n), to store all subsets
// 1. Start with an empty subset and iteratively build all subsets by adding each number to existing subsets.
// 2. For each number, copy all existing subsets, add the current number, and append to the result.
// 3. At the end, the result contains all possible subsets of the input array.

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>()); // start with empty subset

        for (int num : nums) {
            int resultSize = result.size();
            for (int j = 0; j < resultSize; j++) {
                List<Integer> temp = new ArrayList<>(result.get(j)); // make a copy
                temp.add(num); // add current number
                result.add(temp);
            }
        }

        return result;
    }
}