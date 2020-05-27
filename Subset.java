public class Subset {

    
//Time complexisty: O(N*2^N) where N is size of array
//space complexity: O(N*2^N)

//Approach
/**
 * 1. 
 */ 

    public List<List<Integer>> subsets(int[] nums) {
     
        Set<List<Integer>> list = new HashSet<>();
        
        if(nums == null || nums.length == 0)
            return new ArrayList<>(list);
        
        helper(nums, 0, new ArrayList<>(), list);
        
        return new ArrayList<>(list);
        
    }
    
    private void helper(int[] nums, int index, List<Integer> list, Set<List<Integer>> result) {
        
        //Base
        if(list != null)
            result.add(new ArrayList<>(list));
        
        //Logic
        for(int i = index; i < nums.length; i++) {
            
            list.add(nums[i]);
            helper(nums, i+1, list, result);
            list.remove(list.size()-1);
            
        }
        
    }
    
}