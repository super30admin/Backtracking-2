
// Time Complexity : Add : O(2^(n))
// Space Complexity : O(M)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        result.add(new ArrayList<>());
        
        for(int i=0; i<nums.length; i++){
            int k = result.size();
            for(int j = 0; j<k; j++){
                List<Integer> temp = new ArrayList<>(result.get(j));
                temp.add(nums[i]);
                result.add(temp);
            }
        }
        
        return result;
    }
}
