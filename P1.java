//time-o(2^n)
//space-o(n)

class Solution {
     List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
      
        result = new ArrayList<>();
      //null check
      if(nums == null)
        return result;
        
       helper(nums, 0, new ArrayList<>());
        
        return result;
    }
    
    public void helper(int[] nums, int index, List<Integer> path)
    {
       
        result.add(new ArrayList<>(path));
       
        for(int i= index; i<nums.length; i++){
        
            //action
              path.add(nums[i]);
            //recurse
              helper(nums, i+1, path);        
            //backtrack
            path.remove(path.size()-1);
        }
        
    }
}