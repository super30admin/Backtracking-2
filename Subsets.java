class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {

        List<Integer> path = new ArrayList<>();
        helper(nums, path, 0);
        return result;
    }

    public void helper(int[] nums, List<Integer> path, int i){

        //base
        if(i == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }

        //logic
        //0
        helper(nums, path, i+1);

        //1
        path.add(nums[i]);
        helper(nums, path, i+1);

        path.remove(path.size() - 1);
    }
}