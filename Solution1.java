class Solution {

    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return result;    
    }

    private void helper(int[] nums, int i, List<Integer> path){

       //basecase
        if(i == nums.length)
        {
            result.add(new ArrayList<>(path));
            return;

        }

        //no chose case
        helper(nums, i + 1, path);

        //action
        path.add(nums[i]);

        //chose case
        helper(nums, i + 1, path);

        //backtrack
        path.remove(path.size()-1);

    }


}