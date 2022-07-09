// Time Complexity: O(2^n)
// Space Complexity: O(n)
class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res=new ArrayList<>();
        if(nums==null || nums.length==0) return res;
        helper(nums,0,new ArrayList<>());
        return res;
    }
    
    private void helper(int[] nums, int i, List<Integer> pathSoFar){
        // base
        if(i==nums.length) {
             res.add(pathSoFar);
            return;
        }
       
        //no choose
        helper(nums,i+1,new ArrayList<>(pathSoFar));
        //choose
        pathSoFar.add(nums[i]);
        helper(nums,i+1,new ArrayList<>(pathSoFar));
    }
}
