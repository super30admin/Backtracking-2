// Time Complexity = 2^k
// Space Complexity = 

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return result;
    }
    
    private void helper (int[] nums, int idx, List<Integer> path){
        // base
        if(idx == nums.length +1){
            //result.add(new ArrayList<>(path));
            return;
        }
        result.add(new ArrayList<>(path));
        for(int i = idx; i< nums.length; i++){
            //action
            path.add(nums[i]);
            //recurse 
            helper(nums, i+1, path);
            //backtrack
            path.remove(path.size() -1);
        }
        
    }
}