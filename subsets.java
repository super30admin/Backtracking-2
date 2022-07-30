// TC : O(2^n)
// SC : O(h)

class Solution {
    List<List<Integer>> result;
      public List<List<Integer>> subsets(int[] nums) {
      
          result = new ArrayList<>();
          if(nums == null || nums.length == 0) return result;
          helper(nums,0,new ArrayList<>());
          return result;
      }
      
      private void helper(int[] nums, int index, List<Integer> path){
          
          if(index == nums.length){
              result.add(new ArrayList<>(path));
              return;
          }
          // did not choose
          helper(nums,index+1,path);
          // did choose
          path.add(nums[index]);
          helper(nums,index+1,path);
          // backtracking
          path.remove(path.size()-1);
      }
  }