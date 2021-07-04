//Time Complexity - O(n*2^n)
//Space complexity - O(n)

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
      result = new ArrayList<>();
      if(nums == null || nums.length == 0) return result;
      
      helper(nums,0,new ArrayList<>());
      return result;
    }
  
    private void helper(int[] nums, int index, List<Integer> path) {
      //base case
      if(index == nums.length) {
        result.add(path);
        return;
      }
      
      //not choose the number
      helper(nums, index + 1, new ArrayList<>(path));
      
      //choose the number
      //add the number in to the path
      path.add(nums[index]);
      helper(nums, index+1, new ArrayList<>(path));
    }
}