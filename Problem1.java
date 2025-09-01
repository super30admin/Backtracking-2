// Did not face any problem while running code
// TC: O(2^n * n)
// SC: O(n)
class Solution {

    // Have a Result List
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return result;
    }

    public void helper(int[] nums, int i, List<Integer> path) {
        // If length of array is equal to i then append to result
        if(i == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        // Iterte from i+1 node
        helper(nums, i+1, path);
        
        path.add(nums[i]);
        // choose, Also should be i+1
        helper(nums, i+1, path);
        // Backtrack
        path.remove(path.size()-1);
    }
}