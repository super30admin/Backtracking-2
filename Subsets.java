//TC : O(2^N) 
//SC : O(N) // where N is the max stack size of the recurrsion  
//run successfully on Leetcode 
//no problems in solving

//picked up every num and went through all the possibilities of 
//pick and not pick; i used here global variables for the array,
//lists to save the memory and time while recursion;

class Solution {
    List<List<Integer>> ans;
    List<Integer> list;
    int nums[];

    public List<List<Integer>> subsets(int[] nums1) {
        nums = nums1;
        ans = new ArrayList<>();
        list = new ArrayList<>();
        helper(0);
        return ans;
    }

    public void helper(int ind) {
        // base case
        if (ind == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        // logic
        helper(ind + 1);
        list.add(nums[ind]);
        helper(ind + 1);
        list.remove(list.size() - 1);
    }
}