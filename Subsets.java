class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        helper(nums, res, 0, path);
        return res;
    }
    private void helper(int[] nums, List<List<Integer>> res, int index, List<Integer> path){
        if(index == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        //DoNotChoose
        helper(nums, res, index+1, path);
        
        //Choose 
        path.add(nums[index]);
        helper(nums, res, index+1, path);
        path.remove(path.size()-1);
    }
}