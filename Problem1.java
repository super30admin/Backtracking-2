class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new LinkedList<>();
        List<Integer> state=new ArrayList<>();
        
        backtrack(nums,result,state,0);
        return result;
    }
    
    private void backtrack(int[] nums,List<List<Integer>> result,List<Integer> state,int index){
        
        result.add(new LinkedList<>(state));
        
         for(int i=index;i<nums.length;i++){
            state.add(nums[i]);
            backtrack(nums,result,state,i+1);
            state.remove(state.size()-1);
        }
        
    }
}