// Time Complexity : O(n*2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class Subsets {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        
        getSubsets(nums, 0, new ArrayList<>());
        
        return res;
    }
    
    private void getSubsets(int[] nums, int index, List<Integer> temp) {
        res.add(new ArrayList<>(temp));
        
        for(int i=index;i<nums.length;i++) {
            temp.add(nums[i]);
            getSubsets(nums, i+1, temp);
            temp.remove(temp.size()-1);
        }
    }
}
