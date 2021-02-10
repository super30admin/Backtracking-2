// Time Complexity : O(2^n)
// Space Complexity : O(2^n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
public class Subsets {
    class Solution {
        List<List<Integer>> result;
        public List<List<Integer>> subsets(int[] nums) {
            
            // if(nums)
            result = new ArrayList<>();
            helper(nums,0,new ArrayList<Integer>());
            return result;
        }
        
        public void helper(int [] nums,int index,List<Integer> subset)
        {
              if(index==nums.length)
              {
                  List<Integer> temp = new ArrayList<>(subset);
                  result.add(temp);
                  return;
              }
            
              subset.add(nums[index]);
              helper(nums, index+1,subset);
              subset.remove(subset.size()-1);
              helper(nums, index+1,subset);        
        }
        
        
    }
}
