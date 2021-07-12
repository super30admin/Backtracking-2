// time: 2^N
// space: N
class subsets{
    //RECURSIVE
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;
        helper(nums, 0, new ArrayList<>());
        return result;
    }

    private void helper(int[] nums, int index, List<Integer> path){
        //base
        if(index == nums.length){
            result.add(path);
            return;
        }

        // logic
        // not choose
        helper(nums, index + 1, new ArrayList<>(path));

        // choose
        path.add(nums[index]);
        helper(nums, index + 1, new ArrayList<>(path));
    }


    //BACTRACK
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;
        backtrack(nums, 0, new ArrayList<>());
        return result;
    }

    private void backtrack(int[] nums, int index, List<Integer> path){
        //base
        if(index == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }

        // logic
        // not choose
        backtrack(nums, index + 1, path);

        // choose
        path.add(nums[index]);
        backtrack(nums, index + 1, path);

        //bactrack
        path.remove(path.size()-1);
    }
}