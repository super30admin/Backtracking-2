//Time Complexity - O(2^n), where n is the num of elements in nums 
//Space Complexity - O(n)
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        recurse(nums,0, new ArrayList<>());
        return result;
       
    }
    private void recurse(int[] nums, int index, List<Integer> path){
        //base
        result.add(new ArrayList<>(path));
        //logic
        for(int i = index; i < nums.length; i++){
            //action
            path.add(nums[i]);
            //recurse
            recurse(nums, i + 1, path);
            //backtrack
            path.remove(path.size() - 1);
        }
    }
}