class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        this.result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return result;
    }
    private void helper(int[] nums, int index, List<Integer> path){
        if(index==nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        helper(nums, index+1, path);

        path.add(nums[index]);

        helper(nums, index+1, path);

        path.remove(path.size()-1);
    }
}
