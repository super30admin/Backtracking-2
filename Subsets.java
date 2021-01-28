// TC: O(N ^ 2^N)
// SC: O(N ^ 2^N)
// Did it run successfully on Leetcode? : Yes
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList();
        if ( nums == null || nums.length == 0)
            return result;
        helper(nums, 0, new ArrayList());
        
        return result;
    }
    private void helper(int[] nums, int pivotIndex, List<Integer> path)
    {
        result.add(new ArrayList(path));
        //logic
         //choose
        // action
        for ( int i = pivotIndex; i < nums.length; i++)
        {
            // action
             path.add(nums[i]);
            // recurse
             helper(nums, i+1, path);
            // backtrack
             path.remove(path.size()-1);
        }
    }
}


// TC: O(N ^ 2^N)
// SC: O(N ^ 2^N)
// Did it run successfully on Leetcode? : Yes
// class Solution {
//     List<List<Integer>> result;
//     public List<List<Integer>> subsets(int[] nums) {
//         result = new ArrayList();
//         if ( nums == null || nums.length == 0)
//             return result;
//         helper(nums, 0, new ArrayList());
        
//         return result;
//     }
//     private void helper(int[] nums, int index, List<Integer> path)
//     {
//         //base
//         if (index == nums.length)
//         {
//             result.add(new ArrayList(path));
//             return;
//          }
        
//         //logic
//          //choose
//         // action
//         path.add(nums[index]);
//         //recurse
//         helper(nums, index+1, path);
//         //backtrack
//         path.remove(path.size()-1);
        
//         //dont choose
//         helper(nums, index+1, path);
        
//     }
// }
