// Recursive Solution
// Time Complexity:
// Space COmplexity:
class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return res;
        }
        helper(nums, 0 , new ArrayList<>());
        return res;
    }

    private void helper(int[] nums, int index, List<Integer> temp) {
        res.add(temp);

        if(index >= nums.length) {
            return;
        }

        for(int i = index; i < nums.length; i++) {
            List<Integer> list = new ArrayList<>(temp);
            temp.add(nums[i]);
            helper(nums, i+1, list);
        }
    }
}

// Bactracking Approach
// Time COmplexity: O(2^n)
// Space Complexity with recursive stack:
// Space Complexity without recursive stack:
 class Solution {
     public List<List<Integer>> subsets(int[] nums) {
         List<List<Integer>> res = new ArrayList<>();
         if(nums == null || nums.length == 0) {
             return res;
         }
         helper(nums, 0 , new ArrayList<>(), res);
         return res;
     }

     private void helper(int[] nums, int index, List<Integer> list, List<List<Integer>> res) {
         res.add(new ArrayList<>(list));
         if(index >= nums.length) {
             return;
         }

         for(int i = index; i < nums.length; i++) {
             list.add(nums[i]);
             helper(nums, i+1, list, res);
             list.remove(list.size() - 1);
         }
     }
 }