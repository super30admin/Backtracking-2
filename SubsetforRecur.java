//Time Complexity - O(n*2^n)
//Space Complexity - O(n)

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
      result = new ArrayList<>();
      if(nums == null || nums.length == 0) return result;
      
      helper(nums,0,new ArrayList<>());
      return result;
    }
  
    private void helper(int[] nums, int index, List<Integer> path) {
     
     result.add(new ArrayList<>(path)); 
     for(int i = index; i< nums.length; i++) {
       //action (add element to the path)
       path.add(nums[i]);
       helper(nums,i+1, path);
       //backtrack the action
       path.remove(path.size()-1);
     }
    }
}