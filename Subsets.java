//Time Complexity: O(2^n)
//Space Complexity: O(2^n)

class Solution {
    
   List<List<Integer>> result = null;
    
    public List<List<Integer>> subsets(int[] nums) {
        
        result = new ArrayList<>();
        
        if(nums == null || nums.length == 0)
            return result;
        
        helper(nums, 0, new ArrayList<>());
        
        return result;
        
    }
    
    
    private void helper(int[] nums, int index, List<Integer> temp)
    {
        
        result.add(new ArrayList<>(temp));
       
        //chose it
        helper(nums, index, temp)
        temp.add(nums[index]);
            
        helper(nums, index, temp)
        
    }
}


//Backtracking
class Solution {
    
   List<List<Integer>> result = null;
    
    public List<List<Integer>> subsets(int[] nums) {
        
        result = new ArrayList<>();
        
        if(nums == null || nums.length == 0)
            return result;
        
        backtrack(nums, 0, new ArrayList<>());
        
        return result;
        
    }
    
    
    private void backtrack(int[] nums, int index, List<Integer> temp)
    {
        
        result.add(new ArrayList<>(temp));
        for(int i=index; i<nums.length; i++)
        {
            temp.add(nums[i]);
            backtrack(nums, i+1, temp);
            temp.remove(temp.size()-1);
        }
        
    }
}
