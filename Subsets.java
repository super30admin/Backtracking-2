//Time Complexity : exponential
//Space Complexity : O(N)
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        backtrack(nums, 0 ,new ArrayList<>());
        return result;
    }
    public void backtrack(int[] nums, int index, List<Integer> path){
        //base

        result.add(new ArrayList<>(path));
        for(int i = index; i<nums.length;i++){
            //action
            path.add(nums[i]);
            //recurse
            backtrack(nums,i+1,path);
            //backtrack
            path.remove(path.size()-1);
        }
    }
}