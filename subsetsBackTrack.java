// Time Complexity: O(2^n)
//Space Complexity: O(2^n)

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if(nums.length == 0 || nums == null) return result;
        
        helper(nums, 0, new ArrayList<>());
        return result;
    }
    
    private void helper(int[] nums, int index, List<Integer> path){
        
    //base
        if(index == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }    
    //logic    
        //not choose
        helper(nums, index + 1, path);
        
        //choose
        //action
        path.add(nums[index]);
        //recurse
        helper(nums, index + 1, path);
        //backtrack
        path.remove(path.size() - 1);
    }
}