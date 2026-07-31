// Time Complexity : O(2^n) where n is the number of elements in the input array. This is because for each element, we have two choices: include it in a subset or exclude it.
// Space Complexity : O(n) where n is the number of elements in the input array. This is the space required to store all possible subsets.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
// Your code here along with comments explaining your approach : subsets are generated iteratively by starting with an empty subset and for each number in the input array, we create new subsets by adding that number to all existing subsets. This way, we build up all possible combinations of subsets.
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int size = result.size();
            for (int j = 0; j < size; j++) {
                List<Integer> temp = new ArrayList<>(result.get(j));
                temp.add(nums[i]);
                result.add(temp);
            }
        }
        return result;
    }
}