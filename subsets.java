class Solution {
    public ListListInteger subsets(int[] nums) {
        ListListInteger result = new ArrayList();
        
        ListInteger state = new ArrayList();
        
        backtrack(result, state, nums, 0);
        
        return result;
    }
    private void backtrack(ListListInteger result, ListInteger state, int[] nums, int index)
    {
        result.add(new ArrayList(state));
         if(result.contains(state)){
             return;
         }
        
        for(int i=index; inums.length; i++)
        {
            state.add(nums[i]);
            backtrack(result, state, nums, i+1);
            state.remove(state.size()-1);
        }  
    }
}