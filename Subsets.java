
class Subsets {

  // Time Complexity : O(2ˆN)
  // Space Complexity : O(lg(N))
  // Did this code successfully run on Leetcode : YES
  // Any problem you faced while coding this : No

  // Using bruteforce approach
  // pass new list at each node
  List<List<Integer>> result;
   public List<List<Integer>> subsets(int[] nums) {
       result = new ArrayList<>();
       if(nums == null || nums.length == 0) return result;

       helper(nums, 0, new ArrayList<>());

       return result;
   }

   // without backtracking
   private void helper(int[] nums, int index, List<Integer> path){
       // base
       if(index >= nums.length ){
           result.add(path);
           return;
       }
       // logic
       // no choose
       helper(nums, index+1, new ArrayList<>(path));

       // choose
       path.add(nums[index]);
       helper(nums, index+1, new ArrayList<>(path));
   }

   // with backtracking
   private void helper(int[] nums, int index, List<Integer> path){
      // base
      if(index >= nums.length ){
          result.add(path);
          return;
      }

      // logic
      // no choose
      helper(nums, index+1, path);

      // choose
      path.add(nums[index]);
      List<Integer> temp = new ArrayList(path);
      helper(nums, index+1, temp);

      // backtrack
      path.remove(path.size() -1 );
  }
}
