/**
 * LeetCode Execution: Smooth
 * 
 * Time Complexity: O()
 * Space Complexity: O(1), Not accounting for the output
 * 
 * 
 */

public class Solution {
  public List<List<Integer>> subsets(int[] nums) {
      List<List<Integer>> res = new ArrayList<List<Integer>>();
      List<Integer> subset = new ArrayList<Integer>();
      res.add(subset);
      
      Arrays.sort(nums);
      doSubsets(nums,res,subset,0);
      return res;
  }
  
  private void doSubsets(int[] nums, List res,List subset,int start){
      if(start != nums.length){
          for(int i=start; i<nums.length; i++){
              subset.add(nums[i]);
              res.add(new ArrayList(subset));
              doSubsets(nums,res,subset,i+1);
              subset.remove(subset.get(subset.size()-1));
          }
      }
  }
}