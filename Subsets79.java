import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        List<Integer> state = new ArrayList<>();
        
        backTracking(nums,0,result,state);
        
        return result;    
    }
    
    public void backTracking(int[] nums, int index, List<List<Integer>> result, List<Integer> state){
            
        
        result.add(new ArrayList<>(state));
            
        for(int i =index; i<nums.length; i++){
            
            state.add(nums[i]);
            backTracking(nums,i+1,result,state);
            state.remove(state.size()-1);
            
        }
        
        
            
    }
    
    
    
}