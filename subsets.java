//time O(2^n) n is size of array
//space O(n)

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return result;
        
    }
    
    private void helper(int[] nums, int pivot, List<Integer> path) {
        //base
        if(pivot == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        
        //logic
        result.add(new ArrayList<>(path));
        for(int i = pivot; i < nums.length; i++) {
            
            path.add(nums[i]);
            helper(nums, i+1, path);
            path.remove(path.size()-1);
        }
    }
}
