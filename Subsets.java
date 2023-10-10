class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        recursion(nums, 0, new ArrayList<>());
        return result;
    }
    private void recursion(int[] nums, int index, List<Integer> path) {
        //base
        if(index == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        //logic
        recursion(nums, index+1, path);
        path.add(nums[index]);
        recursion(nums, index+1, path);
        path.remove(path.size() - 1);
    }
}