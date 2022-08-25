
//TC = O(2^n)
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return result;
        
    }
    
    
    //Recursion 
    
    private void helper(int[] nums, int i, List<Integer> path){
        //base
        if(i == nums.length) {
            result.add(path);
            return;
        }
        //logic
        //Dont chosse
        helper(nums, i+1, new ArrayList<>(path));
            
        //Choose
        path.add(nums[i]);
        helper(nums, i+1, new ArrayList<>(path));
    }
}




//TC = O(2^n)
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return result;
        
    }
    
    
    //Recursion 
    
    private void helper(int[] nums, int i, List<Integer> path){
        //base
        if(i == nums.length) {
            result.add(path);
            return;
        }
        //logic
        
        //1st Choose
        List<Integer> temp = new ArrayList<>(path); // []
        
        temp.add(nums[i]); // temp = [1]
        helper(nums, i+1, new ArrayList<>(temp)); // [1]
        
        //2nd Dont chosse
        helper(nums, i+1, new ArrayList<>(path)); //[]
        //[[1,2,3],[1,2],[1,3],[1],[2,3],[2],[3],[]]
            
        
      
      
//         //What if we dont create temp list
//         //1st Choose,
//         path.add(nums[i]); // path = [1]
//         helper(nums, i+1, new ArrayList<>(path)); // [1]
        
//         //2nd Dont chosse, we will same reference
//         helper(nums, i+1, new ArrayList<>(path)); //[1]
        
        // [[1,2,3],[1,2,3],[1,2,3],[1,2,3],[1,2,3],[1,2,3],[1,2,3],[1,2,3]]
            
  
    }
}
