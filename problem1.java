class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        
        result = new ArrayList<>();
        result.add(new ArrayList());
        helper(nums,0,new ArrayList());
        return result;
    }
    
    private void helper(int[] nums, int index,List<Integer> curr){
       
        if(index == nums.length){
            return;
        }
        
        for(int i=index;i<nums.length;i++){
            
            curr.add(nums[i]);
            result.add(new ArrayList(curr));
            helper(nums,i+1,curr);
            curr.remove(curr.size()-1);
        }
        
    }
}