// Time Complexity : O(2^n)
// Space Complexity : O(2^n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Notes : For each element, either choose the element and move to the next element recursively, while adding and removing the elements from the path until the last index is not reached.

public class Subsets {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null) return result;

        helper(nums, 0, new ArrayList<>());
        return result;
    }
    
    private void helper(int[] nums, int index, List<Integer> path){

        if(index == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        
        helper(nums, index+1, path);
        path.add(nums[index]);
        helper(nums, index+1, path);
        path.remove(path.size() - 1);
    }
}
