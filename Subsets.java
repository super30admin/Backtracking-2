/**
 * Time Complexity: O(2 ^ N)??
 * Space Complexity: O(n)
 * Runs on Leetcode: yes
 * Problems Solving: 
 *      Still a bit confused on how backtracking code is working.
 *      I got this answer through trial and error
 *      I will have to practice more problems to better my understanding
 */
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<Integer>());
        return result;
    }
    private void backtrack(int[] nums, int index, List<Integer> current){
        current.add(nums[index]);
        result.add(new ArrayList<>(current));
        List<Integer> temp = new ArrayList<>(current);
        temp.remove(0);
        result.add(temp);
        for(int i = index + 1; i < nums.length; i++) {
            backtrack(nums, i, current);
        }
        current.remove(current.size() - 1);
    }
}
