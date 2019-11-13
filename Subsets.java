/**
 * Time Complexity: O(2 ^ N)??
 * Space Complexity: O(n)
 * Runs on Leetcode: yes
 * Problems Solving: 
 *  I had to walk through the solution a couple of times to understand how backtracking was working
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
        
        for(int i = index + 1; i < nums.length; i++){
            // recursive step
            backtrack(nums, i, current);
        }
        // backtracking step
        current.remove(current.size() - 1);
    }
}
