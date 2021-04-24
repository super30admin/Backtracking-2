//Backtracking
//Time Complexity - O(N x 2^N) - where N is the size of the nums
//Space Complexity - O(N)

class Solution {
  List<List<Integer>> result;

  public List<List<Integer>> subsets(int[] nums) {
    result = new ArrayList<>();
    backtrack(nums, new ArrayList<>(), 0);
    return result;
  }

  public void backtrack(int[] nums, List<Integer> path, int index){

    result.add(new ArrayList<>(path));

    for(int i=index; i<nums.length; i++){
      path.add(nums[i]);
      backtrack(nums, path, i+1);
      path.remove(path.size()-1);
    }
  }
}