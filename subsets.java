// Time Complexity : O(2^N)
// Space Complexity : O(2^N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// TC = O(2^N), SC = O(2^N)
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return result;
    }
    // recursion backtracking
    public void helper(int[] nums, int index, List<Integer> path) {
        // base
        if(index == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        // recurse
        // no choose
        helper(nums, index + 1, path);
        // choose
        path.add(nums[index]); // action
        helper(nums, index + 1, path); // recurse
        path.remove(path.size() - 1); // backtrack
    }   
} 
    // 0/ 1 recursion
    // public void helper(int[] nums, int index, List<Integer> path) {
    //     // base
    //     if(index == nums.length) {
    //         result.add(path);
    //         return;
    //     }
        // logic
        // // no choose
        // helper(nums, index + 1, new ArrayList<>(path));
        // // choose
        // path.add(nums[index]);
        // helper(nums, index + 1, new ArrayList<>(path));
        
        // if we are choosing first create temp as we are using the same list at each call
        // choose
        // List<Integer> temp = new ArrayList<>(path);
        // temp.add(nums[index]);
        // helper(nums, index + 1, temp);
        // // no choose
        // helper(nums, index + 1, new ArrayList<>(path));
    //}
 
// }
    // for loop based recursion (No backtrack)
//     private void helper(int[] nums, int index, List<Integer> path) {
//     // base ~ no base condition
//     // logic
//     result.add(path);
//     for(int i = index; i < nums.length; i++) {
//         // action
//         List<Integer> temp = new ArrayList<>(path);
//         temp.add(nums[i]);
//         // recurse
//         helper(nums, i + 1, temp);
//         }
//     }
// }

// without recursion.. same Time & Space O(2^N)
// class Solution {
//     List<List<Integer>> result;
//     public List<List<Integer>> subsets(int[] nums) {
//         result = new ArrayList<>();
//         result.add(new ArrayList<>()); // putting 1st[[]] to start copying and adding
//         for(int i = 0; i < nums.length; i++) {
//             int size = result.size();
//             for(int j = 0; j < size; j++) {
//                 List<Integer> temp = new ArrayList<>(result.get(j));
//                 temp.add(nums[i]);
//                 result.add(temp);
//             }
//         }
//         return result;
//     }
// }