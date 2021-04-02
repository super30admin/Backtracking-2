//Time Complexity : 2^n
//Space complexity : O(n)

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if(nums== null || nums.length == 0) return result;
        
        helper(nums, new ArrayList<>(), 0);
        
        return result;
    }
    
    private void helper(int[] nums, List<Integer> temp, int index) {
        //base
        
            result.add(new ArrayList<>(temp));
        
        //logic
        for(int i=index; i<nums.length; i++){
            //action
        temp.add(nums[i]);
            //recurse
            helper(nums,temp, i+1);
            //backtrack
        temp.remove(temp.size()-1);
        }
    }
}