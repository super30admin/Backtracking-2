// Time Complexity :O(n2)
// Space Complexity :
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :Understanding the solution

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
      List<List<Integer>> result = new ArrayList();
      result.add(new ArrayList());
      for(int n:nums){
          int size = result.size();
          for(int i=0;i<size;i++){
              List<Integer> sublist = new ArrayList(result.get(i));
              sublist.add(n);
              result.add(sublist);
          }
      }
      return result;
    }
}
