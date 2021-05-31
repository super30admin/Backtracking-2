//Time complexity O(2pown)
//Space complexity O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
class Solution {
     List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        
       
        
        result = new ArrayList<>();
         if(nums.length == 0 || nums == null){
            
            return result;
        }
        
        helper(nums, new ArrayList(), 0);
        
        
        return result;
    }
    
    private void helper(int[] nums, ArrayList<Integer> path, int index){
        
       result.add(new ArrayList(path));
        
        for(int i = index; i < nums.length; i ++){
            
            //ArrayList<Integer> temp = new ArrayList<>(path);
            path.add(nums[i]);
            helper(nums,path,i+1);
            path.remove(path.size()-1);
            
            
        }
        
        
        //base case
       
        //result.add(path);
       
        //logic
        
        
    }
}