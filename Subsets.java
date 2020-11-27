/**
 * Time Complexity: O(2 ^ N)??
 * Space Complexity: O(n)
 * Runs on Leetcode: yes
 * Problems Solving: 
 */
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<Integer>());
        return result;
    }
    private void backtrack(int[] nums, int index, List<Integer> current){
        result.add(new ArrayList<>(current));
        for(int i = index; i < nums.length; i++){
            current.add(nums[i]);
            backtrack(nums, i+1, current);
            current.remove(current.size() - 1);
        }
    }
}
