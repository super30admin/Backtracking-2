class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        this.result = new ArrayList<>();
        helper(nums, 0 , new ArrayList<>());
        return result;
    }

    private void helper(int[] nums, int i, List<Integer> path){
        //base
        if(i == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        //logic
        //not choose

        helper(nums, i+1, path);
        //choose
        //action
        path.add(nums[i]);
        helper(nums, i+1, path);//recurse

        //backtrack
        path.remove(path.size() - 1);

    }
}