// Time Complexity : O(n * 2^n), exponential
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


public class subsets {
    List<List<Integer>> result;
    int pivot;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();    
        for (pivot = 0; pivot <= nums.length; pivot++){
            backtrack(nums, new ArrayList(), 0);
        }
        return result;
  }

  public void backtrack(int[] nums,List<Integer> list,int index) {
    if (list.size() == pivot) {
      result.add(new ArrayList(list));
      return;
    }
    for (int i = index; i < nums.length; i++) {
       list.add(nums[i]); // add candidate
       backtrack(nums, list, i+1);
       list.remove(list.size() - 1);
    }
  }
}
