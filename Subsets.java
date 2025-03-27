import java.util.ArrayList;
import java.util.List;

//Time Complexity : O(2^n)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

//recursion
/*
class Solution {
  List<List<Integer>> res;
  public List<List<Integer>> subsets(int[] nums) {
      res=new ArrayList<>();
      helper(nums,0,new ArrayList<>());
      return res;
  }

  private void helper(int[] nums, int idx, List<Integer> subset){
      if(idx==nums.length){
          res.add(subset);
          return;
      }
      //choose
      List<Integer> l1=new ArrayList<>(subset);
      l1.add(nums[idx]);
      helper(nums,idx+1,l1);

       //not choose
      helper(nums,idx+1,subset);
      
  }
}

//recursion with backtrack
class Solution {
  List<List<Integer>> res;
  public List<List<Integer>> subsets(int[] nums) {
      res=new ArrayList<>();
      helper(nums,0,new ArrayList<>());
      return res;
  }

  private void helper(int[] nums, int idx, List<Integer> subset){
      if(idx==nums.length){
          res.add(new ArrayList<>(subset));
          return;
      }
      //choose
      subset.add(nums[idx]);
      helper(nums,idx+1,subset);
      subset.remove(subset.size()-1);

       //not choose
      helper(nums,idx+1,subset);
      
  }
}*/
/*
//for loop recursion with backtrack
class Solution {
  List<List<Integer>> res;
  public List<List<Integer>> subsets(int[] nums) {
      res=new ArrayList<>();
      helper(nums,0,new ArrayList<>());
      return res;
  }

  private void helper(int[] nums, int pivot, List<Integer> subset){
      res.add(new ArrayList<>(subset));
      for(int i=pivot;i<nums.length;i++){
          subset.add(nums[i]);
          helper(nums,i+1,subset);
          subset.remove(subset.size()-1);

          //bruteforce again
          // List<Integer> l1=new ArrayList<>(subset);
          // l1.add(nums[i]);
          // helper(nums,i+1,l1);

      }
  }
}
*/

//add one element to list, make its possible lists. Then add another element to this list of list. This way go till last element.
class Subsets {
  
  public List<List<Integer>> subsets(int[] nums) {
      List<List<Integer>> res=new ArrayList<>();
      res.add(new ArrayList<>());
      for(int i=0;i<nums.length;i++){
          int len=res.size();
          for(int j=0;j<len;j++){
              List<Integer> l1=new ArrayList<>(res.get(j));
              l1.add(nums[i]);
              res.add(l1);
          }
      }
      return res;
  }
}
