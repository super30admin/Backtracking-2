//Time Complexity: O(2^N)
//Space Complexity: O(N)

class Solution {
    
    List<List<Integer>> result;
    
    public List<List<Integer>> subsets(int[] nums) {
        
        result = new ArrayList<>();
            
        if(nums==null || nums.length==0)
        {
            return result;
        }
        
        helper(nums,0,new ArrayList<>());
        
        return result;
    }
    
    private void helper(int nums[],int index,List<Integer> path)
    {
        //base
        result.add(new ArrayList<>(path));
        
        //logic
        
        for(int i=index;i<nums.length;i++)
        {
            //action
            path.add(nums[i]);
            
            //recurse
            helper(nums,i+1,path);
            
            //backtrack
            path.remove(path.size()-1);
        }
        
        return;
    }
}