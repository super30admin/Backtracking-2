public class Subsets {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length == 0) return result;
        backtrack(nums, 0, new ArrayList<>());
        return result;
    }
    
    private void backtrack(int[] nums, int idx, List<Integer> path){
        // base
        result.add(new ArrayList<>(path));
        if(idx == nums.length){
            return;
        }
        
        // logic
        for(int i=idx; i<nums.length;i++){
            path.add(nums[i]);
            backtrack(nums, i+1, path);
            path.remove(path.size()-1);
        }
    }
}
